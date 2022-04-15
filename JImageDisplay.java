import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {
    // инициализация переменной с типом BufferedImage
    private BufferedImage image;

    // консутркутор класса
    public JImageDisplay(int width, int height){
        // инициализация объекта BufferImage
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // создание объекта Dimension
        Dimension imageDimension = new Dimension(width, height);

        // вызов метода родительского класса
        super.setPreferredSize(imageDimension);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    public void clearImage(){
        // черный цвет
        int[] blackColor = {0, 0, 0};
        image.setRGB(0, 0, image.getWidth(), image.getHeight(), blackColor, 0 ,1);
    }

    public void drawPixel(int x, int y, int rgbColor){
        image.setRGB(x, y, rgbColor);
    }

    public BufferedImage getImage(){
        return image;
    }
};

