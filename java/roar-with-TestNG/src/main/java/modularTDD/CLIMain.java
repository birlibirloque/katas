package modularTDD;

import java.util.Scanner;

public class CLIMain {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        while (true) {

            System.out.println("0.- Salir");
            System.out.println("1.- Registrar usuario");
            System.out.println("2.- Seguir a usuario");
            System.out.println("3.- Ver lista de seguidores de usuario");

            String command = scan.nextLine();
            if (command.equals("0")) {
                System.exit(0);
            } else if (command.equals("1")) {
                System.out.println("Introduce nick de usuario");
                String username = scan.nextLine();

                UserService userService = UserServiceFactory.getUserService();
                userService.register(username);
            } else if (command.equals("2")) {
                System.out.println("Introduce nick de usuario al que seguir");
                String username1 = scan.nextLine();

                System.out.println("Introduce tu nick de usuario ");
                String username2 = scan.nextLine();

                UserService userService = UserServiceFactory.getUserService();
                userService.follow(username2, username1);
            } else if (command.equals("3")) {
                System.out.println("Introduce nick de usuario");
                String username = scan.nextLine();

                UserService userService = UserServiceFactory.getUserService();
                String sep = "";
                for(String user:userService.followers(username)) {
                    System.out.print(sep + user);
                    sep = ",";
                }
                System.out.println();
            }
        }
    }
}
