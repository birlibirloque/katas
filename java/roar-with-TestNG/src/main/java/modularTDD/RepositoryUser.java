package modularTDD;

public interface RepositoryUser {
    public void register(User user);

    public boolean isRegistered(String username);

    public User getUser(String username);

    void store(User userA);
}
