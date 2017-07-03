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

	@FXML
	private ListView<Appointment> myListView;
	private ObservableList<Appointment> listViewData = FXCollections.observableArrayList();
	private	Stage prevStage;
	private Main main;

	private Appointment appointment;

    public void setPrevStage(Stage stage){
         this.prevStage = stage;
    }

	public void setMain(Main main){
		this.main = main;
	}

	public CalendarEditController() throws IOException{
		listViewData.add(new Appointment("Essen am Samstag"));
		listViewData.add(new Appointment("Hausaufgaben"));
	}

    @FXML
	private void initialize() {
		myListView.setItems(listViewData);

		myListView.setCellFactory((list) -> {
			return new ListCell<Appointment>() {
				@Override
				protected void updateItem(Appointment item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.getDate() + "  :  " + item.getText());
					}
				}
			};
		});
    }

	@FXML
	private void handleDeleteAppointment(ActionEvent event) throws IOException {
		Appointment selectedNotiz = myListView.getSelectionModel().getSelectedItem();
		if (selectedNotiz != null) {

			listViewData.remove(selectedNotiz);
			myListView.refresh();

		} else {
			nothingSelected();
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
			CalendarEditAppointmentController controller = myLoader.getController();
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
			nothingSelected();
		}
	}

	private void nothingSelected(){
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.initOwner(prevStage);
		alert.setTitle("No Selection");
		alert.setHeaderText("No Appointment selected");
		alert.setContentText("Select an Appointment first");

		alert.showAndWait();
	}

	@FXML
	private void handleNewAppointment(ActionEvent event) throws IOException {
		Appointment newAppointment = new Appointment();
		listViewData.add(newAppointment);

		Stage stage;
		AnchorPane root;

		FXMLLoader myLoader = new FXMLLoader(main.getClass().getResource("EditAppointment.fxml"));
		root = myLoader.load();
		CalendarEditAppointmentController controller = myLoader.getController();
		controller.setAppointment(newAppointment);

		stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("Wer das liest ist dumm");
		stage.initModality(Modality.APPLICATION_MODAL);

		stage.initOwner(prevStage);
		controller.setPrevStage(stage);
		stage.showAndWait();

		myListView.refresh();
	}
}


