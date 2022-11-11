package com.js.total;
import java.util.ArrayList;

import com.js.controler.AuthorityControler;
import com.js.controler.RoleControler;
import com.js.controler.UserControler;
import com.js.object.Authority;
import com.js.object.Role;
import com.js.object.User;


public class RBAC {
	public UserControler uc;
	public RoleControler rc;
	public AuthorityControler ac;
	
	public RBAC() {
		uc = new UserControler(this);
		rc = new RoleControler(this);
		ac = new AuthorityControler(this);
	}
	
	public void setLink(Role role, Authority author) {
		role.setLink(author);
		author.setLink(role);
	}
	
	public void makeClass(int classNum) {
		
	}
	
	
	class Class{
		ArrayList<User> students;
		ArrayList<Role> roles;
		ArrayList<Authority> authorities;
		
		
	}
	
}
