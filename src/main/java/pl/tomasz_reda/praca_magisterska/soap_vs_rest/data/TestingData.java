package pl.tomasz_reda.praca_magisterska.soap_vs_rest.data;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.BookCategory;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserRoleEnum;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserRoles;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.BookCategoryRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRoleRepository;

import java.util.Random;

@Component
public class TestingData implements CommandLineRunner {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    protected static final String[] bookCategories = {"Fantasy", "Biografie/Autobiografie", "Młodzieżowa", "Naukowa", "Sportowa", "Bajka", "Historyczna", "Horror", "Przygodowa", "Inna"};


    @Override
    public void run(String... args) throws Exception {
        UserRoles userRoles = new UserRoles();
        userRoles.setId(1l);
        userRoles.setUserRole(UserRoleEnum.CASUAL_USER);
        userRoleRepository.save(userRoles);
        UserRoles userRoles1 = new UserRoles();
        userRoles1.setId(2l);
        userRoles1.setUserRole(UserRoleEnum.ADMIN);
        userRoleRepository.save(userRoles1);

        BookCategory bookCat = null;
        for (String bookCategory : bookCategories) {
            bookCat = new BookCategory();
            bookCat.setCategoryType(bookCategory);
            bookCategoryRepository.save(bookCat);
        }
        User user = null;
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int number = random.nextInt(10);
            user = new User(null, "test" + number, "test" + number, "test" + number + "@op.pl", 1231231, "GHJbnm123", userRoles);
            userRepository.save(user);
        }

    }


}
