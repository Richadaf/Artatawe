package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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

    public void onBiddingHistoryClicked(){
        try{
            Parent historyParent = FXMLLoader.load(getClass().getResource("BiddingHistory.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bidding History - " + SystemController.user.getUserName());
            stage.setScene(new Scene(historyParent, 600, 400));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void onBackSelected(ActionEvent event){
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        BrowsingGUI Browser = new BrowsingGUI();
        try{
            Browser.start(window);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
