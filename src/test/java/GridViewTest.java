import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.mockito.Mockito.*;

public class GridViewTest {

    @Test
    public void paintGrid() {
        //given
        Grid grid = mock(Grid.class);
        GridView view = new GridView(grid);
        Graphics g = mock(Graphics.class);
        grid.WIDTH = 3;
        grid.HEIGHT = 3;
        grid.CELL_DIMENSIONS = 20;

        Square[][] board = new Square[3][3];
        board[0][0] = new Square(0, 0);
        board[0][1] = new Square(0, 1);
        board[0][2] = new Square(0, 2);
        board[1][0] = new Square(1, 0);
        board[1][1] = new Square(1, 1);
        board[1][2] = new Square(1, 2);
        board[2][0] = new Square(2, 0);
        board[2][1] = new Square(2, 1);
        board[2][2] = new Square(2, 2);

        when(grid.getBoard()).thenReturn(board);

        Square s = mock(Square.class);
        when(s.isAlive()).thenReturn(false);


        //when
        view.paintGrid(g);

        //then  --checking that the cells (for which the coordinates are found in the array created above) are filled
        for (int y = 0; y < grid.HEIGHT; y++) {
            for (int x = 0; x < grid.WIDTH; x++) {
                s = board[x][y];
                verify(g).fillRect(GridView.SPACING_BETWEEN_CELLS + s.getX() * grid.CELL_DIMENSIONS,
                        GridView.SPACING_BETWEEN_CELLS + s.getY() * grid.CELL_DIMENSIONS,
                        grid.CELL_DIMENSIONS - GridView.SPACING_BETWEEN_CELLS * GridView.SPACING_BETWEEN_CELLS,
                        grid.CELL_DIMENSIONS - GridView.SPACING_BETWEEN_CELLS * GridView.SPACING_BETWEEN_CELLS);
            }
        }


    }

}
