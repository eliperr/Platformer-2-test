/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer;

/**
 *
 * @author eliperr
 */
import javax.swing.JFrame;
public class GameRunner implements Runnable{
    
    private final double FPS=60;
  public boolean gameover=false;
  private GamePanel gamePanel;
  private GameFrame gameFrame;
 private Thread gameThread;
  private int frames=0;
  
  public GameRunner()
     {
  
        gamePanel= new GamePanel(); 
       gameFrame= new GameFrame(gamePanel);
        gamePanel.requestFocus();
        
        
         
          
      }
  
    public void startGameLoop()
    {
       gameThread=new Thread(this);
        gameThread.start(); 
    }
    
    public void run()
    {
        long now=System.nanoTime();
        long lastFrame=0;
        long frameUpdate=0;
        double timePerFrame=1000000000/FPS;
        while(!gameover)
            
        { now=System.nanoTime();     //check if frame has passed if so repaint gamepanel
            if (now-lastFrame>=timePerFrame)
            {
                gamePanel.repaint();
                lastFrame=now;
                frames++;  
               
            }
            
            //FPS counter
            if (now-frameUpdate>=1000000000) //if second pass update frames
                {System.out.println(frames);
                frames=0;
                frameUpdate=now;
                }
            
        }
        
      //count frames
      
    }
}
