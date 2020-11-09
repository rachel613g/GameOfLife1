import org.junit.Test;

import java.awt.event.MouseEvent;

import static org.mockito.Mockito.*;


import static org.junit.Assert.*;

public class GameMouseClickListenerTest {

    @Test
    public void mouseClicked() {
        //given
        Grid grid = mock(Grid.class);
        GameMouseClickListener mouseClickListener = new GameMouseClickListener(grid);
        MouseEvent event = mock(MouseEvent.class);
        when(event.getX()).thenReturn(315);
        when(event.getY()).thenReturn(400);
        when(grid.getWIDTH()).thenReturn(30);
        when(grid.getHEIGHT()).thenReturn(30);
        //when
        mouseClickListener.mouseClicked(event);

        //then
        verify(grid).toggleSquare(10,13);
    }
}