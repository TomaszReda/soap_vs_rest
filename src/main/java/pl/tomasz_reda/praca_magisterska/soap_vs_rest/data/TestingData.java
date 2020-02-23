package pl.tomasz_reda.praca_magisterska.soap_vs_rest.data;

import com.querydsl.core.types.dsl.StringPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.BookCategory;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.BookState;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserRoleEnum;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserRoles;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.BookCategoryRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.BookRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRoleRepository;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

@Component
public class TestingData implements CommandLineRunner {

    protected static final String[] bookCategories = {"Fantasy", "Biografie/Autobiografie", "Młodzieżowa", "Naukowa", "Sportowa", "Bajka", "Historyczna", "Horror", "Przygodowa", "Inna"};
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookCategoryRepository bookCategoryRepository;

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
        User user = null;
        user = new User(null, "test", "test", "test@op.pl", "GHJbnm123", "123123123", userRoles1);
        userRepository.save(user);


        BookCategory bookCat = null;
        for (String bookCategory : bookCategories) {
            bookCat = new BookCategory();
            bookCat.setCategoryType(bookCategory);
            bookCategoryRepository.save(bookCat);
        }
        BookState[] bookStateTAble = {BookState.BOOKED, BookState.CONFIRMED, BookState.DELETE, BookState.NOTRESERVED};
        String[] PublisherTABLE = {"Pearson", "Reed Elsevier", "ThomsonReuters", "Wolters Kluwer", "Random House", "Hachette Livre",
                "Grupo Planeta", "McGraw-Hill Education", "Holtzbrinck", "Scholastic"};
        String[] authorTAble = {"Anna", "Maria", "Katarzyna", "Małgorzata", "Agnieszka", "Krystyna", "Barbara", "Ewa", "Elżbieta", "Zofia", "Janina", "Teresa", "Joanna", "Magdalena", "Monika", "Jadwiga", "Danuta", "Irena", "Halina", "Helena", "Beata", "Aleksandra", "Marta", "Dorota", "Marianna", "Grażyna", "Jolanta", "Stanisława", "Iwona", "Karolina", "Bożena", "Urszula", "Justyna", "Renata", "Alicja", "Paulina", "Sylwia", "Natalia", "Wanda", "Agata", "Aneta", "Izabela", "Ewelina", "Marzena", "Wiesława", "Genowefa", "Patrycja", "Kazimiera", "Edyta", "Stefania", "first-m.txt", "Jan", "Andrzej", "Piotr", "Krzysztof", "Stanisław", "Tomasz", "Paweł", "Józef", "Marcin", "Marek", "Michał", "Grzegorz", "Jerzy", "Tadeusz", "Adam", "Łukasz", "Zbigniew", "Ryszard", "Dariusz", "Henryk", "Mariusz", "Kazimierz", "Wojciech", "Robert", "Mateusz", "Marian", "Rafał", "Jacek", "Janusz", "Mirosław", "Maciej", "Sławomir", "Jarosław", "Kamil", "Wiesław", "Roman", "Władysław", "Jakub", "Artur", "Zdzisław", "Edward", "Mieczysław", "Damian", "Dawid", "Przemysław", "Sebastian", "Czesław", "Leszek", "Daniel", "Waldemar"};
        String[] lastnameTable = {"Ożga", "Kuczek", "Leśniak", "Suchecki", "Chłopek", "Trocha", "Żygadło", "Franczak", "Antosiak", "Przybył", "Prałat", "Chudziński", "Kot", "Kura", "Zagrodzki", "Rutyna", "Pacek", "Kudyba", "Kiełtyka", "Niedziałkowski", "Radtke", "Patalas", "Goral", "Sławiński", "Dyduch", "Pisarczyk", "Kubasik", "Dziedzic", "Kantor", "Kukliński", "Wojcieszak", "Łucki", "Kulczyński", "Gurgul", "Słomiński", "Zdunek", "Kulawik", "Cisło", "Suchy", "Mączka", "Rajca", "Śmiałek", "Rzepecki", "Wacławski", "Wawer", "Kotuła", "Wojtkiewicz", "Langer", "Wolszczak", "Bałdyga", "Malesa", "Wachowicz", "Cieśla", "Fila", "Leśkiewicz", "Godek", "Cygan", "Raszka", "Koźlik", "Kanclerz", "Fornalczyk", "Fedorowicz", "Nycz", "Zięcina", "Ogorzałek", "Czajkowski", "Kułakowski", "Frąckiewicz", "Widz", "Buśko", "Kopciński", "Jarecki", "Cichoński", "Seroczyński", "Cichocki", "Kantorski", "Kryński", "Wypych", "Fiuk", "Perzanowski", "Mruk", "Kropidłowski", "Rynkiewicz", "Niewęgłowski", "Nieckarz", "Śliwiński", "Warzecha", "Barczak", "Milanowski", "Kozub", "Zamojski", "Łazowski", "Sulikowski", "Woś", "Niewiarowski", "Szczupak", "Tarka", "Dolecki", "Pieczykolan", "Klasa", "Węsierski", "Sylwestrzak", "Skorupa", "Dunaj", "Żuber", "Kunicki", "Staniek", "Pijanowski", "Sitarz", "Kleszcz", "Narewski", "Staniak", "Dzik", "Polanowski", "Podleśny", "Pociecha", "Stadnik", "Iskra", "Kolczyński", "Muszyński", "Wilamowski", "Pacholec", "Brodziński", "Kałużyński", "Rybicki", "Faron", "Szymanek", "Boczar", "Jarczyński", "Dołęgowski", "Połczyński", "Piętka", "Konior", "Koszałka", "Juchniewicz", "Szymaszek", "Smulski", "Sanecki", "Bochniak", "Łakomski", "Sarna", "Jaguś", "Oleszkiewicz", "Napieralski", "Szota", "Machura", "Słomski", "Seremak", "Kraj", "Krzykowski", "Szczawiński", "Kortas", "Korolczuk", "Matecki", "Wąsowski", "Kulpiński", "Ciechanowicz", "Chodkiewicz", "Stefanek", "Trzciński", "Matuszkiewicz", "Rychlik", "Szymczak", "Dworaczek", "Adamczewski", "Ignatowicz", "Spychała", "Łuka", "Sierant", "Kukułka", "Skrzypczak", "Budziak", "Paszko", "Polewski", "Stachnik", "Słomka", "Świerc", "Hryciuk", "Giemza", "Świerczek", "Błaut", "Grzymała", "Krawczak", "Szymczyk", "Just", "Bułat", "Serafin", "Karbowiak", "Borowczyk", "Komor", "Ciarkowski", "Gnat", "Stryczek", "Makuła", "Ogrodnik", "Mazurowski", "Gapski", "Wiatr", "Paduch", "Lemański", "Rytel", "Świątkowski", "Kumor", "Słomczyński", "Kościółek", "Drzyzga", "Dymiński", "Ochocki", "Dudkiewicz", "Balcer", "Ruszczyk", "Prorok", "Bogusz", "Gil", "Borecki", "Kluz", "Szurgot", "Wieliczko", "Jabłoński", "Mączyński", "Staszczak", "Danowski", "Kulczyk", "Dawidowski", "Nowotarski", "Grabek", "Dobkowski", "Siek", "Błaszczyński", "Piątkowski", "Kuśmierek", "Brudnicki", "Staszkiewicz", "Rosiński", "Kasperski", "Ciura", "Miśta", "Derda", "Sibiński", "Ostrowski", "Pakulski", "Sawiński", "Józefowski", "Gostkowski", "Dębek", "Trojan", "Danielski", "Ratajczyk", "Iwanowicz", "Zdeb", "Ogrodowski", "Sławek", "Ryłko", "Wieczorkowski", "Ciszek", "Tobiasz", "Majkowski", "Pawelski", "Motylewski", "Łupiński", "Lubas", "Zawiślak", "Sagan", "Sus", "Wodecki", "Królikowski", "Bandurski", "Gębka", "Mikołajewski", "Zwolak", "Pudełko", "Kłopotowski", "Gorczyński", "Kęsy", "Nakielski", "Żelechowski", "Wojdyło", "Pawlicki", "Wiecha", "Frąc", "Jurkiewicz", "Dzierżanowski", "Sankowski", "Eliasz", "Machała", "Dobrzyński", "Gruszczyński", "Wołyniec", "Chludziński", "Orlikowski", "Pawluk", "Szumowski", "Igielski", "Fijałkowski", "Mędrek", "Antończyk", "Wicik", "Płaza", "Żak", "Łebek", "Pilch", "Węgrzyn", "Włodarczak", "Kaim", "Remiszewski", "Maroszek", "Cupiał", "Szmigiel", "Toboła", "Bobek", "Świderek", "Czerw", "Siwiak", "Bakuła", "Gondek", "Sobieski", "Grodzki", "Michalec ", "Piekutowski", "Fornal", "Mateusiak", "Richter", "Czyżak", "Plewa", "Bania", "Rygiel", "Kucza", "Najder", "Roszyk", "Musiałowski", "Zuber", "Krysa", "Knap", "Schmidt", "Dwojak", "Berliński", "Wójcicki", "Kampa", "Łukasiak", "Kuryło", "Skrok", "Czaplewski", "Wawro", "Grygoruk", "Szczepanowski", "Kubiczek", "Bajek", "Krężel", "Samsel", "Grzegorek", "Grad", "Grzegorzewski", "Majchrzak", "Kuźniar", "Sulowski", "Walkiewicz", "Kin", "Szul", "Adamowicz", "Mazurkiewicz", "Kapłon", "Wojdyła", "Szpakowski", "Bagrowski", "Głodek", "Piwowarczyk", "Zarzycki", "Paul", "Brol", "Gumowski", "Gaca", "Fil", "Pęczek", "Czerniejewski", "Kopyciński", "Franczyk", "Pilarski", "Pietraszewski", "Feliks", "Kościński", "Zimnicki", "Tobolski", "Czarnik", "Całus", "Ciepliński", "Boczkowski", "Anioł", "Jesionowski", "Muchowski", "Skibiński", "Dąbkowski", "Abramowski", "Szumilas", "Barnaś", "Mierzejewski", "Czapliński", "Pióro", "Kępa", "Waligóra", "Rutkiewicz"};
        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        String[] titleTABLE = {"Wszystko rozpada się Chinua Achebe", " Baśnie Hans  ", " Boska komedia  ", " Epos o Gilgameszu ", " Księga Hioba  ", " Księga tysiąca i jednej nocy  ", " Saga o Njalu ", " Duma i uprzedzenie ", " Ojciec Goriot Honoré de Balzac", " Molloy, Malone umiera, Nienazywalne, trylogia Samuel Beckett", " Dekameron Giovanni ", " Fikcje Jorge", " Wichrowe Wzgórza Emily Brontë", " Obcy Albert ", " Wiersze Paul ", " Podróż do kresu nocy ", " Don Kichot ", " Opowieści kanterberyjskie", " Nowele i opowiadania ", " Nostromo", " Wielkie nadzieje ", " Kubuś Fatalista i jego pan ", " Berlin Alexanderplatz ", " Zbrodnia i kara ", "", " Idiota ", " Biesy ", " Bracia Karamazow ", " Miasteczko Middlemarch  ", "", "Niewidzialny człowiek ", " Medea Eurypides", " Absalomie, Absalomie… ", " Wściekłość i wrzask", " Pani Bovary", " Szkoła uczuć ", " Romancero cygańskie", " Sto lat samotności ", " Miłość w czasach zarazy ", " Faust ", " Martwe dusze ", " Blaszany bębenek ", " Wielkie pustkowie ", " Głód Knut Hamsun", " Stary człowiek i morze ", " Iliada ", " Odyseja ", " Nora ", " Ulisses ", " Opowiadania ", " Proces ", " Zamek ", " Siakuntala ", " Głos góry ", " Grek Zorba ", " Synowie i kochankowie", " Niezależni  ", " Wiersze  ", " Złoty notes  ", " Pippi Pończoszarka  ", " Dziennik szaleńca  ", " Dzieci naszej dzielnicy  ", " Buddenbrokowie  ", " Czarodziejska góra  ", " Moby Dick  ", " Próby  ", " Historia Elsa ", " Umiłowana  ", " Genji monogatari  ", " Człowiek ", " Lolita ", " Rok 1984 ", " Metamorfozy ", " Księga niepokoju", " Opowiadania", " W poszukiwaniu straconego czasu", "", " Gargantua i Pantagruel François", " Pedro ", " Masnawi ", " Dzieci północy", " Ogród drzew", " Sezon migracji na Północ At-Tajjib Salih", " Miasto ślepców", " Hamlet", " Król Lear", " Otello", " Król Edyp", " Czerwone i czarne", " Życie i myśli JW ", " Zeno Cosini ", " Podróże Guliwera", " Wojna i pokój", " Anna Karenina ", " Śmierć Iwana Iljicza", " Przygody Hucka", " Ramajana ", " Eneida ", " Mahabharata ", " Źdźbła trawy ", " Pani Dalloway", " Do latarni morskie", " Pamiętniki Hadriana"};

