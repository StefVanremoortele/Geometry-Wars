/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import geometrywars.BasicEnemy;
import geometrywars.HUD;
import geometrywars.Handler;
import geometrywars.ID;
import geometrywars.KeyInput;
import geometrywars.Player;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
    // serialVersionUID is nodig omdat canvas een serialized class is.
    // Als je dit niet aanmaakt dan maakt de klasse automatisch 1 en
    // kun je InvalidClassExceptions krijgen.
    private static final long serialVersionUID = 1550691097823471818L;
    
    
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;
    // Thread is nodig om verschillende processen tegelijk te kunnen afhandelen
    private Thread thread;
    // Running wordt true in start()
    private boolean running = false;
    
    private Random r;
    public Handler handler;
   
    private HUD hud;
    
    public Game(){
        // handler bevat een LinkedList<GameObject> die fungeert als queue
        // en klaarstaat om alle graphics te renderen
        handler = new Handler();
        
        // Component class method
        // zorgt ervoor dat keyListener klaarstaat om keyinput te ontvangen
        this.addKeyListener(new KeyInput(handler));
        
        // Window class zorgt voor configuratie en aanmaak van JFrame
        // (this)Game wordt meegegeven en start() wordt opgeroepen
        // na het opzetten van de frame
        new Window(WIDTH, HEIGHT, "Geometry Wars!", this);
        
        r = new Random();
        
        hud = new HUD();
        // Aanmaak 2 players met positie midden ( WIDTH / 2 && HEIGHT / 2 )
        handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player));
        handler.addObject(new BasicEnemy( r.nextInt(WIDTH) , r.nextInt(HEIGHT), ID.BasicEnemy));
        
    }
    // Synchronized nodig om alle processen simultaan af te handelen
    // samen met thread
    public synchronized void start(){
        // Thread wordt aangemaakt
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop (){
        try{
            thread.join();
            running = false;
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        this.requestFocus();
        //Gameloop
        //Bepaalt oa de frames
        //wiskundig
        //copy paste
        long lastTime = System.nanoTime();
        
        double amountOfTicks = 60.0;
        double ns = 100000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if (running)
                render();
            
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    // refreshen van LinkedList<GameObjects> die graphics updated
    private void tick(){
        
        handler.tick();    
        hud.tick();
    }
    private void render(){
        //Buffer maken en inladen
        //buffer zorgt ervoor dat het scherm vloeiend wordt weergegeven
        //dmv multibuffer(3) staat er continue een queue van graphics klaar
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);
        
        //graphics inladen in handler die vervolns op elke GameObject (graphic) .render() uitvoert
        handler.render(g);
        
        hud.render(g);
        
        //oude graphics verwijderen (maw player kan niet op 2 plaatsen tegelijkertijd zijn)µ
        //??? Wanneer ik dit weglaat werkt alles nog steeds
        g.dispose();
        
        //Next Queue van buffer tonen
        bs.show();
    }
    
    public static int clamp(int var, int min, int max){
        if ( var >= max) 
            return var = max;
        else if ( var <= min ) 
            return var = min;
        else 
            return var;
    }

}
