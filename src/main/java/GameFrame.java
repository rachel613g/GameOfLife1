import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JButton nextButton;
    private JButton clearButton;
    private JPanel buttonPanel;
    private Grid grid;
    private GridView gridView;
    private Dimension buttonMaxSize;

    public GameFrame(Grid grid,
                GridView gridView,
                GameMouseClickListener mouseClickListener) {
        super();

        this.grid = grid;
        this.gridView = gridView;

        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());
        add(gridView, BorderLayout.CENTER);
        addMouseListener(mouseClickListener);

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
        clearButton.addActionListener(actionEvent -> clearClicked());
        buttonPanel.add(clearButton);
    }

    private void clearClicked() {
        grid.clearGrid();
        gridView.repaint();
    }

    private void addNextButton() {
        nextButton = new JButton("next-->");
        buttonMaxSize = new Dimension(20, 20);
        nextButton.setMaximumSize(buttonMaxSize);
        buttonPanel.add(nextButton);
        nextButton.addActionListener(actionEvent -> nextClicked());
    }

    private void nextClicked() {
        grid.getNextGeneration();
        gridView.repaint();
    }
}

//Don't forget Test for Listener class

