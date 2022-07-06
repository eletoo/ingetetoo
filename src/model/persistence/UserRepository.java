package model.persistence;

import model.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserRepository implements Loadable, Saveable {
    private Map<String, User> userMap = new HashMap<>();;

    public UserRepository() {

    }

    public void load() throws IOException {
        String currentDir = System.getProperty("user.dir");
        var db = new File(currentDir + "/db");
        assert db.exists() || db.mkdir();

        var uf = new File(currentDir + "/db/users.dat");

        if (uf.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(uf));
            try {
                this.userMap = (Map<String, User>) ois.readObject();
            } catch (ClassNotFoundException | IOException e) {
                this.userMap = new HashMap<>();
            }
        }
    }

    public void save() {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "/db/users.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userMap);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isEmpty() {
        return this.userMap.isEmpty();
    }

    public boolean isUsernameTaken(String username) {
        return userMap.containsKey(username);
    }

    public void addUser(User user) {
        this.userMap.put(user.getUsername(), user);
        this.save();
    }

    public void updateUser(String oldname, String newname, String newpw) {
        userMap.get(oldname).changeUsername(newname);
        userMap.get(oldname).changePassword(newpw);
        userMap.put(newname, userMap.get(oldname));
        userMap.remove(oldname);
        this.save();
    }

    public User getUser(String username) {
        return this.userMap.get(username);
    }

}
