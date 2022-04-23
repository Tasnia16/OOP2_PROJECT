package CHAT_Server;

public class Multiple_Client
{
       int client_count =0;
        Form_fill_up_client[] clients = new Form_fill_up_client[5000];
    
    public void Add_multi_Client(Form_fill_up_client new_client)
    {
        clients[client_count] = new_client;

        clients[client_count].Single_client = this;
        clients[client_count].Client_number = client_count;

        client_count++;
    }



    public void Remove_Client(int k)
    {
          client_count--;

           for(int i=k;i<client_count;i++)
             {
                     clients[i] = clients[i+1];
             }
    }
    
}
