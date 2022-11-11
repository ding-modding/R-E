package rne.develop.object.scenario;

import rne.develop.main.Main;
import rne.develop.object.Event;
import rne.develop.object.User;

public class ScenarioC extends Scenario{
	
	public User question;
	public User answer;
	
	public Scenario back;
	
	public ScenarioA A;
	
	public ScenarioC() {
		name = "C";
		//links.add(new Link(toB, new Scen));
	}
	
	public void set(User question, User answer, Scenario back, ScenarioA a) {
		links.clear();
		this.question = question;
		this.answer = answer;
		this.A = a;
		Action[] toBac = {new Action(question, Event.MicUnactive) };
		links.add(new Link(toBac, back));
	}
	
	@Override
	public Scenario Do(User u, Event e) {
		super.Do(u, e);
		for(Link l : links) {
			if(l.Done()) {
				if(l.to.name.equals("B") ) {
					((ScenarioB)l.to).set(answer, A);
				}else if(l.to.name.equals("A") ) {
					((ScenarioA)l.to).set(answer);
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
		System.out.println("  Authority: {Mic}/online+{QuestionerCam, AnswererCam}");
		System.out.println("\nQuestioner: " + question.name);
		System.out.println("  Authority: {Mic}/online+{AnswerCam}");
		System.out.println("\nAnswerer: " + answer.name);
		System.out.println("  Authority: {Mic, ScreenShare}/online+{QuestionerCam}");
		System.out.print("\nparticipitant: /");
		for(User u : Main.particitant) 
			if(u != A.teacher && u != answer && u != question) System.out.print(u.name+"/");
		
		System.out.println();
		System.out.println("  Authority: {}/online+{QuestionerCam, AnswererCam}");
		System.out.println("::---------::");
	}
	
}
