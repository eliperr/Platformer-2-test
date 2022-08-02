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
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
public class GamePanel extends JPanel{
    
        private int x=100;
       private  int y=100;
        private int w=100;
        private int h=100;
        private boolean touching;
        private Color c=Color.blue;
       private int xdim, ydim;
        
        
    public GamePanel()
    {  
      
       addKeyListener(new keyboardInputs(this));
     
         
    }
    
  public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
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
  
  public static Color randColor()
  {  int red=(int) (255*Math.random());
     int green=(int) (255*Math.random());
     int blue=(int) (255*Math.random());
      //System.out.println ("color is " + red + " " + green + " " + blue);
      return  new Color(red, green, blue);
    
  }
}
