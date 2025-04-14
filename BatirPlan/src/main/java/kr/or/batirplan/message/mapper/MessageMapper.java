package kr.or.batirplan.message.mapper;

import kr.or.batirplan.message.vo.MessageVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MessageMapper {
    void sendMessage(MessageVO message);
    List<MessageVO> getReceivedMessages(String rcver);
    List<MessageVO> getSentMessages(String dsptcher);
    void updateMessageStatus(int mssageNo);
    void deleteMessage(int mssageNo);
    void restoreMessage(int mssageNo);
}
