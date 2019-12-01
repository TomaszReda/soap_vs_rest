package pl.tomasz_reda.praca_magisterska.soap_vs_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AngularController {

    public static final String HOME_PAGE = "forward:/index.html";

    private String page() {
        return HOME_PAGE;
    }

    @GetMapping("/")
    public String page(Model model) {
        return page();
    }

    @GetMapping("/home")
    public String home(Model model) {
        return page();
    }
}
