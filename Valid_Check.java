public class Valid_Check {
    Board bd;

    public Valid_Check() {
        bd = new Board();
        bd.create_rows();
    }

    public boolean valid(int from, int to) {
        int[] check_list = new int[45];
        int b = 0;
        for (int i = 0; i < 9; i += 1) {
            for (int j = 0; j < 9; j += 1) {
                if (bd.board[i].row[j] == 1) {
                    check_list[b] = (i * 9) + j;
                    b += 1;
                }
            }
        }
        check_list[44] = 40;
        boolean answer = true;
        int no = 0;
        while (answer == true && no < 2) {
            for (int i = 0; i < 45; i += 1) {
                if (from == check_list[i]) {
                    answer = true;
                    break;
                } else {
                    answer = false;
                }
            }
            no += 1;
            from = to;
        }
        return answer;
    }

    public boolean valid(String from, String to) {
        boolean answer = false;
        if (from.length() == 2 &&
                to.length() == 2) {
            int alpha_from = from.charAt(0);
            int num_from = from.charAt(1);
            int alpha_to = to.charAt(0);
            int num_to = to.charAt(1);
            if ((alpha_from > 96 && alpha_from < 106) ||
                    (alpha_from > 64 && alpha_from < 74) &&
                            num_from > 48 && num_from < 58 &&
                            (alpha_to > 96 && alpha_to < 106)
                    ||
                    (alpha_to > 64 && alpha_to < 74) &&
                            num_to > 48 && num_to < 58) {
                answer = true;
            }
        }
        return answer;
    }
}