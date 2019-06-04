package com.beamon.service;

import com.beamon.container.Container;
import com.beamon.container.ContainerType;
import com.beamon.dto.SolutionResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RiddleService {

    public SolutionResponse getOneLitreSolution() {
        SolutionResponse solutionResponse = new SolutionResponse();

        Container bathtub = Container.Bathtub();
        Container fiveLitreBottle = new Container(5, 0, ContainerType.BOTTLE);
        Container threeLitreBottle = new Container(3, 0, ContainerType.BOTTLE);

        threeLitreBottle.fillWithFluidFromContainer(bathtub);
        solutionResponse.getSteps().add("threeLitreBottle.fillWithFluidFromContainer(bathtub)");

        fiveLitreBottle.fillWithFluidFromContainer(threeLitreBottle);
        solutionResponse.getSteps().add("fiveLitreBottle.fillWithFluidFromContainer(threeLitreBottle)");

        threeLitreBottle.fillWithFluidFromContainer(bathtub);
        solutionResponse.getSteps().add("threeLitreBottle.fillWithFluidFromContainer(bathtub)");

        fiveLitreBottle.fillWithFluidFromContainer(threeLitreBottle);
        solutionResponse.getSteps().add("fiveLitreBottle.fillWithFluidFromContainer(threeLitreBottle)");

        solutionResponse.getContainers().addAll(Arrays.asList(fiveLitreBottle, threeLitreBottle, bathtub));

        return solutionResponse;
    }

    public SolutionResponse getFourLitreSolution() {
        SolutionResponse solutionResponse = new SolutionResponse();

        Container bathtub = Container.Bathtub();
        Container fiveLitreBottle = new Container(5, 0, ContainerType.BOTTLE);
        Container threeLitreBottle = new Container(3, 0, ContainerType.BOTTLE);

        fiveLitreBottle.fillWithFluidFromContainer(bathtub);
        solutionResponse.getSteps().add("fiveLitreBottle.fillWithFluidFromContainer(bathtub)");

        threeLitreBottle.fillWithFluidFromContainer(fiveLitreBottle);
        solutionResponse.getSteps().add("threeLitreBottle.fillWithFluidFromContainer(fiveLitreBottle)");

        threeLitreBottle.empty();
        solutionResponse.getSteps().add("threeLitreBottle.empty()");

        threeLitreBottle.fillWithFluidFromContainer(fiveLitreBottle);
        solutionResponse.getSteps().add("threeLitreBottle.fillWithFluidFromContainer(fiveLitreBottle)");

        fiveLitreBottle.fillWithFluidFromContainer(bathtub);
        solutionResponse.getSteps().add("fiveLitreBottle.fillWithFluidFromContainer(bathtub)");

        threeLitreBottle.fillWithFluidFromContainer(fiveLitreBottle);
        solutionResponse.getSteps().add("threeLitreBottle.fillWithFluidFromContainer(fiveLitreBottle)");

        solutionResponse.getContainers().addAll(Arrays.asList(fiveLitreBottle, threeLitreBottle, bathtub));

        return solutionResponse;
    }
}
