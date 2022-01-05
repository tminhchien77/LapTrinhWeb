package qlbvsb.Controller.Admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import qlbvsb.Entity.CauThu;
import qlbvsb.Entity.VaiTro;
import qlbvsb.Entity.ViTri;
import qlbvsb.Model.PlayerInfo;


@Transactional
@Controller
@RequestMapping(value ="/views/admin/")
public class AdminPlayerController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String inDex(ModelMap model)
	{
		return"admin/index";
	}		
	@RequestMapping("login")
	public String btnLogin(HttpServletRequest request, ModelMap model)
	{		
		return"admin/login";
	}
	
	
	@RequestMapping("list-player")
	public String list(HttpServletRequest request, ModelMap model,
			@ModelAttribute("player") PlayerInfo player)
	{	
		List<PlayerInfo> playerList=this.getAll();			
		PagedListHolder<PlayerInfo> pagedListHolder = new PagedListHolder<PlayerInfo>(playerList);
		Integer page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);	
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return"admin/list-player";
	}
	
	@RequestMapping("add-player")
	public String add(HttpServletRequest request, ModelMap model,
			@ModelAttribute("player") PlayerInfo player)
	{
		System.out.print("chạy tới add rồi!");		
		model.addAttribute("btnStatus", "btnAdd");
		return "admin/add-player";
	}
	@RequestMapping(value="list-player.htm", params ="btnAdd",method = RequestMethod.POST)
	public String save(HttpServletRequest request, ModelMap model,
			@ModelAttribute("player") PlayerInfo player)
	{	
		
		Integer temp=this.savePlayer(player);
		System.out.println("Giá trị temp: " + temp);
		if (temp != 0) {
			model.addAttribute("message", "Thêm thành công");
		} else {
			model.addAttribute("message", "Thêm thất bại!");
		}
		
		System.out.println("Giá trị: " + player.getSoAo());
		System.out.println("Giá trị data: " + player.getFileData().getBytes());
		
		PagedListHolder<PlayerInfo> pagedListHolder = new PagedListHolder<PlayerInfo>(this.getAll());
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);	
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		return "redirect:/views/admin/list-player.htm";
	}
	@RequestMapping(value="edit-player/{id}.htm", params ="linkEdit")
	public String edit(HttpServletRequest request, ModelMap model,
			@ModelAttribute("player") CauThu player,@PathVariable("id") Integer  id)
	{		
		model.addAttribute("btnStatus","btnEdit");
		model.addAttribute("player", this.getPlayer(id));
		return"admin/edit-player";
	}

	@RequestMapping(value="list-player.htm", params ="btnEdit")
	public String editPlayer(HttpServletRequest request, ModelMap model,
			@ModelAttribute("player") CauThu player)
	{	
		Integer temp = this.updatePlayer(player);
		if (temp != 0) {
			model.addAttribute("message", "Update thành công");
		} else {
			model.addAttribute("message", "Update thất bại!");
		}
		System.out.println("Giá trị: " + player.getSoAo());
		PagedListHolder<PlayerInfo> pagedListHolder = new PagedListHolder<PlayerInfo>(this.getAll());
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);	
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "redirect:/views/admin/list-player.htm";
	}
	@RequestMapping(value = "delete-player/{id}.htm", params = "linkDelete")
	public String deleteProduct(HttpServletRequest request, ModelMap model,@ModelAttribute("player") CauThu player,@PathVariable("id") Integer  id) {
		Integer temp = this.deletePlayer(this.getPlayer(id));
		if (temp != 0) {
			model.addAttribute("message", "Delete thành công");
		} else {
			model.addAttribute("message", "Delete thất bại!");
		}
		
		PagedListHolder<PlayerInfo> pagedListHolder = new PagedListHolder<PlayerInfo>(this.getAll());
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);	
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "redirect:/views/admin/list-player.htm";
	}
		
	@RequestMapping(value="list-player.htm", params = "btnSearch")
	public String searchPlayer(HttpServletRequest request, ModelMap model,
			@ModelAttribute("player") CauThu player) {
		PagedListHolder<CauThu> pagedListHolder = new PagedListHolder<CauThu>(this.searchPlayer(request.getParameter("searchInput")));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		return "redirect:/views/admin/list-player.htm";
	}
	
	public List<PlayerInfo> getAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM CauThu";
		Query query = session.createQuery(hql);
		List<PlayerInfo> playerList = query.list();		
		return playerList;
	}
	public CauThu getPlayer(Integer soAo ) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CauThu where SoAo= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", soAo);
		CauThu list = (CauThu) query.list().get(0);		
		return list;
	}

	public List<CauThu> searchPlayer(String player_name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CauThu where Ten LIKE :player_name";
		Query query = session.createQuery(hql);
		query.setParameter("player_name", "%" +  player_name + "%");
		List<CauThu> list = query.list();
		return list;
	}
    public Integer savePlayer(PlayerInfo playerInfor) {
    	Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			     
			Integer soAo = playerInfor.getSoAo();

	        CauThu player = null;

	        boolean isNew = false;
	        if (player == null) {
	            isNew = true;
	            player = new CauThu();
	            player.setNgayRaMat(new Date());
	            player.setNgaySinh(new Date());
	        
		        player.setSoAo(soAo);
		        player.setHoTen(playerInfor.getHoTen());
		       
		        player.setTenAoDau(playerInfor.getTenAoDau());		       
		        player.setNoiSinh(playerInfor.getNoiSinh());		       
		        player.setCanNang(playerInfor.getCanNang());
		        player.setChieuCao(playerInfor.getChieuCao());
		        player.setTieuSu(playerInfor.getTieuSu());
		        player.setVaiTro(playerInfor.getVaiTro());
		        player.setViTri(playerInfor.getViTri());

		        if (playerInfor.getFileData() != null) {
		            byte[] image = playerInfor.getFileData().getBytes();
		            if (image != null && image.length > 0) {
		            	player.setAnh(image);
		            	
		            }
		        }
	        }
	        session.save(player);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	       
    }
    @RequestMapping(value = { "/playerImage" }, method = RequestMethod.GET)
    public void productImage(HttpServletRequest request,HttpServletResponse response, ModelMap model,
            @RequestParam("soAo") Integer soAo) throws IOException {
        CauThu player = null;
        if (soAo != null) {
        	player = this.getPlayer(soAo);
        }
        if (player != null && player.getAnh() != null) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(player.getAnh());
        }
        response.getOutputStream().close();
    }

	public List<PlayerInfo> getAllPlayerInfo(Integer soAo) {
		Session session = factory.getCurrentSession();
		String hql="FROM CauThu p where SoAo:soAo order by p.SoAo desc ";
		Query query = session.createQuery(hql);
		List<PlayerInfo> playerList = query.list();		
		return playerList;
	}
    
	public Integer insertPlayer(CauThu player) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			     
			session.save(player);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	public Integer updatePlayer(CauThu player) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(player);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	public Integer deletePlayer(CauThu player) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(player);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}	
	@ModelAttribute("VaiTro")
	public List<VaiTro> getVaiTro() {
		Session session = factory.getCurrentSession();
		String hql = "FROM VaiTro";
		Query query = session.createQuery(hql);
		List<VaiTro> type = query.list();		
		return type;
	}
	@ModelAttribute("ViTri")
	public List<ViTri> getViTri() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ViTri";
		Query query = session.createQuery(hql);
		List<ViTri> type = query.list();		
		return type;
	}
	
}
