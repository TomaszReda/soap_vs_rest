package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class TestOtherObject3 {
    private String field1;
    private List<String> field2;
    private TestOtherObject4 testOtherObject4;
}
