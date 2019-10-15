package com.Inventory.MWJ.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Role")
public class Role extends AuditModel {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int role_id;
	@Column(name="role_name")
	private String role;
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
