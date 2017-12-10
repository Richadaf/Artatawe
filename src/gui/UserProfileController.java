package gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;

public class UserProfileController extends Application{


    @FXML
    Label lblName;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPhone;

    @FXML
    private Button btnEditProfile;

    @FXML
    private ImageView imgUser;

    @FXML
    private Hyperlink lnkEditProfileImage;

    @FXML
    private Hyperlink lnkBiddingHistory;

    @FXML
    private Label lblAddress;

    @FXML
    private void initialize() {
        lblName.setText(SystemController.user.getFirstName() +  " " + SystemController.user.getLastName());
        lblUsername.setText(SystemController.user.getUserName());
        lblPhone.setText(SystemController.user.getPhoneNumber());
        lblAddress.setText(SystemController.user.getAddress());
        Image imageFile = new Image(SystemController.user.getAvatar());
        imgUser.setImage(imageFile);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
