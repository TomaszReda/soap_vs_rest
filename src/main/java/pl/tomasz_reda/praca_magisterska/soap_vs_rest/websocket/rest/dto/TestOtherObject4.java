package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestOtherObject4 {
    private String field;
    private List<String> fieldName = new ArrayList<>();
}
