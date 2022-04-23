package CHAT_Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Form_fill_up_client extends Thread
{
    String string = new String();
    int Client_number;
    String User_Name;
       private Socket socket=null;
       private DataInputStream in=null;
       private DataOutputStream out=null;
       Multiple_Client Single_client;

       Form_fill_up_client(Socket socket)
    {
         this.socket = socket;
         this.start();
    }

    @Override
    public void run()
    {
        try
        {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            User_Name = in.readUTF();
            shout(User_Name +" is active now");
            while(true)
            {
                string = in.readUTF();
                System.out.println(string);

                if("Exit".equals(string))
                {
                      Single_client.Remove_Client(Client_number);

                      socket.close();
                      break;
                }
                else
                {
                    shout(string);
                }
            }
            shout(User_Name +" has left the chatroom.");
        } catch (IOException e)
        {
            Logger.getLogger(Form_fill_up_client.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
     public void shout(String str) throws IOException
     {
        for(int i = 0; i< Single_client.client_count; i++)
        {
              Single_client.clients[i].out.writeUTF(str);
        }
    }
    
}
