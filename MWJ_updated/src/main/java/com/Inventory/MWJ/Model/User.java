package com.Inventory.MWJ.Model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Userdetails")
public class User extends AuditModel implements UserDetails{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	@Column(name = "username")

	private String reg_new_user_name_input;
	@Column(name = "password")
	private String reg_new_user_password_input;

	@Column(name = "new_password")
	private String Newpassword;

	public String getNewpassword() {
		return Newpassword;
	}

	public void setNewpassword(String newpassword) {
		Newpassword = newpassword;
	}

	@Column(name = "confirm_password")
	private String reg_new_user_confirm_password_input;

	@Column(name = "email_id")
	private String reg_new_user_email_input;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

	private Set<Role> roles;

	public User() {

	}

	public User(int user_id, String username, String password, String email, String confirmpassword, Set<Role> roles) {
		super();
		this.user_id = user_id;
		this.reg_new_user_name_input = username;
		this.reg_new_user_password_input = password;
		this.reg_new_user_email_input = email;
		this.roles = roles;
		this.reg_new_user_confirm_password_input = confirmpassword;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getReg_new_user_name_input() {
		return reg_new_user_name_input;
	}

	public void setReg_new_user_name_input(String reg_new_user_name_input) {
		this.reg_new_user_name_input = reg_new_user_name_input;
	}

	public String getReg_new_user_password_input() {
		return reg_new_user_password_input;
	}

	public void setReg_new_user_password_input(String reg_new_user_password_input) {
		this.reg_new_user_password_input = reg_new_user_password_input;
	}

	public String getReg_new_user_confirm_password_input() {
		return reg_new_user_confirm_password_input;
	}

	public void setReg_new_user_confirm_password_input(String reg_new_user_confirm_password_input) {
		this.reg_new_user_confirm_password_input = reg_new_user_confirm_password_input;
	}

	public String getReg_new_user_email_input() {
		return reg_new_user_email_input;
	}

	public void setReg_new_user_email_input(String reg_new_user_email_input) {
		this.reg_new_user_email_input = reg_new_user_email_input;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
	
		return true;
	}

}
