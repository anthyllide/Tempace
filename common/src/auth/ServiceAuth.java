package auth;

import model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * TODO : define return types
 */
public interface ServiceAuth extends Remote {
    public User authentification(String login, String password) throws RemoteException;
    public boolean desauthentification(User user) throws RemoteException;
    public User newUser(String login, String password) throws RemoteException;
    public boolean isLogged(User u) throws RemoteException;
}
