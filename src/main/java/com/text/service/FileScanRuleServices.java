package com.text.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.text.model.PTRule;
import com.text.model.PatternTemplate;
import com.text.model.Template;
import com.text.model.fileOperations;
import com.text.repository.FileOpRepository;
import com.text.repository.PatternRepository;
import com.text.repository.TemplateRepository;

@Service
public class FileScanRuleServices {
	
	@Autowired
	EmailServices emailServices;
	@Autowired
	PatternRepository patternRepository;
	@Autowired
	FileOpRepository fileOpRepository;
	@Autowired
	TemplateRepository templateRepository;

	public String getrulename(String path) throws IOException, SAXException, TikaException {
		
		
		List<fileOperations> findAll = fileOpRepository.findAll();
		Iterator<fileOperations> iterator = findAll.iterator();
	while (iterator.hasNext()) {
		fileOperations fileOperations = (fileOperations) iterator.next();
		Long temId = fileOperations.getTemId();
	
		Optional<Template> tId = templateRepository.findById(temId);
		Template template = tId.get();
		
		//pattern rule scan in Documents
		
		Set<PTRule> patternrules = template.getPatternrules();
		Iterator<PTRule> iterator2 = patternrules.iterator();
		while (iterator2.hasNext()) {
			PTRule ptRule = (PTRule) iterator2.next();
			System.out.println(ptRule.getPt_id());
			if (ptRule.getPt_id()!=null) {
				Optional<PatternTemplate> findById = patternRepository.findById(ptRule.getPt_id());
				PatternTemplate patternTemplate = findById.get();
				System.out.println(patternTemplate);
				List<String> pattern = patternTemplate.getPattern();
				Iterator<String> iterator3 = pattern.iterator();
				while (iterator3.hasNext()) {
					String repatt = (String) iterator3.next();
					System.out.println(repatt);
					 AutoDetectParser parser=new AutoDetectParser();
					  Metadata metadata=new Metadata();
					  BodyContentHandler handler=new BodyContentHandler();
					  InputStream is=new FileInputStream(path+fileOperations.getFilename());
					  System.out.println(path+fileOperations.getFilename());
					  ParseContext context=new ParseContext();
					  
					  parser.parse(is, handler, metadata);
					  
					  String string1=handler.toString();
			      
				      String[] ch=string1.split(" ");
				     
				      
				      Pattern pattern1=Pattern.compile(repatt);
				      System.out.println(repatt);
				      
				      for (int i = 0; i < ch.length; i++) {
				    	
				      	 Matcher matcher=pattern1.matcher(ch[i]);
				      	 boolean addharfound=matcher.matches();
				      	 System.out.println(addharfound);
				      	if (addharfound) {
				      		String message="<h4>All documents Scan successfully !! We get some Information in your Documents</h4><br>";
				      		message+="<table border='1'>\n"
				      				+ "  <tr>\n"
				      				+ "    <th>File Name</th>\n"
				      				+ "    <th>Pattern Name</th>\n"
				      				+ "    <th>File Scan status</th>\n"
				      				+ "    <th>Pattern Number </th>\n"
				      				+ "  </tr>\n"
				      				+ "  <tr>\n"
				      				+ "    <td>"+fileOperations.getFilename()+"</td>\n"
				      				+ "    <td>"+patternTemplate.getName()+"</td>\n"
				      				+ "    <td>Completed</td>\n"
				      				+ "    <td>"+ch[i]+"</td>\n"
				      				+ "  </tr>\n"
				      			
				      				+ "</table>";
				      		
				      		message+="</table>";
				      		message+="<br><br><br><br>";
//				      		message += "<p> File Name= <b>"+fileOperations.getFilename()+"</b> </p><br>";
//				      		message+="<p>Pattern Name=<b>"+patternTemplate.getName()+"</b></p><br><br><br>";
				      		message+="<font color=red>Thanks Dear</font>";
				      		
							emailServices.sendAttach(message ,"Pattern Rules","sant.kumar@dataresolve.com");
							Optional<fileOperations> findById2 = fileOpRepository.findById(fileOperations.getFile_id());
							fileOperations fileOperations2 = findById2.get();
							fileOperations2.setProcessingstate("completed");
							fileOpRepository.save(fileOperations2);
						}
				      	
					
				}
			}
		}
		
		
	}
		
		
	}
	return null;
	}
}
