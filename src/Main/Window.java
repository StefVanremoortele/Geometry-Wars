/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

/**
 *
 * @author STEF
 */
public class Window extends Canvas {
    private static final long serialVersionUID = 240840600533728354L;
    private JFrame frame;
    public Window(int width, int height, String title, Game game){
        // JFrame Titel
        frame = new JFrame(title);
        // JFrame Afmetingen
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        // JFrame Gedrag
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        //Fullscreen 1920*1080
        //setFullScreen( );
        
        // Game toevoegen, zichtbaar maken & starten        
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
    // TODO: Make screen configuration for other resolutions
    private  void setFullScreen(){
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = env.getDefaultScreenDevice();
        
        if ( gd.isFullScreenSupported() ){
            
            gd.setFullScreenWindow( frame );
            
        }
    }
}
