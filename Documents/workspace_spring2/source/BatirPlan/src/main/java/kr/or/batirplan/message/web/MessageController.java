package kr.or.batirplan.message.web;

import kr.or.batirplan.message.service.MessageService;
import kr.or.batirplan.message.vo.MessageVO;
import kr.or.batirplan.notification.service.NotificationService;
import kr.or.batirplan.notification.vo.NotificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sendMessage")
    public void sendMessage(MessageVO message) {
        messageService.sendMessage(message);
        messagingTemplate.convertAndSendToUser(message.getRcver(), "/queue/messages", message);

        NotificationVO notification = new NotificationVO();
        notification.setRcver(message.getRcver());
        notification.setSj("새 쪽지 도착!");
        notification.setCn("새로운 쪽지가 도착했습니다.");
        notification.setTyCode("MSG");
        notification.setCnncUrl("/message/list");

        notificationService.saveNotification(notification);
        messagingTemplate.convertAndSendToUser(message.getRcver(), "/queue/notifications", notification);
    }
}
