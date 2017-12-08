package gui;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;


public class DrawingController {

    @FXML
    private Slider slider;
    @FXML
    private ToggleButton curveBut;
    @FXML
    private ToggleButton lineBut;
    @FXML
    private ToggleButton eraserBut;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colourPick;
    @FXML
    private Image pic1;
    @FXML
    private Image pic2;
    @FXML
    private Image pic3;
    @FXML
    private Image pic4;
    @FXML
    private Image pic5;
    @FXML
    private Image pic6;

    private AvatarSelected chosenAvatar;
    File profilePic;
    Boolean start = true;
    double startX;
    double startY;
    double endX;
    double endY;

    @FXML
    public void toAvatarPane() throws Exception{
        Stage secondStage = new Stage();
        Parent avatarPane = FXMLLoader.load(getClass().getResource("gui/Avatar.fxml"));
        secondStage.setTitle("Select An Avatar");
        secondStage.setScene(new Scene(avatarPane, 600, 400));
        secondStage.show();
    }

    @FXML
    public double getStrokeWidth() {
        return slider.getValue();
    }

    @FXML
    public Color getColor() {
        return colourPick.getValue();
    }

    @FXML
    public void drawShape(MouseEvent e) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        if(lineBut.isSelected()) {

            if(e.getEventType() == MouseEvent.MOUSE_DRAGGED && start == true) {
                startX = e.getX();
                startY = e.getY();
                start = false;
            }
            if(e.getEventType() == MouseEvent.MOUSE_CLICKED) {
                endX = e.getX();
                endY = e.getY();
                start = true;
                gc.setStroke(getColor());
                gc.setLineWidth(getStrokeWidth()/2);
                gc.strokeLine(startX, startY, endX, endY);
            }
        }

        else if(curveBut.isSelected()) {
            gc.setFill(getColor());
            gc.fillOval(e.getX() - (getStrokeWidth()/4), e.getY() - (getStrokeWidth()/4), (getStrokeWidth() / 2), (getStrokeWidth() / 2));
        }

        else if(eraserBut.isSelected()) {
            gc.clearRect(e.getX() - (getStrokeWidth()/4), e.getY() - (getStrokeWidth()/4), (getStrokeWidth()/2), (getStrokeWidth()/2));
        }
    }

    public void saveCanvas() {
        chosenAvatar = null;
        saveImage();
    }

    public void imageSaved() {
        try {
            Stage popUp = new Stage();
            Parent popUpPane = FXMLLoader.load(getClass().getResource("gui/popUp.fxml"));
            popUp.setTitle("Image Saved");
            popUp.setScene(new Scene(popUpPane, 600, 400));
            popUp.show();
        } catch(Exception e) {
        }
    }

    @FXML
    public void saveImage() {
        if(chosenAvatar == null) {
            WritableImage wim = new WritableImage(400, 400);
            canvas.snapshot(null, wim);
            profilePic = new File("CanvasImage.png");


            try {
                ImageIO.write(SwingFXUtils.fromFXImage(wim, null), "png", profilePic);
                imageSaved();
                //User.setImage("CanvasImage.png");
            } catch (Exception e) {
                System.out.print("Failed to save image: " + e);
            }
        } else {
            imageSaved();
            //User.setImage(getImage());
        }

    }

    public void chosen1() {
        chosenAvatar = AvatarSelected.AVATAR_1;
    }
    public void chosen2() {
        chosenAvatar = AvatarSelected.AVATAR_2;
    }
    public void chosen3() {
        chosenAvatar = AvatarSelected.AVATAR_3;
    }
    public void chosen4() {
        chosenAvatar = AvatarSelected.AVATAR_4;
    }
    public void chosen5() {
        chosenAvatar = AvatarSelected.AVATAR_5;
    }
    public void chosen6() {
        chosenAvatar = AvatarSelected.AVATAR_6;
    }

    public String getImage() {
        switch (chosenAvatar) {
            case AVATAR_1:
                return pic1.getUrl();

            case AVATAR_2:
                return pic2.getUrl();

            case AVATAR_3:
                return pic3.getUrl();

            case AVATAR_4:
                return pic4.getUrl();

            case AVATAR_5:
                return pic5.getUrl();

            case AVATAR_6:
                return pic6.getUrl();

            default:
                return "No avatar chosen";
        }
    }
}
