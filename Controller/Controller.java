package Controller;

import Model.BonusException;
import Model.Model;
import View.View;

public class Controller {
	private Model model;
	private View view;
	private static char workerType;
	private static boolean exFlag = false;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		view.insertAction(e -> {
			try {
				exFlag = false;
				if (getSalary() < 0) {
					throw new IllegalArgumentException();
				} else {
					Model.insertIntoList(Model.workersArr);
				}
			} catch (BonusException ex) {
				View.bonusException(ex.getMessage());
			} catch (NumberFormatException ex) {
				View.invalidSalary(ex.getMessage());
				exFlag = true;
			} catch (IllegalArgumentException ex) {
				View.negativeSalary(ex.getMessage());
				exFlag = true;
			}
		});

		view.compareAction(e -> {
			if (Model.compare(Model.workersArr)) {
				View.equals();
			} else {
				View.notEquals();
			}
			View.cleanFields();
		});

		view.workerAction(e -> {
			workerType = 'W';
		});
		view.managerAction(e -> {
			workerType = 'M';
		});
		view.ownerAction(e -> {
			workerType = 'O';
		});
	}

	public static String getCostByType() {
		return Model.costByType(Model.workersArr);
	}

	public static String getCostOfAllBonuses() {
		return Model.costOfAllBonuses(Model.workersArr);
	}

	public static String getPrint() {
		return Model.printList(Model.workersArr);
	}

	public static char getWorkerType() {
		return workerType;
	}

	public static String getName() {
		return View.getText1();
	}

	public static int getSalary() {
		return Integer.parseInt(View.getText2());
	}

	public static int getBonus() {
		return workerType != 'W' ? Integer.parseInt(View.getText3()) : 0;
	}

	public static int getText1() {
		return Integer.parseInt(View.getText1());
	}

	public static int getText2() {
		return Integer.parseInt(View.getText2());
	}

	public static boolean getFlag() {
		return exFlag;
	}

	public static void setWorkerType(char workerType) {
		Controller.workerType = workerType;
	}

}
