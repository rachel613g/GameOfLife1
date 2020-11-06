import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame(GridView gridView,
                     GameMouseClickListener mouseClickListener) {
        super();

        setSize(800,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());
        add(gridView, BorderLayout.CENTER);
        addMouseListener(mouseClickListener);
    }

}

//Don't forget Test for Listener class

