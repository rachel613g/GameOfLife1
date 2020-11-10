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
        //x = e.getX();
        //y = e.getY();
        //System.out.println("Mouse click at " + x + ", " + y);
        x = x / grid.CELL_DIMENSIONS;
        y = y / grid.CELL_DIMENSIONS;
        grid.toggleSquare(x, y);
        gridView.repaint();
    }
}
