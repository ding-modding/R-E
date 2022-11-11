package com.js.object;

import java.util.ArrayList;

import com.js.total.RBAC;

public class User {
	
	RBAC rbac;
	
	ArrayList<Role> roles;
	
	String name;
	
	
	public User(RBAC r, String name) {
		rbac = r;
		this.name = name;
		rbac.uc.userArr.add(this);
	}
	
	public void AddRole(Role r) {
		roles.add(r);
	}
	
	public void RemoveRole(Role r) {
		roles.remove(r);
	}
	
	public boolean haveAuthor(int k) {
		Authority au = rbac.ac.authorityArr.get(k);
		for(Role r : roles) {
			if(au.roleLink.contains(r)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkHaveAuthor(Role r,Authority au) {
		if(au.roleLink.contains(r)) return true;
		for(Role s : r.sons) {
			if(checkHaveAuthor(s,au))return true;
		}
		return false;
	}
	
	
}
