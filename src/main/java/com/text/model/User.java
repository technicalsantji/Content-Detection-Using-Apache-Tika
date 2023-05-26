package com.text.model;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name ="users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String dob;
    private String phone;
    private String gender;
    private String email;
    private boolean enabled=true;
    private String profile;
    
    

    @OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    private Set<UserRole> userRoles=new HashSet<>();
    public User(long id, String firstname, String lastname, String username, String password, String dob, String phone, String gender, String email, boolean enabled) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public User(long id, String firstname, String lastname, String username, String password, String dob, String phone, String gender, boolean enabled, String profile, Set<UserRole> userRoles) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.enabled = enabled;
        this.profile = profile;
        this.userRoles = userRoles;
    }

    public User() {
    }
    

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		
		
		Set<Authority> set=new HashSet<>();
		this.userRoles.forEach(userRoles->{
			set.add( new Authority(userRoles.getRole().getRolename()));
		});
		return set;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
}
