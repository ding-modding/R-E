package rne.develop.object.scenario;

import rne.develop.main.Main;
import rne.develop.object.Event;
import rne.develop.object.User;

public class ScenarioB extends Scenario{
	
	User speaker;
	
	ScenarioA A;
	
	public ScenarioB() {
		name = "B";
		//links.add();
	}
	
	public void set(User speaker, ScenarioA a) {
		A = a;
		this.speaker = speaker;
		links.clear();
		Action[] toC = {new Action(null, Event.MicActivate)};
		Action[] toA = {new Action(speaker, Event.SitBack_MicUnactivate)};
		links.add(new Link(toC, new ScenarioC()));
		links.add(new Link(toA, a));
	}
	
	@Override
	public Scenario Do(User u, Event e) {
		super.Do(u, e);
		for(Link l : links) {
			if(l.Done()) {
				if(l.to.name.equals("C") ) {
					((ScenarioC)l.to).set(l.condition.get(0).did.get(0), speaker, this,A);
				}else if(l.to.name.equals("A") ) {
					((ScenarioA)l.to).set(A.teacher);
				}
				printingChangingScenario(l.to.name);
				return l.to;
			}
		}
		return this;
	}
	
	@Override
	public void printData() {
		super.printData();
		System.out.println("Host: " + A.teacher.name);
		System.out.println("  Authority: {Mic, ScreenShare, CreateRoom, FileShare}/online+{TotalParticitantCam}");
		System.out.println("\nPresenter: " + speaker.name);
		System.out.println("  Authority: {Mic, ScreenShare}/online+{TotalParticitantCam}");
		System.out.print("\nparticipitant: /");
		for(User u : Main.particitant) 
			if(u != A.teacher && u != speaker) System.out.print(u.name+"/");
		
		System.out.println();
		System.out.println("  Authority: {}/online+{PresenterCam}");
		System.out.println("::---------::");
	}
	
}
