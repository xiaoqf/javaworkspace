package design.hashing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginCheck {

    /** password and username */
    private static final Map<String, String> USER_PASSWORD = new HashMap<String, String>();

    /** full name and username */
    private static final Map<String, String> USER_FULLNAME = new HashMap<String, String>();

    public static void main(String[] args) {
        try {
            // get the input file with path
            String usersFileName = Thread.currentThread().getContextClassLoader().getResource("user.data").getPath();

            init(usersFileName);

            login();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * initialize
     * 
     * @param usersFileName
     * @throws Exception
     */
    @SuppressWarnings("resource")
    private static void init(String usersFileName) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(usersFileName));
        String line = reader.readLine();
        while (line != null) {
            if (!line.equals("")) {
                // split with comma
                String[] values = line.trim().split(",");
                USER_FULLNAME.put(values[1].trim(), values[0].trim());
                USER_PASSWORD.put(values[1].trim(), values[2].trim());
            }
            // next line
            line = reader.readLine();
        }
    }

    /**
     * user login
     */
    @SuppressWarnings("resource")
    private static void login() {
        Scanner input = new Scanner(System.in);
        // first time
        System.out.print("login: ");
        String userName = input.nextLine();
        System.out.print("password: ");
        String password = input.nextLine();
        if (!USER_PASSWORD.containsKey(userName) || !USER_PASSWORD.get(userName).equals(password)) {
            System.out.println("Either the username or password is incorrect. You have 2 more attempts.");
        } else {
            System.out.println("Login successful!");
            System.out.println("Welcome " + USER_FULLNAME.get(userName));
            return;
        }
        // second time
        System.out.print("login: ");
        userName = input.nextLine();
        System.out.print("password: ");
        password = input.nextLine();
        if (!USER_PASSWORD.containsKey(userName) || !USER_PASSWORD.get(userName).equals(password)) {
            System.out.println("Either the username or password is incorrect. You have 1 more attempts.");
        } else {
            System.out.println("Login successful!");
            System.out.println("Welcome " + USER_FULLNAME.get(userName));
            return;
        }
        // third time
        System.out.print("login: ");
        userName = input.nextLine();
        System.out.print("password: ");
        password = input.nextLine();
        if (!USER_PASSWORD.containsKey(userName) || !USER_PASSWORD.get(userName).equals(password)) {
            System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
        } else {
            System.out.println("Login successful!");
            System.out.println("Welcome " + USER_FULLNAME.get(userName));
        }
    }
}
