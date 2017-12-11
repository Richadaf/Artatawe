package gui;

import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import data.Data;
import users.Artwork;

public class ArtworkGUI extends Application {

    
	FlowPane root;
    BorderPane border;
    VBox root2;
    VBox root3;
    
    private TableView table = new TableView();
    private ArrayList<Artwork> artworks = new ArrayList<Artwork>();
    
    SystemController s = new SystemController();
    String usersName = s.user.getFirstName() + " " + s.user.getLastName();
     ArrayList<Artwork> findseller = Data.getArtworkBySellerName(usersName);
    private final ObservableList<users.Artwork> data = FXCollections.observableArrayList(findseller);

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        border = new BorderPane();
        root = new FlowPane();
        root2 = new VBox();
        root3 = new VBox();

        //setup buttons
        Button btnProfile = new Button("Back To Profile ");
        btnProfile.setPadding(new Insets(10,10,10,10));



        //tableView
        table.setEditable(true);

        TableColumn artworkNameCol = new TableColumn("Artwork Name");
        artworkNameCol.setCellValueFactory(
                new PropertyValueFactory<users.Artwork, String>("title"));

        TableColumn currentPriceCol = new TableColumn("Current Price");
        currentPriceCol.setCellValueFactory(
                new PropertyValueFactory<users.Artwork, String>("currentPrice"));

        TableColumn bidsAllowedCol = new TableColumn("Bids Allowed");
        bidsAllowedCol.setCellValueFactory(
                new PropertyValueFactory<users.Artwork, String>("bidsAllowed"));

        TableColumn bidsLeftCol = new TableColumn("Bids Left");
        bidsLeftCol.setCellValueFactory(
                new PropertyValueFactory<users.Artwork, String>("bidsLeft"));

        TableColumn completedAuctionCol = new TableColumn("Completed Auction");
        completedAuctionCol.setCellValueFactory(
                new PropertyValueFactory<users.Artwork, String>("completed"));

        table.getColumns().addAll(artworkNameCol, currentPriceCol, bidsAllowedCol, bidsLeftCol, completedAuctionCol);
        table.setItems(data);
        table.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

        //table.setPadding(new Insets(100,10,10,10));
        //add everything to vbox
        root2.setPadding(new Insets(400,750,20,50));
        root2.setSpacing(15);
        root2.getChildren().addAll(btnProfile);
        root3.setPadding(new Insets(50,100,150,-800));
        root3.getChildren().addAll(table);

        border.setLeft(root2);
        border.setCenter(root3);

        // Handle a button event
        btnProfile.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

            }
        });


        Scene showArt = new Scene(border, 900, 500);

        primaryStage.setScene(showArt);
        primaryStage.setTitle("Auction History");
        primaryStage.show();
    }

    public static void main(String[] args) {
    	Data.populateArtwork();
        launch(args);
    }

    //Show the Painting or Sculpture or both


}
