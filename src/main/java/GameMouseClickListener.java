import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameMouseClickListener extends MouseAdapter {
    private Grid grid;
    public GameMouseClickListener(Grid grid)
    {
        this.grid = grid;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        //translate e's x,y coords to our grid
        grid.toggleSquare(e.getX()/grid.getWIDTH(), e.getY()/grid.getHEIGHT());
    }
}
