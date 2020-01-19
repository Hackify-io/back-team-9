package com.digital_lab.hackify.ad_tech.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImporterService {

	// Method to save file with type (allocation or sap), month and year identifier
	public String importFile(MultipartFile file) {
		String completado = "Completado";
		String serverPath;
		try {
			serverPath = "C:/Users/j_edu/Desktop/adTechImages/" + file.getOriginalFilename();
			File uploadFile = new File(serverPath);
			file.transferTo(uploadFile);
			return serverPath;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return completado;
		} catch (IOException e) {
			e.printStackTrace();
			return completado;
		}
	}
}
