package chat;

import ChatAuth.ServiceAuth;
import ChatAuth.ServiceAuthImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServeurT3 {



    public static void main(String[] args) throws Exception {
        // write your code here

        ServiceAuthImpl service = new ServiceAuthImpl();
        ServiceAuth stub;

        stub = (ServiceAuth) UnicastRemoteObject.exportObject(service, 0);

        Registry registry = LocateRegistry.createRegistry(2000);
        registry.bind("Auth", stub);

        System.out.println("Service start");

    }
}
