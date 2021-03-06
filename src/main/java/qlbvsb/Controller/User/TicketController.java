package qlbvsb.Controller.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import qlbvsb.Bean.Mailer;
import qlbvsb.Entity.HoaDon;
import qlbvsb.Entity.TRANDAU;
import qlbvsb.Entity.TRANDAU_VE;
import qlbvsb.Entity.Ve;

@Transactional
@Controller
@RequestMapping("/tickets/")
public class TicketController {
	@Autowired
	SessionFactory factory;
	
	@Autowired
	Mailer mailer;
	
	@RequestMapping("index")
	public String index(ModelMap model) {
		Date date=new Date();
		Session session=factory.getCurrentSession();
		String hql="from TRANDAU td WHERE td.nhaKhach=1 and td.btDoiNha is null";
		Query query=session.createQuery(hql);
		List<TRANDAU> listTD=query.list();
		model.addAttribute("tranDau", listTD);
		return "user/tickets/index";
		
	}
	@RequestMapping(value = "buyTicket/{id}", method = RequestMethod.GET)
	public String inforCT(ModelMap model,@PathVariable("id") Integer id ){
		Session session = factory.getCurrentSession();
		String hql = "FROM TRANDAU td where td.maTran=" + id;
		Query query = session.createQuery(hql);
		List<TRANDAU> list = query.list();
		model.addAttribute("td", list.get(0));
		hql="from TRANDAU_VE tdv where tdv.tranDau.maTran=" + id;
		query=session.createQuery(hql);
		List<TRANDAU_VE> listTDV=query.list();
		model.addAttribute("list", listTDV);
		model.addAttribute("hoaDon", new HoaDon());
		return "user/tickets/buyTicket";
	}
	@RequestMapping(value = "buyTicket/{id}", method = RequestMethod.POST)
	public String insert(ModelMap model,@ModelAttribute("hoaDon") HoaDon hoaDon,@PathVariable("id") Integer id,
			@ModelAttribute("maVeTran")Integer maVeTran, BindingResult errors ) {
		/*
		if(hoaDon.getSoLuongMua()==0) {
			errors.rejectValue("soLuongMua", "hoaDon","Vui l??ng nh???p ??i???m!");
		}else if(hoaDon.getSoLuongMua()<1||hoaDon.getSoLuongMua()>5) {
			errors.rejectValue("soLuongMua", "hoaDon","Ch??? ???????c mua t??? 1 ?????n 5 v??");
		}
		if(hoaDon.getEmail().trim().length()==0) {
			errors.rejectValue("email", "hoaDon","Vui l??ng nh???p email!");
		}
		if(errors.hasErrors()) {
			model.addAttribute("message", "Vui l??ng s???a c??c l???i sau ????y!");
		}else {
			model.addAttribute("message", "Ch??c m???ng, b???n ???? nh???p ????ng!");
		}
		*/
		Session session1 = factory.getCurrentSession();
		String hql = "FROM TRANDAU_VE tdv where tdv.MaVe_Tran=" + maVeTran;
		Query query = session1.createQuery(hql);
		List<TRANDAU_VE> list = query.list();
		TRANDAU_VE tdv=list.get(0);
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			
			hoaDon.setTranDau_Ve(tdv);
			session.save(hoaDon);
			Random generator = new Random();
			List<String> listID = new ArrayList<>();
			String body="B???n ???? mua "+hoaDon.getSoLuongMua()+" v?? xem tr???n: Barcelona vs "+hoaDon.getTranDau_Ve().getTranDau().getThamGiaGiai().getDoiBong().getTenDoi()
					+" v??o ng??y: "+hoaDon.getTranDau_Ve().getTranDau().getNgayThiDau()+"\n"+"Th???i gian thi ?????u: "
					+hoaDon.getTranDau_Ve().getTranDau().getThoiGianBD()+" C??c m?? s??? v?? c???a b???n l??: \n";
			for(int i=0;i<hoaDon.getSoLuongMua();i++) {
				String idVe=(1000+generator.nextInt(8999)+""+(i+1)+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")));
				Ve ve=new Ve();
				ve.setIDVe(idVe);
				body=body+idVe+"\n";
				ve.setHoaDon(hoaDon);
				session.save(ve);
				listID.add(idVe);
			}
			t.commit();
			body=body+"C??m ??n b???n ???? ???ng h??? ?????i b??ng!";
			mailer.send("trungkientk2202@gmail.com", hoaDon.getEmail(), "Mua v?? th??nh c??ng", body);
			model.addAttribute("hoaDon", hoaDon);
			model.addAttribute("listID", listID);
		} catch (Exception e) {
			t.rollback();
		}
		finally {
			session.close();
		}
		return "user/tickets/completed";
	}
}
