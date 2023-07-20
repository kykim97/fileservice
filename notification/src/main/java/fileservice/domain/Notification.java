package fileservice.domain;

import fileservice.NotificationApplication;
import fileservice.domain.UserNotified;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Notification_table")
@Data
public class Notification {

    @Id
    private String fileName;

    private String notificationType;

    @PostPersist
    public void onPostPersist() {
        UserNotified userNotified = new UserNotified(this);
        userNotified.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = NotificationApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }
}
