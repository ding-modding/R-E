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
		//�⺻ �ó����� A, ���� ������ 'smith'

		nowS = nowS.Do(particitant.get(0), Event.Leturedesk_MicActivate);
		//alpha�� ��Ź ������ ������ ����ũ�� �۵���Ű�� �Ѵ�.
		
		nowS = nowS.Do(particitant.get(0), Event.SitBack_MicUnactivate);
		//alpha�� �ڸ��� ���ư��� ����ũ ����� �����Ѵ�.
		
		nowS = nowS.Do(particitant.get(3), Event.MicActivate);
		//epsilon�� ����ũ�� �۵���Ű���Ѵ�.
		
		nowS.printData();
		//���� �ó������� ������ ����Ѵ�.
		
		nowS = nowS.Do(particitant.get(5), Event.MicActivate);//eta�� ����ũ�� �۵���Ű���Ѵ�.
		nowS = nowS.Do(particitant.get(6), Event.MicActivate);//theta�� ����ũ�� �۵���Ű���Ѵ�.
		nowS = nowS.Do(particitant.get(5), Event.MicActivate);//eta�� ����ũ�� �۵���Ű���Ѵ�.
		
		nowS = nowS.Do(particitant.get(3), Event.MicUnactive);//eplsilo�� ����ũ�� �۵��� ���߷��Ѵ�.
		nowS = nowS.Do(particitant.get(4), Event.Move);//zeta�� �ڸ��� �����δ�
		nowS = nowS.Do(t, Event.CreateRoom);//���������� 'smith'�� ���� �����Ϸ��Ѵ�.
		
	}
}
