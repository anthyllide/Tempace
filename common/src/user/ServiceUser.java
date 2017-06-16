package user;


import model.Conversation;
import model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceUser extends Remote {
    public User[] getConnectedContacts(User u) throws RemoteException;
    public Conversation[] getConversations(User u) throws RemoteException;
    public boolean addContact(User user,User contact) throws RemoteException;
    public boolean deleteContact(User user,User contact) throws RemoteException;
}
