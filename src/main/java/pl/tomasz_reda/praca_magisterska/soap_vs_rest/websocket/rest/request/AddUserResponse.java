package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.request;

import lombok.Data;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class AddUserResponse {

    String timeToAddDate;
    List<User> user = new ArrayList<>();

    @Override
    public String toString() {
        return "<p>" +
                "timeToAddDate=" + timeToAddDate + "</p>"+
                "user={" + user +"}";
    }
}
