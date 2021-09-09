package appcurate.capstone.nineyards.entity;

import com.alibaba.fastjson.JSON;
import lombok.*;

import java.util.Date;
import java.util.List;

// 映射SQL中表的entity类
@Data // equal @Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private int id;
    private int companyId;
    private String password;
    private int type;           // 0- Project Member; 1- Project Manager; 2- Client;
    private int status;         // 0- Deleted; 1- Active; We dont actually delete data, the deleted data can be used in data science .
    private String name;
    private String notes;
    private String mainTelephone;
    private String department;
    private String emailAddress;
    private String extraContacts;
    private String landline;
    private String mobile;
    private Date createTime;    // this data can be used in data science

    public void setExtraContacts(List<Integer> extraContacts){
        this.extraContacts = JSON.toJSONString(extraContacts);
    }

    public List<Integer> getExtraContacts(){
        return JSON.parseArray(this.extraContacts, Integer.class);
    }
}
