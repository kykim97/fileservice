package fileservice.domain;

import fileservice.domain.*;
import fileservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class UserNotified extends AbstractEvent {

    public UserNotified(File aggregate) {
        super(aggregate);
    }

    public UserNotified() {
        super();
    }
}
