package net.kzn.shoppingbackend.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerException(){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","The page is not constructed");
		mv.addObject("errorDescription","The page you are looking is unavaliable");
		mv.addObject("title","404 error");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerExceptionForProduct(){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","The Product is Not avaliable");
		mv.addObject("errorDescription","The product you are looking is unavaliable");
		mv.addObject("title","404 error");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerExceptionForCommon(Exception e){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Contact Admin");
		mv.addObject("errorDescription",e.toString());
		mv.addObject("title","404 error");
		return mv;
	}
}
