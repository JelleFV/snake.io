import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Snake {
    private static final int SEGMENTS = 3;
    private static final double SPEED = 3.0;          // pixels per frame
    private static final double SEGMENT_GAP = 12;     // distance between segments
    private static final int RADIUS = 12;
    private static final double TURN_RATE = 0.07;

    //body [ [500, 300],
    // [ ... ]]
    private final ArrayList<double[]> body = new ArrayList<>(); 
    private double angle = 0; // direction the head is facing, in radians
    private BufferedImage faceDerpImg;

    public Snake(double x, double y) {
        for (int i = 0; i < SEGMENTS; i++) {
            body.add(new double[]{x, y});
        }
        
        try {
            faceDerpImg = ImageIO.read(new File("face_derp.png"));
        }  catch (IOException e) {
            System.err.println("Could not load face_derp.png: " + e.getMessage());
        }
    }

    public void update(double targetX, double targetY) {
        double[] head = body.get(0);

        double dx = targetX - head[0];
        double dy = targetY - head[1];

        if (Math.hypot(dx, dy) > 5) {
            double targetAngle = Math.atan2(dy, dx);
            double diff = targetAngle - angle;

            while (diff > Math.PI) { 
                diff -= 2*Math.PI;
            }

            while (diff < -Math.PI) {
                diff += 2*Math.PI; 
            }
            
            if(Math.abs(diff) < TURN_RATE){
                angle = targetAngle;
            } else {
                angle += TURN_RATE * Math.signum(diff);
            }

        }

        head[0] += Math.cos(angle) * SPEED;
        head[1] += Math.sin(angle) * SPEED;

        // Each segment follows the one in front of it
        for (int i = 1; i < body.size(); i++) {
            double[] front = body.get(i - 1);
            double[] seg = body.get(i);

            double segDx = front[0] - seg[0];
            double segDy = front[1] - seg[1];
            double dist = Math.hypot(segDx, segDy);
            
            if (dist > SEGMENT_GAP) {
                seg[0] = front[0] - segDx / dist * SEGMENT_GAP;
                seg[1] = front[1] - segDy / dist * SEGMENT_GAP;
            }
        }
    }

    public double getX() {
            return body.get(0)[0];
        }
    public double getY() {
            return body.get(0)[1];
        }

    public int getRadius(){
        return Snake.RADIUS;
    }


    public void grow(){
        double [] last = body.get(body.size() - 1 );
        body.add(new double []{last[0], last[1]});
    }


    public void draw(Graphics2D g, double cameraX, double cameraY) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Draw from tail to head so the head ends up on top
        for (int i = body.size() - 1; i >= 0; i--) {
            double[] seg = body.get(i);
            
            if (i == 0) {
                // Head: green circle, then the face image on top
                int x = (int) (seg[0] - cameraX) - RADIUS;
                int y = (int) (seg[1] - cameraY) - RADIUS;
                int diameter = RADIUS * 2;
            

            g.setColor(new Color(34, 139, 34));
            g.fillOval(x, y, diameter, diameter);

            if (faceDerpImg != null) {
                g.drawImage(faceDerpImg, x, y, diameter, diameter, null);
            }
            } else {
                // Body segments: smaller green circles
                int r = RADIUS - 4;
                g.setColor(new Color(34, 139, 34));
                g.fillOval(
                    (int) (seg[0] - cameraX) - r,
                    (int) (seg[1] - cameraY) - r,
                    r * 2,
                    r * 2
               );
        }
    }
}



   
}