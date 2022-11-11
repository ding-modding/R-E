package rne.develop.object.scenario;

import java.util.ArrayList;

import rne.develop.object.Event;
import rne.develop.object.User;


public class Scenario {
	String name;
	ArrayList<Link> links = new ArrayList<Scenario.Link>();
	
	public Scenario Do(User u, Event e) {
		System.out.println("\nEVENT: "+u.name + " " + e);
		for(Link l : links) {
			l.Do(u,e);
		}
		return null;
	}
	
	public void	printingChangingScenario(String to) {
		System.out.println("< scenario Change : "+name+" to "+ to + " >");
	}
	
	public void printData() {
		System.out.println("\n::Scenario"+ name+"::");
	}
	
	
	public class Link {
		ArrayList<Action> condition = new ArrayList<Scenario.Action>();
		Scenario to;
		public Link(Action[] con, Scenario to) {
			for(Action a : con) condition.add(a);
			this.to = to;
		}
		
		public boolean Done() {
			for(Action a : condition) {
				if(!a.Do) return false;
			}
			return true;
		}
		
		public void Do(User u, Event e) {
			for(Action a : condition) {
				if(!a.event.equals(e)) continue;
				if(a.filter == null) {
					a.Do = true;
					a.did.add(u);
				}else {
					if(a.filter.equals(u)) {
						a.did.add(u);
						a.Do = true;
					}
				}
			}
		}
	}
	
	

	
	public class Action{
		User filter;
		ArrayList<User> did;
		Event event;
		boolean Do;
		public Action(User user, Event event) {
			this.filter = user;
			this.event = event;
			Do = false;
			did = new ArrayList<User>();
		}
	}
	
}
