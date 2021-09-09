package appcurate.capstone.nineyards.entity;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data // equal @Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    private int id;
    private int companyId;
    private int pmId;
    private String title;
    private String memberIdList;
    private String summary;
    private Date createTime;

    public void setMemberIdList(List<Integer> memberIdList){
        this.memberIdList = JSON.toJSONString(memberIdList);
    }

    public List<Integer> getMemberIdList(){
        return JSON.parseArray(this.memberIdList, Integer.class);
    }
}
