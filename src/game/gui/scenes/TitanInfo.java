package game.gui.scenes;

import java.io.File;

import game.gui.Launcher;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class TitanInfo extends Scene {
	 public TitanInfo(Parent root) {
	    	super(root,1920,1800);
	    	
	        AudioClip sword = new AudioClip(new File("src/game/gui/sounds/sword.mp3").toURI().toString());
	        sword.setCycleCount(1);
	    	 BorderPane b= new BorderPane();
		        BackgroundSize backgroundSize = new BackgroundSize(1920, 1800, true, true, true, false);
		        BackgroundImage backgroundImage = new BackgroundImage(new Image("game/gui/images/height charte.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), b);
		        fadeTransition.setFromValue(1.0);
		        fadeTransition.setToValue(0.0);
		        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1), b);
		        fadeTransition1.setFromValue(0.0);
		        fadeTransition1.setToValue(1.0);
		        fadeTransition1.play();
		        b.setBackground(new Background(backgroundImage));
		         Button e=new Button();
		         e.setMinSize(400, 200);
		         e.setOpacity(0);
		         e.setTranslateY(900);
		         e.setTranslateX(-50);
		         b.setRight(e);
                this.setRoot(b);
                e.setOnAction(new EventHandler<ActionEvent>() { 
            		 @Override
            		 public void handle(ActionEvent event) {
            			 sword.play();
            		
            			 fadeTransition.play();
            			Launcher.currView.setScene(new Rules(new BorderPane()));
            			Launcher.currView.setFullScreen(true);
            		 }});
}
}
