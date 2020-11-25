import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {
    private JButton nextButton;
    private JButton clearButton;
    private JButton playButton;
    private JButton stopButton;
    private JPanel buttonPanel;

    private Grid grid;
    private GridThread gridThread;
    private final Dimension buttonMaxSize = new Dimension(20, 20);

    public GameFrame(Grid grid,
                     GridView gridView,
                     GridThread gridThread) {
        super();

        this.grid = grid;
        this.gridThread = gridThread;

        setSize(815, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());
        add(gridView, BorderLayout.CENTER);

        gridView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clickGridView(e);
                repaint();
            }
        });
        addButtonPanel();
        addNextButton();
        addClearButton();
        addPlayButton();
        addStopButton();
    }

    private void clickGridView(MouseEvent e) {
        try {
            //translates mouse position x,y into Grid's x,y
            int x = e.getX() / grid.CELL_DIMENSIONS;
            int y = e.getY() / grid.CELL_DIMENSIONS;

            grid.toggleSquare(x, y);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
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

    private void addPlayButton() {
        playButton = new JButton("play-->");
        playButton.setMaximumSize(buttonMaxSize);
        playButton.addActionListener(actionEvent -> {
            grid.setRun(true);
            gridThread.start();
        });
        buttonPanel.add(playButton);
    }

    private void addStopButton() {
        stopButton = new JButton("stop");
        stopButton.setMaximumSize(buttonMaxSize);
        stopButton.addActionListener(actionEvent -> {
            grid.setRun(false);
            repaint();
        });
        buttonPanel.add(stopButton);
    }
}

