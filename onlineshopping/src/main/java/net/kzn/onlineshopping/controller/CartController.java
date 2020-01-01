package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.service.CartLineService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartLineService cartLineService;

	@RequestMapping("/show")
	public ModelAndView showCart(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Show Cart");
		mv.addObject("userClickedShowCart", true);
		mv.addObject("cartLine", cartLineService.getCartLine());
		return mv;
	}
}
