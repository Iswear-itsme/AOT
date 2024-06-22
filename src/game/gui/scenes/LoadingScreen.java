package game.gui.scenes;

import game.gui.Launcher;

import java.io.File;




import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class LoadingScreen extends Scene {
    public LoadingScreen(Parent root) {
        super(root, 1920, 1080);
        BorderPane b = new BorderPane();
        Media med = new Media(new File("src/game/gui/images/loading-ezgif.com-resize-video (1).mp4").toURI().toString());
        MediaPlayer medp = new MediaPlayer(med);
        MediaView bgvid = new MediaView(medp);
        medp.setVolume(0);
        medp.setCycleCount(5);
        medp.play();
        medp.setAutoPlay(true);
        b.getChildren().add(bgvid);
        AudioClip vogel = new AudioClip(new File("src/game/gui/sounds/audiomass-output.mp3").toURI().toString());
        vogel.setCycleCount(1);
        vogel.play();
        

        ProgressBar loadingBar = new ProgressBar();
        loadingBar.setProgress(0);
        loadingBar.setPrefWidth(1930);
        loadingBar.setLayoutX(1900);
        loadingBar.setLayoutY(850);
        loadingBar.setTranslateY(-240);
        loadingBar.setStyle(
        	    "-fx-accent: #000000;" + 
        	    "-fx-background-color: #000000;" +
        	    "-fx-border-color: #000000;" + 
        	    "-fx-border-width: 0;" +
       	    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.5), 10, 0, 0, 10);" +
        	    "-fx-shape: \"M 0 0 L 100 0 L 100 20 L 0 20 Z\";"
        	);
        b.setBottom(loadingBar);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), new KeyValue(loadingBar.progressProperty(), 1)));
        timeline.play();

        timeline.setOnFinished(event -> {
            Launcher.currView.setScene(new MainMenu(new BorderPane()));
            Launcher.currView.setFullScreen(true);
        });

        this.setRoot(b);
    }
}