        String[] DescritionTable = {"Pierwsza książka Nassima Nicholasa Taleba, autora słynnego \"Czarnego Łabędzia\" i \"Antykruchości\". W błyskotliwym eseju autor zastanawia się nad rolą przypadku na rynkach finansowych, i szerzej – w życiu człowieka. Na podstawie swego wieloletniego doświadczenia zawodowego praktyka-ilościowca, a także w oparciu o setki przeczytanych książek, Taleb snuje frapującą opowieść o tym, jak funkcjonować w świecie, w którym kluczową rolę odgrywa losowość i dlaczego ludzie tak usilnie starają się usystematyzować przypadek. W swych rozważaniach przechodzi od matematycznej", "Trzecia część początku kultowego cyklu zekranizowanego jako kultowy serial telewizyjny Pamiętnik Stefano przenosi akcję o sto lat wcześniej i odkrywa początek historii miłosnego trójkąta dwóch braci wampirów i pięknej dziewczyny, której obaj pragną Damon zdradził brata w Nowym Orleanie. Teraz Stefano postanawia rozpocząć wszystko od nowa. Ślubuje nie skrzywdzić już nigdy więcej człowieka. Przemierza ulice Manhattanu, usiłując zniknąć w tętniącym życiem mieście. A kiedy myśli, że uciekł już", "Wspomnienia wybitnego myśliciela konserwatywnego, ukazujące przemiany polityczne, społeczne i kulturowe dokonujące się w XIX wieku. Popiel opisuje i analizuje procesy i wydarzenia, których był uczestnikiem i świadkiem, m.in. powstanie listopadowe, rabację galicyjską, Wiosnę Ludów, powstanie styczniowe. Charakteryzuje również politykę francuską, niemiecką, austriacką, angielską i rosyjską oraz dyskusję o władzy świeckiej papieża i spory polityczne z doby autonomii galicyjskiej. Jego Pamiętniki przedstawiają narodziny i ewolucję polskiego konserwatyzmu, pozwalając współczesnemu czytelnikowi zroz...", "Zżerani przez ciekawość, wszyscy trzej pochylili się nad reklamówką. − Może są tu skradzione pieniądze Fritjofa – podsunął Aron, z trudem łapiąc oddech. − Na pewno tu są – odparł Leo. Ale ich nie było. Brat trzymał przed nimi niewielką wełnianą czarną rzecz. − Aha, to czapka, nie sweter. I co z tego? – stwierdził Henke. − Nie widzisz? Przyjrzyj się – upierał się Aron. – Myślę, że nasz braciszek ma rację. Wtedy Henke także to dostrzegł. To nie była zwyczajna czapka, lecz kominiarka z wyciętymi otworami na oczy i usta. Dokładnie taka, jaką zawsze noszą prawdziw...", "XIV wiek, Norwegia... Trzydzieści lat po wielkiej epidemii dżumy, nazwanej \"czarną śmiercią\". We dworze rycerza Gudmunda mają miejsce tajemnicze zdarzenia. Tova, piękna i mądra córka rycerza, dostrzega dziwne postaci, krążące pod osłoną nocy w pobliżu starej nie zamieszkanej chaty. Nikt jednak nie daje wiary opowieściom dziewczyny, uważając, że to wytwór jej wyobraźni. Pewnego dnia Tova zostaje podstępnie uprowadzona przez okrutnego wojownika imieniem Ravn...", "ozpocznij przygodę z Visual C++! Jakie prawa rządzą programowaniem obiektowym? Jak tworzyć usługi systemowe? Jak dokumentować tworzony kod? Microsoft Visual C++ jest zintegrowanym środowiskiem, pozwalającym na tworzenie aplikacji przy użyciu języków C, C++ lub C++/CLI. Zawiera ono wyspecjalizowane narzędzia, pomagające w wydajnym tworzeniu rozwiązań opartych o te języki. Pierwsza wersja Visual C++ została wydana w 1992 roku, a środowisko to jest bezustannie ulepszane. Najnowsze wydanie, z datą 2008, zostało opublikowane w listopadzie 2007 roku i wprowadziło wiele nowości -- jak chociażby ...", "Drugie poprawione wydanie opowieści o Mordimerze Madderdinie, inkwizytorze, który nie waha się zadawać pytań i dążyć do odkrycia prawdy o otaczającym go świecie. Świecie pełnym intryg i zła. Świecie, w którym ludziom zagrażają demony, czarownicy oraz wyznawcy mrocznych kultów. Świecie, którego siłą napędową są nienawiść, chciwość oraz żądza. Do tego właśnie uniwersum Mordimer Madderdin niesie żagiew Boskiej miłości… OTO ŚWIAT, w którym Chrystus zstąpił z krzyża i surowo ukarał swych prześladowców. Świat gdzie słowa modlitwy brzmią: „i daj nam siłę, byśmy nie przebaczali naszym winowajcom”...", "        W błyskotliwym eseju autor zastanawia się nad rolą przypadku na rynkach finansowych, i szerzej – w życiu człowieka. Na podstawie swego wieloletniego doświadczenia zawodowego praktyka-ilościowca, a także w oparciu o setki przeczytanych książek, Taleb snuje frapującą opowieść o tym, jak funkcjonować w świecie, w którym kluczową rolę odgrywa losowość i dlaczego ludzie tak usilnie starają się usystematyzować przypadek. W swych rozważaniach przechodzi od matematycznej metody Monte Carlo (wykorzystywanej do modelowania matematycznego złożonych procesów, w których trudno za pomocą podejścia analitycznego przewidzieć wynik) do koncepcji rosyjskiej ruletki."};

