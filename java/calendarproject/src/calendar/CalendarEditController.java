package calendar;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class CalendarEditController {
	
	@FXML
	private TextArea editTextArea;
	
	@FXML
	private Button okEditButton;
	
	private	Stage stage;
	
	private Calendar calendar;
	
	public CalendarEditController() {
				
	}

    public void setPrevStage(Stage stage){
         this.stage = stage;
    }
	
    public void setCalendar(Calendar calendar) {
    	this.calendar = calendar;
        editTextArea.setText(calendar.getText());
    }

	@FXML
	private void handleClose(ActionEvent event) throws IOException {
		Platform.exit();
	}
	
    @FXML
	private void initialize() {
    	
    	okEditButton.setOnAction((event) -> {
    		calendar.setText(editTextArea.getText());
    		stage.close();
		});
    }
}

