package com.text.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.james.mime4j.dom.Multipart;
import org.apache.tika.exception.TikaException;
import org.omg.RTCORBA.PRIVATE_CONNECTION_POLICY_TYPE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.text.model.FTRule;
import com.text.model.Filetypespattern;
import com.text.model.KWRule;
import com.text.model.KeywordTemplate;
import com.text.model.PTRule;
import com.text.model.PatternTemplate;
import com.text.model.Template;
import com.text.model.fileOperations;
import com.text.repository.FileOpRepository;
import com.text.repository.FiletypeRepository;
import com.text.repository.KeywordRepository;
import com.text.repository.PatternRepository;
import com.text.service.EmailServices;
import com.text.service.FileScanRuleServices;
import com.text.service.FileWorkingServices;
import com.text.service.Fileoperationservice;


@RestController
@CrossOrigin("*")
public class FileOperationController {
	@Autowired
	private FileScanRuleServices fileScanRuleServices;
	@Autowired
	private EmailServices emailServices;
	@Autowired
    private	FileWorkingServices fileWorkingServices;
	@Autowired
	private KeywordRepository keywordRepository;
	@Autowired
	private PatternRepository patternRepository;
	@Autowired
	private FiletypeRepository filetypeRepository;
	@Autowired
	private  FileOpRepository fileOpRepository;
	@Autowired
	private Fileoperationservice fileoperationservice;
	String patg	="/home/sant/Documents/SpringBootApp/Mca/ImgUploads/";
	@PostMapping(value = "/fileuploads")
  public ResponseEntity<String> savefileoperation(@RequestParam("filename") MultipartFile multipartFile,@RequestParam("tid") Long tid) throws InterruptedException, IOException, SAXException, TikaException{
		synchronized(this) {
			fileoperationservice.storeimg(multipartFile,tid);
		}
		
		fileOperations f=new fileOperations();
		
	
		//emailServices.sendAttach("hello ,this message received from java program by Sant Kumar", "all pattern rule after sometime will be send", "santkumar17010481@gmail.com");
		String getrulename = fileScanRuleServices.getrulename(patg);
		return ResponseEntity.status(HttpStatus.CREATED).body(getrulename);
		
		
	}
	@GetMapping("/getfileop")
public ResponseEntity<List<fileOperations>> getallfileop() {
	List<fileOperations> findAll = this.fileOpRepository.findAll();
	return ResponseEntity.ok(findAll);
	
}
	
	
}
