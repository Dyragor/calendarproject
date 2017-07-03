package calendar;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDate;

/**
 * Created by 5ia15sikunz on 26.06.2017.
 */
public class Appointment {
    private StringProperty text;
    private ObjectProperty<LocalDate> datum;
    private boolean wholeDay;
    private String title;
    private String startTime, endTime;

    public ObjectProperty<LocalDate> datumProperty() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum.set(datum);
    }

    public boolean isWholeDay() {
        return wholeDay;
    }

    public void setWholeDay(boolean wholeDay) {
        this.wholeDay = wholeDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Appointment() {
        this(null);
    }
    public Appointment(String text) {
        this.text = new SimpleStringProperty(text);
        this.datum = new SimpleObjectProperty<>(LocalDate.now());
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

    public LocalDate getDate() {
        return datum.get();
    }
}
