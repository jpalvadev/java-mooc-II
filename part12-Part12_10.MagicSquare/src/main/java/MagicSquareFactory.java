
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm
        // here

        int num = 1;
        int row = 0;
        int col = size / 2;

        while (num <= size * size) {
            square.placeValue(col, row, num);
            num++;

            int nextRow = (row - 1 + size) % size;
            int nextCol = (col + 1) % size;

            if (square.readValue(nextCol, nextRow) != 0) {
                row = (row + 1) % size;
            } else {
                row = nextRow;
                col = nextCol;
            }
        }

        return square;
    }

}
