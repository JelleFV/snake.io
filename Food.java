import java.awt.*;

public class Food {
    int radius = 11;
    double x;
    double y;

    public Food(double x, double y){
        this.x = x;
        this.y = y;
    } 
    
    public void draw(Graphics2D g,double cameraX,double cameraY){
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(255,0,0));
        g.fillOval((int)(x - cameraX) - radius, (int) (y- cameraY) - radius, radius, radius);

    }



}
