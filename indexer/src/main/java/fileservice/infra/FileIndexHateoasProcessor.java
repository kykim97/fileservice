package fileservice.infra;

import fileservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class FileIndexHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<FileIndex>> {

    @Override
    public EntityModel<FileIndex> process(EntityModel<FileIndex> model) {
        return model;
    }
}
