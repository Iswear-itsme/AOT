package game.gui.scenes;



import java.io.File;

import game.gui.Launcher;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Credits extends Scene{
		 public Credits(Parent root) {
		    	super(root,1920,1800);
		    	Media med=new Media(new File("src/game/gui/images/creds.mp4").toURI().toString());
		    	MediaPlayer medp=new MediaPlayer(med);
		    	MediaView bgvid = new MediaView(medp);
		    	medp.setVolume(0);
		    	medp.setCycleCount(5);
		    	medp.play();
		    	medp.setAutoPlay(true);
		    	 BorderPane b= new BorderPane();
			         this.setOnKeyPressed(new EventHandler<KeyEvent>()
				        		{
				        			 @Override
				        	          public void handle(KeyEvent event) {
				        				 if (event.getCode()==KeyCode.ESCAPE)
			    			 Launcher.currView.close();
								System.exit(0);
			    		 }});
			        b.getChildren().add(bgvid);
			       this.setRoot(b);
}
}
