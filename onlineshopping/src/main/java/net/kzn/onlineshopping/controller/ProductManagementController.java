package net.kzn.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;
import net.kzn.shoppingbackend.util.FileUploadUtility;
import net.kzn.shoppingbackend.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ProductManagementController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductManagementController.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView manageProducts(@RequestParam(name="operation",required=false) String operation){
		ModelAndView mv = new ModelAndView("page");
		Product product = new Product();
		product.setSupplier_id(1);
		product.setIs_active(true);
		mv.addObject("product", product);
		mv.addObject("title","Manage products");
		mv.addObject("userClickedManageProduct",true);
		if(operation != null && operation.equals("success")){
			mv.addObject("message", "Product added Successfully.");
		}
		return mv;
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult validationResult , Model mv,
			HttpServletRequest request){
		logger.info("starte add product with "+product);
		new ProductValidator().validate(product, validationResult);
		if(validationResult.hasErrors()){
			mv.addAttribute("title","Manage products");
			mv.addAttribute("userClickedManageProduct",true);
			return "page";
		}
		boolean result = productDAO.addProduct(product);
		if(result && !product.getFile().getOriginalFilename().isEmpty()){
			FileUploadUtility.uploadFile(request,product.getFile(),product.getCode());
		}
		logger.info("add product result is "+result);
		return "redirect:/manage/products?operation=success";
	}
	
	@ModelAttribute("categories")
	public List<Category> getcategories(){
		return categoryDAO.list();
	}
}
