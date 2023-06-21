package sg.edu.nus.iss.paf22_workshop.RestTemplate;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sg.edu.nus.iss.paf22_workshop.model.RSVP;

@Service
public class RSVPRestTemplate {

    private static final String RSVP_ENDPOINT_URL = "http://localhost:8080/api/rsvps";

    private static RestTemplate restTemplate = new RestTemplate();

    public List<RSVP> getRSVPs() {

        HttpEntity<String> entity = 
                new HttpEntity<String>("parameters");

        ResponseEntity<List<RSVP>> results = restTemplate
                .exchange(RSVP_ENDPOINT_URL, 
                HttpMethod.GET, 
                entity,
                new ParameterizedTypeReference<List<RSVP>>() {
                });

        return results.getBody();
    }

    public Integer createRSVP(RSVP newRSVP) {

        ResponseEntity<Integer> result = restTemplate
                .postForEntity(RSVP_ENDPOINT_URL, 
                newRSVP, 
                Integer.class);

        return result.getBody();
    }

    public Integer updateRSVPs(RSVP newRSVP) {

        HttpEntity<String> entity = 
                new HttpEntity<String>("parameters");

        ResponseEntity<Integer> result = restTemplate
                .exchange(RSVP_ENDPOINT_URL, 
                HttpMethod.PUT, 
                entity, 
                Integer.class);

        return result.getBody();
    }
}
