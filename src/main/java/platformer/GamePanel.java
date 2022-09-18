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
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 import java.io.InputStream;
import javax.imageio.ImageIO;
public class GamePanel extends JPanel{
    
        private int x=100;
       private  int y=100;
        private int w=100;
        private int h=100;
        private int FPS=60;
        private boolean touching;
        private Color c=Color.blue;
       private int xdim, ydim;
        private Dimension size;
        private BufferedImage img, subImg;
        private long animationTime=5;
        private int animationFrame=1;
         private long prevTime=0;
          private boolean left=false;
    private boolean right=false;
    private boolean up=false;
   private boolean down=false;
   private int countUp=0;
   private int ycount=1;
   private int n=5;//number of frames in animation 
   private int tick=5;
   public Player player;
    
    public GamePanel()
    {  
         this.player= new Player(); 
        
       addKeyListener(new keyboardInputs(this));
    size=new Dimension (1200,800);
     
       setPreferredSize(size);
         //uploadImg();
         
    }
    
    
    public void update()
 { 
     x=player.setPosition(x,y)[0];
     y=player.setPosition(x,y)[1];
     //x=player.getX();
    // y=player.getY();
     player.animate();
    // System.out.println("update");
  
  
     
 }
  
  

   
  public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
         //paintSquare(g);
           //System.out.println(up);
       
          
             BufferedImage sub= player.animate();
              g.drawImage(sub,x,y, sub.getWidth()*2, sub.getHeight()*2, null); 
               
     
         
        
    }
 
  //starting with stand still
  //change ycount for different frames of animation,0 for standstill
 
 
  public void paintSquare(Graphics g)
  {
      xdim=this.getWidth();
        ydim=this.getHeight();
        
         //g.fillRect(x,y,w,h); 
      
         // System.out.println(y);  
        
       if (!touching && (x+w>=xdim || x<=0 ||y+h>=ydim || y<=0))
        {
        
            //System.out.println("color");
             c=randColor();
              //c=Color.RED;
             // g.setColor(c);/////
            // g.setColor(c);
           
            
                 touching=true;//if already touching don't want to choose another random color
                    //System.out.println(touching);
        }
     
       else if (x+w<xdim && x>0 && y+h<ydim && y>0)
        {
            touching=false;
           c=Color.BLUE;
             
            //System.out.println(touching); 
        }
        g.setColor(c);
        g.fillRect(x,y,w,h);
             //repaint();
      
  }
  
  

 
  public static Color randColor()
  {  int red=(int) (255*Math.random());
     int green=(int) (255*Math.random());
     int blue=(int) (255*Math.random());
      //System.out.println ("color is " + red + " " + green + " " + blue);
      return  new Color(red, green, blue);
    
  }
}
