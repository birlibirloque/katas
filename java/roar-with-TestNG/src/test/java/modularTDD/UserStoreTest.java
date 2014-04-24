package modularTDD;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UserStoreTest {
    RepositoryUser repositoryUser;

    UserService userService;

    @BeforeTest
    public void setUp(){
        repositoryUser = new RepositoryFileUser();

        userService = new UserService(repositoryUser);
    }
    @Test
    public void shouldAllowSomeUsersRegister() {

        String username1 = "@pasku1";
        userService.register(username1);
        assertTrue(repositoryUser.isRegistered(username1), "user " + username1 + "is not registered");

        String username2 = "@pasku2";
        userService.register(username2);

        RepositoryUser repositoryUser2 = new RepositoryFileUser();

        assertTrue(repositoryUser2.isRegistered(username1), "user " + username1 + " is not registered");
        assertTrue(repositoryUser2.isRegistered(username2), "user " + username2 + "is not registered");
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

        RepositoryUser repositoryUser2 = new RepositoryFileUser();
        UserService userService2 = new UserService(repositoryUser2);
        assertTrue(userService2.followers(username1).contains(username2), "user2 is not following user1 " + userService2.followers(username1));
    }
}


