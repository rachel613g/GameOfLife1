import javax.swing.*;
import java.awt.*;

public class GridView extends JComponent {

    private Grid grid;
    public static final int SPACING_BETWEEN_CELLS = 1;

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
        for (int y = 0; y < grid.HEIGHT; y++) {
            for (int x = 0; x < grid.WIDTH; x++) {
                Square s = board[x][y];
                if (s.isAlive()) {
                    g.setColor(Color.YELLOW);
                }
                else {
                    g.setColor(Color.LIGHT_GRAY);
                }
                g.fillRect(SPACING_BETWEEN_CELLS+s.getX()*grid.CELL_DIMENSIONS,
                           SPACING_BETWEEN_CELLS+s.getY()*grid.CELL_DIMENSIONS,
                        grid.CELL_DIMENSIONS-SPACING_BETWEEN_CELLS*SPACING_BETWEEN_CELLS,
                        grid.CELL_DIMENSIONS-SPACING_BETWEEN_CELLS*SPACING_BETWEEN_CELLS);
            }
        }

    }
}
