import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BallAnimation extends JPanel implements ActionListener {
    private int ballX, ballY;
    private final int ballDiameter = 20;
    private final int SPEED = 10;
    private int xDirection = SPEED;
    private int yDirection = SPEED;
    private List<Point> trail;

    public BallAnimation() {
        ballX = 0;
        ballY = 150;
        trail = new ArrayList<>();
        Timer timer = new Timer(30, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        for (int i = 1; i < trail.size(); i++) {
            Point p1 = trail.get(i - 1);
            Point p2 = trail.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ballX += xDirection;
        ballY += yDirection;

        if (ballX <= 0 || ballX + ballDiameter >= getWidth()) {
            xDirection = -xDirection;
        }
        if (ballY <= 0 || ballY + ballDiameter >= getHeight()) {
            yDirection = -yDirection;
        }

        trail.add(new Point(ballX + ballDiameter / 2, ballY + ballDiameter / 2));
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Animation");
        BallAnimation animation = new BallAnimation();
        frame.add(animation);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
