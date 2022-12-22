import java.util.*;
import javax.swing.*;

public class Play {

    public Play() {

    }

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        Board bd = new Board();
        Render r = new Render();
        Game gm = new Game();
        JFrame frame = new JFrame("Brainvita");
        frame.setSize(330, 350);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Row[] temp;
        bd.create_rows();
        Row[] l = bd.board;
        r.render_names(frame);
        r.render(l, frame);
        while (gm.gameOver_check(l) == true) {
            System.out.print("Coordinates of the marble you want to move: ");
            String from = sc.next();
            System.out.print("Coordinates of the place where you want to move to: ");
            String to = sc.next();
            System.out.print("\f");

            temp = gm.remove_marble(from, to);
            if (Game.valid == true) {
                l = temp;
            }

            r.render(l);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            try {
                if (Game.valid == false) {
                    throw new IllegalAccessException();
                }
            } catch (IllegalAccessException e) {
                System.out.println("Invalid Move!!\nTry Again!");
                System.out.println();
            }
        }
        r.render(l);
        System.out.println("The game is over!");
        gm.count_marbles(l);
    }
}