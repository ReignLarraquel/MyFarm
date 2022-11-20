package my_farm;

import javax.swing.JFrame;

public class UI {
   JFrame frame;

   public UI() {
      frame = new JFrame("My Farm");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.add(new GamePanel());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
}
