package gui;

// import com.sun.deploy.util.ArrayUtil;
import data.Data;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import users.User;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Sam Huxtable
 * @author Hunter Zheung
 * @author Richard
 * @author Corey
 */
public class SystemController extends Application {

    private static Stage window;
    public static User user;
    private static Scene loginScene;
    private static Scene signUpScene;
    private static Scene Browsing;
    //Login Variables
    @FXML
    private TextField txtLogin;

    @FXML
    private Button btnEnter;

    @FXML
    private Label lblLoginResponse;

    //Sign up Variables
    @FXML
    Label lblResponse;

    @FXML
    TextField txtUserName;

    @FXML
    TextField txtFirstName;

    @FXML
    TextField txtLastName;

    @FXML
    TextField txtPhone;

    @FXML
    TextField txtAddress1;

    @FXML
    TextField txtAddress2;

    @FXML
    ImageView imgProfile;

    public static void main(String[] args) {
        Data.populate();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent signUpParent = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        signUpScene = new Scene(signUpParent);

        Parent loginParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        loginScene = new Scene(loginParent);


        primaryStage.setTitle("Login - Artatawe");
        primaryStage.setScene(loginScene);

        primaryStage.show();

    }

    @FXML
    public void onEnterButtonClicked(ActionEvent event) throws IOException {
        if (!txtLogin.getText().equals("") && txtLogin.getText() != null) {

            String userName = txtLogin.getText();

            User searchUserResult = Data.getUser(userName);
            // If user isn't found
            if (searchUserResult == null) {
                txtLogin.setText("");
                lblLoginResponse.setText("No user exists with this id");
                lblLoginResponse.setVisible(true);
            } else {
                user = searchUserResult;
                Parent userProfileParent = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
                Scene userProfileScene = new Scene(userProfileParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("User Profile - Artatawe");




                window.setScene(userProfileScene);
                window.show();
            }
        }
    }


    @FXML
    public void signUp() throws IOException {
        window.setScene(signUpScene);
        window.show();
    }
    @FXML
    public void chooseImg() {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Drawing.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Drawing");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        } catch(Exception e) {

        }
    }
    @FXML
    public void onSignUpBtnClicked(ActionEvent event) throws IOException {
        //Check if any Required field is empty
        if(txtUserName.getText().equals("") || txtUserName == null){
            lblResponse.setText("Username field is required");
            lblResponse.setVisible(true);
            return;
        }
        if(txtFirstName.getText().equals("") || txtFirstName == null){
            lblResponse.setText("First Name field is required");
            lblResponse.setVisible(true);
            return;
        }
        if(txtLastName.getText().equals("") || txtLastName == null){
            lblResponse.setText("Last Name field is required");
            lblResponse.setVisible(true);
            return;
        }
        if(txtPhone.getText().equals("") || txtPhone == null){
            lblResponse.setText("Phone Number is required");
            lblResponse.setVisible(true);
            return;
        }
        if(txtAddress1.getText().equals("") || txtAddress1 == null){
            lblResponse.setText("Address line 1 is required");
            lblResponse.setVisible(true);
            return;
        }

        //Validate input
        if(Data.getUser(txtUserName.getText()) != null){
            lblResponse.setText("Username already taken");
            lblResponse.setVisible(true);
            return;
        }

        int phoneNumber;
        try{
            phoneNumber = Integer.parseInt(txtPhone.getText());
        }catch(NumberFormatException e){
            lblResponse.setText("Invalid character at phone number");
            lblResponse.setVisible(true);
            return;
        }

        String address = txtAddress2.getText().equals("") ? txtAddress1.getText()
                : txtAddress1.getText().concat(",").concat(txtAddress2.getText());

        User mUser = new User(txtUserName.getText(),txtFirstName.getText(), txtLastName.getText(), String.valueOf(phoneNumber),address);
        //Data.saveUser(mUser);
        user = mUser;
        window.setScene(loginScene);
        window.show();
        chooseImg();
        // lblResponse.setText("Account Created, Login with username");
        //lblResponse.setVisible(true);

    }

    @FXML
    public void onLoginBtnClicked() throws IOException {
        window.setScene(loginScene);
        window.show();

    }


}
