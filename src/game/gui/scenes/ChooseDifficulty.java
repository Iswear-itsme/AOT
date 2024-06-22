package game.gui.scenes;

import java.io.File;
import java.io.IOException;

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

public class ChooseDifficulty extends Scene{
	 public ChooseDifficulty(Parent root) {
	    	super(root,1920,1800);
	    	 BorderPane b= new BorderPane();
	    	 AudioClip sword = new AudioClip(new File("src/game/gui/sounds/sword.mp3").toURI().toString());
	         sword.setCycleCount(1);
		        BackgroundSize backgroundSize = new BackgroundSize(1920, 1800, true, true, true, false);
		        BackgroundImage backgroundImage = new BackgroundImage(new Image("game/gui/images/choosedif"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		         
		        b.setBackground(new Background(backgroundImage));
		         Button e=new Button();
		         Button h=new Button();
		         Button r=new Button();
		         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), b);
		         fadeTransition.setFromValue(1.0);
		         fadeTransition.setToValue(0.0);
		         FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1), b);
		         fadeTransition1.setFromValue(0.0);
		         fadeTransition1.setToValue(1.0);
		         fadeTransition1.play();
		         
		         e.setOnAction(new EventHandler<ActionEvent>() { 
		    		 @Override
		    		 public void handle(ActionEvent event) {
		    			 MainMenu.mp.stop();
		    			 MainMenu.flag=true;
		    			 sword.play();
		    			 fadeTransition.play();
		    			try {
		    				
							Launcher.currView.setScene(new Easy(new BorderPane()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
						
						}
		    			Launcher.currView.setFullScreen(true);
		    		 }});
		         r.setOnAction(new EventHandler<ActionEvent>() { 
		  
		    		 @Override
		    		 public void handle(ActionEvent event) {
		    			 sword.play();
		    			 fadeTransition.play();
		    			Launcher.currView.setScene(new MainMenu(new BorderPane()));
		    			Launcher.currView.setFullScreen(true);
		    		 }});
		         h.setOnAction(new EventHandler<ActionEvent>() { 
		    		 @Override
		    		 public void handle(ActionEvent event) {
		    			 sword.play();
		    			 fadeTransition.play();
		    			 MainMenu.mp.stop();
		    			 MainMenu.flag=true;
		    			try {
		    				
							Launcher.currView.setScene(new Hard(new BorderPane()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			Launcher.currView.setFullScreen(true);
		    		 }});
		     
		        b.setTop(e);
		         e.setTranslateX(450);
		         e.setTranslateY(150);
		         e.setMinSize(200, 200);
		         r.setMinSize(210, 100);
		         h.setMinSize(200 ,200);
		         b.setCenter(h);
		         h.setTranslateX(450);
		         h.setTranslateY(200);
		        b.setLeft(r);
		        r.setTranslateX(60);
		        r.setTranslateY(-140);
		        r.setOpacity(0);
		        e.setOpacity(0);
		        h.setOpacity(0);
		         this.setRoot(b);

}
	 }
