package rne.develop.object.scenario;

import rne.develop.main.Main;
import rne.develop.object.Event;
import rne.develop.object.User;

public class ScenarioE extends Scenario{
	
	ScenarioA A;
	
	public ScenarioE() {
		name = "E";
		//links.add(new Link(toB, new Scen));
	}
	
	public void set(ScenarioA A) {
		links.clear();
		this.A = A;
		Action[] toA = {new Action(null, Event.Move), new Action(A.teacher, Event.RemoveRoom) };
		links.add(new Link(toA,A));
	}
	
	@Override
	public Scenario Do(User u, Event e) {
		super.Do(u, e);
		for(Link l : links) {
			if(l.Done()) {
				((ScenarioA)l.to).set(A.teacher);
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
		System.out.println("  Authority: {Mic, Create&RemoveRoom , TotalParticitantCam}/online+{}");
		System.out.print("\nparticipitant: /");
		for(User u : Main.particitant) 
			if(u != A.teacher) System.out.print(u.name+"/");
		
		System.out.println();
		System.out.println("  Authority: {JoinRoom, RoomParticitantCam}/online+{}");
		System.out.println("::---------::");
	}
}
