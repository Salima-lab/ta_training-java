package Planes;

import Enums.ClassificationLevel;
import Enums.ExperimentalTypes;

public class ExperimentalPlane extends Plane{

    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String modelOfPlane, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes experimentalType, ClassificationLevel classificationLevel) {
        super(modelOfPlane, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + modelOfPlane + '\'' +
                '}';
    }
}
