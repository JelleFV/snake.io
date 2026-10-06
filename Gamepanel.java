import java.awt.*;
import javax.swing.*;


public class GamePanel extends JPanel {

    public final int Width = 1280;
    final int Height = 720;

    public GamePanel() {
        setPreferredSize(new Dimension(Width, Height));
        this.setSize(1280, 720);
        this.setBackground(new Color(0, 0, 0));
        this.setDoubleBuffered(true);
    }


    
}
