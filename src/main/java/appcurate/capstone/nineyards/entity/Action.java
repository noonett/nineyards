package appcurate.capstone.nineyards.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data // equal @Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Action {
    private int id;
    private int phaseId;
    private int userId;
    private String title;
    private String dependency;
    private int visibility;         // 0- visible; 1- not visible to client;
    private int status;
    private int type;               // 0- normal; 1- milestone
    private String description;
    private String attachmentUrl;
    private Date startDate;
    private long duration;
    private Date createDate;
}
