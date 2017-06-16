package data;

import model.Conversation;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceData extends Remote {
    public boolean saveConversation(Conversation c) throws RemoteException;
    public Conversation getConversation(Integer id) throws RemoteException;
}
