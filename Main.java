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
public class Main  {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    GameRunner game=new GameRunner();
    game.startGameLoop();
    //Thread gameThread=new Thread(game);
        //gameThread.start();
}
}