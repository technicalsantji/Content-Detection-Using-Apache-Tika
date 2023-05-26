package com.text.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
//import org.apache.tika.exception.TikaException;
//import org.apache.tika.metadata.Metadata;
//import org.apache.tika.parser.AutoDetectParser;
//import org.apache.tika.parser.ParseContext;
//import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.text.model.Image;
import com.text.model.PatternManagements;
import com.text.model.ResponseMessage;
import com.text.repository.ImageRepository;

@Service
public class FileStorageService {
	@Autowired
	  private ImageRepository fileDBRepository;

	  public Image store(String path,MultipartFile file) throws IOException {
	    String fileName = file.getOriginalFilename();
	    Image FileDB = new Image(fileName, file.getContentType(), file.getBytes());

        
		
		String filepath=path+File.separator+fileName;
		File file2=new File(path);
		if (!file2.exists()) {
			file2.mkdir();
		}
		
		Files.copy(file.getInputStream(), Paths.get(filepath));
	    
	    return fileDBRepository.save(FileDB);
	  }

	  public Image getFile(String id) {
	    return fileDBRepository.findById(id).get();
	  }
	  
	  public Stream<Image> getAllFiles() {
	    return fileDBRepository.findAll().stream();
	  }
	  
	  public PatternManagements getresource(String path,String filename) throws IOException, SAXException, TikaException {
		  String fullpath=path+File.separator+filename;
		  
		  AutoDetectParser parser=new AutoDetectParser();
		  Metadata metadata=new Metadata();
		  BodyContentHandler handler=new BodyContentHandler();
		  InputStream is=new FileInputStream(fullpath);
		  ParseContext context=new ParseContext();
		  
		  parser.parse(is, handler, metadata);
		  
		  String string=handler.toString();
      
	      String[] ch=string.split(" ");
	      
	      PatternManagements patternManagements=new PatternManagements();
	     
	      //addhar number getting from file
	      
	      String regexforadhar="[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}";
	      
	      Pattern pattern=Pattern.compile(regexforadhar);
	      
	      for (int i = 0; i < ch.length; i++) {
	    	
	      	 Matcher matcher=pattern.matcher(ch[i]);
	      	 boolean addharfound=matcher.matches();
	      	
	      	
	      	 if (addharfound) {
	      		patternManagements.setAddharfound(addharfound);
//	      		System.out.println("addhar Number: "+ch[i]);
	      		 patternManagements.setAddhar(ch[i]);
	      		 break;
				}
	      	
			}
	      
        String regexforpan = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern pattern1=Pattern.compile(regexforpan);
        for (int i = 0; i < ch.length; i++) {
			
        	 Matcher matcher=pattern1.matcher(ch[i]);
        	 boolean panfound=matcher.matches();
        	 
        	 if (panfound) {
//        		 System.out.println("Pan Card Number: "+ch[i]);
        		 patternManagements.setPanfound(panfound);
        		 patternManagements.setPan(ch[i]);
        		 break;
			}
        	
		}
	       
		return patternManagements;
	}
	  
}
