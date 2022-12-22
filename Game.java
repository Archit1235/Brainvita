public class Game {
    Board bd;
    Row rw;
    Row[] l;
    Valid_Check vc;
    int[] coordinates;
    static boolean valid;

    public Game() {
        rw = new Row();
        bd = new Board();
        vc = new Valid_Check();
        bd.create_rows();
        coordinates = new int[81];
        l = new Row[9];
        for (int h = 0; h < 9; h += 1) {
            l[h] = new Row();
        }
        coordinates = rw.switchto(bd.board);
    }

    public Row[] remove_marble(String input_from, String input_to) {
        valid = false;
        int from;
        int to;
        if (vc.valid(input_from, input_to) == true) {
            if (input_from.charAt(0) > 96 && input_from.charAt(0) < 106) {
                from = (input_from.charAt(1) - 49) * 9 + input_from.charAt(0) - 97;
                to = (input_to.charAt(1) - 49) * 9 + input_to.charAt(0) - 97;
            } else {
                from = (input_from.charAt(1) - 49) * 9 + input_from.charAt(0) - 65;
                to = (input_to.charAt(1) - 49) * 9 + input_to.charAt(0) - 65;
            }
            if (vc.valid(from, to) == true) {
                if (coordinates[from] == 0 ||
                        coordinates[to] == 1 ||
                        coordinates[(from + to) / 2] == 0) {
                    valid = false;
                } else if (from - to == 2 ||
                        to - from == 2 ||
                        from - to == 18 ||
                        to - from == 18) {
                    coordinates[from] = 0;
                    coordinates[to] = 1;
                    coordinates[(from + to) / 2] = 0;
                    l = rw.switchto(coordinates);
                    valid = true;
                }
            }
        }
        return l;
    }

    public boolean gameOver_check(Row[] check) {
        int[] list = new int[81];
        boolean return_stat = false;
        list = rw.switchto(check);
        for (int j = 0; j < 81; j += 1) {
            if (list[j] == 1) {
                if (list[j + 1] == 1 ||
                        list[j - 1] == 1) {
                    return_stat = true;
                    break;
                } else if (j < 72) {
                    if (list[j + 9] == 1) {
                        return_stat = true;
                        break;
                    }
                } else if (j > 10) {
                    if (list[j - 9] == 1) {
                        return_stat = true;
                        break;
                    }
                }
            }
        }
        return return_stat;
    }

    public void count_marbles(Row[] s) {
        int answer = 0;
        int[] list = rw.switchto(s);
        for (int i = 0; i < 81; i += 1) {
            if (list[i] == 1) {
                answer += 1;
            }
        }
        System.out.println("The number of marble(s) left: " + answer);
    }
}