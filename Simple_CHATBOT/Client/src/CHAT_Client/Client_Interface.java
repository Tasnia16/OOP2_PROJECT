package CHAT_Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Client_Interface
{
    DataInputStream in;
    DataOutputStream out;
    int option;
    String string;
    String User_name;
    Socket socket;

    JPanel Panel;
    JFrame Frame;
    JButton Button;
    JTextArea TextArea;  // displays message
    JTextField TextField;       //sends message
    JScrollPane ScrollPane;
    DefaultCaret Caret;
    Font font;


    Client_Interface(String User_name,int option,Socket socket,DataOutputStream out, DataInputStream in) throws IOException
    {

        this.User_name = User_name;
        this.option = option;
        this.socket = socket;
        this.out = out;
        this.in =in;
        Panel = new JPanel();
        Frame = new JFrame();
        TextArea = new JTextArea("",30,25);
         ScrollPane = new JScrollPane(TextArea);
        TextField = new JTextField(20);
        font = new Font("Arial", Font.BOLD, 14);
        Button = new JButton("Send");
        
        out.writeUTF(User_name);

        Frame.setTitle(User_name);
        Frame.setName(User_name);
        Frame.setSize(400,600);

        
        TextArea.setLineWrap(true);
        TextArea.setEditable(false);
        TextArea.setWrapStyleWord(true);
        TextArea.setFont(font);

        Caret = (DefaultCaret) TextArea.getCaret();
        Caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        //theme(intArray);

        if(option==1)
        {
        TextArea.setBackground(Color.WHITE);
        TextArea.setForeground(Color.BLACK);
       }

        else if(option==2)
        {
            TextArea.setBackground(Color.BLACK);
            TextArea.setForeground(Color.WHITE);
        }

        else if(option==3)
        {
            TextArea.setBackground(Color.DARK_GRAY);
            TextArea.setForeground(Color.CYAN);
        }

        else
        {
            TextArea.setBackground(Color.BLUE);
            TextArea.setForeground(Color.YELLOW);
        }


        Button.setSize(100,50);
        Frame.addWindowListener(new java.awt.event.WindowAdapter()
        {
         @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent)
         {
             try
             {
                 out.writeUTF("Quit");
                 socket.close();
                 System.exit(0);
             }

             catch (IOException ex)
             {
                 Logger.getLogger(Client_Interface.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
        }
        );


        Button.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               try
               {
                   string = TextField.getText();
                   if(!string.equals("")) out.writeUTF(User_name+": "+ string);
                   TextField.setText("");
               }
               catch (IOException ex)
               {
                   Logger.getLogger(Client_Interface.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
        });
        
        TextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==10){
                    try
                    {
                            string = TextField.getText();
                            if(!"".equals(string)) out.writeUTF(User_name+": "+ string);
                            TextField.setText("");
                    }
                    catch (IOException ex)
                    {
                          Logger.getLogger(Client_Interface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyReleased(KeyEvent e)

            {
                }

        });
        
        Thread thread = new Thread()

        {
          @Override
          public void run()
          {
              while(!"Exit".equals(string)){
                  try
                  {
                      TextArea.append(in.readUTF()+"\n");
                  }

                  catch (IOException ex)
                  {
                        Logger.getLogger(Client_Interface.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          }  
        };

          thread.start();
        Frame.setVisible(true);
        Panel.add(ScrollPane);
        Panel.add(TextField);
        Panel.add(Button);
        Frame.add(Panel);

    }
}
