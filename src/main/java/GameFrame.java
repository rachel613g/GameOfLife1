import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {
    JButton nextButton;

    public GameFrame(Grid grid,
                GridView gridView,
                GameMouseClickListener mouseClickListener) {
        super();

        setSize(815, 480);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());
        add(gridView, BorderLayout.CENTER);

        gridView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mouseClickListener.clickGridView(e);
                repaint();
            }
        });

        nextButton = new JButton("next-->");
        nextButton.setMaximumSize(new Dimension(20, 20));
        add(nextButton, BorderLayout.AFTER_LAST_LINE);
        nextButton.addActionListener(actionEvent -> {
            grid.getNextGeneration();
            repaint();
        });
    }
}

//Don't forget Test for Listener class

