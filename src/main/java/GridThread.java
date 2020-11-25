public class GridThread {
    private static final int DELAY_MS = 5;
    private int currentDelay;

    private final Grid grid;
    private final GridView view;

    public GridThread(Grid grid, GridView view) {
        this.grid = grid;
        this.view = view;
        currentDelay = DELAY_MS;
    }

    public void run() {
        while (grid.getRun()) {
            grid.getNextGeneration();
            System.out.println("hey");
            view.repaint();
            try {
                Thread.sleep(currentDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

