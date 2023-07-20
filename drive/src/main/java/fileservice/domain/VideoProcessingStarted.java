package fileservice.domain;

import fileservice.domain.*;
import fileservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoProcessingStarted extends AbstractEvent {

    public VideoProcessingStarted(File aggregate) {
        super(aggregate);
    }

    public VideoProcessingStarted() {
        super();
    }
}
