package CHAT_Client;
import java.net.*;
import java.io.*;
import java.lang.reflect.Method;
import java.lang.*;
import javax.swing.JOptionPane;

public class Client
{
     public static void main(String[] args)
        {

            try{
                Class clsobj2=String.class;


                Method[]methods=clsobj2.getMethods();

                for (Method method:methods)
                {
                    String Method_name=method.getName();
                    System.out.println("Name of the methods for client:"+Method_name);
                }
            }


            catch (Exception e)

            {
                e.printStackTrace();
            }


            int option = 0;
            String Error_Notification;
        String IP_Address = new String();
        String Port_Number = new String();
        String User_Name = new String();
        Socket socket=null;
        DataOutputStream out=null;
        DataInputStream in=null;
        Error_Message error = null;
        int GET;

        for(;;)
        {
            Basic_Information information = new Basic_Information();
             GET = JOptionPane.showConfirmDialog(null, information.getPanel(), " Enter the Informations", JOptionPane.OK_CANCEL_OPTION);


             if (GET != JOptionPane.OK_OPTION)
            {
                System.exit(0);
            }

             else

             {
                 IP_Address = information.IP_Text_Field.getText();
                 Port_Number = information.Port_Text_Field.getText();
                 User_Name = information.User_Text_Field.getText();

             }

            if (!"".equals(IP_Address) && !"".equals(Port_Number) && !"".equals(User_Name))
            {
                break;
            }
        }
        try
        {
            Button button = new Button();
            socket = new Socket(IP_Address,Integer.parseInt(Port_Number));
            out = new DataOutputStream(socket.getOutputStream());
            in  = new DataInputStream(socket.getInputStream());
            int GET2 = JOptionPane.showConfirmDialog(null,button.getPanel()," Choose a Theme", JOptionPane.OK_CANCEL_OPTION);

            //program task completed
            if(GET2!=JOptionPane.OK_OPTION)
            {
                System.exit(0);
            }

            else
            {
                option = button.getOption();
            }
        
        Client_Interface INTERFACE = new Client_Interface(User_Name,option,socket,out,in);

        }

        catch(NumberFormatException e)
        {
            error =  new Error_Message("******INVALID PORT******");
        }

        catch (IllegalArgumentException e)
        {
            error=new Error_Message("****Port out of range****");
        }

        catch(IOException e)
        {
            Error_Notification = e.toString();
            if(Error_Notification.charAt(9)=='U')
            {
               error =  new Error_Message("******INVALID HOST******");
            }

            else
            {
               error =   new Error_Message("******WRONG PORT******");
            }
        }


    }

}
