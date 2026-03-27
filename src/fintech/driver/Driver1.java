package fintech.driver;

import fintech.model.Account;
import java.util.*;

/**
 * @author 12S24013 - Adryan Julianto Panjaitan
 */

public class Driver1 {
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

        accounts.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                Account acc = entry.getValue();
                System.out.println(acc.getUsername() + "|" + acc.getName() + "|" + String.format("%.1f", acc.getBalance()));
            });
    }
}

