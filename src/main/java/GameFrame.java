import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    JButton nextButton;

    public GameFrame(Grid grid,
                GridView gridView,
                GameMouseClickListener mouseClickListener) {
        super();
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());
        add(gridView, BorderLayout.CENTER);
        addMouseListener(mouseClickListener);


        nextButton = new JButton("next-->");
        nextButton.setMaximumSize(new Dimension(20, 20));
        add(nextButton, BorderLayout.AFTER_LAST_LINE);
        nextButton.addActionListener(actionEvent -> grid.getNextGeneration());
    }
}

//Don't forget Test for Listener class

