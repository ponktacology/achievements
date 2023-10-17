package me.ponktacology.achievement;

public class Progress {

    private final double target;
    public double value;

    public Progress(double target) {
        this.target = target;
    }

    public void increment(double value) {
        this.value = Math.min(target, this.value + value);
    }

    public boolean completed() {
        return value >= target;
    }

    public double completion() {
        return Math.min(value / target, 1.0);
    }

}
