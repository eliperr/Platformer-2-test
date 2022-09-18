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
    
    public final double FPS=60;
  public boolean gameover=false;
  private GamePanel gamePanel;
  private GameFrame gameFrame;
 private Thread gameThread;
  private int frames=0;
  private int updates=0;
  
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
        
        long lastCheck=0;
        
        //need to separate UPS and FPS
        //UPS is updates-all game logic
        //FPS is rendering animation 
        //otherwise is rendering is too slow logic could be slowed down 
        double timePerFrame=1000000000/FPS;
        double timePerUpdate=1000000000/FPS*3;
        double previousTime=0;
         long currentTime;
        
        double deltaU=0;
        double deltaF=0;
        
        while(!gameover)
           
        {  currentTime=System.nanoTime();
            deltaU+=(currentTime-previousTime)/timePerUpdate;
            deltaF+=(currentTime-previousTime)/timePerFrame;
            
            previousTime=currentTime; 
           
            if (deltaU>=1)
            {   gamePanel.update();
                updates++;
                
                deltaU--;
            }
            
            if (deltaF>=1)
            {
                gamePanel.repaint(); 
                frames++;
                deltaF--;
            }
            
            
           
            //FPS & UPS counter
            if (System.currentTimeMillis()-lastCheck>=1000) //if second pass update frames
                {//System.out.println("frames : " + frames + " updates: " + updates);
                lastCheck=System.currentTimeMillis();
                frames=0;//System.out.println(0);
                updates=0;
                
                }
            
        }
        
     
      
    }
}
