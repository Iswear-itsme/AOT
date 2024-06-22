package game.gui.scenes;

import game.gui.Launcher;

import java.io.File;




import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
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


public class Controls extends Scene{
	
	public Controls(Parent root){
		super (root,1920,1800);
		
		
        AnchorPane ap=new AnchorPane();
        
        this.setCursor(new ImageCursor(new Image("game/gui/images/Cursor.png")));
        BackgroundSize backgroundSize = new BackgroundSize(1920, 1800, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("game/gui/images/Controls_screen_2.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        ap.setBackground(new Background(backgroundImage));
        
        
        Button r=new Button();
        r.setPrefSize(200, 60);;
        r.setLayoutX(45);
        r.setLayoutY(35);
        r.setOpacity(0);
        ap.getChildren().add(r);
        
        
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), ap);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        
        r.setOnAction(new EventHandler<ActionEvent>() { 
     		 @Override
     		 public void handle(ActionEvent event) {
     			AudioClip sword = new AudioClip(new File("src/game/gui/sounds/sword.mp3").toURI().toString());
     			sword.play();
     	        sword.setCycleCount(1);
     	        fadeTransition.play();
   			    fadeTransition.setOnFinished(event1 -> {
     			Launcher.currView.setScene(new MainMenu(new BorderPane()));
     			Launcher.currView.setFullScreen(true);
   			    });
   			    }
     		    });
	
         
         
         
         this.setRoot(ap);
	}
	
	
}