/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometrywars;

import Main.Game;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author stef
 */
public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        int mx = e.getX();
        int my = e.getY();

        if(Game.state.equals(Game.STATE.MENU)){
            if (mx > 275 && mx < 275 + 100){
                if(my > 150 && my < 150 + 50){
                    // pressed Play button
                    Game.state = Game.STATE.GAME;
                }else if(my > 250 && my < 250 + 50){
                    // pressed Help button
                    Game.state = Game.STATE.GAME;
                }else if(my > 350 && my < 350 + 30){
                    // Pressed Exit button
                    System.exit(1);
                }
            }
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
