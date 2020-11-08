import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        grid.toggleSquare(1, 3);

        //then
        Assert.assertTrue(grid.getBoard()[1][3].isAlive());
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
    }

    @Test
    public void getNextGeneration() {
    }
}