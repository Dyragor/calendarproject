package calendar;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CalendarEditAppointmentController {

    @FXML
    private TextField editTextArea;

    @FXML
    private Button closeButton;

    @FXML
    private	Stage prevStage;

    private Appointment appointment;

    public void setPrevStage(Stage stage){
        this.prevStage = stage;
    }

    public CalendarEditAppointmentController(){
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
        editTextArea.setText(appointment.getText());
    }
    @FXML
    private void initialize() {
        closeButton.setOnAction((event) -> prevStage.close());
    }


}


