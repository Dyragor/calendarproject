package calendar;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CalendarController {

	@FXML
	private	Stage prevStage;
	private Main main;
	@FXML
	private Button dayone;
	@FXML
	private Button daytwo;
	@FXML
	private Button daythree;
	@FXML
	private Button dayfour;
	@FXML
	private Button dayfive;
	@FXML
	private Button daysix;
	@FXML
	private Button dayseven;
	@FXML
	private Button dayeight;
	@FXML
	private Button daynine;
	@FXML
	private Button dayten;
	@FXML
	private Button dayeleven;
	@FXML
	private Button daytwelve;
	@FXML
	private Button daythirteen;
	@FXML
	private Button dayfourteen;
	@FXML
	private Button dayfifteen;
	@FXML
	private Button daysixteen;
	@FXML
	private Button dayseventeen;
	@FXML
	private Button dayeighteen;
	@FXML
	private Button daynineteen;
	@FXML
	private Button daytwenty;
	@FXML
	private Button daytwone;
	@FXML
	private Button daytwtwo;
	@FXML
	private Button daytwthree;
	@FXML
	private Button daytwfour;
	@FXML
	private Button daytwfive;
	@FXML
	private Button daytwsix;
	@FXML
	private Button daytwseven;
	@FXML
	private Button daytweight;
	@FXML
	private Button daytwnine;
	@FXML
	private Button daythirty;
	@FXML
	private Button daythone;

	private Month month;

    public void setPrevStage(Stage stage){
         this.prevStage = stage;
    }

    public void setMain(Main main){
        this.main = main;
   }

	public CalendarController() throws IOException {
	}

	@FXML
    private void handleEditDay(ActionEvent event) throws IOException {
		Stage stage;
		AnchorPane root;

		FXMLLoader myLoader = new FXMLLoader(main.getClass().getResource("EditView.fxml"));
		root = myLoader.load();
		CalendarEditController controller = myLoader.getController();

		stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("Appointments");
		stage.initModality(Modality.APPLICATION_MODAL);

		stage.initOwner(prevStage);
		controller.setMain(main);
		controller.setPrevStage(stage);
		stage.show();
    }


	@FXML
	private void initialize() {

	}


	@FXML
    private void handleClose(ActionEvent event) throws IOException {
		Platform.exit();
    }

	@FXML
    private void handleAbout(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.initOwner(prevStage);
        alert.setTitle("Calendar 1.0");
        alert.setHeaderText("About");
        alert.setContentText("2017 by Simon Kunz, Andreas Schranz");
        alert.showAndWait();
    }

}