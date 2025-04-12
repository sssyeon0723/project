package kr.or.batirplan.message.vo;

import lombok.Data;
import java.util.Date;

@Data
public class MessageVO {
    private int mssageNo;
    private String dsptcher;
    private String rcver;
    private String cn;
    private Date sndngDt;
    private Date recptnDt;
    private String messageSttus;
    private String recovryPosblAt;
}
