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
public class ProjectManager {
    private int id;
    private int userId;
    private int companyId;
    private String name;
    private String email;
    private Date createTime;
}
