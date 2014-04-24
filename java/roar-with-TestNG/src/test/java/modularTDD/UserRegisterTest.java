package modularTDD;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UserRegisterTest {
    RepositoryUser repositoryUser;

    UserService userService;

    @BeforeTest
    public void setUp(){
        repositoryUser = new RepositoryMemoryUser();

        userService = new UserService(repositoryUser);
    }
    @Test
    public void shouldAllowSomeUsersRegister() {

        String username1 = "@pasku1";
        String username2 = "@pasku2";

        userService.register(username1);
        assertTrue(repositoryUser.isRegistered(username1), "user " + username1 + " is not registered");
        assertFalse(repositoryUser.isRegistered(username2), "user " + username2 + " is registered");

        userService.register(username2);
        assertTrue(repositoryUser.isRegistered(username1), "user " + username1 + " is not registered");
    }

    @Test
    public void shouldAlertWhenAttemptingRegisterAnAlreadyRegisteredUser() {
        String username1 = "@pasku1";
        userService.register(username1);

        assertFalse(userService.register(username1), "already registered");
    }

    @Test
    public void userRegisteredShouldFollowAnotherUserRegistered() {
        String username1 = "@pasku1";
        userService.register(username1);
        String username2 = "@pasku2";
        userService.register(username2);

        userService.follow(username1, username2);

        assertTrue(userService.followers(username1).contains(username2), "user2 is not following user1 " + userService.followers(username1));
    }
}

