package sg.edu.nus.iss.paf22_workshop.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf22_workshop.model.RSVP;

@Repository
public class RSVPRepository {
    
    private JdbcTemplate template;

    private final String getAllSQL = 
            "select * from rsvp";

    private final String findByIdSQL =
            "select * from rsvp where full_name = %?%";

    private final String saveSQL =
            """
            insert into rsvp (full_name, email, phone, 
            confirmation_date, comments) values (?, ?, ?, ?, ?)                       
                        """;

    
    private final String updateSQL = 
            "update into rsvp set email = ?, phone = ?, confirmation_date = ? where id = ?";

    public RSVPRepository(JdbcTemplate template) {
        this.template = template;
    }

    public List<RSVP> getAllRSVP() {
        return template.query(
                getAllSQL, 
                BeanPropertyRowMapper
                .newInstance(RSVP.class));
    }

    public RSVP findRSVPById(int id) {
        return template.queryForObject(
                findByIdSQL, 
                BeanPropertyRowMapper
                .newInstance(RSVP.class), 
                id);
    }

    public int saveRSVP(RSVP rsvp) {
        return template.update(
                saveSQL, 
                rsvp.getFullName(), 
                rsvp.getEmail(), 
                rsvp.getPhone(), 
                rsvp.getConfirmationDate(), 
                rsvp.getComments());
    }

    public int updateRSVP(int id, RSVP rsvp) {
        return template.update(
                updateSQL,
                rsvp.getEmail(), 
                rsvp.getPhone(), 
                rsvp.getConfirmationDate(), 
                id
        );
    }
}
