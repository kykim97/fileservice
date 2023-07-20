package fileservice.domain;

import fileservice.DriveApplication;
import fileservice.domain.FileIndexed;
import fileservice.domain.FileUploaded;
import fileservice.domain.UserNotified;
import fileservice.domain.VideoProcessingStarted;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "File_table")
@Data
public class File {

    @Id
    private String fileName;

    private Integer fileSize;

    private Boolean isIndexed;

    private Boolean isUploaded;

    private String videoUrl;

    @PostPersist
    public void onPostPersist() {
        FileUploaded fileUploaded = new FileUploaded(this);
        fileUploaded.publishAfterCommit();

        FileIndexed fileIndexed = new FileIndexed(this);
        fileIndexed.publishAfterCommit();

        VideoProcessingStarted videoProcessingStarted = new VideoProcessingStarted(
            this
        );
        videoProcessingStarted.publishAfterCommit();

        UserNotified userNotified = new UserNotified(this);
        userNotified.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static FileRepository repository() {
        FileRepository fileRepository = DriveApplication.applicationContext.getBean(
            FileRepository.class
        );
        return fileRepository;
    }
}
