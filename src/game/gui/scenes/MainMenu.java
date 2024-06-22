package game.gui.scenes;
import java.io.File;
import game.gui.Launcher;
import javafx.animation.FadeTransition;


import javafx.animation.ScaleTransition;

import javafx.animation.TranslateTransition;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.*;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javafx.util.Duration;

public class MainMenu extends Scene {
	
	public static boolean flag=true;
	public static AudioClip mp;
    public MainMenu(Parent root) {
    	super(root,1920,1800);
     	Media med=new Media(new File("src/game/gui/images/bgm.mp4").toURI().toString());
    	MediaPlayer medp=new MediaPlayer(med);
    	MediaView bgvid = new MediaView(medp);
    	medp.setVolume(0);
    	medp.setCycleCount(5);
    	medp.play();
    	medp.setAutoPlay(true);
    	 mp = new AudioClip(new File("src/game/gui/sounds/mainmenu theme.mpeg").toURI().toString());
        mp.setCycleCount(1);
        if(flag==true){
        	mp.play();
        	flag=false;
        }
        
        	
    
     AudioClip sword = new AudioClip(new File("src/game/gui/sounds/sword.mp3").toURI().toString());
        sword.setCycleCount(1);
        
        BorderPane b = new BorderPane();
        
        b.getChildren().add(bgvid);
        this.setCursor(new ImageCursor(new Image("game/gui/images/Cursor.png")));
        VBox buttons = new VBox();
       Image im1=new Image("game/gui/images/ATTACK-ON-TITAN--UTOPIA.png");
       ImageView attOn= new ImageView (im1);    
        ImageView qwe1= new ImageView(new Image("game/gui/images/Start.png"));
        ImageView qwe2= new ImageView(new Image("game/gui/images/ControlsButton.png"));
        ImageView qwe3= new ImageView(new Image("game/gui/images/Rules.png"));
        ImageView qwe4= new ImageView(new Image("game/gui/images/Description (1).png"));
        ImageView qwe5= new ImageView(new Image("game/gui/images/Exit.png"));
        HBox stack = new HBox();
        stack.getChildren().addAll(attOn);
        stack.setAlignment(Pos.CENTER);
        //stack.setTranslateY(-300.0);
        b.setCenter(stack);
       Button Start=createButton("", 0);
       Start.setGraphic(qwe1);
       Button Controls=createButton("", 24);
       Controls.setGraphic(qwe2);
       Button Rules= createButton("", 24);
       Rules.setGraphic(qwe3);
       Button Credits= createButton("", 24);
       Credits.setGraphic(qwe4);
       Button Exit= createButton("", 24);
       Exit.setGraphic(qwe5);
       TranslateTransition f= new TranslateTransition();
       f.setDuration(Duration.seconds(2));
       f.setDelay(Duration.seconds(1));
       f.setNode(Start);
       f.setToX(50);
      // f.setToY(-10);
       f.setAutoReverse(true);
       f.setCycleCount(100);
       f.play();
       TranslateTransition g= new TranslateTransition();
       g.setDuration(Duration.seconds(2));
       g.setNode(Controls);
       g.setToX(-20);
      // g.setToY(-10);
       g.setAutoReverse(true);
       g.setCycleCount(100);
       g.play();
       TranslateTransition h= new TranslateTransition();
       h.setDuration(Duration.seconds(2));
       h.setNode(Rules);
       h.setToX(45);
      // h.setToY(-10);
       h.setAutoReverse(true);
       h.setCycleCount(100);
       h.play();
       TranslateTransition l= new TranslateTransition();
       l.setDuration(Duration.seconds(2));
       l.setNode(Exit);
       l.setToX(-15);
       l.setAutoReverse(true);
       l.setCycleCount(100);
       l.play();
       TranslateTransition m= new TranslateTransition();
       m.setDuration(Duration.seconds(2));
       m.setNode(Start);
       m.setToX(40);
       m.setAutoReverse(true);
       m.setCycleCount(100);
       m.play();
       TranslateTransition n= new TranslateTransition();
       n.setDuration(Duration.seconds(2));
       n.setNode(buttons);
       n.setToX(50);
       //n.setToY(200);
       n.setAutoReverse(true);
       n.setCycleCount(100);
       n.play();
       buttons.setTranslateY(500);
       FadeTransition fade1= new FadeTransition();
       fade1.setNode(buttons);
       fade1.setDuration(Duration.seconds(10));
       fade1.setAutoReverse(true);
       fade1.setCycleCount(1000);
       fade1.setRate(10);
       fade1.setFromValue(1.0);
       fade1.setToValue(0);
       fade1.play();
     ScaleTransition scale1=new ScaleTransition();
     stack.setScaleX(2);
     stack.setScaleY(2);
     scale1.setNode(stack);
     scale1.setAutoReverse(true);
    scale1.setToX(1);
    scale1.setToY(1);
    scale1.setDuration(Duration.seconds(5));
    scale1.play();
     
      FadeTransition fade3=new FadeTransition();
      fade3.setNode(stack);
      fade3.setFromValue(0);
      fade3.setDuration(Duration.seconds(5));
      fade3.setToValue(1);
      fade3.play();
      fade3.setCycleCount(1);
   
    	
        
         buttons.setSpacing(10);
      buttons.getChildren().addAll(
              Start ,
            Controls,
            Rules,
            Credits,
             Exit
        );

        buttons.setTranslateX(-10);
        buttons.setTranslateY(120);
       b.setLeft(buttons);
      
       FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), b);
       fadeTransition.setFromValue(1.0);
       fadeTransition.setToValue(0.0);
       FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1), b);
       fadeTransition1.setFromValue(0.0);
       fadeTransition1.setToValue(1.0);
       fadeTransition1.play();
       
    
      
       this.setRoot(b);
       Start.setOnAction(new EventHandler<ActionEvent>() { 
  		 @Override
  		 public void handle(ActionEvent event) {
  			 sword.play();
  			 
  			//mp.stop();
  			fadeTransition.play();
  			 fadeTransition.setOnFinished(event1 -> {
  			Launcher.currView.setScene(new ChooseDifficulty(new BorderPane()));
  			Launcher.currView.setFullScreen(true);
  			
  			 });
  		 }});
       Controls.setOnAction(new EventHandler<ActionEvent>() { 
    		 @Override
    		 public void handle(ActionEvent event) {
    			 sword.play();
    			 fadeTransition.play();
      			 fadeTransition.setOnFinished(event1 -> {
    			Launcher.currView.setScene(new Controls(new BorderPane()));
    			Launcher.currView.setFullScreen(true);});
      			
      			flag=true;
      			//mp.pause();
      			
    		 }});
        
       Credits.setOnAction(new EventHandler<ActionEvent>() { 
    		 @Override
    		 public void handle(ActionEvent event) {
    			 sword.play();
    			 fadeTransition.play();
      			 fadeTransition.setOnFinished(event1 -> {
    			Launcher.currView.setScene(new GameDescription(new BorderPane()));
    			Launcher.currView.setFullScreen(true);});
    			
    		 }});
       Rules.setOnAction(new EventHandler<ActionEvent>() { 
    		 @Override
    		 public void handle(ActionEvent event) {
    			 sword.play();
    			 fadeTransition.play();
      			 fadeTransition.setOnFinished(event1 -> {
    			Launcher.currView.setScene(new Rules(new BorderPane()));
    			Launcher.currView.setFullScreen(true);});
    	
    		 }});
       Exit.setOnAction(new EventHandler<ActionEvent>() { 
    		 @Override
    		 public void handle(ActionEvent event) {
    			 sword.play();
    			 Launcher.currView.close();
					System.exit(0);
    		 }});
       
      
    }

    
    private Button createButton(String text, double fontSize) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: transparent;");
        return button;
    }

   
}