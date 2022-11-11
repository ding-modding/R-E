package com.js.controler;

import java.util.ArrayList;

import com.js.object.Role;
import com.js.total.RBAC;

public class RoleControler {
	RBAC rbac;
	
	public ArrayList<Role> roleArr;
	
	public RoleControler(RBAC r) {
		rbac = r;
	}
	
	public Role makeRole(String name) {
		return new Role(rbac, name);
	}
}
