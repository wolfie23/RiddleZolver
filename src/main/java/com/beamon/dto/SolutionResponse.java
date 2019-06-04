package com.beamon.dto;

import com.beamon.container.Container;

import java.util.ArrayList;
import java.util.List;

public class SolutionResponse {
    private List<String> steps = new ArrayList<>();
    private List<Container> containers = new ArrayList<>();

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }
}
