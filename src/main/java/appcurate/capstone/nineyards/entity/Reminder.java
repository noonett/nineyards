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
public class Reminder {
    private int id;
    private int userId;
    private int status;         // 0- Wait to notify; 1- Deleted; 2 - Notified
    private String phaseId;
    private String title;
    private String description;
    private Date notifyTime;
    private Date createTime;
}
