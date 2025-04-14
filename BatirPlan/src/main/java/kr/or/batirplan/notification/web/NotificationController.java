package kr.or.batirplan.notification.web;

import kr.or.batirplan.notification.service.NotificationService;
import kr.or.batirplan.notification.vo.NotificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{rcver}")
    public List<NotificationVO> getNotifications(@PathVariable String rcver) {
        return notificationService.getNotificationsByReceiver(rcver);
    }

    @PutMapping("/read/{ntcnNo}")
    public void markAsRead(@PathVariable int ntcnNo) {
        notificationService.markNotificationAsRead(ntcnNo);
    }

    @DeleteMapping("/delete/{ntcnNo}")
    public void deleteNotification(@PathVariable int ntcnNo) {
        notificationService.deleteNotification(ntcnNo);
    }
}
