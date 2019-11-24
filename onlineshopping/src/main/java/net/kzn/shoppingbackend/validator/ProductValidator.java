package net.kzn.shoppingbackend.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.kzn.shoppingbackend.dto.Product;

public class ProductValidator implements Validator{

	private static final Logger logger = LoggerFactory.getLogger(ProductValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product)target;
		logger.info("this is the type of image "+product.getFile().getSize());
		if(product.getUnit_price() == null){
			errors.rejectValue("unit_price", null, "Unit price cannot be less than 1!");
		}
		if(product.getFile() == null || product.getFile().getOriginalFilename().isEmpty()){
			errors.rejectValue("file", null, "Please upload the Image!");
		}else if(!(product.getFile().getContentType().equalsIgnoreCase("image/jpeg")
				|| product.getFile().getContentType().equalsIgnoreCase("image/png") 
				|| product.getFile().getContentType().equalsIgnoreCase("image/gif"))){
			errors.rejectValue("file", null, "Please upload the Image of jpeg or png format!");
		}else if(product.getFile().getSize() > (1024 *1024)){
			errors.rejectValue("file", null, "Please upload the Image of size < 1MB");
		}
		
	}

}
