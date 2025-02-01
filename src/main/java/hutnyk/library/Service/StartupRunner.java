package hutnyk.library.Service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("\n Default Test Accounts:");
        System.out.println(" Reader:    Username: user1 | Password: 1234");
        System.out.println(" Publisher: Username: user2 | Password: qwerty");
        System.out.println(" Librarian: Username: user3 | Password: pjatk");
        System.out.println(" Admin:     Username: admin | Password: asd3");
        System.out.println("\n Application available at  http://localhost:8080\n");
    }
}
