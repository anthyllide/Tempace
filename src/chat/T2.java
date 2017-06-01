package chat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ChatAuth.ServiceAuth;
import Common.User;


public class T2
{
	public static void main(String [] args) throws Exception 
	{
		System.out.println("On client");
		Registry registry = LocateRegistry.getRegistry("127.0.0.1",2000);
		ServiceAuth service;
		service = (ServiceAuth) registry.lookup("Auth");


		System.out.println("User auth 1");
		User user = service.authentification("toto", "toto");
		System.out.println("Create user");
		service.newUser("toto", "toto");
		System.out.println("User auth 2");
		user = service.authentification("toto", "toto");
	}
}
