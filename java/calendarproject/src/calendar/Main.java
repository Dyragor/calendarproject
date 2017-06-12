package calendar;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("CalendarView.fxml"));
            AnchorPane root = myLoader.load();
            CalendarController controller = myLoader.getController();
            controller.setPrevStage(primaryStage);
            controller.setMain(this);
            Scene scene = new Scene(root, 1034, 573);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Calenderproject");
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
