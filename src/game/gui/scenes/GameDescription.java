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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class GameDescription extends Scene {
	public GameDescription(Parent root){
		super (root,1920,1800);
		
		AnchorPane ap=new AnchorPane();
		 AudioClip sword = new AudioClip(new File("src/game/gui/sounds/sword.mp3").toURI().toString());
	        sword.setCycleCount(1);
		 BackgroundSize backgroundSize = new BackgroundSize(1920, 1800, true, true, true, false);
	        BackgroundImage backgroundImage = new BackgroundImage(new Image("game/gui/images/game_desc_new.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
	         ap.setBackground(new Background(backgroundImage));
	 Button ret=new Button();
	 ret.setPrefSize(200,60);
     ret.setLayoutX(30);
     ret.setLayoutY(20);
     ret.setOpacity(0);
     ap.getChildren().add(ret);
     FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), ap);
     fadeTransition.setFromValue(1.0);
     fadeTransition.setToValue(0.0);
     FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1), ap);
     fadeTransition1.setFromValue(0.0);
     fadeTransition1.setToValue(1.0);
     fadeTransition1.play();
     ret.setOnAction(new EventHandler<ActionEvent>() { 
  		 @Override
  		 public void handle(ActionEvent event) {
  			AudioClip sword = new AudioClip(new File("src/game/gui/sounds/sword.mp3").toURI().toString());
  			sword.play();
  	        sword.setCycleCount(1);
  	      fadeTransition.play();
			 fadeTransition.setOnFinished(event1 -> {
  			Launcher.currView.setScene(new MainMenu(new BorderPane()));
  			Launcher.currView.setFullScreen(true);});
  		 }});
     this.setRoot(ap);
}}
