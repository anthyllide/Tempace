package chat;


import model.Conversation;
import model.Message;
import model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceConversation extends Remote {
    public boolean newMessage(Conversation c, Message m) throws RemoteException;
    public Conversation newConversation(User u) throws  RemoteException;
    public boolean addUser(Conversation c, User u) throws RemoteException;
    public boolean deleteUser(Conversation c, User u) throws RemoteException;

    // TODO: deleteConversation
}
