package gui;





import data.Data;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import users.User;

public class LoginUIController extends Application{

	   
	    @FXML
	    private TextField txtLogin;
	    
	    @FXML
	    private Button btnEnter;
	    @FXML
	    private Label lblResponse;
	    
	    


	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("login.fxml"));
		primaryStage.setTitle("Login - Artatawe");
		primaryStage.setScene( new Scene(root));
		
		primaryStage.show();
	
	}

	@FXML
	public void onEnterButtonClicked() {
		if(!txtLogin.getText().equals("") && txtLogin.getText() != null){
			int id = -1;
			//Validate username entry 
			try{ 
			 id = Integer.parseInt(txtLogin.getText());
			}catch(NumberFormatException e){
				txtLogin.setText("");
				lblResponse.setText("User id should be an integer");
				lblResponse.setVisible(true);

			}
			//If user isn't found
			if(Data.getUser(id) == null){
				txtLogin.setText("");
				lblResponse.setText("No user exists with this id");
				lblResponse.setVisible(true);
			}else{
				//Login
			}
		}
		//Catch Number Format exception: Id should be a unique integer
	}
	@FXML
	public void signUp(){
		
	}
}