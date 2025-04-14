package kr.or.batirplan.notification.mapper;

import kr.or.batirplan.notification.vo.NotificationVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NotificationMapper {
    void saveNotification(NotificationVO notification);
    List<NotificationVO> getNotificationsByReceiver(String rcver);
    void markNotificationAsRead(int ntcnNo);
    void deleteNotification(int ntcnNo);
}
