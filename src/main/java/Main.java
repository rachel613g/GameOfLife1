public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        GridView gridView = new GridView(grid);

        GameMouseClickListener mouseClickListener = new GameMouseClickListener(grid);
        GridThread gridThread = new GridThread(grid, gridView);
        GameFrame frame = new GameFrame(grid, gridView, mouseClickListener, gridThread);

        frame.setVisible(true);
    }

}