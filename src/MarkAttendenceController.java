import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class MarkAttendenceController implements Initializable {

    @FXML
    ComboBox <String> courseComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    // adding Courses
    courseComboBox.getItems().addAll(getCoursesList());

    }



    // adding courses names to list
    public ArrayList<String> getCoursesList(){
        ArrayList <String> courseNames = new ArrayList<>();
        courseNames.add("Bachlore in Computer Applications");
        courseNames.add("Diploma in Computer Engineering");
        courseNames.add("Diploma in Electronics & Electrical Engineering");
        return courseNames;
    }
}
