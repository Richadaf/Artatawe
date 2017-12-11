package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.stream.Stream;


public class BrowingGUI extends Application {

    FlowPane artflow;
    ScrollPane s;
    BorderPane border;
    VBox root2;
    ScrollPane artShow;
    Stage window;
    Scene scene2;
    StackPane layout2;
    Scene showArt;
    Parent sample;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        sample = FXMLLoader.load(getClass().getResource("sample.fxml"));
        border = new BorderPane();
        border.setId("pane");
        artflow = new FlowPane();
        root2 = new VBox();
        root2.setPadding(new Insets(50,100,50,100));
        root2.setSpacing(15);

        //setup buttons
        Button painting = new Button("Painting  ");
        painting.setPadding(new Insets(10,10,10,10));


        Button showAll = new Button("Show All ");
        showAll.setPadding(new Insets(10,10,10,10));

        Button sculpture = new Button("Sculpture");
        sculpture.setPadding(new Insets(10,10,10,10));

        root2.getChildren().addAll(showAll,painting,sculpture);

        //border.getChildren().addAll(root,root2);
        border.setRight(root2);

        Button btn = new Button("Change Background");



        //data for artworks
        String[] sculptures = { "file:/C:/Users/Hunte/Pictures/Saved%20Pictures/coast.jpg",
                "file:/C:/Users/Hunte/Pictures/Saved%20Pictures/blue.jpg",
                "file:/C:/Users/Hunte/Pictures/Saved%20Pictures/green.jpg",
                "file:/C:/Users/Hunte/Pictures/Saved%20Pictures/ice.jpg",
                "file:/C:/Users/Hunte/Pictures/Saved%20Pictures/moon.jpg",
        };

        String[] paintings = {  "file:/C:/Users/Hunte/Pictures/Saved%20Pictures/cake.jpg",
                "file:/C:/Users/Hunte/Pictures/Saved%20Pictures/cherry.jpg",
                "file:/C:/Users/Hunte/Pictures/Saved%20Pictures/mushroom.jpg",
                "file:/C:/Users/Hunte/Pictures/Saved%20Pictures/house.jpg",
                "file:/C:/Users/Hunte/Pictures/Saved%20Pictures/rainbow.jpg",
                "file:/C:/Users/Hunte/Pictures/Saved%20Pictures/snow.jpg",
        };

        String[] all = Stream.concat(Arrays.stream(paintings), Arrays.stream(sculptures)).toArray(String[]::new);

        filter(all);

        //set the button event
        painting.setOnMouseClicked((MouseEvent e) -> {
            filter(paintings);
        });

        sculpture.setOnMouseClicked((MouseEvent e) -> {
            filter(sculptures);
        });

        showAll.setOnMouseClicked((MouseEvent e) -> {
            filter(all);
        });

        //create second pane;
        Button back = new Button("Go Back To Browsing");
        back.setPadding(new Insets(10,10,10,10));
        back.setOnMouseClicked((MouseEvent e) -> {
            window.setScene(showArt);
        });

        Button bid = new Button("Bid!");
        bid.setPadding(new Insets(10,10,10,10));
        TextField bidPrice = new TextField();
        Label labelPrice = new Label("CurrentPrice:");
        Label currentPrice = new Label("56");

        bid.setOnMouseClicked((MouseEvent e)->{
            Integer value1 = Integer.valueOf(bidPrice.getText());
            Integer value2 = Integer.valueOf(currentPrice.getText());
            //biding method...
            if(value1>value2){
                System.out.print("YOU SUCCESS!");
            }
        });

        layout2 = new StackPane();
        VBox artBid = new VBox();
        artBid.setSpacing(30);
        artBid.setPadding(new Insets(60,60,60,60));

        artBid.getChildren().addAll(labelPrice,currentPrice,bidPrice,bid,back);
        layout2.getChildren().addAll(artBid);
        scene2 = new Scene(layout2, 300, 300);

        showArt = new Scene(border, 900, 500);
        showArt.getStylesheets().addAll(this.getClass().getResource("setBackground.CSS").toExternalForm());
        window.setScene(showArt);
        window.setTitle("Hello World");
        window.show();
    }
    @FXML
    Button bb;
    public static void main(String[] args) {
        launch(args);
    }

    //Show the Painting or Sculpture or both
    public void filter(String[] type){
        artflow = new FlowPane();
        artflow.setId("pane");
        artflow.setPrefWidth(600);
        for(int i=0;i<type.length;i++){
            VBox v = new VBox();
            Image image = new Image(type[i],150,150,false,false);
            ImageView a = new ImageView(image);

            //allows image double click
            a.setPickOnBounds(true);
            a.setOnMouseClicked((MouseEvent e) -> {
                if(e.getClickCount() == 2){
                    //go to artwork detail
                    //System.out.println("Double clicked");
                    window.setScene(new Scene(sample,400,400));
                }
            });

            Label l = new Label("Title: Coast");
            v.getChildren().addAll(a,l);
            v.setSpacing(10);
            v.setPadding(new Insets(50,15,15,15));
            artflow.getChildren().addAll(v);
        }
        //setBackground();
        s = new ScrollPane();
        //s.setId("pane");
        s.setContent(artflow);

        s.isPannable();
        s.setStyle("edge-to-edge");
        border.setCenter(s);
    }
}
