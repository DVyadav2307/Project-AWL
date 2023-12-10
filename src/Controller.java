import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller implements Initializable {


    // login page components
    @FXML
    AnchorPane loginAnchorPane;
    @FXML
    TextField emailLoginPageTextField;
    @FXML
    PasswordField passwordLoginPagePasswordField;
    @FXML
    TextField hiddenPasswordLoginPageTextField;
    @FXML
    Button LoginPageButton;
    @FXML
    Hyperlink registerHereLoginPageHyperlink;
    @FXML
    CheckBox showPasswordLoginPageCheckBox;
    @FXML
    ImageView emailErrorLoginPageImageView;
    @FXML
    ImageView passwordErrorLoginPageImageView;
    @FXML
    Label otherInfoLoginPageLabel;

    // sinup page components
    @FXML
    AnchorPane signupAnchorPane;
    @FXML
    TextField emailSingupTextField;
    @FXML
    PasswordField passwordSignupPasswordField;
    @FXML
    PasswordField confirmPasswordSignupPasswordField;
    @FXML
    Hyperlink loginHereSignupHyperlink;
    @FXML
    Button registerSignupButton;
    @FXML
    ImageView passwordConfirmErrorSignupImageView;
    @FXML
    ImageView emailErrorSignupImageView;
    @FXML
    ImageView passwordErrorSignupImageView;
    @FXML
    Label otherInfoSignupLabel;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // SignUp page is on top, setting it invisible to show loginPage first
        signupAnchorPane.setVisible(false);
        loginAnchorPane.setVisible(true);

        // hiding error messeges when start
        emailErrorLoginPageImageView.setVisible(false);
        passwordErrorLoginPageImageView.setVisible(false);
        emailErrorSignupImageView.setVisible(false);
        passwordConfirmErrorSignupImageView.setVisible(false);
        passwordErrorSignupImageView.setVisible(false);
        
    }

     // remove rror msg when clicked  COMMON METHOD
    public void removeError(MouseEvent e){
        if(e.getSource() == emailLoginPageTextField){
            emailErrorLoginPageImageView.setVisible(false);
        }
       
        if((e.getSource() == passwordLoginPagePasswordField || (e.getSource() == hiddenPasswordLoginPageTextField))){
            passwordErrorLoginPageImageView.setVisible(false);
        }

        if(e.getSource() == emailSingupTextField){
            emailErrorSignupImageView.setVisible(false);
        }

        if(e.getSource() == passwordSignupPasswordField){
            passwordErrorSignupImageView.setVisible(false);
        }

        if(e.getSource() == confirmPasswordSignupPasswordField){
            passwordConfirmErrorSignupImageView.setVisible(false);
        }
        
    }

    /* ------------------------LOGIN PAGE CONTROLS-------------------------------------- */

    // ensure both feilds works fine 
    public void synchronizePasswordAndHiddenFeild(KeyEvent e){
        if(e.getSource() == passwordLoginPagePasswordField){
            hiddenPasswordLoginPageTextField.setText(passwordLoginPagePasswordField.getText());
        }
        if(e.getSource() == hiddenPasswordLoginPageTextField){
            passwordLoginPagePasswordField.setText(hiddenPasswordLoginPageTextField.getText());
        }
    }

    public void showOrHidePassword(ActionEvent e){
        // Show password when checkbox clicked
        if(showPasswordLoginPageCheckBox.isSelected()){
            passwordLoginPagePasswordField.setVisible(false);
        }
        // hide passwordd when checkbox unchecked
        else{
            passwordLoginPagePasswordField.setVisible(true);
        }
    }

    public void Login(ActionEvent e){
        try{

            // check for empty email and password feilds
            if(emailLoginPageTextField.getText().isBlank()){
                emailErrorLoginPageImageView.setVisible(true);
            }else{
                if(passwordLoginPagePasswordField.getText().isEmpty()){
                    passwordErrorLoginPageImageView.setVisible(true);
    
                }else{// login button actual action
    
                    // switch to next interface
                    Stage stage = ((Stage)((Node)e.getSource()).getScene().getWindow());
                    Parent root = FXMLLoader.load(getClass().getResource("TeacherInterface.fxml"));
                    stage.setScene(new Scene(root));
                    stage.centerOnScreen();
                   

                }
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

   
    // switching interface
    public void switchInterface(ActionEvent e){
        if(e.getSource() == registerHereLoginPageHyperlink){
            signupAnchorPane.setVisible(true);
            loginAnchorPane.setVisible(false);
        }
        if(e.getSource() == loginHereSignupHyperlink){
            loginAnchorPane.setVisible(true);
            signupAnchorPane.setVisible(false);
        }
    }
    /* ------------------------------------------------------------------------------------------------- */

    /* --------------------------SIGN UP PAGE CONTROLS-------------------------------------- */

    public void register(ActionEvent e){
        // checkin for empty email feilds
        if(emailSingupTextField.getText().isBlank()){
            emailErrorSignupImageView.setVisible(true);
        }
        else{
            // checking for emptry create password feild
            if(passwordSignupPasswordField.getText().isEmpty()){
                passwordErrorSignupImageView.setVisible(true);
            }
            else{
                // checking unmatch confirm password
                if(!confirmPasswordSignupPasswordField.getText().equals(passwordSignupPasswordField.getText())){
                    passwordConfirmErrorSignupImageView.setVisible(true);
                }
                else{
                    // registration button actual action



                    // alert on succesfull registration
                    Alert successAlert = new Alert(AlertType.INFORMATION);
                    successAlert.setTitle("Success");
                    successAlert.setHeaderText("Registartion Successfull");
                    successAlert.setContentText("You have registered successfully.You may now login");
                    successAlert.showAndWait();

                    // moving to login Page
                    loginAnchorPane.setVisible(true);
                    signupAnchorPane.setVisible(false);                    
                }
            }
        }
    }


    public void matchPasswordOnEveryPress(KeyEvent e){
        if(!confirmPasswordSignupPasswordField.getText().equals(passwordSignupPasswordField.getText())){
            otherInfoSignupLabel.setText("Password didn't match.");
        }else{
            otherInfoSignupLabel.setText("");
        }
    }
    
}
