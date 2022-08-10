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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
public class GameFrame extends JFrame implements ComponentListener {
    public static  int xdim=400;
    public static int ydim=400;
    GamePanel gamepanel=new GamePanel();
    public GameFrame(GamePanel gamepanel)
            
    {  
       JFrame jframe=new JFrame();
       //jframe.setSize(xdim,ydim);
   
       jframe.add(gamepanel);
       jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jframe.pack();
      // jframe.setResizable(false);
        jframe.setVisible(true);
    }
    
    @Override
     public void componentResized(ComponentEvent ce) {
      ydim = this.getHeight();
     xdim = this.getWidth();
    System.out.println("resize");
     }
    
  public void componentHidden(ComponentEvent ce) {};
  public void componentShown(ComponentEvent ce) {};
  public void componentMoved(ComponentEvent ce) { };
  
 
    
    
}
