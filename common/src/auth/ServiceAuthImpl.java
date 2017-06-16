package auth;


import model.User;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * T3
 */
public class ServiceAuthImpl implements ServiceAuth {


    private static final String FILENAME = "auth.txt";
    private ArrayList<User> loggedUsers = new ArrayList<User>();

    /**
     *
     * @param login
     * @param password
     * @return User logged or null if not logged
     * @throws RemoteException
     */
    public User authentification(String login, String password) throws RemoteException {
        User u = new User(login, password);

        try {
            if(this.userExist(u) && ! this.loggedUsers.contains(u)) {
                System.out.println(u.getLogin() + " successfull auth !");
                this.loggedUsers.add(u);
            } else {
                u = null;
            }
        } catch (Exception e) {
            System.out.println(e);
            u = null;
        }

        return u;
    }

    /**
     *
     * @param user
     * @return
     * @throws RemoteException
     */
    public boolean desauthentification(User user) throws RemoteException {
        boolean isDesauth = false;
        if(this.loggedUsers.contains(user)) {
            this.loggedUsers.remove(user);
            isDesauth = true;
            System.out.println(user.getLogin() + " successful desauth");
        }

        return isDesauth;
    }

    /**
     *
     * @param login
     * @param password
     * @return
     * @throws RemoteException
     */
    public User newUser(String login, String password) throws RemoteException {
        User u = new User(login, password);

        // Si l'utilisateur n'est pas dans le fichier on l'ajoute
        try {
            if(! userExist(u)) {
                Writer output = new BufferedWriter(new FileWriter(FILENAME, true));
                output.append(u.getLogin() + ":" + u.getPassword());
                output.close();

                System.out.println(u.getLogin() + " account created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Vérifie qu'un utilisateur est dans le tableau loggedUsers
     * @param u
     * @return
     * @throws RemoteException
     */
    public boolean isLogged(User u) throws RemoteException {
        boolean isLogged = false;

        if(this.loggedUsers.contains(u)) {
            isLogged = true;
        }

        return isLogged;
    }

    /**
     *
     * @param u
     * @return boolean
     * @throws IOException
     */
    private boolean userExist(User u) throws IOException {
        boolean exist = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(":");

                // Si la ligne contient un login et un mot de passe
                if(parts.length == 2) {
                    System.out.println("reading line");
                    String login = parts[0];
                    String pwd = parts[1];

                    if(login.equals(u.getLogin())) {

                        System.out.println("user match");
                        if(pwd.equals(u.getPassword())){
                            System.out.println("password match");
                            exist = true;
                        }

                        break;
                    }
                } else {
                    System.out.println("format doesn't match");
                    break;
                }

            }
        } catch (FileNotFoundException e) {

            File f = new File(FILENAME);
            f.createNewFile(); // if file already exists will do nothing

            System.out.println(e);
        }

        return exist;
    }
}
