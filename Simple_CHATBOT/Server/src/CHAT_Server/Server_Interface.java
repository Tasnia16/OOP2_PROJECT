package CHAT_Server;
import javax.swing.*;
import java.awt.*;


public class Server_Interface
{
    JFrame Frame;

    JPanel Panel;

    JLabel label1, label2, label3;

    public void SET_INFO(String IP_Address, int Port)
    {
            Frame = new JFrame();

            Frame.setSize(200,200);

            Frame.setTitle("Server");
            Frame.setName("Server");

           Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           Panel = new JPanel(new GridLayout(3,1));
        
        label1 = new JLabel("Server Started Successfully");
        label2 = new JLabel("IP Address: "+IP_Address);
        label3 = new JLabel("Port: "+Port);
        
        Panel.add(label1);
        Panel.add(label2);
        Panel.add(label3);
        Frame.add(Panel);
        
        Frame.setVisible(true);
    }
}
