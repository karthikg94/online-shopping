package net.kzn.shoppingbackend.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	private static String ABS_Path="D:\\backup\\projects\\online-shopping\\onlineshopping\\src\\main\\webapp\\assests\\Images\\";
	private static String REAL_Path="";
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		logger.info("Real path from the request is "+request.getSession().getServletContext().getRealPath("/"));
		REAL_Path = request.getSession().getServletContext().getRealPath("/assests/Images");
		logger.info("Real path from the REAL_Path is "+REAL_Path);
		logger.info("Real path from the ABS_Path is "+ABS_Path);
		//Check whether folder exists if not create new folder
		if(!new File(ABS_Path).exists()){
			new File(ABS_Path).mkdir();
		}
		if(!new File(REAL_Path).exists()){
			new File(REAL_Path).mkdir();
		}
		//upload the file to location
		try {
			file.transferTo(new File(ABS_Path + code + ".jpg"));
			file.transferTo(new File(REAL_Path + code + ".jpg"));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
