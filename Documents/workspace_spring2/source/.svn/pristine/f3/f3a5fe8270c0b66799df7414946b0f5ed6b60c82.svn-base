package kr.or.batirplan.notification.service;

import kr.or.batirplan.notification.mapper.NotificationMapper;
import kr.or.batirplan.notification.vo.NotificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public void saveNotification(NotificationVO notification) {
        notificationMapper.saveNotification(notification);
    }

    @Override
    public List<NotificationVO> getNotificationsByReceiver(String rcver) {
        return notificationMapper.getNotificationsByReceiver(rcver);
    }

    @Override
    public void markNotificationAsRead(int ntcnNo) {
        notificationMapper.markNotificationAsRead(ntcnNo);
    }

    @Override
    public void deleteNotification(int ntcnNo) {
        notificationMapper.deleteNotification(ntcnNo);
    }
}
