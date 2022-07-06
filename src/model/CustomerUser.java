package model;

public class CustomerUser extends User{
    /**
     * Costruttore: salva la password dopo l'hashing
     *
     * @param _username username
     * @param _password password in chiaro
     */
    public CustomerUser(String _username, String _password) {
        super(_username, _password);
    }
}
