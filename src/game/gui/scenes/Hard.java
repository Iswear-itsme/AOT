package game.gui.scenes;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import game.gui.Launcher;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import game.engine.lanes.Lane;
import game.engine.lanes.Tiles;
import game.engine.titans.AbnormalTitan;
import game.engine.titans.ArmoredTitan;
import game.engine.titans.ColossalTitan;
import game.engine.titans.PureTitan;
import game.engine.titans.Titan;
import game.engine.weapons.PiercingCannon;
import game.engine.weapons.SniperCannon;
import game.engine.weapons.VolleySpreadCannon;
import game.engine.weapons.WallTrap;
import game.engine.weapons.Weapon;
import game.engine.*;
import game.engine.exceptions.*;
public class Hard extends Scene {
	 public static  Battle battle;
	public  static GridPane grid;
	public static boolean exception=false;
	private static Image p1=(new Image("game/gui/images/pure.png"));
	 private static Image p2=(new Image("game/gui/images/col.png"));
	 private static Image p3=(new Image("game/gui/images/arm.png"));
	private static  Image p4=(new Image("game/gui/images/abnorm.png"));
	private static Image w1=(new Image("game/gui/images/apc.png"));
	 private static Image w2=(new Image("game/gui/images/asc.png"));
	 private static Image w3=(new Image("game/gui/images/avc.png"));
	private static  Image w4=(new Image("game/gui/images/awt.png"));
	private static Image lo=(new Image("game/gui/images/image.png"));
    private static Image ld=(new Image("game/gui/images/borken.jfif"));
	public static VBox wal;
	public Text score;
	public Text turn;
	public Text phase;
	public Text rsrc;
	FadeTransition f;
	TranslateTransition m;
	public static ProgressBar hpBar;
	public static Lane lane;
	BorderPane b;
	public VBox wep;
	public  HBox wep1;
	public static HBox wep2;
	public static HBox wep3;
	public  static HBox wep4;
	public static HBox wep5;
	public static int ln;
	public  AudioClip vogel;
   public static boolean hard;
   FadeTransition fadeTransition;
   public static int HiScoreH;
	    public Hard(Parent root) throws IOException {
	    	super(root,1920,1800);
	        vogel = new AudioClip(new File("src/game/gui/sounds/hard.mpeg").toURI().toString());
	        vogel.setCycleCount(1);
	        vogel.play();
	    	
	         b= new BorderPane();
	        BackgroundSize backgroundSize = new BackgroundSize(1920, 1800, true, true, true, false);
	        BackgroundImage backgroundImage = new BackgroundImage(new Image("game/gui/images/hard_bg.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
	         b.setBackground(new Background(backgroundImage));
//	         Media med=new Media(new File("src/game/gui/sounds/Untitled video - Made with Clipchamp.mp4").toURI().toString());
//		    	MediaPlayer medp=new MediaPlayer(med);
//		    	medp.setRate(20);
//		    	MediaView bgvid = new MediaView(medp);
//		    	medp.play();
//		    	medp.setCycleCount(20);
//		  
//		    	medp.setAutoPlay(true);
//		    	b.getChildren().add(bgvid);
	        HBox shop= new HBox();
	        VBox walls=new VBox();
	        VBox label=new VBox();
	        score=new Text("Score:0");
      
       Font faont1=Font.loadFont(getClass().getResourceAsStream("Trumpit.otf"), 40);
score.setFont(faont1);
	         turn = new Text("Turn:1");
	        turn.setFont(faont1);
	         phase=new Text("Phase:EARLY");
	        phase.setFont(faont1);
	         rsrc=new Text("Resources:625");
	        rsrc.setFont(faont1);
	        label.getChildren().addAll(score,turn,phase,rsrc);
	    
	        Button exc= mButton();
	        exc.setMinSize(300, 270);
	        exc.setTranslateX(90);
	        
	         grid = new GridPane();
	        grid.setHgap(10);
	        grid.setVgap(10);
	        
	        wal=new VBox();
	        wep=new VBox();
	        hpBar=new ProgressBar();
	        b.getChildren().addAll(grid,walls,shop,label,wal,wep);
	        wal.setTranslateX(300);
	        wal.setTranslateY(300);
	        ImageView v1=new ImageView(w1);
			   ImageView v2=new ImageView(w2);
			   ImageView v3=new ImageView(w3);
			   ImageView v4=new ImageView(w4);
			   Button ein= mButton();
		        ein.setGraphic(new ImageView(new Image("game/gui/images/shop.jpeg")));
		       
	           v1.setFitWidth(100);
			   v2.setFitWidth(100);
			   v3.setFitWidth(100);
			   v4.setFitWidth(100);
			   v1.setFitHeight(100);
			   v2.setFitHeight(100);
			   v3.setFitHeight(100);
			   v4.setFitHeight(100);
	        shop.setTranslateX(800);
	        shop.getChildren().addAll(ein,exc);
	        grid.setTranslateX(300);
	        grid.setTranslateY(300);
	        f=new FadeTransition();
	    	f.setNode(grid);
	        f.setFromValue(1);
	        f.setDuration(Duration.seconds(0.2));
	        f.setToValue(0);
	        f.setCycleCount(2);
	        f.setAutoReverse(true);
	        m= new TranslateTransition();
	        m.setDuration(Duration.seconds(0.4));
	        m.setNode(grid);
	        m.setByX(2);
	        m.setAutoReverse(true);
	        m.setCycleCount(100);
	       
	       exc.setOpacity(0);
	       wep1=new HBox();
		   wep2=new HBox();
		   wep3=new HBox();
		   wep4=new HBox();
		   wep5=new HBox();
		   ImageView c1=new ImageView(w1);
		   ImageView c2=new ImageView(w2);
		   ImageView c3=new ImageView(w3);
		   ImageView c4=new ImageView(w4);
		   ImageView c11=new ImageView(w1);
		   ImageView c21=new ImageView(w2);
		   ImageView c31=new ImageView(w3);
		   ImageView c41=new ImageView(w4);
		   ImageView c12=new ImageView(w1);
		   ImageView c22=new ImageView(w2);
		   ImageView c32=new ImageView(w3);
		   ImageView c42=new ImageView(w4);
		   ImageView c13=new ImageView(w1);
		   ImageView c23=new ImageView(w2);
		   ImageView c33=new ImageView(w3);
		   ImageView c43=new ImageView(w4);
		   ImageView c14=new ImageView(w1);
		   ImageView c24=new ImageView(w2);
		   ImageView c34=new ImageView(w3);
		   ImageView c44=new ImageView(w4);
		   c1.setOpacity(0);
		   c2.setOpacity(0);
		   c3.setOpacity(0);
		   c4.setOpacity(0);
		   c1.setFitWidth(50);
		   c2.setFitWidth(50);
		   c3.setFitWidth(50);
		   c4.setFitWidth(50);
		   c1.setFitHeight(50);
		   c2.setFitHeight(50);
		   c3.setFitHeight(50);
		   c4.setFitHeight(50);
		   
		   c11.setOpacity(0);
		   c21.setOpacity(0);
		   c31.setOpacity(0);
		   c41.setOpacity(0);
		   c11.setFitWidth(50);
		   c21.setFitWidth(50);
		   c31.setFitWidth(50);
		   c41.setFitWidth(50);
		   c11.setFitHeight(50);
		   c21.setFitHeight(50);
		   c31.setFitHeight(50);
		   c41.setFitHeight(50);
		   
		   c12.setOpacity(0);
		   c22.setOpacity(0);
		   c32.setOpacity(0);
		   c42.setOpacity(0);
		   c12.setFitWidth(50);
		   c22.setFitWidth(50);
		   c32.setFitWidth(50);
		   c42.setFitWidth(50);
		   c12.setFitHeight(50);
		   c22.setFitHeight(50);
		   c32.setFitHeight(50);
		   c42.setFitHeight(50);
		   
		   c13.setOpacity(0);
		   c23.setOpacity(0);
		   c33.setOpacity(0);
		   c43.setOpacity(0);
		   c13.setFitWidth(50);
		   c23.setFitWidth(50);
		   c33.setFitWidth(50);
		   c43.setFitWidth(50);
		   c13.setFitHeight(50);
		   c23.setFitHeight(50);
		   c33.setFitHeight(50);
		   c43.setFitHeight(50);
		   
		   c14.setOpacity(0);
		   c24.setOpacity(0);
		   c34.setOpacity(0);
		   c44.setOpacity(0);
		   c14.setFitWidth(50);
		   c24.setFitWidth(50);
		   c34.setFitWidth(50);
		   c44.setFitWidth(50);
		   c14.setFitHeight(50);
		   c24.setFitHeight(50);
		   c34.setFitHeight(50);
		   c44.setFitHeight(50);
		   wep1.getChildren().addAll(c1,c2,c3,c4);
		   wep2.getChildren().addAll(c11,c21,c31,c41);
		   wep3.getChildren().addAll(c12,c22,c32,c42);
		   wep4.getChildren().addAll(c13,c23,c33,c43);
		   wep5.getChildren().addAll(c14,c24,c34,c44);
		   wep.getChildren().addAll(wep1,wep2,wep3,wep4,wep5);
		   wep.setSpacing(100);
		   wep.setTranslateY(350);
		   wep.setTranslateX(120);
		    fadeTransition = new FadeTransition(Duration.seconds(1), b);
	        fadeTransition.setFromValue(1.0);
	        fadeTransition.setToValue(0.0);
	        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1), b);
	        fadeTransition1.setFromValue(0.0);
	        fadeTransition1.setToValue(1.0);
	        fadeTransition1.play();
	        
	        for (int row = 0; row < 5; row++) {
	            for (int col = 0; col < 100; col++) {
	            	Tiles tile = new Tiles(row, col);
	            	tile.setOpacity(0);
	                tile.setMaxSize(15,140);
	                tile.setMinSize(15,140);
	                grid.add(tile, col, row);}}
	        
	        

	         
	        exc.setOnAction(new EventHandler<ActionEvent>() { 
	    		 @Override
	    		 public void handle(ActionEvent event) {
	    			Launcher.currView.setScene(new MainMenu(new BorderPane()));
	    			Launcher.currView.setFullScreen(true);
	    		 }});
	        this.setRoot(b);
	          battle= new Battle(1,0,110,5,125);
	  
	        this.setOnKeyPressed(new EventHandler<KeyEvent>()
	        		{
	        			 @Override
	        	          public void handle(KeyEvent event) {
	        				 int x=-1;
	        				
	        			 if (event.getCode().isDigitKey()){     				
	        				 selectLane(event.getCode(),exc);
	        				
	        			 }
	        			 else{
	        				 switch(event.getCode()){
	        			 case W: x=1;break;
	        			 case A: x=2;break;
	        			 case S: x=3;break;
	        			 case D: x=4;break;
	        			 case E:
	        				    battle.passTurn();
	        				   updateMap();
	        				 break;
	        			 case Q: 
	        				 if (battle.getNumberOfTurns()<25){
								try {
									battle.purchaseWeapon(2, battle.getLanes().peek());
									updateMap();
								} catch (InsufficientResourcesException e1) {
								} catch (InvalidLaneException e1) {
								
								}
	        				 }
	        				 else if (battle.getNumberOfTurns()<40){
	        					 if (battle.getResourcesGathered()<25){
	        						 battle.passTurn();
	        					     updateMap();}
	        					     else{
									try {
										battle.purchaseWeapon(1, battle.getLanes().peek());
										updateMap();
									} catch (InsufficientResourcesException e1) {
									} catch (InvalidLaneException e1) {
									
									}}
		        				 }

	        				 else {
	        					 if (battle.getResourcesGathered()<75){
	        						 if (battle.getResourcesGathered()<25){
	        						 battle.passTurn();
	        					     updateMap();}
	        						 else{
	        							 try {
											battle.purchaseWeapon(2, battle.getLanes().peek());
										} catch (InsufficientResourcesException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (InvalidLaneException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										updateMap();}
	        						 }
	        					     else{
									try {
										battle.purchaseWeapon(4, battle.getLanes().peek());
										updateMap();
									} catch (InsufficientResourcesException e1) {
									} catch (InvalidLaneException e1) {
									
									}}
		        				 }
	        				 
	        				 
	        				 
	        			 default: break;
	        				 }
	        			 if (x!=-1){
	        				 exception=false;
	        				 try {
	        					 
								battle.purchaseWeapon(x, lane);
							} catch (InsufficientResourcesException e) {
								showException("Insufficient Resources");
							    exception=true;
							} catch (InvalidLaneException e) {
								showException("Select a lane first");
								exception=true;
							}
	        				 if (exception==false){
	        					 updateMap();
	        				 }
	        			 }
        			 	//exit to loss screen
	        			 }
	        			 }
	        		//}
	        				  });
	        		
	        
	        }
	    public void updateMap(){
	    	if (battle.isGameOver()){
	    		if (battle.getScore()>HiScoreH)
	    			HiScoreH=battle.getScore();
	    		hard=true;
	    		Launcher.currView.setScene(new Lost(new BorderPane()));
     			Launcher.currView.setFullScreen(true);
     			vogel.stop();
                 
	    	}
	    	 f.play();
	    	 m.play();
	    	grid.getChildren().clear();
	    	
	    	 for (int row = 0; row < 5; row++) {
		            for (int col = 0; col < 10; col++) {
		            	Tiles tile = new Tiles(row, col);
		            	tile.setOpacity(0);
		                tile.setMaxSize(150,140);
		                tile.setMinSize(150,140);
		                grid.add(tile, col, row);}}
	    	 
	    	ArrayList<Titan> ti=new ArrayList<Titan>();
	    	for (int i=0;i<5;i++){
	    		if (!battle.getOriginalLanes().get(i).isLaneLost()&&!battle.getOriginalLanes().get(i).getTitans().isEmpty()){
	    		ti.addAll(battle.getOriginalLanes().get(i).getTitans());
	    		Label l=new Label("Danger Level"+battle.getOriginalLanes().get(i).getDangerLevel()
    					+"\n Wall Health:"+battle.getOriginalLanes().get(i).getLaneWall().getCurrentHealth()
    					);
    			//l.setTranslateX(100);
    		    grid.add(l, 0, i);
	    		while(!ti.isEmpty()){
	    			int x=ti.get(0).getDistance();
	    			x/=10;
	    			if (x>0)
	    				x--;
	    			
	    			grid.add(getbar(ti.get(0)), x, i);
	    			grid.add(getimage(ti.remove(0)),x, i);
	    			updateWeapon(i);
	    			
	    					
	    		}
	    		
	    		}
	    		getwall(i);
	    	    if( battle.getOriginalLanes().get(i).isLaneLost()){
	    	    	switch(i){
	    	    	case 0: wep1.setOpacity(0);break;
	    	    	case 1: wep2.setOpacity(0);break;
	    	    	case 2: wep3.setOpacity(0);break;
	    	    	case 3: wep4.setOpacity(0);break;
	    	    	case 4: wep5.setOpacity(0);break;
	    	    	}
	    	    }
	    		
	    		
	    	}
	    	score.setText("Score:"+battle.getScore());
    		turn.setText("Turn:"+battle.getNumberOfTurns());
    		phase.setText("Phase:"+battle.getBattlePhase());
    		rsrc.setText("Resources:"+battle.getResourcesGathered());
	    	
	  
	    		

	    }
  public  void updateWeapon(int i){		  
	  ArrayList <Weapon> w= battle.getOriginalLanes().get(i).getWeapons();
	  
	  for(int j=0;j<w.size();j++){
		  if (w.get(j) instanceof PiercingCannon){
			  switch(i){
			  case 0:wep1.getChildren().get(0).setOpacity(1);break;
			  case 1:wep2.getChildren().get(0).setOpacity(1);break;
			  case 2:wep3.getChildren().get(0).setOpacity(1);break;
			  case 3:wep4.getChildren().get(0).setOpacity(1);break;
			  case 4:wep5.getChildren().get(0).setOpacity(1);break;
			  }}
			  if (w.get(j) instanceof SniperCannon ){
				  switch(i){
				  case 0:wep1.getChildren().get(1).setOpacity(1);break;
				  case 1:wep2.getChildren().get(1).setOpacity(1);break;
				  case 2:wep3.getChildren().get(1).setOpacity(1);break;
				  case 3:wep4.getChildren().get(1).setOpacity(1);break;
				  case 4:wep5.getChildren().get(1).setOpacity(1);break;
				  }}
				  if (w.get(j) instanceof VolleySpreadCannon){
					  switch(i){
					  case 0:wep1.getChildren().get(2).setOpacity(1);break;
					  case 1:wep2.getChildren().get(2).setOpacity(1);break;
					  case 2:wep3.getChildren().get(2).setOpacity(1);break;
					  case 3:wep4.getChildren().get(2).setOpacity(1);break;
					  case 4:wep5.getChildren().get(2).setOpacity(1);break;
					  }}
					  if (w.get(j) instanceof WallTrap){
						  switch(i){
						  case 0:wep1.getChildren().get(3).setOpacity(1);break;
						  case 1:wep2.getChildren().get(3).setOpacity(1);break;
						  case 2:wep3.getChildren().get(3).setOpacity(1);break;
						  case 3:wep4.getChildren().get(3).setOpacity(1);break;
						  case 4:wep5.getChildren().get(3).setOpacity(1);break;
						  }}
		  }
				 
	    	
	    }
	    public void showException(String msg){			//exception appears top right
	    	Text message = new Text(msg);
	    	//message.setFont(Font.font("Arial", 24));
	    	message.setStyle("-fx-font-family: 'Impact'; -fx-font-size: 20;");
	        message.setVisible(true);
	        message.setTranslateX(1600);
	        message.setTranslateY(100);

	        Timeline timeline = new Timeline();
	        timeline.setCycleCount(1);
	        timeline.setAutoReverse(false);

	        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
	            message.setVisible(false);
	        });

	        timeline.getKeyFrames().add(keyFrame);

	        
	        
	        b.getChildren().add(message);

	        timeline.play();
	       
		
		
	}
	   
	   
	    public void selectLane(KeyCode x,Button exc){
	    	int y=-1;
	    	switch(x){	 
			case   DIGIT1:y=0;break;
			case   DIGIT2:y=1;break;
			case   DIGIT3:y=2;break;
			case   DIGIT4:y=3;break;
			case   DIGIT5:y=4;break;
			
			}
	    	if (y==-1)
	    		return;
	    	try{
				 if ((battle.getOriginalLanes().get(y)==(null))){
				 }
				    
				 
				else{
					 lane=battle.getOriginalLanes().get(y);
					throw new InvalidLaneException();
				}}
				 catch (InvalidLaneException e1){
					 if (lane.isLaneLost())
						 showException("Lane is lost");
				 }
	    	
	    }
	    public static ImageView getimage(Titan t){
	    	ImageView ce=new ImageView();
	        ce.setFitHeight(120);
	        ce.setPreserveRatio(true);
	    	if (t instanceof PureTitan)
	       		  ce.setImage(p1);
	       		
	    	else if (t instanceof AbnormalTitan){
	    		 ce.setImage(p4);
	    		 ce.setFitHeight(100);
	    		 ce.setTranslateX(-12);
	    		 }
	    	else if (t instanceof ColossalTitan){
	    		 ce.setImage(p2);
	    		 ce.setFitHeight(140);
	    		 ce.setTranslateX(-20);
	    		 }
	       	else 
	       	    ce.setImage(p3);
	    	return ce;
	    	
	    	}
	 
	    public static ProgressBar getbar(Titan t){
	    	ProgressBar x=new ProgressBar();
	    	 x.setProgress(t.getCurrentHealth()/(double)t.getBaseHealth());
	    	 x.setTranslateY(80);
	    	 x.setStyle("-fx-accent: red;");
	    	 return x;
	    	
	    	}
	    public static void getwall(int i){
	    	if (i==0)
	    	wal.getChildren().clear();
	    	ImageView ce=new ImageView();
	    	ce.setFitHeight(155);
	    	//ce.setPreserveRatio(true);
	    	ce.setTranslateX(-300);
	    	//ce.setTranslateY(-50);
	    	
	    	if (!battle.getOriginalLanes().get(i).isLaneLost()){
	    		ce.setImage(lo);
	    	}
	    	else
	    		ce.setImage(ld);
	    	wal.getChildren().add(ce);
	    }


	   public Button mButton(){
		   Button butto=new Button();
		   butto.setMinSize(300, 200);
		   butto.setStyle("-fx-background-color: transparent;");
		   return butto;
	   }
	 
		   
	  
	    
	        }
