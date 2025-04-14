package kr.or.batirplan.message.service;

import kr.or.batirplan.message.vo.MessageVO;
import java.util.List;

public interface MessageService {
    void sendMessage(MessageVO message);
    List<MessageVO> getReceivedMessages(String rcver);
    List<MessageVO> getSentMessages(String dsptcher);
    void updateMessageStatus(int mssageNo);
    void deleteMessage(int mssageNo);
    void restoreMessage(int mssageNo);
}
