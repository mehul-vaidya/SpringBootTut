package com.api.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	//public final String uPLOAD_DIRString = "C:\\Users\\mehul\\Documents\\workspace-spring-tool-suite-4-4.19.0.RELEASE\\RestAPI_MYSQL_Nested_objects\\src\\main\\resources\\static\\image";
	public final String uPLOAD_DIRString = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
		
	}  
	
	public boolean uploadFile(MultipartFile file){
		boolean isUploaded = false;
		try{
			/*
			InputStream is = file.getInputStream();
			byte data[] = new byte[is.available()];
			is.read(data);
			FileOutputStream fos = new FileOutputStream(uPLOAD_DIRString+ File.separator+file.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			isUploaded=true;	
			*/
			//alternate code
			System.out.println("***************");
			System.out.println(Paths.get(uPLOAD_DIRString+File.separator+file.getOriginalFilename()));
			Files.copy(file.getInputStream(),Paths.get(uPLOAD_DIRString+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			isUploaded=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isUploaded;
	}
}
