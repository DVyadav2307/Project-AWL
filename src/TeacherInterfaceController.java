import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class TeacherInterfaceController implements Initializable {

    @FXML
    StackPane TeacherInterfaceMainStackPane;

    @FXML
    Button dashboardButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    // delete thsis later
    public void loadDashboard(ActionEvent e)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardInterface.fxml"));
        Parent DashboardInterface = loader.load();
        TeacherInterfaceMainStackPane.getChildren().addAll(DashboardInterface);

    }

}
