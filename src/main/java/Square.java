public class Square {
        private final int x;
        private final int y;
        private boolean isAlive;

        public Square(Square square) {
            this.x = square.x;
            this.y = square.y;
        }

        public Square(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setAlive(){
            isAlive = true;
        }

        public void setDead(){
            isAlive = false;
        }

        public boolean isAlive() {
            return isAlive;
        }

        public void toggleSquare() {
            if (this.isAlive) {
                this.setDead();
            } else {
                this.setAlive();
            }
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square segment = (Square) o;
        return x == segment.x &&
                y == segment.y;
    }
}
