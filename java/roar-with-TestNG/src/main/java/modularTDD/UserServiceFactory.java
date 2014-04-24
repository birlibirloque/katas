package modularTDD;

public class UserServiceFactory {

    public static UserService getUserService() {
        RepositoryUser repositoryUser = new RepositoryMemoryUser();
        return new UserService(repositoryUser);
    }
}
