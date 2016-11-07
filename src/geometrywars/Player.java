/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometrywars;

import Main.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author STEF
 */
public class Player extends GameObject {
    
    Random r = new Random();
    Handler handler;
    
    public Player(int x, int y, ID id){
        super(x, y, id);
        this.handler = handler;   
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }
    @Override
    public void tick(){
        x += velX;
        y += velY;
        
        x = Game.clamp(x, 0, Game.WIDTH - 32);
        y = Game.clamp(y, 0, Game.HEIGHT - 32);
    }
    @Override
    public void render(Graphics g){
        //Graphics2D g2d = (Graphics2D) g;
        //g.setColor(Color.red);
        //g2d.draw(getBounds());
        
        if ( id == ID.Player) g.setColor(Color.blue);
        if ( id == ID.Player2) g.setColor(Color.green);
        else if ( id == ID.Player2) g.setColor(Color.blue);
        g.fillRect(x, y, 32, 32);
    }
}
