/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package platformer;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author eliperr
 */
public class Player {
    
        private int x=100;
       private  int y=100;
        private int w=100;
        private int h=100;
        private int FPS=60;
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
   
   public Player()
   {
    
      uploadImg(); 
  
   }
    private void uploadImg()
   {
      // InputStream stream=getClass().getResourceAsStream("/bluediamond.png");
       //for some reason this way of getting an image doesn't work regardless of the path 
       
       
       try
       {
        this.img=ImageIO.read(new File("images/player_sprites.png")); 
          //img= ImageIO.read(stream); 
          //System.out.println(img);
       }
       catch (IOException e)
               {
                   System.out.println("error");
                   e.printStackTrace();
                   
               }
       
   }
    
   public BufferedImage animate()
          
     {
       
      long now=System.currentTimeMillis();
      
      long time=10000/FPS;
      
      
      
     
      animationTime=now-prevTime;
      
   
      
  
      if ( animationTime>=time)
      {
          
          if (up) //countUp>0 does using this create a better animation or not?
            {
            n=3;
         
            ycount=2;
          //FPS=120;
            }
          else if (left || right)
          {
              ycount=1;
          
              n=6;
              //System.out.println("moving");
              
          }
          else //idle
          {
              n=5;
              
              ycount=0;
              //FPS=60;
          }
          
        animationFrame=(animationFrame+1)%n;
       
      
           prevTime=System.currentTimeMillis();
           
           
                
      }
      
      
       BufferedImage sub=img.getSubimage(animationFrame*64, ycount*40, 64, 40);
    
      
      return sub;
      
         
         
     } 
   
  public void Left()
  {
     
     //x-=10;
     left=true;
    //repaint();
   
  }
  
  public void Right()
  {
      //x+=10;
      right=true;
      //repaint();
  }
  
  public void Up()
  {
     
      //y-=10; 
      up=true;
        //System.out.println(up);
      //repaint();
     
      
  }
  
  public void Down()
  {
     //y+=10;
     down=true;
      System.out.println(down);
     //repaint();
  }
  
  public int[] setPosition(int x, int y)
  {
      if (right)
      {
          x+=10;
          
      }
      
      if (left)
      {
          
          x-=10;
          
      }
      
      if (down)
      {
          System.out.println(y);
          y+=10;
          ///System.out.println("down");
      }
      
      if (up)
      {
         y-=10; 
      }
     
      int [] result={x, y};
      return result;
  }
  
  public int getX()
  {
      return x;
  }
  
  public int getY()
  {
          //System.out.println(y);
      return y;
  
  }
/*public void  reset()
{
    
    left=false;
    right=false;
    up=false;
    
    
    
}*/
  
 
  
 public void stopUp()
 {
     up=false;
       //System.out.println(up);
     
 }
 
 public void stopDown()
 {
     down=false;
     System.out.println(down);
     
 }
 public void stopRight()
 {
     right=false;
     
 }
 public void stopLeft()
 {
    left=false;
     
 }  
    
    
    
    
    
    
    
    
    
    
}



