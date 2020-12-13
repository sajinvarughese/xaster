package com.org.onlinetailoring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.onlinetailoring.entity.OrderDetails;
import com.org.onlinetailoring.entity.UserDetails;
import com.org.onlinetailoring.service.OrderService;
import com.org.onlinetailoring.service.OrderServiceHelper;

/**
 * The Class OnlineTailoringController.
 */
@Controller
public class OrderController {

	/** The order service. */
	@Autowired
	OrderService orderService;

	/**
	 * New orders page.
	 *
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/neworders")
	public String newOrdersPage(HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			return "new_orders";
		}
	}

	/**
	 * Suit measure page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/suit_measure")
	public String suitMeasurePage(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			model.addAttribute("orderDetails", new OrderDetails());
			return "suit_measure";
		}
	}

	/**
	 * Suit measure page action.
	 *
	 * @param orderDetails
	 *            the order details
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@PostMapping("/suit_measure")
	public String suitMeasurePageAction(@ModelAttribute OrderDetails orderDetails, Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			orderDetails.setOrderType("Suit");
			session.setAttribute("iniOrderDetails", orderDetails);
			// OrderDetails order = orderService.createOrder(orderDetails);
			model.addAttribute("orderDetails", orderDetails);
			return "mens_furtherdetails";
		}
	}

	/**
	 * Mens further details page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/mens_furtherdetails")
	public String mensFurtherDetailsPage(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			model.addAttribute("orderDetails", new OrderDetails());
			return "mens_furtherdetails";
		}
	}

	/**
	 * Mens further details.
	 *
	 * @param orderDetails
	 *            the order details
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @param redirectAttr
	 *            the redirect attr
	 * @return the string
	 */
	@PostMapping("/mens_furtherdetails")
	public String mensFurtherDetails(@ModelAttribute OrderDetails orderDetails, Model model, HttpSession session,
			RedirectAttributes redirectAttr) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			OrderDetails initialOrderDetails = (OrderDetails) session.getAttribute("iniOrderDetails");
			session.removeAttribute("iniOrderDetails");
			orderDetails = OrderServiceHelper.mergeOrderDetails(initialOrderDetails, orderDetails);
			orderDetails.setUserDetails(userDetails);
			orderService.createOrder(orderDetails);
			redirectAttr.addFlashAttribute("success", "Successfully placed your order");
			return "redirect:mens_furtherdetails";
		}
	}

	/**
	 * Order history page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/orderhistory")
	public String orderHistoryPage(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			List<OrderDetails> orderDetailList = orderService.getOrderDetailsByUserId(userDetails.getId());
			model.addAttribute("orderDetailList", orderDetailList);
			return "order_history";
		}
	}

	/**
	 * Gets the all orders.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the all orders
	 */
	@GetMapping("/all_orders")
	public String getAllOrders(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			List<OrderDetails> orderList = orderService.getAllOrders();
			model.addAttribute("orderList", orderList);
			return "all_orders";
		}
	}

	/**
	 * Trouser measure page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/trouser_measure")
	public String trouserMeasurePage(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			model.addAttribute("orderDetails", new OrderDetails());
			return "trouser_measure";
		}
	}

	/**
	 * Trouser measure page action.
	 *
	 * @param orderDetails
	 *            the order details
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@PostMapping("/trouser_measure")
	public String trouserMeasurePageAction(@ModelAttribute OrderDetails orderDetails, Model model,
			HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			orderDetails.setOrderType("Trouser");
			session.setAttribute("iniOrderDetails", orderDetails);
			model.addAttribute("orderDetails", orderDetails);
			return "mens_furtherdetails";
		}
	}

	/**
	 * Shirt measure page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/shirt_measure")
	public String shirtMeasurePage(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			model.addAttribute("orderDetails", new OrderDetails());
			return "shirt_measure";
		}
	}

	/**
	 * Shirt measure page action.
	 *
	 * @param orderDetails
	 *            the order details
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@PostMapping("/shirt_measure")
	public String shirtMeasurePageAction(@ModelAttribute OrderDetails orderDetails, Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			orderDetails.setOrderType("Shirt");
			session.setAttribute("iniOrderDetails", orderDetails);
			model.addAttribute("orderDetails", orderDetails);
			return "mens_furtherdetails";
		}
	}

	/**
	 * Blouse measure page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/blouse_measure")
	public String blouseMeasurePage(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			model.addAttribute("orderDetails", new OrderDetails());
			return "blouse_measure";
		}
	}

	/**
	 * Blouse measure page action.
	 *
	 * @param orderDetails
	 *            the order details
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@PostMapping("/blouse_measure")
	public String blouseMeasurePageAction(@ModelAttribute OrderDetails orderDetails, Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			orderDetails.setOrderType("Blouse");
			session.setAttribute("iniOrderDetails", orderDetails);
			model.addAttribute("orderDetails", orderDetails);
			return "girls_further";
		}
	}

	/**
	 * Girls further page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/girls_further")
	public String girlsFurtherPage(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			model.addAttribute("orderDetails", new OrderDetails());
			return "girls_further";
		}
	}

	/**
	 * Girls further action.
	 *
	 * @param orderDetails
	 *            the order details
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @param redirectAttr
	 *            the redirect attr
	 * @return the string
	 */
	@PostMapping("/girls_further")
	public String girlsFurtherAction(@ModelAttribute OrderDetails orderDetails, Model model, HttpSession session,
			RedirectAttributes redirectAttr) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			OrderDetails initialOrderDetails = (OrderDetails) session.getAttribute("iniOrderDetails");
			session.removeAttribute("iniOrderDetails");
			orderDetails = OrderServiceHelper.mergeOrderDetails(initialOrderDetails, orderDetails);
			orderDetails.setUserDetails(userDetails);
			orderService.createOrder(orderDetails);
			redirectAttr.addFlashAttribute("success", "Successfully placed your order");
			return "redirect:girls_further";
		}
	}

	/**
	 * Gown measure page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/gown_measure")
	public String gownMeasurePage(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			model.addAttribute("orderDetails", new OrderDetails());
			return "gown_measure";
		}
	}

	/**
	 * Gown measure page action.
	 *
	 * @param orderDetails
	 *            the order details
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@PostMapping("/gown_measure")
	public String gownMeasurePageAction(@ModelAttribute OrderDetails orderDetails, Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			orderDetails.setOrderType("Gown");
			session.setAttribute("iniOrderDetails", orderDetails);
			model.addAttribute("orderDetails", orderDetails);
			return "girls_further";
		}
	}

	/**
	 * Kurtis measure page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@GetMapping("/kurtis_measure")
	public String kurtisMeasurePage(Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			model.addAttribute("orderDetails", new OrderDetails());
			return "kurtis_measure";
		}
	}

	/**
	 * Kurtis measure page action.
	 *
	 * @param orderDetails
	 *            the order details
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@PostMapping("/kurtis_measure")
	public String kurtisMeasurePageAction(@ModelAttribute OrderDetails orderDetails, Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			orderDetails.setOrderType("Kurti");
			session.setAttribute("iniOrderDetails", orderDetails);
			model.addAttribute("orderDetails", orderDetails);
			return "girls_further";
		}
	}

	@GetMapping("/update_order")
	public String updateOrderPage(@RequestParam String id, Model model, HttpSession session) {
		OrderDetails orderDetails = null;
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			try {
				orderDetails = orderService.getOrderDetails(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("orderDetails", orderDetails);
		}
		return "update_order";
	}

	/**
	 * Update order.
	 *
	 * @param orderDetails the order details
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@PostMapping("/update_order")
	public String updateOrder(@ModelAttribute OrderDetails orderDetails, Model model, HttpSession session) {
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		if (null == userDetails) {
			return "customer_home";
		} else {
			try {
				orderService.createOrder(orderDetails);
				model.addAttribute("successMsg", "Updated updated successfully");
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("errorMsg", "Failed to update order");
			}
		}
		return "update_order";
	}
}
