package Model;

import java.util.ArrayList;
import Controller.Controller;

public class Model {
	public static ArrayList<Person> workersArr = new ArrayList<>();

	public static void insertIntoList(ArrayList<Person> workersArr) throws BonusException {
		char workerType = Controller.getWorkerType();
		String name = Controller.getName();
		int salary = Controller.getSalary();
		int bonus = Controller.getBonus();

		switch (workerType) {

		case 'W': {
			Worker w = new Worker(name, salary);
			workersArr.add(w);
			break;
		}
		case 'M': {
			Manager m = new Manager(name, salary, bonus);
			workersArr.add(m);
			break;
		}
		case 'O': {
			Owner o = new Owner(name, salary, bonus);
			workersArr.add(o);
			break;
		}
		}
	}

	public static String printList(ArrayList<Person> workersArr) {
		String print = "";
		if (workersArr.size() != 0) {
			for (int i = 0; i < workersArr.size(); i++) {
				print += workersArr.get(i).toString() + "\n";
			}
			return print;
		}
		return "The list is empty";
	}

	public static String costOfAllBonuses(ArrayList<Person> workersArr) {
		int sum = 0;

		for (int i = 0; i < workersArr.size(); i++) {
			if (workersArr.get(i) instanceof Manager) {
				Manager m = (Manager) workersArr.get(i);
				sum += m.getBonus();
			}
		}
		return String.valueOf(sum);
	}

	public static String costByType(ArrayList<Person> workersArr) {
		boolean flag = true;
		int cost;
		do {
			cost = 0;
			char workerType = Controller.getWorkerType();
			switch (workerType) {

			case 'W': {
				for (int i = 0; i < workersArr.size(); i++) {
					if (workersArr.get(i).getClass() == Worker.class) {
						cost += ((Worker) workersArr.get(i)).getSalary();
					}
				}
				break;
			}

			case 'M': {
				for (int i = 0; i < workersArr.size(); i++) {
					if (workersArr.get(i).getClass() == Manager.class) {
						Manager m = (Manager) workersArr.get(i);
						cost += m.getSalary() + m.getBonus();
					}
				}
				break;
			}

			case 'O': {
				for (int i = 0; i < workersArr.size(); i++) {
					if (workersArr.get(i).getClass() == Owner.class) {
						Owner o = (Owner) workersArr.get(i);
						cost += o.getSalary() + o.getBonus() + Owner.BASE;
					}
				}
				break;
			}
			}
		} while (!flag);
		return String.valueOf(cost);
	}

	public static boolean compare(ArrayList<Person> workers) {
		int firstIndex = Controller.getText1();
		int secondIndex = Controller.getText2();
		return (workers.get(firstIndex).equals(workers.get(secondIndex)));

	}
}
