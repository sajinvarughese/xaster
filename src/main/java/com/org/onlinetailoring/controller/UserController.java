package com.org.onlinetailoring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.onlinetailoring.entity.Login;
import com.org.onlinetailoring.entity.UserDetails;
import com.org.onlinetailoring.service.UserService;

/**
 * The Class OnlineTailoringController.
 */
@Controller
public class UserController {

	/** The user service. */
	@Autowired
	UserService userService;

	/**
	 * Home page.
	 *
	 * @return the string
	 */
	@RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET)
	public String homePage() {
		return "customer_home";
	}

	/**
	 * About.
	 *
	 * @return the string
	 */
	@GetMapping("/about")
	public String about() {
		return "about";
	}

	/**
	 * Contact.
	 *
	 * @return the string
	 */
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	/**
	 * Signup.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("login", new Login());
		return "signup";
	}

	/**
	 * Login page.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

	/**
	 * Login home page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/login_home")
	public String loginHomePage(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			return "login_home";
		}
	}

	/**
	 * Logout.
	 *
	 * @param request
	 *            the request
	 * @return the string
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "customer_home";
	}

	/**
	 * Login action.
	 *
	 * @param login
	 *            the login
	 * @param model
	 *            the model
	 * @param redirectAttr
	 *            the redirect attr
	 * @param httpRequest
	 *            the http request
	 * @return the string
	 */
	@PostMapping("/login")
	public String loginAction(@ModelAttribute Login login, Model model, RedirectAttributes redirectAttr,
			HttpServletRequest httpRequest) {
		UserDetails userDetails = null;
		Login finalLogin = userService.getUserDetails(login);
		if (null != finalLogin) {
			userDetails = finalLogin.getUserDetails();
		}
		if (null == userDetails) {
			redirectAttr.addFlashAttribute("error", "username password incorrect");
			return "redirect:login";
		} else {
			model.addAttribute("userDetails", userDetails);
			httpRequest.getSession().setAttribute("userDetails", userDetails);
			if ("Admin".equals(finalLogin.getRole())) {
				return "admin_home";
			} else {
				return "login_home";
			}
		}
	}

	/**
	 * Signup action.
	 *
	 * @param login
	 *            the login
	 * @param model
	 *            the model
	 * @param redirectAttr
	 *            the redirect attr
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	@PostMapping("/signup")
	public String signupAction(@ModelAttribute Login login, Model model, RedirectAttributes redirectAttr)
			throws Exception {
		login.setRole("User");
		UserDetails userDetails = userService.registerUser(login);
		if (null == userDetails) {
			redirectAttr.addFlashAttribute("error", "User not saved");
			return "redirect:signup";
		} else {
			redirectAttr.addFlashAttribute("success", "User registered successfully");
			return "redirect:signup";
		}

	}

	/**
	 * Admin home page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/admin_home")
	public String adminHomePage(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			return "admin_home";
		}
	}

	/**
	 * Gets the all users.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the all users
	 */
	@GetMapping("/all_users")
	public String getAllUsers(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			List<UserDetails> userList = userService.getAllUsers();
			model.addAttribute("userList", userList);
			return "all_users";
		}
	}

	@GetMapping("/forgot_password")
	public String forgotPassword(Model model) {
		model.addAttribute("login", new Login());
		return "forgot_password";
	}

	@PostMapping("/sendOTP")
	public @ResponseBody String sendOTP(@RequestParam String username, HttpSession session) {
		System.out.println(username);
		try {
			String otp = userService.sendOTP(username);
			session.setAttribute("otp", otp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "test";
	}

	/**
	 * Update password.
	 *
	 * @param model the model
	 * @param login the login
	 * @param session the session
	 * @return the string
	 */
	@PostMapping("/updatepassword")
	public String updatePassword(Model model, @ModelAttribute Login login, HttpSession session) {
		try {
			if (login.getOtp().equals(session.getAttribute("otp"))) {
				session.removeAttribute("otp");
				login.setOtp("");
				userService.updatePassword(login);
				model.addAttribute("successMsg", "Successfully updated password");
			} else {
				model.addAttribute("errorMsg", "Invalid OTP");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forgot_password";
	}
}
