package fileservice.domain;

import fileservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "dashboards",
    path = "dashboards"
)
public interface DashboardRepository
    extends PagingAndSortingRepository<Dashboard, String> {}
