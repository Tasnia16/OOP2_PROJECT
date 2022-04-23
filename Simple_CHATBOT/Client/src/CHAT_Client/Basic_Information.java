package CHAT_Client;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

public class Basic_Information
{
    JTextField IP_Text_Field, Port_Text_Field, User_Text_Field;
    JPanel Panel;
    JLabel ip_Label, port_Label, userId_Label;

    
    public Basic_Information()
    {
        Panel = new JPanel();
        Panel.setLayout(new BoxLayout(Panel,BoxLayout.PAGE_AXIS));
        
        ip_Label = new JLabel("IP :");
        port_Label = new JLabel("Port:");
        userId_Label = new JLabel("User id:");

        IP_Text_Field = new JTextField(20);
        Port_Text_Field = new JTextField(20);
        User_Text_Field = new JTextField(20);
        
        Panel.add(ip_Label);
        Panel.add(IP_Text_Field);
        Panel.add(port_Label);
        Panel.add(Port_Text_Field);
        Panel.add(userId_Label);
        Panel.add(User_Text_Field);
    }
    
    JPanel getPanel()
    {
          return Panel;
    }
    
}
