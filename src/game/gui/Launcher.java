package game.gui;
import game.gui.scenes.LoadingScreen;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class Launcher extends Application {
	public static Stage currView;
	@Override
	public void start(Stage stage) throws Exception {
		currView=stage;
		currView.setFullScreen(true);
		currView.setScene(new LoadingScreen(new BorderPane()));
		currView.setFullScreenExitHint("");
		currView.setTitle("Redemption Of Utopia");
		currView.getIcons().add(new Image("game/gui/icon"));
		currView.show();}
	public static void main(String[] args) {
		launch(args);}
	}