        for (int i = 0; i < 200; i++) {
            String firstname = random(authorTAble);
            String lastname = random(lastnameTable);
            String author = firstname + " " + lastname;
            BookState bookState = random(bookStateTAble);
            String Desscription = random(DescritionTable);
            String pubiler = random(PublisherTABLE);
            int quant = random.nextInt(100);
            String title = random(titleTABLE);
            String ISB = UUID.randomUUID().toString();

            Book book = new Book(null, author, title, pubiler, randomBirthDate, ISB, quant, Desscription, BookState.NOTRESERVED, null);
            bookRepository.save(book);
            System.err.println("INSERT INTO public.book(" +
                    " author, book_state, date, description, isbn, publisher, quant, title) " +
                    "VALUES (" +
                    "\'" + author + "\'," +
                    "\'" + bookState + "\'," +
                    "\'" + randomBirthDate + "\'," +
                    "\'" + Desscription + "\'," +
                    "\'" + ISB + "\'," +
                    "\'" + pubiler + "\'," +
                    "\'" + quant + "\'," +
                    "\'" + title + "\'" +
                    ");");


        }
        for (Book book : bookRepository.findAll()) {
            System.err.println("DELETE FROM public.book where isbn=\'" + book.getIsbn() + "\';");

        }


        for (Book book : bookRepository.findAll()) {
            for (String s : randomType()) {
                System.err.println("INSERT INTO public.book_book_category(" +
                        "book_id, category_id) " +
                        " " +
                        "\nSELECT (Select id from public.book where isbn=\'" + book.getIsbn() + "\')" +
                        ", " +
                        "\n(Select id from public.book_category where category_type=\'" + s + "\'" +
                        ");");
            }
        }


    }

    private Set<String> randomType() {
        Set<String> bookCategoriessssss = new HashSet<>();
        Random random = new Random();
        int rr1 = random.nextInt(5) % 5 + 0;
        for (int r = 0; r < rr1; r++) {
            int rrr = random.nextInt(bookCategories.length) % bookCategories.length + 0;
            bookCategoriessssss.add(bookCategories[rrr]);

        }
        return bookCategoriessssss;

    }

    private BookState random(BookState[] tab) {
        Random r = new Random();
        int rrr = r.nextInt(tab.length) % tab.length + 0;
        return tab[rrr];
    }

    private String random(String[] tab) {
        Random r = new Random();
        int rrr = r.nextInt(tab.length) % tab.length + 0;
        return tab[rrr];
    }


}
