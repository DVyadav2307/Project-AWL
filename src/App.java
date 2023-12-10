import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginAndSinginScene.fxml"));

            // loading first interface to mainScene
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            primaryStage.setTitle("AWL");
            
        } catch (Exception e) {
           e.printStackTrace();
           System.out.println( "execption captured in START METHIOD");
        }
    }
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}
