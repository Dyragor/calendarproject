package calendar;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
/**
 *  Calendarproject
 *
 * @author Simon Kunz, Andreas Schranz
 * @version 1.0
 *
 */
public class CalendarEditAppointmentController {

    @FXML
    private TextField editTextArea;

    @FXML
    private TextField editVon;
    @FXML
    private TextField editBis;
    @FXML
    private TextField editTitle;
    @FXML
    private CheckBox editWholeDay;
    @FXML
    private Button closeButton;
    @FXML
    private Button okEditButton;

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
        editBis.setText(appointment.getEndTime());
        editVon.setText(appointment.getStartTime());
        editTitle.setText(appointment.getTitle());
        editTitle.setText(appointment.getTitle());
        editWholeDay.setSelected(appointment.isWholeDay());
    }
    @FXML
    private void initialize() {
        closeButton.setOnAction((event) -> prevStage.close());
        okEditButton.setOnAction((event) -> {
            appointment.setTitle(editTitle.getText());
            appointment.setStartTime(editVon.getText());
            appointment.setEndTime(editBis.getText());
            appointment.setWholeDay(editWholeDay.isSelected());
            appointment.setText(editTextArea.getText());
            prevStage.close();
        });
    }


}


