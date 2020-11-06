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
        System.out.println("Testing mouse click coords.");
        System.out.println("x: " + e.getX() + ", y: " + e.getY());
        e.translatePoint(-30, -30);
        System.out.println("translated x: " + e.getX() + ", translated y: " + e.getY());
    }
}
