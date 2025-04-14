package kr.or.batirplan.notification.service;

import kr.or.batirplan.notification.vo.NotificationVO;
import java.util.List;

public interface NotificationService {
    void saveNotification(NotificationVO notification);
    List<NotificationVO> getNotificationsByReceiver(String rcver);
    void markNotificationAsRead(int ntcnNo);
    void deleteNotification(int ntcnNo);
}
