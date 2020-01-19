package com.digital_lab.hackify.ad_tech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digital_lab.hackify.ad_tech.service.ImporterService;

@RestController
@RequestMapping(path="/uploadImage")
@CrossOrigin
public class FileController {
	@Autowired
	ImporterService importer;
	
	@PostMapping(value="",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadSapFile(@RequestParam("fileToUpload") MultipartFile file,@RequestParam String id) {
		String result=importer.importFile(file);
		return result;
	}


}
