package com.docker.manager.controllers;

import com.docker.manager.services.DockerService;
import com.github.dockerjava.api.model.Image;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
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
