
package geometrywars;

import Main.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class BasicEnemy extends GameObject {
    
    public BasicEnemy(int x, int y, ID id){
        super(x, y, id);
        velX = 1;
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, 16, 16);
    }
    @Override
    public void tick() {
        x += velX;
        y += velY;
        if ( y <= 0 || y >= Game.HEIGHT - 64 ) velY *= -1;
        if ( x <= 0 || x >= Game.WIDTH ) velX *= -1;
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 32);
    }
    
}
