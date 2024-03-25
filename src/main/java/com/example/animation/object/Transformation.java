package com.example.animation.object;

public class Transformation {
    private double rotationAngle; // in degrees
    private double scaleFactor;
    private double positionX;
    private double positionY;

    // Constructors
    public Transformation() {
        this(0.0, 1.0, 0.0, 0.0); // Default values
    }

    public Transformation(double rotationAngle, double scaleFactor, double positionX, double positionY) {
        this.rotationAngle = rotationAngle;
        this.scaleFactor = scaleFactor;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    // Getters and setters
    public double getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    public double getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(double scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "Transformation{" +
                "rotationAngle=" + rotationAngle +
                ", scaleFactor=" + scaleFactor +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }
}

