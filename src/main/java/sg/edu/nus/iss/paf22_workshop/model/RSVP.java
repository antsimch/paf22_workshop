package sg.edu.nus.iss.paf22_workshop.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RSVP {

    private Integer id;
    
    private String fullName;

    private String email;

    private String phone;

    private Date confirmationDate;

    private String comments;
}