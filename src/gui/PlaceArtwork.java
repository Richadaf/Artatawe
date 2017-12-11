package gui;

import users.Artwork;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Responsible for adding new artworks
 * @author Siddhartha Gurung (912318)
 */
public class PlaceArtwork extends Application {

    //Variable Declarations
    @FXML
    Hyperlink lnkEditProfileImage;

    @FXML
    TextField txtTitle;

    @FXML
    TextArea txtDescription;

    @FXML
    TextField txtCreatorName;

    @FXML
    TextField txtYear;

    @FXML
    TextField txtReservePrice;

    @FXML
    ChoiceBox chbTypeOfArtwork;

    @FXML
    TextField txtNumOfBidsAllowed;

    @FXML
    TextField txtWidth;

    @FXML
    TextField txtHeight;

    @FXML
    TextField txtDimensions;

    @FXML
    TextField txtMaterial;

    @FXML
    Button btnCancel;

    @FXML
    Button btnUploadArtwork;

    @Override
    public void start(Stage primaryStage) throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("PlaceArtwork.fxml"));
            primaryStage.setTitle("PlaceArtwork");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
    }
    private void initialize() {

    }
}
