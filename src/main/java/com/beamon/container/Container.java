package com.beamon.container;

import static com.beamon.container.ContainerType.BATHTUB;
import static com.beamon.container.ContainerType.BOTTLE;

public class Container {
    private int capacity;
    private int level;
    private ContainerType type;

    public Container(int capacity, int level, ContainerType type) {
        this.capacity = capacity;
        this.level = level;
        this.type = type;
    }

    public static Container Bathtub() {
        return new Container(Integer.MAX_VALUE, Integer.MAX_VALUE, BATHTUB);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (BOTTLE.equals(this.type)) {
            level = level < 0 ? 0 : level;
            this.level = level > capacity ? capacity : level;
        }
    }

    public void empty() {
        setLevel(0);
    }

    public void fillWithFluidFromContainer(Container otherContainer) {
        final int maxTransferrableLevel = this.getCapacity() - this.getLevel();
        final int transferredLevel = maxTransferrableLevel > otherContainer.getLevel() ? otherContainer.getLevel() : maxTransferrableLevel;
        final int leftInOther = otherContainer.getLevel() - transferredLevel;
        otherContainer.setLevel(leftInOther);
        this.setLevel(this.getLevel() + transferredLevel);
    }

    @Override
    public String toString() {
        return "{" +
                "\"capacity\":\"" + capacity + "\"" + ", " +
                "\"level\":\"" + level + "\"" + ", " +
                "\"type\":" + (type == null ? "null" : type) +
                "}";
    }
}
