import java.awt.*;
import javax.swing.*;

public class Board {
    Row[] board;

    public Board() {
        board = new Row[9];
        for (int i = 0; i < 9; i += 1) {
            board[i] = new Row();
        }
    }

    public void create_rows() {
        for (int j = 0; j < 9; j += 1) {
            if (j < 3 || j > 5) {
                for (int i = 0; i < 9; i += 1) {
                    if (i > 2 && i < 6) {
                        board[j].row[i] = 1;
                    } else {
                        board[j].row[i] = 0;
                    }
                }
            } else {
                for (int l = 0; l < 9; l += 1) {
                    board[j].row[l] = 1;
                }
            }
        }
        board[4].row[4] = 0;
    }
}

class Render extends Board {
    static JLabel[] buttons;
    static Icon icon;
    int button_index;

    Render() {
        buttons = new JLabel[45];
        icon = new ImageIcon("marble.png");
        button_index = 0;
    }

    public static JLabel make_button(int box_state, int x, int y, int h, int w) {
        JLabel b;
        if (box_state == 1) {

            b = new JLabel(icon);
        } else {
            b = new JLabel();
        }
        b.setBackground(Color.white);
        b.setBounds(x + 30, y + 30, 30, 30);
        b.setBorder(BorderFactory.createLineBorder(Color.black));
        return b;
    }

    public void short_side(int y, Row[] f) {
        int x = 90;
        for (int i = 3; i < 6; i++) {
            buttons[button_index] = make_button(f[y].row[i], x, y * 30, 30, 30);
            x += 30;
            button_index += 1;
        }
    }

    public void long_side(int y, Row[] f) {
        int x = 0;
        for (int i = 0; i < 9; i++) {
            buttons[button_index] = make_button(f[y].row[i], x, y * 30, 30, 30);
            x += 30;
            button_index += 1;
        }
    }

    public JLabel[] render(Row[] b, JFrame f) {
        for (int i = 0; i < 3; i++) {
            short_side(i, b);
        }
        for (int i = 3; i < 6; i++) {
            long_side(i, b);
        }
        for (int i = 6; i < 9; i++) {
            short_side(i, b);
        }
        for (int i = 0; i < 45; i++) {
            f.add(buttons[i]);
        }
        return buttons;
    }

    public void render(Row[] b) {
        button_index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (b[i].row[j] == 1) {
                    buttons[button_index].setIcon(icon);
                } else {
                    buttons[button_index].setIcon(null);
                }
                button_index += 1;
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                if (b[i].row[j] == 1) {
                    buttons[button_index].setIcon(icon);
                } else {
                    buttons[button_index].setIcon(null);
                }
                button_index += 1;
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if (b[i].row[j] == 1) {
                    buttons[button_index].setIcon(icon);
                } else {
                    buttons[button_index].setIcon(null);
                }
                button_index += 1;
            }
        }
    }

    public void render_names(JFrame frame) {
        JLabel[] alpha = new JLabel[9];
        JLabel[] num = new JLabel[9];
        char c = 'a';
        int n = 1, x = 40, y = 30;
        for (int i = 0; i < 9; i++) {
            String s = "" + c++;
            alpha[i] = new JLabel(s);
            s = "" + n++;
            num[i] = new JLabel(s);
            frame.add(alpha[i]);
            frame.add(num[i]);
            alpha[i].setBounds(x, 0, 30, 30);
            num[i].setBounds(10, y, 30, 30);
            x += 30;
            y += 30;
        }
    }
}