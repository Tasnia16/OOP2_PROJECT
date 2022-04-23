package CHAT_Client;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Button {
    JPanel panel;
    JRadioButton b1,b2,b3,b4;
    ButtonGroup buttonGroup;
    
    public Button(){
        panel = new JPanel();
        panel.setSize(300,100);
        buttonGroup = new ButtonGroup();
        
        b1 = new JRadioButton("Light",true);
        b2 = new JRadioButton("Dark");
        b3 = new JRadioButton("Gray");
        b4=new JRadioButton("Blue");
           buttonGroup.add(b1);
           buttonGroup.add(b2);
           buttonGroup.add(b3);
           buttonGroup.add(b4);
        
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
    }
    
         public JPanel getPanel()
             {
                return panel;
             }
    
    public int getOption()
    {
        if(b1.isSelected())
            return 1;
        else if(b2.isSelected())
            return 2;
        else if(b3.isSelected())
            return 3;
        else
            return 4;
    }
}
