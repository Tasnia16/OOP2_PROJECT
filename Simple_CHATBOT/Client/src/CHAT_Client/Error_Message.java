package CHAT_Client;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Error_Message

{
    JPanel Panel;
    JLabel Label;
    JFrame Frame;

    public Error_Message(String string)
    {
         Frame = new JFrame();
          Frame.setSize(200,100);

          Frame.setTitle("ERROR");
           Frame.setName("ERROR");
           Panel = new JPanel();
           Label = new JLabel(string);
           Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           Panel.add(Label);
           Frame.add(Panel);
          Frame.setVisible(true);
    }
}
