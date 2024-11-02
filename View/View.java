package View;

import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Controller.Controller;

public class View {

	// Buttons
	private Button btAdd = new Button("Add new employee");
	private Button btPrint = new Button("Print all employees");
	private Button btCostOfBonus = new Button("Cost of all bonuses");
	private Button btCostByType = new Button("Cost by type");
	private Button btCompare = new Button("Comparing employees");
	private Button btRet = new Button("Return");
	private Button btInsert = new Button("Insert");
	private Button btW = new Button("Worker");
	private Button btO = new Button("Owner");
	private Button btM = new Button("Manager");
	private Button btF = new Button("Finish");
	private Button btComp = new Button("Compare");

	// Radio Buttons
	private RadioButton rbW = new RadioButton("Worker");
	private RadioButton rbM = new RadioButton("Manager");
	private RadioButton rbO = new RadioButton("Owner");

	// TextFields
	private static TextField t1 = new TextField();
	private static TextField t2 = new TextField();
	private static TextField t3 = new TextField();

	// Texts
	private Text txt = new Text("Please choose one of the following: ");
	private Text print = new Text();

	public View(Stage primaryStage) {

		// Main menu
		VBox mainBox = new VBox(10, txt, btAdd, btPrint, btCostOfBonus, btCostByType, btCompare, btF);
		mainBox.setAlignment(Pos.CENTER);
		mainBox.setPadding(new Insets(30));
		Scene main = new Scene(mainBox, 400, 400);
		primaryStage.setTitle("Main menu");
		primaryStage.setScene(main);
		primaryStage.show();

		// adding new employees
		btAdd.setOnMouseClicked(e -> {
			HBox addBox = new HBox(30, btW, btM, btO, btRet);
			addBox.setAlignment(Pos.CENTER);
			addBox.setPadding(new Insets(30));
			Scene addScene = new Scene(addBox, 500, 250);
			primaryStage.setTitle("Adding new employee");
			primaryStage.setScene(addScene);

			// Details Scene
			GridPane detPane = new GridPane();
			Scene detScene = new Scene(detPane, 400, 250);
			detPane.add(new Label("Enter Name: "), 0, 0);
			detPane.add(t1, 1, 0);
			detPane.add(new Label("Enter Salary: "), 0, 1);
			detPane.add(t2, 1, 1);
			detPane.add(new Label("Enter Bonus: "), 0, 2);
			detPane.add(t3, 1, 2);
			detPane.add(btInsert, 1, 3);
			detPane.setAlignment(Pos.CENTER);
			GridPane.setHalignment(btInsert, HPos.RIGHT);
			detPane.setPadding(new Insets(10));
			detPane.setHgap(10);
			detPane.setVgap(10);

			btW.setOnMouseClicked(a -> {
				cancelT3();
				primaryStage.setTitle("Worker Screen");
				primaryStage.setScene(detScene);
			});
			btM.setOnMouseClicked(a -> {
				activeT3();
				primaryStage.setTitle("Manager Screen");
				primaryStage.setScene(detScene);
			});
			btO.setOnMouseClicked(a -> {
				activeT3();
				primaryStage.setTitle("Owner Screen");
				primaryStage.setScene(detScene);
			});
			btInsert.setOnMouseClicked(a -> {
				if (Controller.getWorkerType() == 'O' && Controller.getBonus() > 10000) {
					primaryStage.close();
				}
				if (Controller.getFlag() == false) {
					cleanFields();
					primaryStage.setScene(addScene);
				}
			});
		});

		// Printing all employees
		btPrint.setOnMouseClicked(e -> {
			GridPane printBox = new GridPane();
			Scene printScene = new Scene(printBox, 500, 250);
			printBox.setAlignment(Pos.CENTER);
			printBox.setPadding(new Insets(30));
			printBox.add(txt, 0, 0);
			printBox.add(print, 1, 1);
			printBox.add(btRet, 1, 2);
			GridPane.setHalignment(btRet, HPos.RIGHT);
			GridPane.setHalignment(txt, HPos.RIGHT);
			txt.setText("The list content: ");
			primaryStage.setScene(printScene);
			primaryStage.setTitle("Printing employee");
			print.setText(Controller.getPrint());
		});

		// Getting Cost of all bonuses
		btCostOfBonus.setOnMouseClicked(e -> {
			GridPane costBox = new GridPane();
			Scene printScene = new Scene(costBox, 500, 250);
			costBox.setAlignment(Pos.CENTER);
			costBox.setPadding(new Insets(30));
			costBox.add(txt, 0, 0);
			costBox.add(print, 1, 1);
			costBox.add(btRet, 1, 2);
			GridPane.setHalignment(btRet, HPos.RIGHT);
			GridPane.setHalignment(txt, HPos.RIGHT);
			txt.setText("Cost of all bonuses: ");
			primaryStage.setScene(printScene);
			primaryStage.setTitle("Cost of all Bonuses");
			print.setText(Controller.getCostOfAllBonuses());
		});

		// Getting Cost By Type
		btCostByType.setOnMouseClicked(e -> {
			HBox costHbox = new HBox(20, rbW, rbM, rbO);
			TitledPane tPane = new TitledPane("Choose type of worker: ", costHbox);
			tPane.setCollapsible(false);
			VBox costVBox = new VBox(20, tPane, txt, print, btRet);
			Scene costScene = new Scene(costVBox, 500, 250);
			costVBox.setPadding(new Insets(30));
			txt.setText("The Cost is: ");
			print.setText("");
			primaryStage.setScene(costScene);
			primaryStage.setTitle("Cost By Type");
			handleRadio();
		});

		// Comparing two employees
		btCompare.setOnMouseClicked(e -> {
			GridPane comparePane = new GridPane();
			Scene compareScene = new Scene(comparePane, 400, 250);
			comparePane.setPadding(new Insets(30));
			comparePane.setAlignment(Pos.CENTER);
			comparePane.add(new Label("Enter first index "), 0, 0);
			comparePane.add(t1, 1, 0);
			comparePane.add(new Label("Enter second index "), 0, 1);
			comparePane.add(t2, 1, 1);
			comparePane.add(btComp, 1, 2);
			comparePane.add(btRet, 1, 2);
			comparePane.setHgap(10);
			comparePane.setVgap(10);
			GridPane.setHalignment(btRet, HPos.RIGHT);
			primaryStage.setTitle("Comparing employees");
			primaryStage.setScene(compareScene);
		});

		btRet.setOnMouseClicked(e -> {
			primaryStage.setScene(main);
		});

		btF.setOnMouseClicked(e -> {
			primaryStage.close();
		});

	}

