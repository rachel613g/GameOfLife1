import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameMouseClickListener extends MouseAdapter {
    private Grid grid;
    private GridView gridView;
    private int x;
    private int y;
    public GameMouseClickListener(Grid grid, GridView gridView)
    {
        this.grid = grid;
        this.gridView = gridView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        //translate e's x,y coords to our grid
        x = e.getX() / grid.CELL_DIMENSIONS;
        y = e.getY() / grid.CELL_DIMENSIONS;
        grid.toggleSquare(x, y);
        gridView.repaint();
    }
}
