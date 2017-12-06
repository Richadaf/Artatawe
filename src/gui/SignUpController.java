package gui;

import java.io.File;
import java.io.IOException;
import java.util.List;

import data.Data;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import users.User;

public class SignUpController extends Application {

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
	
	@Override
	public void start(Stage primaryStage) throws Exception {

	}

	@FXML
	public void onLoginBtnClicked(ActionEvent event) throws IOException {
		Parent signUpRoot = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene signUpScene = new Scene(signUpRoot);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(signUpScene);
		window.show();

	}
	@FXML
	public void onSignUpBtnClicked(ActionEvent event) {
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
					
					User user = new User(txtUserName.getText(),txtFirstName.getText(), txtLastName.getText(), String.valueOf(phoneNumber),address);
					lblResponse.setText("Account Created, Login with username");
					lblResponse.setVisible(true);
						
	}
	//TODO: Choose Image Uncompleted
	@FXML
	public void onChooseImgBtnClicked(ActionEvent event) throws IOException {
		FileChooser fc = new FileChooser();
		fc.setTitle("Choose Profile Picture");
		fc.getExtensionFilters().addAll(new ExtensionFilter("JPEG Files","*.jpg"),new ExtensionFilter("PNG Files", "*.png"));
		File fileSelected  = fc.showOpenDialog(null);
	//	String t = fileSelected.();
		//Image imageSelected = new Image(t);
		//imgProfile.setImage(imageSelected);
	}
}
