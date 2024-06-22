package game.gui.scenes;

import game.gui.Launcher;

import java.io.File;

import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class WeaponInfo extends Scene{
	public WeaponInfo(Parent root){
		super (root,1920,1800);
		
        AudioClip sword = new AudioClip(new File("src/game/gui/sounds/sword.mp3").toURI().toString());
        sword.setCycleCount(1);
        BorderPane b = new BorderPane();
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), b);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1), b);
        fadeTransition1.setFromValue(0.0);
        fadeTransition1.setToValue(1.0);
        fadeTransition1.play();
        this.setCursor(new ImageCursor(new Image("game/gui/images/Cursor.png")));
        BackgroundSize backgroundSize = new BackgroundSize(1920, 1800, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("game/gui/images/wep info.jpeg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
         b.setBackground(new Background(backgroundImage));
       
       
         Button r=new Button();
         r.setMinSize(210, 100);
         
         b.setLeft(r);
        
         r.setOpacity(0);
         r.setOnAction(new EventHandler<ActionEvent>() { 
      		 @Override
      		 public void handle(ActionEvent event) {
      			 sword.play();
      			 
      			fadeTransition.play();
      			Launcher.currView.setScene(new Rules(new BorderPane()));
      			Launcher.currView.setFullScreen(true);
      		 }});
      
         
         
         
         
         
         this.setRoot(b);
         
			
		
	}

}
