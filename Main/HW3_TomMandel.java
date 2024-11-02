//HW3_TomMandel	Tom Mandel	205633688
package Main;

import Controller.Controller;
import Model.Model;
import View.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class HW3_TomMandel extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Model model = new Model();
		View view = new View(primaryStage);
		Controller controller = new Controller(model, view);
	}
}
