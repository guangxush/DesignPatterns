package factory.example;

import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class SealOne implements Seal {
    BufferedImage image;
    Graphics2D g;

    SealOne() {
        image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        g = image.createGraphics();
        g.setColor(Color.white);
        Rectangle2D rect = new Rectangle2D.Double(0, 0, 100, 100);
        g.fill(rect);
        g.setColor(Color.red);
        BasicStroke bs =
                new BasicStroke(3f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
        Ellipse2D ellipse = new Ellipse2D.Double(5, 6, 80, 80);
        g.setStroke(bs);
        g.draw(ellipse);
        g.setFont(new Font("宋体", Font.BOLD, 14));
        g.drawString("中国银行", 16, 50);
    }
    @Override
    public Image getImage() {
        return image;
    }
}
