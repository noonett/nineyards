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
public class Phase {
    private int id;
    private int projectId;
    private String title;
    private String dependency;
    private int visibility;         // 0- visible; 1- not visible to client;
    private int status;
    private int type;               // 0- normal; 1- milestone
    private String description;
    private Date startDate;
    private long duration;
    private Date createDate;
}
