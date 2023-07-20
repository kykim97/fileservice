package fileservice.domain;

import fileservice.domain.*;
import fileservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoProcessed extends AbstractEvent {

    public VideoProcessed(Video aggregate) {
        super(aggregate);
    }

    public VideoProcessed() {
        super();
    }
}
