package rne.develop.main;
import java.util.ArrayList;

import rne.develop.object.Event;
import rne.develop.object.User;
import rne.develop.object.scenario.Scenario;
import rne.develop.object.scenario.ScenarioA;

public class Main {
	
	static String[] users = {"alpha","beta", "delta", "epsilon", "zeta", "eta", "Theta", "lota"};
	
	public static ArrayList<User> particitant = new ArrayList<User>();
	
	public static void main(String[] args) {
		
		User t = new User("smith");
		Scenario nowS = new ScenarioA();
		((ScenarioA)nowS).set(t);
		for(String s : users) {
			particitant.add(new User(s));
		}
		//기본 시나리오 A, 수업 진행자 'smith'

		nowS = nowS.Do(particitant.get(0), Event.Leturedesk_MicActivate);
		//alpha가 교탁 앞으로 나오고 마이크를 작동시키려 한다.
		
		nowS = nowS.Do(particitant.get(0), Event.SitBack_MicUnactivate);
		//alpha가 자리로 돌아가고 마이크 사용을 중지한다.
		
		nowS = nowS.Do(particitant.get(3), Event.MicActivate);
		//epsilon이 마이크를 작동시키려한다.
		
		nowS.printData();
		//현재 시나리오의 정보를 출력한다.
		
		nowS = nowS.Do(particitant.get(5), Event.MicActivate);//eta가 마이크를 작동시키려한다.
		nowS = nowS.Do(particitant.get(6), Event.MicActivate);//theta가 마이크를 작동시키려한다.
		nowS = nowS.Do(particitant.get(5), Event.MicActivate);//eta가 마이크를 작동시키려한다.
		
		nowS = nowS.Do(particitant.get(3), Event.MicUnactive);//eplsilo이 마이크를 작동을 멈추려한다.
		nowS = nowS.Do(particitant.get(4), Event.Move);//zeta가 자리를 움직인다
		nowS = nowS.Do(t, Event.CreateRoom);//수업진행자 'smith'가 방을 생성하려한다.
		
	}
}
