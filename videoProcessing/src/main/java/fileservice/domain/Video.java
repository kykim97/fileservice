package fileservice.domain;

import fileservice.VideoProcessingApplication;
import fileservice.domain.VideoProcessed;
import fileservice.domain.VideoProcessingStarted;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Video_table")
@Data
public class Video {

    @Id
    private String fileName;

    private String videoUrl;

    @PostPersist
    public void onPostPersist() {
        VideoProcessingStarted videoProcessingStarted = new VideoProcessingStarted(
            this
        );
        videoProcessingStarted.publishAfterCommit();

        VideoProcessed videoProcessed = new VideoProcessed(this);
        videoProcessed.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static VideoRepository repository() {
        VideoRepository videoRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoRepository.class
        );
        return videoRepository;
    }
}
