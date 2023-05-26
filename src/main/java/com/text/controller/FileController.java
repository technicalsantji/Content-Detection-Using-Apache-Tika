package com.text.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.tika.exception.TikaException;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.xml.sax.SAXException;

import com.text.model.Image;
import com.text.model.PatternManagements;
import com.text.model.ResponseFile;
import com.text.model.ResponseMessage;
import com.text.service.FileStorageService;

@Controller
@CrossOrigin("http://localhost:4200")
public class FileController {

  @Autowired
  private FileStorageService storageService;
  
 private String paths="/home/sant/Documents/SpringBootApp/Mca/uploads";

  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";
    try {
      storageService.store(paths,file);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
    	System.out.println(e.getMessage());
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }

  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getI_id())
          .toUriString();

      return new ResponseFile(
    		  dbFile.getI_id(),
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable("id") String id,HttpServletResponse response) {
	  
    Image fileDB = storageService.getFile(id);
   
    return ResponseEntity.ok()
    		
    	.contentType(MediaType.parseMediaType(fileDB.getType()))
        .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + fileDB.getName() + "\"")
        
        .body(fileDB.getData());
  }
  
  @PostMapping("/text")
  public ResponseEntity<PatternManagements> gettext(@PathVariable("file") MultipartFile file) throws IOException, SAXException, TikaException {
	   PatternManagements getresource = this.storageService.getresource(paths,file.getOriginalFilename());
	  System.out.println(getresource.toString());
	return ResponseEntity.status(HttpStatus.OK).body(getresource);
}
  
  
  
}
