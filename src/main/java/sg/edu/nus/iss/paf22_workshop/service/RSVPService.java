package sg.edu.nus.iss.paf22_workshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf22_workshop.model.RSVP;
import sg.edu.nus.iss.paf22_workshop.repository.RSVPRepository;

@Service
public class RSVPService {
    
    private RSVPRepository rsvpRepo;

    public RSVPService(RSVPRepository rsvpRepo) {
        this.rsvpRepo = rsvpRepo;
    }

    public List<RSVP> getAllRSVP() {
        return rsvpRepo.getAllRSVP();
    }

    public RSVP findRSVPById(int id) {
        return rsvpRepo.findRSVPById(id);
    }

    public int saveRSVP(RSVP rsvp) {
        return rsvpRepo.saveRSVP(rsvp);
    }

    public int updateRSVP(int id, RSVP rsvp) {
        return rsvpRepo.updateRSVP(id, rsvp);
    }
}
