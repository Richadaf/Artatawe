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

/**
 * @author Sam Huxtable
 */
public class DrawingController {

    //Variable Declarations
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
    private File profilePic;
    private Boolean start = true;
    private double startX;
    private double startY;
    private double endX;
    private double endY;

    /**
     * Opens a pane to choose an avatar
     * @throws Exception
     */
    @FXML
    public void toAvatarPane() throws Exception{
        Stage secondStage = new Stage();
        Parent avatarPane = FXMLLoader.load(getClass().getResource("Avatar.fxml"));
        secondStage.setTitle("Select An Avatar");
        secondStage.setScene(new Scene(avatarPane, 600, 400));
        secondStage.show();
    }

    /**
     * Gets thickness from the slider
     * @return The sliders value
     */
    @FXML
    public double getStrokeWidth() {
        return slider.getValue();
    }

    /**
     * Gets colour from the Color Picker
     * @return Colour
     */
    @FXML
    public Color getColor() {
        return colourPick.getValue();
    }

    /**
     * Takes a Mouse Event and uses it to draw a line, Curve or For an eraser.
     * @param e
     */
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

    /**
     * Saves a canvas after making sure there is no avatar selected
     */
    public void saveCanvas() {
        chosenAvatar = null;
        saveImage();
    }

    /**
     * Opens a pop up saying the image has been saved
     * @throws Exception
     */
    public void imageSaved() {
        try {
            Stage popUp = new Stage();
            Parent popUpPane = FXMLLoader.load(getClass().getResource("popUp.fxml"));
            popUp.setTitle("Image Saved");
            popUp.setScene(new Scene(popUpPane, 600, 400));
            popUp.show();
        } catch (Exception e) {
            System.out.print("Failed to save image: " + e);
        }
    }

    /**
     * Saves canvas to an image or saves avatar
     */
    @FXML
    public void saveImage() {
        if(chosenAvatar == null) {
            WritableImage wim = new WritableImage(400, 400);
            canvas.snapshot(null, wim);
            profilePic = new File("CanvasImage.png");


            try {
                ImageIO.write(SwingFXUtils.fromFXImage(wim, null), "png", profilePic);
                imageSaved();
                //users.User.setImage("CanvasImage.png");
            } catch (Exception e) {
                System.out.print("Failed to save image: " + e);
            }
        } else {
            imageSaved();
            //users.User.setImage(getImage());
        }

    }

    /**
     * Sets the selected avatar to picture 1
     */
    public void chosen1() {
        chosenAvatar = AvatarSelected.AVATAR_1;
    }

    /**
     * Sets the selected avatar to picture 2
     */
    public void chosen2() {
        chosenAvatar = AvatarSelected.AVATAR_2;
    }

    /**
     * Sets the selected avatar to picture 3
     */
    public void chosen3() {
        chosenAvatar = AvatarSelected.AVATAR_3;
    }

    /**
     * Sets the selected avatar to picture 4
     */
    public void chosen4() {
        chosenAvatar = AvatarSelected.AVATAR_4;
    }

    /**
     * Sets the selected avatar to picture 5
     */
    public void chosen5() {
        chosenAvatar = AvatarSelected.AVATAR_5;
    }

    /**
     * Sets the selected avatar to picture 6
     */
    public void chosen6() {
        chosenAvatar = AvatarSelected.AVATAR_6;
    }

    /**
     * Gets the avatar URL
     * @return Image URL
     */
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
                return "";
        }
    }
}
