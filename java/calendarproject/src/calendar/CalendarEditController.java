package calendar;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CalendarEditController {
	
	@FXML
	private TextArea editTextArea;
	
	@FXML
	private Button closeButton;

	private	Stage stage;

	private Appointment appointment;
	
	private Calendar calendar;

	public CalendarEditController() throws IOException{
		listViewData.add(new Appointment("Essen am Samstag"));
		listViewData.add(new Appointment("Hausaufgaben"));
	}

    public void setPrevStage(Stage stage){
         this.stage = stage;
    }
	
    public void setCalendar(Calendar calendar) {
    	this.calendar = calendar;
        editTextArea.setText(calendar.getText());
    }
	
    @FXML
	private void initialize() {
    	closeButton.setOnAction((event) -> {
    		stage.close();
		});
    }





	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
		editTextArea.setText(appointment.getText());
	}

	@FXML
	private ListView<Appointment> myListView;
	private ObservableList<Appointment> listViewData = FXCollections.observableArrayList();
	private	Stage prevStage;
	private Main main;

	public void setMain(Main main){
		this.main = main;
	}

	@FXML
	private void handleDeleteAppointment(ActionEvent event) throws IOException {
		Appointment selectedNotiz = myListView.getSelectionModel().getSelectedItem();
		if (selectedNotiz != null) {

			listViewData.remove(selectedNotiz);
			myListView.refresh();

		} else {
			// Nothing selected.
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.initOwner(prevStage);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Appointment selected");
			alert.setContentText("Select an Appointment first");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleEditAppointment(ActionEvent event) throws IOException {
		Appointment selectedAppointment = myListView.getSelectionModel().getSelectedItem();
		if (selectedAppointment != null) {

			Stage stage;
			AnchorPane root;

			FXMLLoader myLoader = new FXMLLoader(main.getClass().getResource("EditAppointment.fxml"));
			root = (AnchorPane) myLoader.load();
			CalendarEditController controller = (CalendarEditController) myLoader.getController();
			controller.setAppointment(selectedAppointment);

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
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.initOwner(prevStage);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Appointment selected");
			alert.setContentText("Select an Appointment first");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleNewAppointment(ActionEvent event) throws IOException {
		//Notiz selectedNotiz = myListView.getSelectionModel().getSelectedItem();
		Appointment newNote = new Appointment();
		listViewData.add(newNote);

		Stage stage;
		AnchorPane root;

		FXMLLoader myLoader = new FXMLLoader(main.getClass().getResource("EditAppointment.fxml"));
		root = (AnchorPane) myLoader.load();
		CalendarEditController controller = (CalendarEditController) myLoader.getController();
		controller.setAppointment(newNote);

		stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("New Appointment Dialog");
		stage.initModality(Modality.APPLICATION_MODAL);

		stage.initOwner(prevStage);
		controller.setPrevStage(stage);
		stage.showAndWait();

		myListView.refresh();
	}

}


