package com.js.object;

import java.util.ArrayList;

import com.js.total.RBAC;

public class Authority {
	
	public RBAC rbac;
	
	public String description;
	
	public ArrayList<Role> roleLink;
	
	public Authority(RBAC r,String des) {
		rbac = r;
		description = des;
		r.ac.authorityArr.add(this);
	}
	
	public void setLink(Role role) {
		roleLink.add(role);
	}
	
	public void removeLink(Role role) {
		roleLink.remove(role);
	}
	
}
