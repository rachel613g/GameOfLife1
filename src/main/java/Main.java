public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        GridView gridView = new GridView(grid);

        GameMouseClickListener mouseClickListener = new GameMouseClickListener(grid);
        new GameFrame(grid, gridView, mouseClickListener).setVisible(true);
    }

}