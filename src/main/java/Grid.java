import java.util.ArrayList;
import java.util.List;

public class Grid {

    private Square[][] board;
    private final Direction[] directions = Direction.values();
    private final List<Square> aliveSquares = new ArrayList<>();
    private final List<Square> deadSquares = new ArrayList<>();

    int CELL_DIMENSIONS = 20;
    int WIDTH = 40; //num columns of grid
    int HEIGHT = 20; //num rows of grid

    public Grid() {
        this.board = new Square[WIDTH][HEIGHT];
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                board[x][y] = new Square(x, y);
            }
        }
    }

    /**
     * for GardenView
     */
    public List<Square> getAliveSquares() {
        return aliveSquares;
    }

    /**
     * for GardenView
     */
    public Square[][] getBoard() {
        return board;
    }

    /**
     * for the MouseKeyListener
     */
    public void toggleSquare(int x, int y) {
        this.board[x][y].toggleSquare();
        aliveSquares.add(this.board[x][y]);
    }

    /**
     * for the "clear" button.
     */
    public void clearGrid() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                board[x][y].setDead();
            }
        }
    }


    /**
     * for the "next generation" button.
     */
    public void getNextGeneration() {
        Square[][] newBoard = new Square[WIDTH][HEIGHT];
        aliveSquares.clear();
        deadSquares.clear();

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Square square = board[x][y];
                newBoard[x][y] = setSquare(square);
            }
        }
        this.board = newBoard;
    }

    private Square setSquare(Square square) {
        int numAliveNeighbours = countAliveNeighbours(square);
        Square newSquare = new Square(square);

        if (square.isAlive()) { //if current square is alive
            if (numAliveNeighbours == 2 || numAliveNeighbours == 3) {
                aliveSquares.add(square);
                newSquare.setAlive();
            } else {
                newSquare.setDead();
            }
        } else { //if current square is dead
            if (numAliveNeighbours == 3) {
                aliveSquares.add(square);
                newSquare.setAlive();
            }
        }

        return newSquare;
    }

    private int countAliveNeighbours(Square square) {
        int numNeighborsAlive = 0;
        List<Square> neighborsToCheck = getNeighbors(square);
        if (square.getY() == 3 && square.getX() == 3){
            System.out.println(neighborsToCheck);
        }
        for (Square s : neighborsToCheck) {
            if (s.isAlive()) {
                numNeighborsAlive++;
            }
        }
        return numNeighborsAlive;
    }

    private List<Square> getNeighbors(Square square) {
        List<Square> neighbors = new ArrayList<>();

        int x = square.getX();
        int y = square.getY();

        int newX = 0;
        int newY = 0;

        for (Direction d: directions) {
            switch (d) {
                case North:
                    newX = x;
                    newY = y-1;
                    break;
                case NorthEast:
                    newX = x + 1;
                    newY = y - 1;
                    break;
                case East:
                    newX = x + 1;
                    newY = y;
                    break;
                case SouthEast:
                    newX = x + 1;
                    newY = y + 1;
                    break;
                case South:
                    newX = x;
                    newY = y + 1;
                    break;
                case SouthWest:
                    newX = x - 1;
                    newY = y + 1;
                    break;
                case West:
                    newX = x - 1;
                    newY = y;
                    break;
                case NorthWest:
                    newX = x - 1;
                    newY = y - 1;
                    break;
                default:
                    throw new RuntimeException(d + " is not a Direction");
            }
            if(isInBounds(newX, newY)){
                neighbors.add(board[newX][newY]);
            }
        }
        return neighbors;
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < WIDTH && y < HEIGHT;
    }
}

//Don't forget Test