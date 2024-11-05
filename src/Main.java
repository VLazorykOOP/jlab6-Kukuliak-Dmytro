import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Animation");
        BallAnimation animation = new BallAnimation();
        frame.add(animation);
        frame.setSize(1230  , 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}