package org.example.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageEditor extends JFrame {

    private BufferedImage image;

    //Constructor, opens the window in full screen
    public ImageEditor() {
        this.setTitle("Image Editor");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMenuBar();
        this.setVisible(true);
    }

    private void setMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenu filters = new JMenu("Filters");
        menuBar.add(filters);
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            //filters on jpeg files only
            fileChooser.setFileFilter(new FileNameExtensionFilter("JPEG file", "jpg", "jpeg"));
            fileChooser.showOpenDialog(this);
            try {
                image = ImageIO.read(fileChooser.getSelectedFile());
                JPanel panel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        if (image != null) {
                            // Get the panel size
                            Dimension size = getSize();
                            // Compute the coordinates that will center the image
                            int x = (size.width - image.getWidth()) / 2;
                            int y = (size.height - image.getHeight()) / 2;
                            g.drawImage(image, x, y, this);
                        }
                    }
                };
                add(panel);
                this.revalidate();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        fileMenu.add(openMenuItem);
        JMenuItem grayscale = new JMenuItem("Gray Scale");
        grayscale.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Not implemented yet", "Grayscale effect", JOptionPane.PLAIN_MESSAGE);
        });
        filters.add(grayscale);
        JMenuItem sepia = new JMenuItem("Sepia");
        filters.add(sepia);
        this.setJMenuBar(menuBar);
    }

    //Main method, creates the window
    public static void main(String[] args) {
        ImageEditor imageEditor = new ImageEditor();
    }

}
