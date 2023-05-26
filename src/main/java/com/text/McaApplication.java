package com.text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.text.model.FTRule;
import com.text.model.FileExtDescriptionMaster;
import com.text.model.Filetypeextlibmap;
import com.text.model.Filetypespattern;
import com.text.model.KWRule;
import com.text.model.KeywordTemplate;
import com.text.model.PTRule;
import com.text.model.PatternTemplate;
import com.text.model.Role;
import com.text.model.Template;
import com.text.model.User;
import com.text.model.UserRole;
import com.text.model.fileOperations;
import com.text.repository.FileExtDescriptionMasterRepository;
import com.text.repository.FileOpRepository;
import com.text.repository.FiletypeRepository;
import com.text.repository.KeywordRepository;
import com.text.repository.PatternRepository;
import com.text.repository.TemplateRepository;
import com.text.repository.UserRepository;
import com.text.service.FileWorkingServices;
import com.text.service.UserService;


@SpringBootApplication
public class McaApplication  implements CommandLineRunner{
	@Autowired
    private	FileWorkingServices fileWorkingServices;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	@Autowired
	FileExtDescriptionMasterRepository fileExtDescriptionMasterRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private KeywordRepository keywordRepository;
	@Autowired
	private PatternRepository patternRepository;
	@Autowired
	private FiletypeRepository filetypeRepository;
	@Autowired
	private FileOpRepository fileOpRepository;
	@Autowired TemplateRepository templateRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(McaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		User user =new soutUser();
//		user.setFirstname("Sant");
//		user.setLastname("Kumar");
//		user.setDob("11/03/2000");
//		user.setEmail("sant.kumar@dataresolve.com");
//		user.setUsername("sant5464");
//		user.setGender("male");
//		user.setPhone("8340422551");
//		user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
//		user.setProfile("default.png");
//		Role role=new Role();
//		role.setRoleid(51L);
//		role.setRolename("ADMIN");
//
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1);
	
	
	}
}
