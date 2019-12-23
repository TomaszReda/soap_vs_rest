package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class TestOtherObject1 {
    private String testField1;
    private String testField2;
    private String testField3;
    private List<String> list;
}
