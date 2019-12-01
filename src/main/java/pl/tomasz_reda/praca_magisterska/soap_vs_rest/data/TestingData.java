package pl.tomasz_reda.praca_magisterska.soap_vs_rest.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.BookCategory;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserRoleEnum;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserRoles;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.BookCategoryRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRoleRepository;

@Component
public class TestingData implements CommandLineRunner {

    @Autowired
    private UserRoleRepository userRoleRepository;

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
    }


}
