package com.js.controler;

import java.util.ArrayList;

import com.js.object.User;
import com.js.total.RBAC;

public class UserControler {
	RBAC rbac;
	
	public ArrayList<User> userArr;
	
	public UserControler(RBAC r) {
		rbac = r;
	}
	
	public User makeUser(String name) {
		return new User(rbac, name);
	}
}
