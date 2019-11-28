import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

class RandomRocks{
    public static void main(String args[]) throws IOException{
        BufferedImage img = ImageIO.read(new URL(
        "https://images-na.ssl-images-amazon.com/images/I/81YPB6jlJiL._SX355_.jpg"));
        ImageIcon icon = new ImageIcon(img);
        JFrame frame = new JFrame("Random Rocks");
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 100);
        JButton rockButton = new JButton("Press for rock");
        rockButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame rockFrame = new JFrame("R o c k");
                rockFrame.setLayout(new FlowLayout());
                rockFrame.setSize(500, 300);
                JLabel lbl = new JLabel();
                lbl.setIcon(icon);
                rockFrame.add(lbl);

                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
                Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
                int x = (int) Math.round(Math.random() * rect.getMaxX());
                int y = (int) Math.round(Math.random() * rect.getMaxY());
                rockFrame.setLocation(x, y);

                rockFrame.setVisible(true);
                rockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        frame.getContentPane().add(rockButton);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
