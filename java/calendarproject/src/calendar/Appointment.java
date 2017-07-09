package calendar;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 *  Calendarproject
 *
 * @author Simon Kunz, Andreas Schranz
 * @version 1.0
 *
 */
public class Appointment {
    private StringProperty text;
    private ObjectProperty<LocalDate> datum;
    private BooleanProperty wholeDay;
    private StringProperty title;
    private StringProperty startTime, endTime;

    public ObjectProperty<LocalDate> datumProperty() {
        return datum;
    }

    public boolean isWholeDay() {
        return wholeDay.get();
    }

    public void setWholeDay(boolean wholeDay) {
        this.wholeDay = new SimpleBooleanProperty(wholeDay);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title = new SimpleStringProperty(title);
    }

    public String getStartTime() {
        return startTime.get();
    }

    public void setStartTime(String startTime) {
        this.startTime = new SimpleStringProperty(startTime);
    }

    public String getEndTime() {
        return endTime.get();
    }

    public void setEndTime(String endTime) {
        this.endTime = new SimpleStringProperty(endTime);
    }

    public Appointment(){
        this.text = new SimpleStringProperty("");
        this.startTime = new SimpleStringProperty("");
        this.endTime = new SimpleStringProperty("");
        this.title = new SimpleStringProperty("");
        this.wholeDay = new SimpleBooleanProperty(false);
    }

    public Appointment(String title, String text, boolean wholeDay, String startTime, String endTime) {
        this.text = new SimpleStringProperty(text);
        this.startTime = new SimpleStringProperty(startTime);
        this.endTime = new SimpleStringProperty(endTime);
        this.title = new SimpleStringProperty(title);
        this.wholeDay = new SimpleBooleanProperty(wholeDay);

    }

    public StringProperty getTextProperty() {
        return text;
    }

    public void setText(String text){
        this.text = new SimpleStringProperty(text);

    }

    public String getText() {
        return text.get();
    }

    public ObjectProperty<LocalDate> getDatumProperty() {
        return datum;
    }

}
