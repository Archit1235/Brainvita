public class Row {
    int[] row;

    public Row() {
        row = new int[9];
    }

    public Row[] switchto(int[] coordinates) {
        Row[] board = new Row[9];
        for (int h = 0; h < 9; h += 1) {
            board[h] = new Row();
        }
        int a = 0;
        for (int i = 0; i < 9; i += 1) {
            for (int j = 0; j < 9; j += 1) {
                board[i].row[j] = coordinates[a];
                a += 1;
            }
        }
        return board;
    }

    public int[] switchto(Row[] board) {
        int[] coordinates = new int[81];
        int a = 0;
        for (int i = 0; i < 9; i += 1) {
            for (int j = 0; j < 9; j += 1) {
                coordinates[a] = board[i].row[j];
                a += 1;
            }
        }
        return coordinates;
    }
}