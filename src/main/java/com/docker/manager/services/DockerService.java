package com.docker.manager.services;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class DockerService {
    private final DockerClient dockerClient;

    public DockerService(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public List<Container> listContainers(boolean all, String containerName) {
        if (Objects.equals(null, containerName) || containerName.isEmpty()) {
            return dockerClient.listContainersCmd().withShowAll(all).withNameFilter(Collections.singletonList(containerName)).exec();
        }
        return dockerClient.listContainersCmd().withShowAll(all).exec();
    }

    public List<Image> listImages(String imageName) {
        if (Objects.equals(null, imageName) || imageName.isEmpty()) {
            return dockerClient.listImagesCmd().exec();
        }
        return dockerClient.listImagesCmd().withImageNameFilter(imageName).exec();
    }

    public void startContainer(String containerId) {
        dockerClient.startContainerCmd(containerId).exec();
    }

    public void stopContainer(String containerId) {
        dockerClient.stopContainerCmd(containerId).exec();
    }

    public void deleteContainer(String containerId) {
        dockerClient.removeContainerCmd(containerId).exec();
    }

    public void createContainer(String imageName) {
        dockerClient.createContainerCmd(imageName).exec();
    }
}
