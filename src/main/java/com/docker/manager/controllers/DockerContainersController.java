package com.docker.manager.controllers;

import com.docker.manager.services.DockerService;
import com.github.dockerjava.api.model.Container;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
@Tag(name="Containers", description="Operations related to Docker containers")
public class DockerContainersController {

    private final DockerService dockerService;

    public DockerContainersController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping
    public List<Container> listContainers(@RequestParam(required = false) boolean all, @RequestParam(required = false) String containerName) {
            return dockerService.listContainers(all, containerName);
    }

    @PostMapping("/{id}/start")
    public void startContainer(@PathVariable String id) {
        dockerService.startContainer(id);
    }

    @PostMapping("/{id}/stop")
    public void stopContainer(@PathVariable String id) {
        dockerService.stopContainer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@PathVariable String id) {
        dockerService.deleteContainer(id);
    }

    @PostMapping
    public void createContainer(@RequestParam String imameName) {
        dockerService.createContainer(imameName);
    }

}
