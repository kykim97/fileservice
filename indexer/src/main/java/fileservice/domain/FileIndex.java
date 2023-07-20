package fileservice.domain;

import fileservice.IndexerApplication;
import fileservice.domain.FileIndexed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FileIndex_table")
@Data
public class FileIndex {

    @Id
    private String fileName;

    @PostPersist
    public void onPostPersist() {
        FileIndexed fileIndexed = new FileIndexed(this);
        fileIndexed.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static FileIndexRepository repository() {
        FileIndexRepository fileIndexRepository = IndexerApplication.applicationContext.getBean(
            FileIndexRepository.class
        );
        return fileIndexRepository;
    }
}
