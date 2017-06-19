package calendar;

import java.io.IOException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CalendarController {

	@FXML
	private ListView<Calendar> myListView;
	private ObservableList<Calendar> listViewData = FXCollections.observableArrayList();
	private	Stage prevStage;
	private Main main;

    public void setPrevStage(Stage stage){
         this.prevStage = stage;
    }

    public void setMain(Main main){
        this.main = main;
   }

	public CalendarController() throws IOException {
	}

	@FXML
    private void handleDeleteNotiz(ActionEvent event) throws IOException {

    }

	@FXML
    private void handleEditNotiz(ActionEvent event) throws IOException {
        Calendar selectedCalendar = myListView.getSelectionModel().getSelectedItem();
        if (selectedCalendar != null) {

        	Stage stage;
        	AnchorPane root;

       		FXMLLoader myLoader = new FXMLLoader(main.getClass().getResource("EditView.fxml"));
    		root = (AnchorPane) myLoader.load();
    		CalendarEditController controller = (CalendarEditController) myLoader.getController();
    		controller.setCalendar(selectedCalendar);

        	stage = new Stage();
        	stage.setScene(new Scene(root));
        	stage.setTitle("Edit Note Dialog");
        	stage.initModality(Modality.APPLICATION_MODAL);

        	stage.initOwner(prevStage);
        	controller.setPrevStage(stage);
        	stage.showAndWait();

        	myListView.refresh();

		} else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(prevStage);
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No note selected");
	        alert.setContentText("Select a note first");

	        alert.showAndWait();
	    }
    }

	@FXML
    private void handleNewNote(ActionEvent event) throws IOException {

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
