package geometrywars;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author STEF
 */

// KeyInput zorgt voor het verwerken van de input ( = controls )
public class KeyInput extends KeyAdapter {
    private Handler handler;
    
    public KeyInput(Handler handler) {
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e){
        
        int key = e.getKeyCode();
       
        
        for ( int i = 0; i < handler.object.size(); i++ ) {
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.Player){
                // Key events for player 1
                if (key == KeyEvent.VK_Z) tempObject.setVelY(-1);
                if (key == KeyEvent.VK_S) tempObject.setVelY(+1);
                if (key == KeyEvent.VK_D) tempObject.setVelX(+1);
                if (key == KeyEvent.VK_Q) tempObject.setVelX(-1);
            }
            if (tempObject.getId() == ID.Player2){
                // Key events for player 2
                if (key == KeyEvent.VK_UP) tempObject.setVelY(-5);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(+5);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(+5);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
            }
        }
        
        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for ( int i = 0; i < handler.object.size(); i++ ) {
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.Player){
                // Key events for player 1
                if (key == KeyEvent.VK_Z) tempObject.setVelY(0);
                if (key == KeyEvent.VK_S) tempObject.setVelY(0);
                if (key == KeyEvent.VK_D) tempObject.setVelX(0);
                if (key == KeyEvent.VK_Q) tempObject.setVelX(0);
            }
            if (tempObject.getId() == ID.Player2){
                // Key events for player 2
                if (key == KeyEvent.VK_UP) tempObject.setVelY(0);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
            }
        }
    }
}
