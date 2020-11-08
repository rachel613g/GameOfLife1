import javax.swing.*;
import java.awt.*;

public class GridView extends JComponent {

    private Grid grid;
    public static final int CELL_SIZE = 40;
    public static final int SPACING_BETWEEN_CELLS = 2;

    public GridView(Grid grid) {
        this.grid = grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
    }

    void paintGrid(Graphics g) {
        Square[][] board = grid.getBoard();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                Square s = board[x][y];
                if (s.isAlive()) {
                    g.setColor(Color.YELLOW);
                }
                else {
                    g.setColor(Color.LIGHT_GRAY);
                }
                g.fillRect(SPACING_BETWEEN_CELLS+s.getX()*CELL_SIZE,
                        SPACING_BETWEEN_CELLS+s.getY()*CELL_SIZE,
                        CELL_SIZE-SPACING_BETWEEN_CELLS*SPACING_BETWEEN_CELLS,
                        CELL_SIZE-SPACING_BETWEEN_CELLS*SPACING_BETWEEN_CELLS);
            }
        }

    }
}

//Don't forget Test
