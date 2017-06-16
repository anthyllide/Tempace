package api;

import auth.ServiceAuth;
import model.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/api")
public class WebService
{


	public static void main(String [] args) throws Exception
	{

	}


	@Path("/login")
	@POST
	@Produces("application/json")
	public Response login(@FormParam("login") String login, @FormParam("password") String password) throws RemoteException, NotBoundException
	{

		ServiceAuth authService;
		Registry registry = LocateRegistry.getRegistry("127.0.0.1",2000);
		authService = (ServiceAuth) registry.lookup("Auth");

		if(login.length() > 0 && password.length() > 0) {
			User u = authService.authentification(login, password);
			if(u != null) {
				return Response.ok().build();

			} else {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}
}
