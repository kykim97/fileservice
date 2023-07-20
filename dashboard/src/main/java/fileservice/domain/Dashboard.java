package fileservice.domain;

import fileservice.DashboardApplication;
import fileservice.domain.DashboardUpdated;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Dashboard_table")
@Data
public class Dashboard {

    @Id
    private String fileName;

    private Integer fileSize;

    private Boolean isIndexed;

    private Boolean isUploaded;

    private String videoUrl;

    @PostPersist
    public void onPostPersist() {
        DashboardUpdated dashboardUpdated = new DashboardUpdated(this);
        dashboardUpdated.publishAfterCommit();
    }

    public static DashboardRepository repository() {
        DashboardRepository dashboardRepository = DashboardApplication.applicationContext.getBean(
            DashboardRepository.class
        );
        return dashboardRepository;
    }
}
