package my_farm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
   //Settings
   final int originalTileSize = 16;
   final int scale = 3;

   final int tileSize = originalTileSize * scale;
   final int maxScreenCol = 16;
   final int maxScreenRow = 12;
   final int screenWidth = maxScreenCol * tileSize;
   final int screenHeight = maxScreenRow * tileSize;

   Thread gameThread;

   public GamePanel() {
      this.setPreferredSize(new Dimension(screenWidth, screenHeight));
      this.setBackground(Color.gray);
      this.setDoubleBuffered(true);
   }

   public void startGameThread() {
      gameThread = new Thread(this);
      gameThread.start();
   }

   @Override
   public void run() {
      // TODO Auto-generated method stub
      
   }
}
