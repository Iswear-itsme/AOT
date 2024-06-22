package game.gui.scenes;

import game.gui.Launcher;

import java.io.File;

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
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class Rules extends Scene {
	public Rules(Parent root){
    	super(root,1920,1800);
    	
        AudioClip sword = new AudioClip(new File("src/game/gui/sounds/sword.mp3").toURI().toString());
        sword.setCycleCount(1);
    	BorderPane b= new BorderPane();
        BackgroundSize backgroundSize = new BackgroundSize(1920, 1800, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("game/gui/images/titan_weapon_info.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
         
        b.setBackground(new Background(backgroundImage));
         Button w=new Button();
         Button t=new Button();
         Button r=new Button();
         HBox x=new HBox();
         w.setMinSize(400, 200);
         t.setMinSize(400, 200);
         x.getChildren().addAll(w,t);
         x.setTranslateY(-50);
         t.setTranslateX(350);
         x.setTranslateX(400);
         x.setOpacity(0);
        r.setMinSize(210, 100);
        b.setLeft(r);
         b.setBottom(x);
        r.setOpacity(0);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), b);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1), b);
        fadeTransition1.setFromValue(0.0);
        fadeTransition1.setToValue(1.0);
        fadeTransition1.play();
        r.setOnAction(new EventHandler<ActionEvent>() { 
    		 @Override
    		 public void handle(ActionEvent event) {
    			 sword.play();
    			 fadeTransition.play();
    			Launcher.currView.setScene(new MainMenu(new BorderPane()));
    			Launcher.currView.setFullScreen(true);}});
        w.setOnAction(new EventHandler<ActionEvent>() { 
    		 @Override
    		 public void handle(ActionEvent event) {
    			 sword.play();
    			 
    			 fadeTransition.play();
    			Launcher.currView.setScene(new WeaponInfo(new BorderPane()));
    			Launcher.currView.setFullScreen(true);
    		 }});
        t.setOnAction(new EventHandler<ActionEvent>() { 
    		 @Override
    		 public void handle(ActionEvent event) {
    			 sword.play();
    			 
    			 fadeTransition.play();
    			Launcher.currView.setScene(new TitanInfo(new BorderPane()));
    			Launcher.currView.setFullScreen(true);
    		 }});
        
         this.setRoot(b);
}}
