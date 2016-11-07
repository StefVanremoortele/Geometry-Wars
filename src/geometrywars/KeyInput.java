package geometrywars;

import Main.Game;
import Main.Menu;
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
        
            if (key == KeyEvent.VK_P) {
                // PAUZE functionaliteit toevoegen!!!
                // game.pauze(); in main??
                Game.gamePaused = true;
                Game.state = Game.STATE.MENU;

            }
            
            if(Game.state.equals(Game.STATE.MENU)){
            if (key == KeyEvent.VK_ENTER) {
                Menu.activateButton();
            }

            if (key == KeyEvent.VK_DOWN){
                System.out.println(Menu.currSelected);
                if(Menu.currSelected > Menu.amountOfListItems - 2){
                    Menu.currSelected = 0;
                }else {
                    Menu.currSelected ++;
                }
            }else if(key == KeyEvent.VK_UP){
                System.out.println(Menu.currSelected);
                if(Menu.currSelected <= 0){
                    Menu.currSelected = Menu.amountOfListItems - 1;
                }else {
                    Menu.currSelected --;
                }
            }
        }

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
