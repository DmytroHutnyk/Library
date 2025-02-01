package hutnyk.library.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class StartupRunner implements CommandLineRunner {
    private final ApplicationContext applicationContext;

    @Override
    public void run(String... args) {
        if (isRunningInTestMode()) {
            return;
        }
        System.out.println("\n Default Test Accounts:");
        System.out.println(" Reader:    Username: user1 | Password: 1234");
        System.out.println(" Publisher: Username: user2 | Password: qwerty");
        System.out.println(" Librarian: Username: user3 | Password: pjatk");
        System.out.println(" Admin:     Username: admin | Password: asd3");
        System.out.println("\n Application available at  http://localhost:8080\n");

        listenForExitCommand();
    }

    private void listenForExitCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'q' and pres Enter to exit the application.\n");

        while (true) {
            String input = scanner.nextLine().trim();

            if ("q".equalsIgnoreCase(input)) {
                System.out.println("Shutting down...");
                SpringApplication.exit(applicationContext, () -> 0);
                break;
            }
        }

        scanner.close();
    }
    private boolean isRunningInTestMode() {
        return System.getProperty("java.class.path").contains("test");
    }
}