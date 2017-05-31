package chat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ChatAuth.ServiceAuth;
import Common.User;


public class Client 
{
	public static void main(String [] args) throws Exception 
	{
		System.out.println("On client");
		Registry registry = LocateRegistry.getRegistry("127.0.0.1",2000);
		ServiceAuth service;
		service = (ServiceAuth) registry.lookup("Auth");
		
		User user = service.authentification("toto", " ");
	}
}
