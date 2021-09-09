package appcurate.capstone.nineyards.entity;

import lombok.*;

import java.util.Date;

// 映射SQL中表的entity类
@Data // equal @Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Demo {

    private int id;
    private String username;
    private String password;
    private String company;
    private String salt;
    private String email;
    private int type;
    private int status;
    private String activationCode;
    private String headerUrl;
    private Date createTime;
}
