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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *  Calendarproject
 *
 * @author Simon Kunz, Andreas Schranz
 * @version 1.0
 *
 */
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
	@FXML
	private Button monthBack;
	@FXML
	private Button monthForward;
	@FXML
	private Label monthLabel;

	private Month month = Month.JANUARY;

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
		controller.setDay("1.1");
		stage.show();
    }


	@FXML
	private void initialize() {
    	monthLabel.setText(monthIterating(0));
		monthForward.setOnAction((event) -> {
			monthLabel.setText(monthIterating(1));
			disableButtons();
		});
		monthBack.setOnAction((event) -> {
			monthLabel.setText(monthIterating(-1));
			disableButtons();
		});
	}

	private void disableButtons(){
    	daytwnine.setDisable(false);
		daythirty.setDisable(false);
		daythone.setDisable(false);
		switch(month.length(month)){
			case 28:
				daythirty.setDisable(true);
				daythone.setDisable(true);
				daytwnine.setDisable(true);
				break;
			case 30:
				daythone.setDisable(true);
				break;
			default:
				break;
		}
	}

	private String monthIterating(int forward){
    	if(month.sequence(month) + forward == 0){
    		forward = 11;
		}else if(month.sequence(month) + forward == 13){
    		forward = -11;
		}
    	switch(month.sequence(month) + forward){
			case 1:
				month = Month.JANUARY;
				return "Januar";
			case 2:
				month = Month.FEBRUARY;
				return "Februar";
			case 3:
				month = Month.MARS;
				return "März";
			case 4:
				month = Month.APRIL;
				return "April";
			case 5:
				month = Month.MAY;
				return "Mai";
			case 6:
				month = Month.JUNE;
				return "Juni";
			case 7:
				month = Month.JULY;
				return "Juli";
			case 8:
				month = Month.AUGUST;
				return "August";
			case 9:
				month = Month.SEPTEMBER;
				return "September";
			case 10:
				month = Month.OCTOBER;
				return "Oktober";
			case 11:
				month = Month.NOVEMBER;
				return "November";
			case 12:
				month = Month.DECEMBER;
				return "Dezember";
			default:
				return "ERROR";
		}
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