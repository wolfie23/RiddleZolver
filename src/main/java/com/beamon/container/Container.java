package com.beamon.container;

import static com.beamon.container.ContainerType.BATHTUB;

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
        return new Container(Integer.MAX_VALUE, 0, BATHTUB);
    }

    public int getCapacity() {
        if (BATHTUB.equals(this.getType())) {
            return Integer.MAX_VALUE;
        }
        return capacity;
    }

    public int getLevel() {
        if (BATHTUB.equals(this.getType())) {
            return Integer.MAX_VALUE;
        }
        return level;
    }

    public void setLevel(int level) {
        if (BATHTUB.equals(this.type)) {
            this.level = Integer.MAX_VALUE;
        } else {
            level = level < 0 ? 0 : level;
            this.level = level > capacity ? capacity : level;
        }
    }

    public ContainerType getType() {
        return type;
    }

    public void setType(ContainerType type) {
        this.type = type;
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
