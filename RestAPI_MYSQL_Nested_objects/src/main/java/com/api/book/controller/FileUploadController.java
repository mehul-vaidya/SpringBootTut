package com.api.book.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Empty file");
		}
		
		if(!file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not An JPEG");
		}
		
		//file upload code
		boolean isSuccess = false;
		try {
			FileUploadHelper fuh = new FileUploadHelper();
			isSuccess = fuh.uploadFile(file);
			if(isSuccess) return ResponseEntity.ok("File uploaded successfully");
			else return ResponseEntity.ok(
					                       ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(
					                       file.getOriginalFilename()).toString());
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok("File upload failed");
		}
	}
}
