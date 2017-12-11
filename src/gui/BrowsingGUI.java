package gui;

import javafx.application.Application;
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


public class BrowsingGUI extends Application {

    FlowPane artflow;
    ScrollPane s;
    BorderPane border;
    VBox root2;
    ScrollPane artShow;
    Stage window;
    Scene showArt;


    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
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

        Image image = new Image(SystemController.user.getAvatar(),150,150,false,false);
        ImageView userAvatar = new ImageView(image);

        userAvatar.setPickOnBounds(true);
        userAvatar.setOnMouseClicked((MouseEvent e) -> {
            if(e.getClickCount() == 2){
                try{
                    Parent UserProfile = FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
                    window.setScene(new Scene(UserProfile,600,400));
                }catch(Exception f){
                    f.printStackTrace();
                }
            }
        });


        root2.getChildren().addAll(showAll,painting,sculpture,userAvatar);

        //border.getChildren().addAll(root,root2);
        border.setRight(root2);

        Button btn = new Button("Change Background");


        //data for artworks
        String[] sculptures = { "file:/Users/huxtable/IdeaProjects/Artatawe/src/gui/coast.jpg",
                "file:/Users/huxtable/IdeaProjects/Artatawe/src/gui/blue.jpg",
                "file:/Users/huxtable/IdeaProjects/Artatawe/src/gui/green.jpg",
                "file:/Users/huxtable/IdeaProjects/Artatawe/src/gui/ice.jpg",
                "file:/Users/huxtable/IdeaProjects/Artatawe/src/gui/moon.jpg",
        };

        String[] paintings = {  "file:/Users/huxtable/IdeaProjects/Artatawe/src/gui/cake.jpg",
                "file:/Users/huxtable/IdeaProjects/Artatawe/src/gui/cherry.jpg",
                "file:/Users/huxtable/IdeaProjects/Artatawe/src/gui/mushroom.jpg",
                "file:/Users/huxtable/IdeaProjects/Artatawe/src/gui/house.jpg",
                "file:/Users/huxtable/IdeaProjects/Artatawe/src/gui/rainbow.jpg",
                "file:/Users/huxtable/IdeaProjects/Artatawe/src/gui/snow.jpg",
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



        showArt = new Scene(border, 900, 500);
        showArt.getStylesheets().addAll(this.getClass().getResource("setBackground.CSS").toExternalForm());
        window.setScene(showArt);
        window.setTitle("Browsing");
        window.show();
    }
    /*@FXML
    Button bb;
    public static void main(String[] args) {
        launch(args);
    }
*/
    //Show the Painting or Sculpture or both
    public void filter(String[] type){
        artflow = new FlowPane();
        artflow.setId("pane");
        artflow.setPrefWidth(600);
        for(int i=0;i<type.length;i++){
            VBox v = new VBox();
            Image image = new Image(type[i],150,150,false,false);
            ImageView artworkPhoto = new ImageView(image);

            //allows image double click
            artworkPhoto.setPickOnBounds(true);
            artworkPhoto.setOnMouseClicked((MouseEvent e) -> {
                if(e.getClickCount() == 2){
                    try{
                        SystemController.artworkView = artworkPhoto.getImage().getUrl();
                        Parent ArtworkDetails = FXMLLoader.load(getClass().getResource("ArtworkDetails.fxml"));

                        window.setScene(new Scene(ArtworkDetails,600,400));
                    }catch(Exception f){
                        f.printStackTrace();
                    }
                }
            });

            Label title = new Label("Title: Coast");
            Label descrip = new Label("Description");
            v.getChildren().addAll(artworkPhoto,title,descrip);
            v.setSpacing(10);
            v.setPadding(new Insets(50,15,15,15));
            artflow.getChildren().addAll(v);
        }
        //setBackground();
        s = new ScrollPane();
        //s.setId("pane");
        s.setContent(artflow);

        s.isPannable();
        border.setCenter(s);
    }
}
