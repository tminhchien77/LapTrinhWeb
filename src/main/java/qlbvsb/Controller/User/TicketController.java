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
			errors.rejectValue("soLuongMua", "hoaDon","Vui lòng nhập điểm!");
		}else if(hoaDon.getSoLuongMua()<1||hoaDon.getSoLuongMua()>5) {
			errors.rejectValue("soLuongMua", "hoaDon","Chỉ được mua từ 1 đến 5 vé");
		}
		if(hoaDon.getEmail().trim().length()==0) {
			errors.rejectValue("email", "hoaDon","Vui lòng nhập email!");
		}
		if(errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây!");
		}else {
			model.addAttribute("message", "Chúc mừng, bạn đã nhập đúng!");
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
			String body="Bạn đã mua "+hoaDon.getSoLuongMua()+" vé xem trận: Barcelona vs "+hoaDon.getTranDau_Ve().getTranDau().getThamGiaGiai().getDoiBong().getTenDoi()
					+" vào ngày: "+hoaDon.getTranDau_Ve().getTranDau().getNgayThiDau()+"\n"+"Thời gian thi đấu: "
					+hoaDon.getTranDau_Ve().getTranDau().getThoiGianBD()+" Các mã số vé của bạn là: \n";
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
			body=body+"Cám ơn bạn đã ủng hộ đội bóng!";
			mailer.send("trungkientk2202@gmail.com", hoaDon.getEmail(), "Mua vé thành công", body);
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
