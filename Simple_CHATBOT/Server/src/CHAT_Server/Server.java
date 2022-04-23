package CHAT_Server;
import java.lang.*;
import java.io.*;
import java.lang.reflect.Method;
import java.net.*;
import java.util.ArrayList;

public class Server
{
    public static <E>void print_method2(E[] input)
    {
        for (E element: input)
        {
            System.out.println("Name of the methods for server:"+element);
            //System.out.println("\n");
        }
    }


     public static void main(String[] args) throws IOException
     {
         ArrayList<String> all_method2=new ArrayList<String>();
        try
        {
            Class clsobj=String.class;
            Method[]methods=clsobj.getMethods();

            for (Method method:methods)
            {
                String Method_name=method.getName();
                all_method2.add(Method_name);
                //System.out.println("Name of the methods for client:"+Method_name);
            }
            print_method2(all_method2.toArray());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

         Detail d=new Detail();
         d.memory();


    ServerSocket Chat_Server = new ServerSocket(0);

         Multiple_Client Clients = new Multiple_Client();
         String IP_Address = Inet4Address.getLocalHost().getHostAddress();
         int Port = Chat_Server.getLocalPort();
        
        System.out.println(IP_Address+"  "+Port);
        
        Server_Interface Server_Gui = new Server_Interface();
        Server_Gui.SET_INFO(IP_Address,Port);
        
        while(true)
        {
             Form_fill_up_client  new_Client = new Form_fill_up_client(Chat_Server.accept());
             Clients.Add_multi_Client(new_Client);
        }


     }
}
