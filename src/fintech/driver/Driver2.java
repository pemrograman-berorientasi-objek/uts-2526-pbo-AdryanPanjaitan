package fintech.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fintech.model.Account;

/**
 * @author 12S24013 - Adryan Julianto Panjaitan
 */
public class Driver2 {
    public static void main(String[] _args) {
        Map<String, Account> accounts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("---")) {
                break;
            }

            if (line.startsWith("create-account#")) {
                String[] parts = line.split("#");
                if (parts.length == 3) {
                    String name = parts[1];
                    String username = parts[2];
                    Account account = new Account(name, username);
                    accounts.put(username, account);
                }
            }
        }

        scanner.close();
    }

}