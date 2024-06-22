package game.engine.lanes;


import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Tiles extends StackPane {

    private int row;
    private int col;

    public Tiles(int row, int col) {
        this.row = row;
        this.col = col;
       
    
        
        
        setStyle("-fx-background-color: lightgray; -fx-padding: 10;");

        getChildren().add(new Text(row + ", " + col));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}