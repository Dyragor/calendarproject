package calendar;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Calendar {

		private StringProperty text;
	    private ObjectProperty<LocalDate> datum;

	    public Calendar() {
	        this(null);
	    }
	    public Calendar(String text) {
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