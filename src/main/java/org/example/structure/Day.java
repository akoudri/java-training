package org.example.structure;

public enum Day {

    MONDAY(1, false), TUESDAY(1, false), WEDNESDAY(2, true);

    private int priority;
    private boolean isOff;

    private Day(int priority, boolean isOff) {
        this.priority = priority;
        this.isOff = isOff;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isOff() {
        return isOff;
    }
}
