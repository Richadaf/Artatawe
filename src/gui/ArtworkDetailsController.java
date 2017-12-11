package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;


/**
 * @author Sam Huxtable
 */
public class ArtworkDetailsController extends Application{


    @FXML
    private Label sellerName;

    @FXML
    private Label currentPrice;

    @FXML
    private Label artTitle;

    @FXML
    private Label artistName;

    @FXML
    private TextArea artDescription;

    @FXML
    private Button backToBrowse;

    @FXML
    private Button bidBut;

    @FXML
    private ToggleButton favBut;

    @FXML
    private TextField bidTextBox;

    @FXML
    private ImageView profilePic;

    @FXML
    private ImageView artImage;

    @FXML
    private void initialize() {
        Image artI = new Image(SystemController.artworkView);
        artImage.setImage(artI);

        sellerName.setText(SystemController.user.getFirstName() +  " " + SystemController.user.getLastName());
        Image imageFile = new Image(SystemController.user.getAvatar());
        profilePic.setImage(imageFile);
    }

    public void backTB(ActionEvent event)  {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        BrowsingGUI Browser = new BrowsingGUI();
        try{
            Browser.start(window);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("ArtworkDetails.fxml"));
            primaryStage.setTitle("Artwork");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        } catch(Exception e) {

        }
    }
}
