package qlbvsb.Controller.Admin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import qlbvsb.Entity.CauThu;
import qlbvsb.Entity.DoiBong;
import qlbvsb.Entity.GiaiDau;
import qlbvsb.Entity.LoaiVe;
import qlbvsb.Entity.TRANDAU;
import qlbvsb.Entity.TRANDAU_VE;
import qlbvsb.Entity.ThamGiaGiai;


@Transactional
@Controller
@RequestMapping("/views/admin/match")
public class AdminMatchController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("list-match")
	public String inDex(HttpServletRequest request,ModelMap model,@ModelAttribute("match") TRANDAU match)
	{
		
		List<TRANDAU>matchList = this.getAll();	
		System.out.println("Chiều dài list: "+ matchList.size());
		PagedListHolder<TRANDAU> pagedListHolder = new PagedListHolder<TRANDAU>(matchList);
		Integer page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
	
		pagedListHolder.setPageSize(5);
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("pagedListHolder", pagedListHolder);
		//model.addAttribute("matchList", matchList);
		
		return"admin/match/list-match";
	}
	/*
	@RequestMapping("add-match")
	public String showViewAdding(ModelMap model)
	{
		System.out.println("here");
		System.out.println("why??");
		List<LeagueVm> leagues = this.getLeagues();
		System.out.println("or here?");
		
		/*
		 * model.addAttribute("btnStastus","btnAdd");
		 		model.addAttribute("leagues", leagues);
		 System.out.println("wwhat??");
		
		return"admin/match/tmp";
	}
	
	
	public List<LeagueVm> getLeagues() {
		System.out.println("ERROR");
		Session session = factory.getCurrentSession();
		String hql = "FROM GiaiDau";
		Query query = session.createQuery(hql);
		List<GiaiDau> resultSet = query.list();
		List<LeagueVm> result=new ArrayList<LeagueVm>();
		 System.out.println("ERROR");
		for (GiaiDau giaiDau : resultSet) {
			LeagueVm l=new LeagueVm(giaiDau.getMaGiai(), giaiDau.getTenGiai(), giaiDau.getBase64Image());
			l.setClubs(getClubsOfLeague(l.getMaGiai()));
			result.add(l);
		}
		System.out.println("ERROR");
		return result;
	}
	
	public List<ClubVm> getClubsOfLeague(int idLeague) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ThamGiaGiai as t WHERE t.giaiDau.maGiai = :id";
		Query query = session.createQuery(hql);	
		query.setParameter("id",idLeague);
		List<ThamGiaGiai>  resultSet = query.list();
		List<ClubVm> result=new ArrayList<ClubVm>();
		for (ThamGiaGiai c : resultSet) {
			result.add(new ClubVm(c.getMaDoiDauGiai(), c.getDoiBong().getTenDoi(), c.getDoiBong().getBase64Image()));
		}
		return result;
	}*/
	
	
	@RequestMapping(value="list-match.htm", params ="btnAdd")
	public String add(HttpServletRequest request, ModelMap model,
			@ModelAttribute("match") TRANDAU match)
	{		
		Integer temp = this.insertMatch(match);
		if (temp != 0) {
			model.addAttribute("message", "Thêm thành công");
			
		} else {
			model.addAttribute("message", "Thêm thất bại!");
		}
		model.addAttribute("matchList", this.getAll());
		return "redirect:/views/admin/match/list-match.htm";
	}
	@RequestMapping(value="edit-match/{id}.htm", params ="linkEdit")
	public String edit(HttpServletRequest request, ModelMap model,
			@ModelAttribute("match") TRANDAU match,@PathVariable("id") int id)
	{
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("match", this.getMatch(id));
		return "admin/match/edit-match";
	}

	@RequestMapping(value ="list-match.htm", params = "btnEdit")
	public String editPlayer(HttpServletRequest request, ModelMap model,
			@ModelAttribute("match") TRANDAU match) {
		
		Integer temp = this.updateMatch(match);
		if (temp != 0) {
			model.addAttribute("message", "Update thành công");
		} else {
			model.addAttribute("message", "Update thất bại!");
		}
		PagedListHolder<TRANDAU> pagedListHolder = new PagedListHolder<TRANDAU>(this.getAll());
		Integer page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
	
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		return "redirect:/views/admin/match/list-match.htm";
	}
	@RequestMapping(value="delete-match/{id}.htm", params ="linkDelete")
	public String deleteMatch(HttpServletRequest request, ModelMap model,
			@ModelAttribute("match") TRANDAU match,@ModelAttribute("matchTicket")TRANDAU_VE tranDauVe,@PathVariable("id") int id)
	{	
		match=this.getMatch(id);
		List<TRANDAU_VE> TD_Ve=this.getMatchTicket();
		for(TRANDAU_VE TD:TD_Ve)
		{
			if(id == TD.getTranDau().getMaTran())
			{
				model.addAttribute("message", "Trận đấu này đã đc bán vé, không được xoá !");
			}
			else {
				Integer temp = this.deleteMatch(match);
				if (temp != 0) {
					model.addAttribute("message", "Delete thành công");
				} else {
					model.addAttribute("message", "Delete thất bại!");
				}
			}			
		}
		
		PagedListHolder<TRANDAU> pagedListHolder = new PagedListHolder<TRANDAU>(this.getAll());
		Integer page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
	
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		
		return "redirect:/views/admin/match/list-match.htm";
	}
	@RequestMapping(value="edit-ticket/{id}.htm", params ="linkTicket")
	public String ticket(HttpServletRequest request, ModelMap model,
			@ModelAttribute("match") TRANDAU match,@ModelAttribute("matchTicket")TRANDAU_VE tranDauVe,@PathVariable("id") int id)
	{
		model.addAttribute("match", this.getMatch(id));
		
		return "admin/match/edit-ticket";
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
	public List<TRANDAU> getAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM TRANDAU";
		Query query = session.createQuery(hql);
		List<TRANDAU> matchList = query.list();		
		return matchList;
	}
	public TRANDAU getMatch(int idMatch) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TRANDAU where MaTran= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idMatch);
		TRANDAU list = (TRANDAU) query.list().get(0);		
		return list;
	}
	public Integer insertMatch(TRANDAU match) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(match);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	public Integer updateMatch(TRANDAU match) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(match);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	public Integer deleteMatch(TRANDAU match) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(match);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}	
	
	@ModelAttribute("TypeTicket")
	public List<LoaiVe> getTypeTicket() {
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiVe";
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
	@ModelAttribute("idLeagueJoin")
	public List<ThamGiaGiai> getIdLeague() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ThamGiaGiai ";
		Query query = session.createQuery(hql);	
		List<ThamGiaGiai>  team = query.list();		
		return team;
	}
	@ModelAttribute("doiBong")
	public List<DoiBong> getTeams() {
		Session session = factory.getCurrentSession();
		String hql = "FROM DoiBong ";
		Query query = session.createQuery(hql);	
		List<DoiBong>  team = query.list();		
		return team;
	}
	public ThamGiaGiai getTeam(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ThamGiaGiai where maDoiDauGiai= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ThamGiaGiai list = (ThamGiaGiai) query.list().get(0);		
		return list;
	}
	public List<TRANDAU_VE> getMatchTicket()
	{
		Session session = factory.getCurrentSession();
		String hql = "FROM TRANDAU_VE";
		Query query = session.createQuery(hql);
		List<TRANDAU_VE> matchList = query.list();		
		return matchList;
	}
}
