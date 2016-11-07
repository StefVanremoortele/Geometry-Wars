/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author stef
 */
public class Menu {
    
    public static int currSelected;
    public static int amountOfListItems;
    
    public Menu(){
        currSelected = 0;
        amountOfListItems = 3;
    }
    public Rectangle playButton = new Rectangle(275, 150, 100, 50);
    public Rectangle helpButton = new Rectangle(275, 250, 100, 50);
    public Rectangle exitButton = new Rectangle(275, 350, 100, 50);
    
    public void render(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        
        Font title = new Font("Arial", Font.BOLD, 50);
        g.setFont(title);
        g.setColor(Color.white);
        g.drawString("Geometry Wars", Game.WIDTH / 2-200,100);
        Font text = new Font("Arial", Font.BOLD, 30); 
        g.setFont(text);
        g.setColor(Color.gray);
        g.drawString("help", helpButton.x + 20, helpButton.y + 35);
        g.drawString("exit", exitButton.x + 20, exitButton.y + 35);
        if(Game.gamePaused){
            text = new Font("Arial", Font.BOLD, 20);
            g.setColor(Color.red);
            g.setFont(text);
            g.drawString("resume", playButton.x + 20, playButton.y + 35);
            g.setColor(Color.gray);
        }
        else g.drawString("play", playButton.x + 20, playButton.y + 35);
        g2d.draw(playButton);
        g2d.draw(helpButton);
        g2d.draw(exitButton);
        g.setColor(Color.red);
        switch (currSelected) {
            case 0:
                g.drawRect(playButton.x, playButton.y, playButton.width, playButton.height);        
                break;
            case 1:
                g.drawRect(helpButton.x, helpButton.y, helpButton.width, helpButton.height);
                break;
            case 2:
                g.drawRect(exitButton.x, exitButton.y, exitButton.width, exitButton.height);
                break;
            default:
                break;
        }
    }
    
    public static void activateButton(){
        switch (currSelected) {
            case 0:
                Game.gamePaused = false;
                Game.state = Game.STATE.GAME;
                break;
            case 1:
                Game.state = Game.STATE.GAME;
                break;
            case 2:
                System.exit(1);
            default:
                break;
        }
    }
    
}
