package com.docker.manager.controllers;

import com.docker.manager.services.DockerService;
import com.github.dockerjava.api.model.Image;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@Tag(name="Images", description="Operations related to Docker images")
public class DockerImagesController {

    private final DockerService dockerService;

    public DockerImagesController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping
    public List<Image> listImages(@RequestParam(required = false) String imageName) {
        return dockerService.listImages(imageName);
    }


}
