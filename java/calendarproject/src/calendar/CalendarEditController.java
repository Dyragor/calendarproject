package calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
/**
 *  Calendarproject
 *
 * @author Simon Kunz, Andreas Schranz
 * @version 1.0
 *
 */
public class CalendarEditController {

    @FXML
    private Button closeButton;

    @FXML
    private ListView<Appointment> myListView;
    private ObservableList<Appointment> listViewData = FXCollections.observableArrayList();
    private Stage prevStage;
    private Main main;

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Constructor which adds some test appointments
     * @throws IOException
     */
    public CalendarEditController() throws IOException {
        listViewData.add(new Appointment("Mittagessen","Essen am Samstag", false, "01:00", "03:00"));
        listViewData.add(new Appointment("Hausaufgaben","Mathematik ueben", true, "13:00", "14:00"));
    }

    /**
     * Initializes the GUI which shows all appointments of the day.
     */
    @FXML
    private void initialize() {

        myListView.setItems(listViewData);

        closeButton.setOnAction((event) -> prevStage.close());

        myListView.setCellFactory((list) -> new ListCell<Appointment>() {
            @Override
            protected void updateItem(Appointment item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item.getTitle() + "\t" + item.getStartTime() + "\t" + item.getEndTime() + "\t Ganztägig: "+ item.isWholeDay()+ "\t"+ item.getText());
                }
            }
        });
    }

    /**
     * Method for deleting the appointments.
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleDeleteAppointment(ActionEvent event) throws IOException {
        Appointment selectedNotiz = myListView.getSelectionModel().getSelectedItem();
        if (selectedNotiz != null) {

            listViewData.remove(selectedNotiz);
            myListView.refresh();

        } else {
            nothingSelected();
        }
    }

    /**
     * Method for editing the selected appointment which opens a GUI for editing or
     * if nothing selected a new window with the hint.
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleEditAppointment(ActionEvent event) throws IOException {
        Appointment selectedAppointment = myListView.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            Stage stage;
            AnchorPane root;

            FXMLLoader myLoader = new FXMLLoader(main.getClass().getResource("EditAppointment.fxml"));
            root = myLoader.load();
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

    /**
     * The method is called if no appointment is selected selected it opens a window with a hint.
     */
    private void nothingSelected() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(prevStage);
        alert.setTitle("No Selection");
        alert.setHeaderText("No Appointment selected");
        alert.setContentText("Select an Appointment first");

        alert.showAndWait();
    }

    /**
     * Method for creating new Appointments which opens a new GUI for that.
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleNewAppointment(ActionEvent event) throws IOException {
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
        stage.setTitle("Edit Appointment");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.initOwner(prevStage);
        controller.setPrevStage(stage);
        stage.showAndWait();

        myListView.refresh();

    }

}