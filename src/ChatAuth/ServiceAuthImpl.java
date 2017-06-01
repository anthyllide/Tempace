package ChatAuth;

import Common.User;
import java.rmi.RemoteException;

/**
 * T3
 */
public class ServiceAuthImpl implements ServiceAuth {

    @Override
    public User authentification(String login, String password) throws RemoteException {
        User u = new User(login, password);
        if(this.userExist(u)) {

        }
        return u;
    }

    @Override
    public boolean desauthentification(User user) throws RemoteException {
        return false;
    }

    private boolean userExist(User u) throws RemoteException{
        boolean exist = false;
        if(u.getLogin().contentEquals("toto")) {
            exist = true;
            System.out.println("Auth");
        }

        return exist;
    }
}
