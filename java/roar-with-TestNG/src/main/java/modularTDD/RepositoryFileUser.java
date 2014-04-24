package modularTDD;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RepositoryFileUser implements RepositoryUser {
    private Map<String, User> users = new HashMap<String, User>();
    private String path = "user.lst";

    @Override
    public void register(User user) {
        users.put(user.getUsername(), user);
        storeToFile();
    }

    public boolean isRegistered(String username) {
        loadFromFile();
        return users.containsKey(username);
    }

    public User getUser(String username) {
        loadFromFile();

        return users.get(username);
    }

    @Override
    public void store(User user) {
        loadFromFile();
        users.put(user.getUsername(), user);
        storeToFile();
    }

    private void storeToFile() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private void loadFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            users = (Map<String, User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
}
