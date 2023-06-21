package sg.edu.nus.iss.paf22_workshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.paf22_workshop.RestTemplate.RSVPRestTemplate;
import sg.edu.nus.iss.paf22_workshop.model.RSVP;

@Controller
@RequestMapping(path = "/rsvps")
public class RSVPUIController {

    private RSVPRestTemplate restTemplate;

    public RSVPUIController(RSVPRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/add")
    public String getSave(Model model) {
        model.addAttribute("rsvp", new RSVP());
        return "form";
    }

    @PostMapping(path = "/add")
    public String postSave(RSVP rsvp, Model model) {

        System.out.println(rsvp.toString());
        Integer result = restTemplate.createRSVP(rsvp);

        model.addAttribute("rsvp", rsvp);

        if (result == 1) {
            return "saved";
        } else {
            return "form";
        }
    }

    @GetMapping(path = "/list")
    public String getAllRSVP(Model model) {
        List<RSVP> rsvpList = restTemplate.getRSVPs();
        model.addAttribute("rsvpList", rsvpList);
        return "list";
    }
}
