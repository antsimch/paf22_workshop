package sg.edu.nus.iss.paf22_workshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf22_workshop.model.RSVP;
import sg.edu.nus.iss.paf22_workshop.service.RSVPService;

@RestController
@RequestMapping(path = "/api/rsvps")
public class RSVPController {
    
    private RSVPService rsvpService;

    public RSVPController(RSVPService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @GetMapping
    public ResponseEntity<List<RSVP>> getAllRSVP() {
        List<RSVP> rsvpList = rsvpService.getAllRSVP();

        if (rsvpList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(rsvpList);
        }
    }

    @GetMapping(path = "/rsvp/{id}")
    public ResponseEntity<RSVP> getRSVPById(@PathVariable int id) {
        RSVP rsvp = rsvpService.findRSVPById(id);

        if (rsvp == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(rsvp);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> saveRSVP(@RequestBody RSVP rsvp) {
        int saved = 0;
        saved = rsvpService.saveRSVP(rsvp);

        if (saved == 1) {
            return ResponseEntity.ok().body(saved);
        } else {
            return ResponseEntity.internalServerError().body(saved);
        }
    }

    @PutMapping(path = "/rsvp/{id}")
    public ResponseEntity<Integer> updateRSVP(@PathVariable int id, @RequestBody RSVP rsvp) {

        RSVP r = rsvpService.findRSVPById(id);

        if (r == null) 
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);

        int updated = 0;
        updated = rsvpService.updateRSVP(id, rsvp);

        return ResponseEntity.ok().body(updated);
    }
}
