package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class UserProfileController extends Application {

    @FXML
    private Label lblName;

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

	@Override
	public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui/userProfile.fxml"));
        primaryStage.setTitle("User Profile");
        primaryStage.setScene(new Scene(root, 441, 300));
        primaryStage.show();
	}

    public static void main(String[] args) {
        launch(args);
    }
}
