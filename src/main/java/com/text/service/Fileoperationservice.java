package com.text.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.text.model.fileOperations;
import com.text.repository.FileOpRepository;
@Service
public class Fileoperationservice{
@Autowired
private FileOpRepository fileOpRepository;
	public void storeimg(MultipartFile file,Long id) throws InterruptedException{
		
		String path="/home/sant/Documents/SpringBootApp/Mca/ImgUploads";
		String fileName=file.getOriginalFilename();
		String filepath=path+File.separator+fileName;
		File file2=new File(path);
		if (!file2.exists()) {
			file2.mkdir();
		}
		
		try {
			Files.copy(file.getInputStream(), Paths.get(filepath));
			fileOperations f=new fileOperations();
			f.setTemId(id);
			f.setFilename(fileName);
			f.setProcessingstate("Pending");
			fileOperations save = fileOpRepository.save(f);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}


