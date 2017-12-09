package gui;

// import com.sun.deploy.util.ArrayUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.stream.Stream;


public class SystemController extends Application {

    private static Stage window;
    private static User user;
    private Scene login;
    private Scene signUp;
    private Scene Browsing;

    @FXML
    private TextField txtLogin;

    @FXML
    private Button btnEnter;
    @FXML
    private Label lblResponse;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Data.populate();

        Pane root = (Pane) FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Login - Artatawe");
        primaryStage.setScene(new Scene(root));

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
                lblResponse.setText("No user exists with this id");
                lblResponse.setVisible(true);
            } else {
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
    public void signUp(MouseEvent event) throws IOException {
        Parent signUpParent = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene signUpScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("SignUp - Artatawe");
        window.setScene(signUpScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}