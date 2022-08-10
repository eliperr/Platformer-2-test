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
import java.awt.event.KeyListener; 
import java.awt.event.KeyEvent;
public class keyboardInputs implements KeyListener{
   
    private GamePanel panel;
   
    
    
 public keyboardInputs(GamePanel panel)
 {
     this.panel=panel;
     
 }
    
    
   @Override
        public void keyTyped(KeyEvent e){
        
    }
    
        @Override
    public void keyReleased(KeyEvent e){
        
       // panel.stopUp
    }
    //need to reset here!!! set released movements to false then can try animation
    
    public void keyPressed (KeyEvent e)
    { 
        
        switch(e.getKeyCode()){
            case 38:   //up
            panel.Up();
            break;
            case 37: //left
            panel.Left();
            break;
           
            case 39: //right
            panel.Right();
            break;
            case 40://down
             panel.Down();
             break;
           /// default:
                //panel.reset();
   
        }
    }
   
}
