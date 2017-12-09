package gui;

// import com.sun.deploy.util.ArrayUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.stream.Stream;


public class Main extends Application {

    FlowPane root;
    BorderPane border;
    VBox root2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        border = new BorderPane();
        root = new FlowPane();
        root2 = new VBox();
        root2.setPadding(new Insets(50,30,20,20));
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
        border.setCenter(root);
        border.setRight(root2);

        //setup background picture;
        Image image1 = new Image("file:/C:/Users/Hunte/Pictures/Saved%20Pictures/Christmas-Lights-Background.jpeg");
        Image image2 = new Image("https://cdn.sstatic.net/Sites/stackoverflow/company/img/logos/so/so-logo.png?v=9c558ec15d8a");

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

        Background background2 = new Background(new BackgroundImage(image2,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize));

        border.setBackground(new Background(new BackgroundImage(image1,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize
                )));

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


        Scene showArt = new Scene(border, 900, 500);
        primaryStage.setScene(showArt);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Show the Painting or Sculpture or both
    public void filter(String[] type){
        root = new FlowPane();
        for(int i=0;i<type.length;i++){
            VBox v = new VBox();
            Image image = new Image(type[i],150,150,false,false);
            ImageView a = new ImageView(image);

            //allows image double click
            a.setPickOnBounds(true);
            a.setOnMouseClicked((MouseEvent e) -> {
                if(e.getClickCount() == 2){
                    //go to artwork detail
                    System.out.println("Double clicked");
                }
            });

            Label l = new Label("Title: Coast");
            v.getChildren().addAll(a,l);
            v.setSpacing(5);
            v.setPadding(new Insets(50,15,15,15));
            root.getChildren().addAll(v);
        }
        border.setCenter(root);
    }


}
