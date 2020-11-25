public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        GridView gridView = new GridView(grid);

        GridThread gridThread = new GridThread(grid, gridView);
        GameFrame frame = new GameFrame(grid, gridView, gridThread);

        frame.setVisible(true);
    }
}