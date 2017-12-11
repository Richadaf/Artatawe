package gui;

import data.Data;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import users.User;

import java.io.IOException;

public class UserProfileController extends Application{

    @FXML
    private Label lblUsername;

    @FXML
    private Button btnEditProfile;

    @FXML
    private ImageView imgUser;

    @FXML
    private Hyperlink lnkBiddingHistory;

    @FXML
    private Button btnBack;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtAddress;

    @FXML
    private void initialize() {
        txtFirstName.setEditable(false);
        txtLastName.setEditable(false);
        txtAddress.setEditable(false);
        txtPhone.setEditable(false);

        lblUsername.setText(SystemController.user.getUserName());
        txtFirstName.setText(SystemController.user.getFirstName());
        txtLastName.setText(SystemController.user.getLastName());

        txtPhone.setText(SystemController.user.getPhoneNumber());
        txtAddress.setText(SystemController.user.getAddress());
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

    @FXML
    void onBackSelected() throws  Exception{
        Parent userProfileParent = FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
        Stage stage = new Stage();
        stage.setTitle("User Profile - " + SystemController.user.getUserName());
        stage.setScene(new Scene(userProfileParent, 600, 400));
        stage.show();
    }



    public void onBiddingHistoryClicked()throws Exception{
            Parent historyParent = FXMLLoader.load(getClass().getResource("BiddingHistory.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bidding History - " + SystemController.user.getUserName());
            stage.setScene(new Scene(historyParent, 600, 400));
            stage.show();

    }
    public void onBackSelected(ActionEvent event) throws Exception{
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        BrowsingGUI Browser = new BrowsingGUI();
        Browser.start(window);
    }
    public void onEditProfileBtn() throws IOException{
        txtFirstName.setEditable(true);
        txtLastName.setEditable(true);
        txtPhone.setEditable(true);
        txtAddress.setEditable(true);
        imgUser.setOnMouseClicked(e -> chooseImg());
        btnEditProfile.setText("Save");
        btnEditProfile.setOnAction(event -> {
            if(onSave()){
            btnEditProfile.setText("Edit");
            }
        });
    }
    private boolean onSave() {
        //Check if any Required field is empty
        if(txtFirstName.getText().equals("") || txtFirstName == null){
            txtFirstName.setPromptText("Field is required");
            return false;
        }
        if(txtLastName.getText().equals("") || txtLastName == null){
            txtLastName.setPromptText("Field is required");
            return false;
        }

        if(txtPhone.getText().equals("") || txtPhone == null){
            txtPhone.setPromptText("Phone Number is required");
            return false;
        }
        if(txtAddress.getText().equals("") || txtAddress == null){
            txtAddress.setPromptText("Address line 1 is required");
            return false;
        }

        int phoneNumber;
        try{
            phoneNumber = Integer.parseInt(txtPhone.getText());
        }catch(NumberFormatException e){
            txtPhone.setText("Invalid character at phone number");
            return false;
        }


        User mUser = new User(SystemController.user.getUserName(),txtFirstName.getText(), txtLastName.getText(), String.valueOf(phoneNumber), txtAddress.getText());
        Data.saveUser(mUser);
        return true;
    }
}
