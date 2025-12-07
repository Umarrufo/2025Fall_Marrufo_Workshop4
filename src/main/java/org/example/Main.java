package org.example;

public class Main
{
    private static String dbURL;
    private static String dbUser;
    private static String dbPass;

    public static void main(String[] args)
    {
        dbURL = args[0];
        dbUser = args[1];
        dbPass = args[2];

        UserInterface userInterface = new UserInterface(dbURL, dbUser, dbPass);
        userInterface.display();
    }
}