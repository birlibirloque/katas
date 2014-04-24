package modularTDD;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
    String username;
    private Set<User> followers = new HashSet<User>();

    public User(String name) {
        username = name;
    }

    public String getUsername() {
        return username;
    }

    public void follow(User user) {
        followers.add(user);
    }

    public Set<User> getFollowers() {
        return followers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
