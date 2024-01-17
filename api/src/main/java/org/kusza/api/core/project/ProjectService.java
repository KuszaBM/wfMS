package org.kusza.api.core.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProjectService {

    @GetMapping(
            value = "/project/{projectId}",
            produces = "application/json"
    )
    Project getProject(@PathVariable int projectId);
}
