import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

class RandomRocks{
    static HashMap<String, String> rockImages = new HashMap<>();

    public static void main(String args[]) throws IOException{
        rockImages.put("Andesite", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/andesite.jpg");
        rockImages.put("Basalt", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/basalt.jpg");
        rockImages.put("Dacite", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/dacite.jpg");
        rockImages.put("Diorite", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/diorite.jpg");
        rockImages.put("Gabbro", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/gabbro1.jpg");
        rockImages.put("Granite", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/granite1.jpg");
        rockImages.put("Ignimbrite", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/ignimbrite1.jpg");
        rockImages.put("Argillite", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/argillite2.jpg");
        rockImages.put("Conglomerate", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/conglomerate1.jpg");
        rockImages.put("Limestone", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/limestone-fossiliferous1.jpg");
        rockImages.put("Gneiss", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/gneiss2.jpg");
        rockImages.put("Hornfels", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/hornfels1.jpg");
        rockImages.put("Schist", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/schist10.jpg");
        rockImages.put("Quartzite", "https://flexiblelearning.auckland.ac.nz/rocks_minerals/rocks/images/quartzite2.jpg");

        JFrame frame = new JFrame("Random Rocks");
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 100);
        JButton rockButton = new JButton("Press for rock");
        rockButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> keysList = new ArrayList<String>(rockImages.keySet());
                int randomIndex = new Random().nextInt(keysList.size());
                String randomKey = keysList.get(randomIndex);

                BufferedImage img = null;
                ImageIcon icon = null;

                try {
                    img = ImageIO.read(new URL(rockImages.get(randomKey)));
                    icon = new ImageIcon(img);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }

                JFrame rockFrame = new JFrame("R o c k");
                rockFrame.setLayout(new FlowLayout());
                rockFrame.setSize(550, 400);
                JLabel lbl = new JLabel();
                lbl.setIcon(icon);
                lbl.setText(randomKey);
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
