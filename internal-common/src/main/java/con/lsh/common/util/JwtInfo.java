package con.lsh.common.util;

import lombok.Data;

@Data
public class JwtInfo{
    String subject;
    Long issueDate;
}