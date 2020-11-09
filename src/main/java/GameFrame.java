import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame(GridView gridView) {
        super();

        setSize(815,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());

        add(gridView, BorderLayout.CENTER);
    }

}

//Don't forget Test for Listener class

