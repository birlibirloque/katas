package modularTDD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserService {
    private final RepositoryUser repository;

    public UserService(RepositoryUser repositoryUser) {
        repository = repositoryUser;
    }

    public boolean register(String username) {
        if (!repository.isRegistered(username)) {
            repository.register(new User(username));
            return true;
        }
        return false;
    }

    public void follow(String username1, String username2) {
        User userA = repository.getUser(username1);
        User userB = repository.getUser(username2);
        userA.follow(userB);
        repository.store(userA);
    }

    public Set<String> followers(String username) {
        Set<String> result = new HashSet<String>();
        for (User user : repository.getUser(username).getFollowers()) {
            result.add(user.getUsername());
        }
        return result;
    }
}
