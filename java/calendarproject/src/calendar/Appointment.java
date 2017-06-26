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

    public Appointment() {
        this(null);
    }
    public Appointment(String text) {
        this.text = new SimpleStringProperty(text);

        //this.datum = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
        this.datum = new SimpleObjectProperty<LocalDate>(LocalDate.now());
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
