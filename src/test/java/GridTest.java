import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void getAliveSquares() {
        //given
        Grid grid = new Grid();
        grid.toggleSquare(1, 3);
        grid.toggleSquare(2, 3);
        grid.toggleSquare(4, 5);
        grid.toggleSquare(11, 2);

        List<Square> expectedList = new ArrayList<>();
        expectedList.add(new Square(1, 3));
        expectedList.add(new Square(2, 3));
        expectedList.add(new Square(4, 5));
        expectedList.add(new Square(11, 2));

        //when
        List<Square> actualList = grid.getAliveSquares();

        //then
        assertEquals(expectedList, actualList);
    }

    @Test
    public void getBoard() {
        //given
        Grid grid = new Grid();

        //when
        //then
        assertNotNull(grid.getBoard());
    }

    @Test
    public void toggleSquare() {
        //given
        Grid grid = new Grid();

        //when
        grid.toggleSquare(1, 3);

        //then
        assertTrue(grid.getBoard()[1][3].isAlive());
    }

    @Test
    public void clearGrid() {
        //given
        Grid grid = new Grid();
        Square[][] board = grid.getBoard();
        grid.toggleSquare(1, 3);
        grid.toggleSquare(2, 3);
        grid.toggleSquare(4, 5);
        grid.toggleSquare(11, 2);

        //when
        grid.clearGrid();

        //then
        for (int y = 0; y < grid.HEIGHT; y++) {
            for (int x = 0; x < grid.WIDTH; x++) {
                assertFalse(board[x][y].isAlive());
            }
        }
    }

    @Test
    public void getNextGeneration_underpopulation() {
        //given
        Grid grid = new Grid();
        grid.toggleSquare(3, 3);
        grid.toggleSquare(3, 4);
        grid.toggleSquare(3, 5);

        //when
        grid.getNextGeneration();

        //then
        assertFalse(grid.getBoard()[3][3].isAlive());

    }

    @Test
    public void getNextGeneration_overpopulation() {
        //given
        Grid grid = new Grid();
        grid.toggleSquare(3, 3);
        grid.toggleSquare(3, 4);
        grid.toggleSquare(3, 2);
        grid.toggleSquare(2, 3);
        grid.toggleSquare(4, 3);

        //when
        grid.getNextGeneration();

        //then
        assertFalse(grid.getBoard()[3][3].isAlive());
    }

    @Test
    public void getNextGeneration_cellStaysAlive() {
        //given
        Grid grid = new Grid();
        grid.toggleSquare(3, 3);
        grid.toggleSquare(3, 4);
        grid.toggleSquare(3, 2);

        //when
        grid.getNextGeneration();

        //then
        assertTrue(grid.getBoard()[3][3].isAlive());
    }

    @Test
    public void getNextGeneration_cellComesAlive() {
        //given
        Grid grid = new Grid();
        grid.toggleSquare(3, 4);
        grid.toggleSquare(2, 2);
        grid.toggleSquare(4, 3);

        //when
        grid.getNextGeneration();

        //then
        assertTrue(grid.getBoard()[3][3].isAlive());
    }
}