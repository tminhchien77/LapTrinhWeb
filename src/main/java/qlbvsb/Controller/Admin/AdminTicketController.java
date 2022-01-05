package qlbvsb.Controller.Admin;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import qlbvsb.Entity.DoiBong;
import qlbvsb.Entity.GiaiDau;
import qlbvsb.Entity.LoaiVe;
import qlbvsb.Entity.TRANDAU;
import qlbvsb.Entity.TRANDAU_VE;
import qlbvsb.Entity.ThamGiaGiai;

@Transactional
@Controller
@RequestMapping("/views/admin/tickets")
public class AdminTicketController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("list-ticket")
	public String inDex(HttpServletRequest request,ModelMap model,@ModelAttribute("ticket") TRANDAU_VE ticket)
	{
		List<TRANDAU_VE>matchTickets = this.getAllMatchTickets();	
		
		model.addAttribute("btnStatus", "btnAdd");
		PagedListHolder<TRANDAU_VE> pagedListHolder = new PagedListHolder<TRANDAU_VE>(this.getAllMatchTickets());
		Integer page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
	
		pagedListHolder.setPageSize(2);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		return"admin/tickets/list-ticket";
	}
	
	@RequestMapping(value="list-ticket.htm", params= "btnAdd")
	public String addTicket(HttpServletRequest request, ModelMap model,
			@ModelAttribute("ticket") TRANDAU_VE ticket)
	{		
		System.out.print("Chạy tới đây rồi 2");
		
		Integer temp = this.insertMatchTicket(ticket);
		if (temp != 0) {
			model.addAttribute("message", "Thêm thành công");
			
		} else {
			model.addAttribute("message", "Thêm thất bại!");
		}
		
		model.addAttribute("ticketList", this.getAllMatchTickets());
		return "redirect:/views/admin/tickets/list-ticket.htm";
	}
	
	@RequestMapping(value="edit-ticket/{id}.htm", params ="linkEdit")
	public String edit(HttpServletRequest request, ModelMap model,
			@ModelAttribute("match") TRANDAU match,@ModelAttribute("ticket") TRANDAU_VE ticket,@PathVariable("id") int id)
	{		
		model.addAttribute("btnStatus", "btnEdit");	
		model.addAttribute("ticket", this.getMatchTicket(id));
		
		return "admin/tickets/edit-ticket";
	}

	@RequestMapping(value="list-ticket.htm", params= "btnEdit")
	public String editTicket(HttpServletRequest request, ModelMap model,
			@ModelAttribute("ticket") TRANDAU_VE ticket)
	{	
		Integer temp = this.updateMatchTicket(ticket);
		if (temp != 0) {
			model.addAttribute("message", "Update thành công");
		} else {
			model.addAttribute("message", "Update thất bại!");
		}
		PagedListHolder<TRANDAU_VE> pagedListHolder = new PagedListHolder<TRANDAU_VE>(this.getAllMatchTickets());
		Integer page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
	
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "redirect:/views/admin/tickets/list-ticket.htm";
	}
	@RequestMapping(value="list-ticket.htm", params = "btnSearch")
	public String searchPro(HttpServletRequest request, ModelMap model,
			@ModelAttribute("ticket") TRANDAU_VE matchTicket) {
		PagedListHolder<TRANDAU_VE> pagedListHolder = new PagedListHolder<TRANDAU_VE>(this.searchMathTicket(request.getParameter("searchInput")));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		
		pagedListHolder.setPageSize(10);
		
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		 return "/views/admin/tickets/list-ticket.htm";
	}
	public List<TRANDAU_VE> searchMathTicket(String maVe_Tran) {
		Session session = factory.getCurrentSession();
		Integer ma= Integer.parseInt(maVe_Tran);
		String hql = "FROM TRANDAU_VE where maVe_Tran LIKE :id";
		Query query = session.createQuery(hql);
		query.setParameter("maVe_Tran", "%" +  maVe_Tran + "%");
		List<TRANDAU_VE> list = query.list();
		return list;
	}
	public TRANDAU getTRANDAU(TRANDAU_VE ticket)
	{
		
		Session session = factory.getCurrentSession();
		String hql = "FROM TRANDAU where MaTran= ticket.MaTran";
		Query query = session.createQuery(hql);
		TRANDAU list = (TRANDAU) query.list().get(0);	
		return list;
	}
	public List<TRANDAU_VE> getAllMatchTickets() {
		Session session = factory.getCurrentSession();
		String hql = "FROM TRANDAU_VE";
		Query query = session.createQuery(hql);
		List<TRANDAU_VE> matchTickets = query.list();		
		return matchTickets;
	}
	public TRANDAU_VE getMatchTicket(int idMatch) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TRANDAU_VE where MaVe_Tran= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idMatch);
		TRANDAU_VE list = (TRANDAU_VE) query.list().get(0);		
		return list;
	}
	public Integer insertMatchTicket(TRANDAU_VE matchTicket) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(matchTicket);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	public Integer updateMatchTicket(TRANDAU_VE matchTicket) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(matchTicket);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	public Integer deleteMatchTicket(TRANDAU_VE matchTicket) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(matchTicket);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	@ModelAttribute("Match")
	public List<TRANDAU> getMatch() {
		Session session = factory.getCurrentSession();
		String hql = "FROM TRANDAU";
		Query query = session.createQuery(hql);
		List<TRANDAU> matchList = query.list();		
		return matchList;
	}
	@ModelAttribute("TypeTicket")
	public List<LoaiVe> getTypeTicket() {
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiVe";
		Query query = session.createQuery(hql);
		List<LoaiVe> type = query.list();		
		return type;
	}
	@ModelAttribute("PriceCode")
	public List<LoaiVe> getIdPrice() {
		Session session = factory.getCurrentSession();
		String hql = "FROM GiaApDung";
		Query query = session.createQuery(hql);
		List<LoaiVe> type = query.list();		
		return type;
	}
	@ModelAttribute("League")
	public List<GiaiDau> getLeague() {
		Session session = factory.getCurrentSession();
		String hql = "FROM GiaiDau ";
		Query query = session.createQuery(hql);
		List<GiaiDau> matchLeague = query.list();		
		return matchLeague;
	}
	
}
