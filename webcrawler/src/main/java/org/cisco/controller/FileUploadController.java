package org.cisco.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.cisco.model.FileUpload;
import org.cisco.validator.FileUploadValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

	@Autowired
	FileUploadValidator fileValidator;

	@RequestMapping("/")
	public ModelAndView getUploadForm(
			@ModelAttribute("uploadedFile") FileUpload uploadedFile,
			BindingResult result) {
		return new ModelAndView("fileUploadForm");
	}


	// When click on submit, below method will get called
	@RequestMapping("/submitFileUpload")
	public ModelAndView fileUploaded(
			@ModelAttribute("uploadedFile") FileUpload uploadedFile,
			BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		// Getting uploaded file
		MultipartFile file = uploadedFile.getFile();
		fileValidator.validate(uploadedFile, result);
         System.out.println(uploadedFile.getPath());
         System.out.println(uploadedFile.getQrypath());
         System.out.println(uploadedFile.getFilelocation());
         System.out.println(uploadedFile.getResultpath());
		String fileName = file.getOriginalFilename();

		// If it has error, redirect it to same page
		if (result.hasErrors()) {
			return new ModelAndView("fileUploadForm");
		}

		try {
			inputStream = file.getInputStream();

			File newFile = new File(uploadedFile.getPath() + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("fileUploadSuccess", "fileName", fileName);
	}

}

