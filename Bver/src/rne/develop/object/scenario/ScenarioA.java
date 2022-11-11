package rne.develop.object.scenario;

import rne.develop.main.Main;
import rne.develop.object.Event;
import rne.develop.object.User;
 
public class ScenarioA extends Scenario{
	
	public User teacher;
	
	public ScenarioA() {
		name = "A";
		
		//links.add(new Link(toB, new Scen));
	}
	public void set(User teacher) {
		this.teacher = teacher;
		links.clear();
		Action[] toC = {new Action(null, Event.MicActivate)};
		Action[] toE = {new Action(null, Event.Move), new Action(teacher, Event.CreateRoom)};
		Action[] toB = {new Action(null, Event.Leturedesk_MicActivate)};
		links.add(new Link(toB, new ScenarioB())); 
		links.add(new Link(toC, new ScenarioC()));
		links.add(new Link(toE, new ScenarioE()));
	}
	

	
	@Override
	public Scenario Do(User u, Event e) {
		super.Do(u, e);
		for(Link l : links) {
			if(l.Done()) {
				if(l.to.name.equals("C") ) {
					((ScenarioC)l.to).set(l.condition.get(0).did.get(0) ,teacher, this, this);
				}else if(l.to.name.equals("B") ) {
					((ScenarioB)l.to).set(l.condition.get(0).did.get(0), this);
				}else if(l.to.name.equals("E") ) {
					((ScenarioE)l.to).set(this);
				}
				printingChangingScenario(l.to.name);
				return l.to;
			}
		}
		return this;
	}
	
	public void printData() {
		super.printData();
		System.out.println("Host: " + teacher.name);
		System.out.println("  Authority: {Mic, ScreenShare, CreateRoom, FileShare}/online+{TotalParticitantCam}");
		System.out.print("\nparticipitant: /");
		for(User u : Main.particitant) 
			if(u != teacher) System.out.print(u.name+"/");
		
		System.out.println();
		System.out.println("  Authority: {}/online+{HostCam}");
		System.out.println("::---------::");
	}
}


/*
 * --
1. HostCam
2. Mic
3. ScreenShare
4. ListenerCam/LstCam
5. PresenterCam/PrsCam
6. AnswererCam/AnsCam
7. QuestionerCam/QstCam
8. FileAccess
9. JoinRoom
10. RoomParticitantCam/RoomParCam
11. TotalParticitantCam/TotParCam
12. CreateRoom
*/
