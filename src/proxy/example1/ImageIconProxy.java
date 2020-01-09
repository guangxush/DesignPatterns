package proxy.example1;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class ImageIconProxy implements Icon, Runnable {
    ImageIcon icon;
    URL imageURL;
    Thread loadImage;
    Component c;
    Graphics g;
    int x, y, w = 200, h = 200;

    ImageIconProxy(URL imageURL) {
        this.imageURL = imageURL;
        loadImage = new Thread(this);
    }

    @Override
    public int getIconHeight() {
        if (icon != null)
            h = icon.getIconHeight();
        return h;
    }

    @Override
    public int getIconWidth() {
        if (icon != null)
            w = icon.getIconWidth();
        return w;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (icon != null) {
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE)
                icon.paintIcon(c, g, x, y);
            else
                doWork(c, g, x, y);
        } else
            doWork(c, g, x, y);
    }

    private void doWork(Component c, Graphics g, int x, int y) {
        g.drawString("请稍等...", 200, 150);
        this.c = c;
        this.g = g;
        this.x = x;
        this.y = y;
        if (!loadImage.isAlive()) {
            loadImage = new Thread(this);
        }
        try {
            loadImage.start();
        } catch (Exception exp) {
        }
    }

    @Override
    public void run() {
        try {
            icon = new ImageIcon(imageURL);
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE)
                c.repaint();
        } catch (Exception exp) {
        }
    }
}