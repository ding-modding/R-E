package com.js.object;

import java.util.ArrayList;

import com.js.total.RBAC;

public class Role {
	
	public ArrayList<Authority> authorLink;
	public ArrayList<Role> sons;
	public RBAC r;
	
	public String name;
	
	public Role(RBAC r, String name) {
		r.rc.roleArr.add(this);
		this.name = name;
	}
	
	public void setLink(Authority author) {
		authorLink.add(author);
	}
	
	public void addSonRole(Role role) {
		sons.add(role);
	}
	
	public void removeLink(Authority author) {
		authorLink.remove(author);
	}
	
}
