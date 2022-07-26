import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;

public class StickerBuilder {
    
    public void build() throws IOException {
        BufferedImage originalImage = ImageIO.read(new File("input/movie.jpg"));

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        ImageIO.write(newImage, "png", new File("output/sticker.png"));
    }

    public static void main(String[] args) throws IOException {
        var builder = new StickerBuilder();
        builder.build();
    }
}

