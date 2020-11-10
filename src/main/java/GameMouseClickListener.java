import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameMouseClickListener extends MouseAdapter {
    private Grid grid;
    public GameMouseClickListener(Grid grid)
    {
        this.grid = grid;
    }

    public void clickGridView (MouseEvent e) {
        try {
            int x = e.getX() / grid.CELL_DIMENSIONS;
            int y = e.getY() / grid.CELL_DIMENSIONS;

            grid.toggleSquare(x, y);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