	private void handleRadio() {
		ToggleGroup t = new ToggleGroup();
		rbW.setToggleGroup(t);
		rbM.setToggleGroup(t);
		rbO.setToggleGroup(t);

		EventHandler<ActionEvent> handler = e -> update();
		rbW.setOnAction(handler);
		rbM.setOnAction(handler);
		rbO.setOnAction(handler);
	}

	private void update() {
		if (rbW.isSelected()) {
			Controller.setWorkerType('W');
			print.setText(Controller.getCostByType());
		} else if (rbM.isSelected()) {
			Controller.setWorkerType('M');
			print.setText(Controller.getCostByType());
		} else if (rbO.isSelected()) {
			Controller.setWorkerType('O');
			print.setText(Controller.getCostByType());
		}
	}

	public static String getText1() {
		return t1.getText();
	}

	public static String getText2() {
		return t2.getText();
	}

	public static String getText3() {
		return t3.getText();
	}

	public void compareAction(EventHandler<ActionEvent> e) {
		btComp.setOnAction(e);
	}

	public void workerAction(EventHandler<ActionEvent> e) {
		btW.setOnAction(e);
	}

	public void managerAction(EventHandler<ActionEvent> e) {
		btM.setOnAction(e);
	}

	public void ownerAction(EventHandler<ActionEvent> e) {
		btO.setOnAction(e);
	}

	public void insertAction(EventHandler<ActionEvent> e) {
		btInsert.setOnAction(e);
	}

	public static void cleanFields() {
		t1.clear();
		t2.clear();
		t3.clear();
	}

	public void cancelT3() {
		t3.setEditable(false);
		t3.setStyle("-fx-background-color: darkgrey;");
	}

	public void activeT3() {
		t3.setEditable(true);
		t3.setStyle("-fx-background-color: white; -fx-border-color: lightgrey;");
	}

	public static void negativeSalary(String msg) {
		t2.clear();
		t3.clear();
		JOptionPane.showMessageDialog(null, "Salary must be at least 0!");
	}

	public static void invalidSalary(String msg) {
		t2.clear();
		t3.clear();
		JOptionPane.showMessageDialog(null, "Invalid type for salary, integer is needed!");
	}

	public static boolean bonusException(String msg) {
		JOptionPane.showMessageDialog(null, "!! Owner bonus is too high !!\n Program end now...");
		return false;
	}

	public static void equals() {
		JOptionPane.showMessageDialog(null, "EQUALS");
	}

	public static void notEquals() {
		JOptionPane.showMessageDialog(null, "NOT EQUALS");
	}
}
