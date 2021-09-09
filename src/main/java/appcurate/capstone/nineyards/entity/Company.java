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
public class Company {
    private int id;
    private String name;
    private String address;
    private String telephone;
    private int status;         // 0- Deleted; 1- Active;
    private String abn;
    private String type;
    private Date createTime;

}
