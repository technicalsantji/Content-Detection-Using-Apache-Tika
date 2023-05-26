package com.text.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ur_id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne
    private Role role;
	public Long getUr_id() {
		return ur_id;
	}
	public void setUr_id(Long ur_id) {
		this.ur_id = ur_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public UserRole(Long ur_id, User user, Role role) {
		super();
		this.ur_id = ur_id;
		this.user = user;
		this.role = role;
	}
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserRole [ur_id=" + ur_id + ", user=" + user + ", role=" + role + "]";
	}
   


}
