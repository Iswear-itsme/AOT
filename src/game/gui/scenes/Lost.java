package game.gui.scenes;

import java.io.File;

import game.gui.Launcher;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Lost extends Scene{
	 public Lost(Parent root) {
	    	super(root,1920,1800);
	    	Media mm_au = new Media(new File("src/game/gui/sounds/lost.mpeg").toURI().toString());
	        MediaPlayer mp=new MediaPlayer(mm_au);
	        mp.play();
	    	 BorderPane b= new BorderPane();
		        BackgroundSize backgroundSize = new BackgroundSize(1920, 1800, true, true, true, false);
		        BackgroundImage backgroundImage = new BackgroundImage(new Image("game/gui/images/lost.jpeg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		         
		        b.setBackground(new Background(backgroundImage));
		        Button w=new Button();
		         Button t=new Button();
		         Font faont1=Font.loadFont(getClass().getResourceAsStream("Ditty.ttf"), 40);
		         Text s=new Text();
		         s.setTranslateY(400);
		         s.setFill(Color.SILVER);
		         DropShadow dropShadow = new DropShadow();
		         dropShadow.setOffsetX(2.0);
		         dropShadow.setOffsetY(2.0);
		         dropShadow.setColor(Color.BLACK);

		         s.setEffect(dropShadow);
		         s.setFont(faont1);
		         if (Hard.hard)
		          s.setText("score:"+Hard.battle.getScore()+"\ncivillians evacuated:"+Hard.battle.getScore()/10+"\nhi-score(e):"+Easy.HiScoreE+"\nhi-score(h)"+Hard.HiScoreH);
		         else
		           s.setText("score:"+Easy.battle.getScore()+"\ncivillians evacuated:"+Easy.battle.getScore()/10+"\nhi-score(e):"+Easy.HiScoreE+"\nhi-score(h)"+Hard.HiScoreH);
		     
		         HBox x=new HBox();
	
		         w.setMinSize(400, 200);
		         t.setMinSize(400, 200);
		         x.getChildren().addAll(w,t);
		         x.setTranslateY(-200);
		         t.setTranslateX(450);
		         x.setTranslateX(400);
		         w.setTranslateX(-200);
		         x.setOpacity(0);
		         b.setLeft(s);
		         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), b);
		         fadeTransition.setFromValue(1.0);
		         fadeTransition.setToValue(0.0);
		         FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1), b);
		         fadeTransition1.setFromValue(0.0);
		         fadeTransition1.setToValue(1.0);
		         fadeTransition1.play();
		         w.setOnAction(new EventHandler<ActionEvent>() { 
		    		 @Override
		    		 public void handle(ActionEvent event) {
		    			 mp.pause();
		    			Launcher.currView.setScene(new MainMenu(new BorderPane()));
		    			Launcher.currView.setFullScreen(true);
		    		 }});
		        t.setOnAction(new EventHandler<ActionEvent>() { 
		    		 @Override
		    		 public void handle(ActionEvent event) {
		    			Launcher.currView.setScene(new Credits(new BorderPane()));
		    			Launcher.currView.setFullScreen(true);
		    		 }});
		       
		         b.setBottom(x);
		     this.setRoot(b);

}
}
