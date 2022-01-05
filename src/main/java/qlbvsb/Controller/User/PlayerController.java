package qlbvsb.Controller.User;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qlbvsb.Entity.BanHuanLuyen;
import qlbvsb.Entity.CauThu;
import qlbvsb.Entity.VaiTro;
import qlbvsb.Entity.ViTri;

@Transactional
@Controller
@RequestMapping("/players/")
public class PlayerController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("index")
	public String index(ModelMap model) {
		Session sesson=factory.getCurrentSession();
		String hql="from BanHuanLuyen";
		Query query=sesson.createQuery(hql);
		List<BanHuanLuyen> listBHL=query.list();
		model.addAttribute("banHuanLuyen", listBHL);
		
		hql="from CauThu";
		query=sesson.createQuery(hql);
		List<CauThu> listCT=query.list();
		model.addAttribute("cauThu", listCT);
		
		return "user/players/index";
		
	}
	@RequestMapping("infor/{id}")
	public String inforCT(ModelMap model,@PathVariable("id") Integer id ){
		Session session = factory.getCurrentSession();
		String hql = "FROM CauThu bhl where bhl.soAo=" + id;
		Query query = session.createQuery(hql);
		List<CauThu> listCT = query.list();
		model.addAttribute("ct", listCT.get(0));
		return "user/players/inforCT";
	}
	@RequestMapping("leader/infor/{id}")
	public String inforBHL(ModelMap model,@PathVariable("id") Integer id ){
		Session session = factory.getCurrentSession();
		String hql = "FROM BanHuanLuyen bhl where bhl.maTV=" + id;
		Query query = session.createQuery(hql);
		List<BanHuanLuyen> list = query.list();
		model.addAttribute("bhl", list.get(0));
		return "user/players/inforBHL";
	}
	
}
