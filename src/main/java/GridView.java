import javax.swing.*;
import java.awt.*;

public class GridView extends JComponent {

    private Grid grid;
    public static final int CELL_SIZE = 30;

    public GridView(Grid grid) {
        this.grid = grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
        paintAliveCells(g);
    }

    void paintGrid(Graphics g) {
        Square[][] board = grid.getBoard();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(board[x][y].getX(), board[x][y].getY(),CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(board[x][y].getX(), board[x][y].getY(),CELL_SIZE, CELL_SIZE);  //outline
            }
        }
    }

    void paintAliveCells(Graphics g) {
        for (Square s : grid.getAliveSquares()) {
            g.setColor(Color.YELLOW);
            g.fillRect(s.getX() * CELL_SIZE, s.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(s.getX() * CELL_SIZE, s.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);  //outline
        }
    }

}

//Don't forget Test
