package com.js.controler;

import java.util.ArrayList;

import com.js.object.Authority;
import com.js.total.RBAC;

public class AuthorityControler {
	RBAC rbac;
	
	public ArrayList<Authority> authorityArr;
	
	public AuthorityControler(RBAC r) {
		rbac = r;
	}
	
	public Authority makeAuthor(String des) {
		return new Authority(rbac,des);
	}
	
}