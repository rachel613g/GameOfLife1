public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        GridView gridView = new GridView(grid);
        new GameFrame(grid, gridView).setVisible(true);
    }

}