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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	//add and update product
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult validationResult , Model mv,
			HttpServletRequest request){
		logger.info("starte add product with "+product);
		if(product.getId() == null){
			new ProductValidator().validate(product, validationResult);
		}else{
			if(!product.getFile().getOriginalFilename().isEmpty()){
				new ProductValidator().validate(product, validationResult);
			}
		}
		if(validationResult.hasErrors()){
			mv.addAttribute("title","Manage products");
			mv.addAttribute("userClickedManageProduct",true);
			return "page";
		}
		if(product.getId() == null){
			productDAO.addProduct(product);
		}else{
			productDAO.updateProduct(product);
		}
		if(!product.getFile().getOriginalFilename().isEmpty()){
			FileUploadUtility.uploadFile(request,product.getFile(),product.getCode());
		}
		return "redirect:/manage/products?operation=success";
	}
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int id){
		logger.info("starte edit product with "+id);
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.getProductById(id);
		mv.addObject("product", product);
		mv.addObject("title","Manage products");
		mv.addObject("userClickedManageProduct",true);
		return mv;
	}
	
	@RequestMapping(value="/products/{id}/activate",method=RequestMethod.POST)
	@ResponseBody
	public String productActivateDeactivate(@PathVariable int id){
		logger.info("start productActivateDeactivate "+id);
		Product product = productDAO.getProductById(id);
		boolean productState = product.getIs_active();
		product.setIs_active(!product.getIs_active());
		productDAO.updateProduct(product);
		return (productState) ? "You are Successfully Deactivated the '"+product.getName()+"'" : "You are Successfully Activated the '"+product.getName()+"'";
	}
	
	@RequestMapping(value="/add/category",method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("category") Category category,BindingResult result,Model model){
		categoryDAO.addCategory(category);
		return "redirect:/manage/products?operation=addCategory";
	}
	
	@ModelAttribute("categories")
	public List<Category> getcategories(){
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
}
