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
        private final int FPS=60;
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
       
        
    public GamePanel()
    {  
      
       addKeyListener(new keyboardInputs(this));
    size=new Dimension (1200,800);
     
       setPreferredSize(size);
         uploadImg();
         
    }
    
  
   private void uploadImg()
   {
      // InputStream stream=getClass().getResourceAsStream("/bluediamond.png");
       //for some reason this way of getting an image doesn't work regardless of the path 
       
       
       try
       {
          img=ImageIO.read(new File("images/player_sprites.png")); 
          //img= ImageIO.read(stream); 
       }
       catch (IOException e)
               {
                   e.printStackTrace();
                   
               }
       
   }

   
  public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
         //paintSquare(g);
           
        if (img!=null) 
        {
            
          
              //int xcount=5;
              int ycount=0;
              //BufferedImage sub=img.getSubimage(xcount*64, ycount*40, 64, 40);
             BufferedImage sub= animate();
              g.drawImage(sub,x,y, sub.getWidth()*2, sub.getHeight()*2, null); 
               
        
         //g.drawImage(img.getSubimage(0,0, 71,120), x,y, null);
              //subImg=img.getSubimage(70, 120, 72, 120);
              //g.drawImage(subImg, 300,300, null);
            //g.drawImage(img.getSubimage(0,0, 100,100), 0,0, 1000, 1000, null);
        }
       
        //95 (width), 112 (height)
        
    }
 
  //starting with stand still
  //change ycount for different frames of animation,0 for standstill
 public BufferedImage animate()
          
     {
         
         int ycount=1;
       
      long now=System.currentTimeMillis();
      
      long time=FPS*5;
      animationTime=now-prevTime;
      if ( animationTime>=time)
      {
        animationFrame=(animationFrame+1)%5;
       
      
           prevTime=System.currentTimeMillis();
      }
      BufferedImage sub=img.getSubimage(animationFrame*64, ycount*40, 64, 40);
      
      return sub;
         
         
     }
 
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
             // g.setColor(c);
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
  
  
 
  public void Left()
  {
     
     x-=10;
    //repaint();
   
  }
  
  public void Right()
  {
      x+=10;
      //repaint();
  }
  
  public void Up()
  {
     
      y-=10; 
      //repaint();
     
      
  }
  
  public void Down()
  {
     y+=10;
     //repaint();
  }
/*public void  reset()
{
    
    left=false;
    right=false;
    up=false;
    
    
    
}*/
  
  
  public static Color randColor()
  {  int red=(int) (255*Math.random());
     int green=(int) (255*Math.random());
     int blue=(int) (255*Math.random());
      //System.out.println ("color is " + red + " " + green + " " + blue);
      return  new Color(red, green, blue);
    
  }
}
