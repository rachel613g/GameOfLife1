import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {
    private JButton nextButton;
    private JButton clearButton;
    private JPanel buttonPanel;
    private Grid grid;
    private final Dimension buttonMaxSize =  new Dimension(20, 20);

    public GameFrame(Grid grid,
                GridView gridView,
                GameMouseClickListener mouseClickListener) {
        super();

        this.grid = grid;

        setSize(800, 400);
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
        addButtonPanel();
        addNextButton();
        addClearButton();
    }

    private void addButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setVisible(true);
        add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
    }

    private void addClearButton() {
        clearButton = new JButton("clear");
        clearButton.setMaximumSize(buttonMaxSize);
        clearButton.addActionListener(actionEvent -> {
            grid.clearGrid();
            repaint();
        });
        buttonPanel.add(clearButton);
    }

    private void addNextButton() {
        nextButton = new JButton("next-->");
        nextButton.setMaximumSize(buttonMaxSize);
        nextButton.addActionListener(actionEvent -> {
            grid.getNextGeneration();
            repaint();
        });
        buttonPanel.add(nextButton);
    }
}

