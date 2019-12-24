package pl.tomasz_reda.praca_magisterska.soap_vs_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AngularController {

    public static final String page_PAGE = "forward:/index.html";

    private String page() {
        return page_PAGE;
    }

    @GetMapping("/")
    public String page(Model model) {
        return page();
    }

    @GetMapping("/home")
    public String page1(Model model) {
        return page();
    }

    @GetMapping("/definicje")
    public String page2(Model model) {
        return page();
    }

    @GetMapping("/wstep")
    public String page3(Model model) {
        return page();
    }

    @GetMapping("/stanowosc")
    public String page4(Model model) {
        return page();
    }

    @GetMapping("/cache")
    public String page5(Model model) {
        return page();
    }

    @GetMapping("/protokol")
    public String page6(Model model) {
        return page();
    }

    @GetMapping("/configuracja")
    public String page7(Model model) {
        return page();
    }

    @GetMapping("/wydajnosc")
    public String page8(Model model) {
        return page();
    }

    @GetMapping("/bezpieczenstwo")
    public String page9(Model model) {
        return page();
    }

    @GetMapping("/rozmiar-danych")
    public String page10(Model model) {
        return page();
    }

    @GetMapping("/dane")
    public String page11(Model model) {
        return page();
    }

    @GetMapping("/javaAPI")
    public String page12(Model model) {
        return page();
    }

    @GetMapping("/serwer")
    public String page13(Model model) {
        return page();
    }

    @GetMapping("/wykorzystanie")
    public String page14(Model model) {
        return page();
    }

    @GetMapping("/zastosowania")
    public String page15(Model model) {
        return page();
    }

    @GetMapping("/inne")
    public String page16(Model model) {
        return page();
    }
}
