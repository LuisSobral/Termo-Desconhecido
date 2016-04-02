package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * Created by LuisFelipe.
 */
public class Fundo extends JPanel {

    private BufferedImage img = null;
    private int x = 0;
    private int y = 0;

    public Fundo() throws IOException, URISyntaxException    {
        this.img =  ImageIO.read(new File(getClass().getResource("/gui/bg.jpg").toURI()));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics gr = (Graphics2D)g.create();
        gr.drawImage(img, x, y,this.getWidth(),this.getHeight(),this);
        gr.dispose();
    }
}

