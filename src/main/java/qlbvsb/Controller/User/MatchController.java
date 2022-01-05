package qlbvsb.Controller.User;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import qlbvsb.Entity.DoiBong;
import qlbvsb.Entity.GiaiDau;
import qlbvsb.Entity.TRANDAU_VE;
import qlbvsb.Entity.TRANDAU;
import qlbvsb.Entity.ThamGiaGiai;


@Transactional
@Controller
@RequestMapping("/matches/")
public class MatchController {
	@Autowired
	SessionFactory factory1;
	
	@RequestMapping("index")
	public String index(ModelMap model) {
		Session sesson=factory1.getCurrentSession();
		String hql="from TRANDAU";
		Query query=sesson.createQuery(hql);
		List<TRANDAU> listTD=query.list();
		model.addAttribute("tranDau", listTD);
		
		return "user/matches/index";
		
	}
}
