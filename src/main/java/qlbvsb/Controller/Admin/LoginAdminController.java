package qlbvsb.Controller.Admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import qlbvsb.Entity.UserModel;

@Controller
@RequestMapping("/views/admin/")
public class LoginAdminController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(ModelMap model, @ModelAttribute("user") UserModel user) {
		System.out.println("11111122222");

		return "admin/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String index(ModelMap model,@Valid @ModelAttribute("user") UserModel user, BindingResult errors,
			HttpServletResponse response, HttpServletRequest request, HttpSession ss) throws IOException {
		System.out.println("111133333");
		if (!errors.hasErrors()) {
			System.out.println("22222");
			System.out.println("Không có lỗi Đăng nhâp !");
			if (user.getId().trim().toString().equals("admin")
					&& user.getPassword().trim().toString().equals("123456")) {

				ss.setAttribute("user", "admin");
				System.out.println("Đăng nhâp thành công");

				return "redirect:/views/admin/index.htm";
			}
		}

		return "admin/login";
	}

	@RequestMapping("logout")
	public String Logout(HttpSession ss) {
		ss.removeAttribute("user");
		return "redirect:admin/login";
	}
}
