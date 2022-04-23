package CHAT_Client;
import java.net.*;
import java.io.*;
import java.lang.reflect.Method;
import java.lang.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Client
{
    public static <E>void print_method(E[] input)
    {
        for (E element: input)
        {
            System.out.println("Name of the methods for client:"+element);
            //System.out.println("\n");
        }
    }


     public static void main(String[] args)
        {
            ArrayList<String>all_method=new ArrayList<String>();
            try{


                Class clsobj2=String.class;


                Method[]methods=clsobj2.getMethods();

                for (Method method:methods)
                {
                    String Method_name=method.getName();
                    all_method.add(Method_name);
                    //System.out.println("Name of the methods for client:"+Method_name);
                }
                print_method(all_method.toArray());

            }


            catch (Exception e)

            {
                e.printStackTrace();
            }

            Detail2 d2=new Detail2();
            d2.memory2();

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
