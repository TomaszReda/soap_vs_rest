package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserCasual;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserRoleEnum;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserRoles;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserCasualRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRoleRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.request.AddUserResponse;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserCasualRepository userCasualRepository;

    public String addUser(int ile) {
        UserRoles userRoles = new UserRoles();
        userRoles.setUserRole(UserRoleEnum.CASUAL_USER);
        userRoles = userRoleRepository.save(userRoles);
        AddUserResponse addUserResponse = new AddUserResponse();
        UserCasual userCasual=new UserCasual();
        userCasual = userCasualRepository.save(userCasual);

        LocalDateTime start=LocalDateTime.now();
        for (int i = 0; i < ile; i++) {
            User user = new User("tomek", "reda", "tomekreda@op.pl", 533927396, "GHJbnm123", null, userCasual, userRoles);
            userRepository.save(user);
            addUserResponse.getUser().add(user);
        }
        LocalDateTime end=LocalDateTime.now();
        addUserResponse.setTimeToAddDate(formatTwoDateToResult(start,end));
        return addUserResponse.toString();
    }

    private String formatTwoDateToResult(LocalDateTime start,LocalDateTime end){
        int sekundyStart=start.getHour()*3600+start.getMinute()*60+start.getSecond();
        int sekundyEnd=end.getHour()*3600+end.getMinute()*60+end.getSecond();
        int wynik=sekundyEnd-sekundyStart;
        String format="";
        if(wynik/3600>=1){
            format+="godzin: "+wynik/3600;
            wynik=wynik-wynik*3600;
        }
        if(wynik/60>=1){
            format+="minut: "+wynik/60;
            wynik=wynik-wynik*60;
        }
        if(wynik>0)
            format+="sekund "+wynik;
        return format;
    }
}
