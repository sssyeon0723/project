package kr.or.batirplan.message.service;

import kr.or.batirplan.message.mapper.MessageMapper;
import kr.or.batirplan.message.service.MessageService;
import kr.or.batirplan.message.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void sendMessage(MessageVO message) {
        messageMapper.sendMessage(message);
    }

    @Override
    public List<MessageVO> getReceivedMessages(String rcver) {
        return messageMapper.getReceivedMessages(rcver);
    }

    @Override
    public List<MessageVO> getSentMessages(String dsptcher) {
        return messageMapper.getSentMessages(dsptcher);
    }

    @Override
    public void updateMessageStatus(int mssageNo) {
        messageMapper.updateMessageStatus(mssageNo);
    }

    @Override
    public void deleteMessage(int mssageNo) {
        messageMapper.deleteMessage(mssageNo);
    }

    @Override
    public void restoreMessage(int mssageNo) {
        messageMapper.restoreMessage(mssageNo);
    }
}
