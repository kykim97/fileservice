package fileservice.domain;

import fileservice.domain.*;
import fileservice.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DashboardUpdated extends AbstractEvent {

    public DashboardUpdated(Dashboard aggregate) {
        super(aggregate);
    }

    public DashboardUpdated() {
        super();
    }
}
