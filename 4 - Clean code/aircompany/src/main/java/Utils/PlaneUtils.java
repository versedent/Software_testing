package Utils;

import Planes.ExperimentalPlane;
import Planes.Plane;
import models.ClassificationLevel;

import java.util.List;

public class PlaneUtils {

    public static boolean isSortedByMaxLoadCapacity(List<? extends Plane> planes) {
        boolean isSortedByMaxLoadCapacity = true;

        for (int i = 0; i < planes.size() - 1; i++) {
            Plane currentPlane = planes.get(i);
            Plane nextPlane = planes.get(i + 1);

            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                isSortedByMaxLoadCapacity = false;
                break;
            }
        }

        return isSortedByMaxLoadCapacity;
    }

    public static  boolean isExperimentalPlanesContainsUnclassified(List<? extends ExperimentalPlane> experimentalPlanes) {
        boolean hasUnclassifiedPlanes = false;

        for(ExperimentalPlane experimentalPlane : experimentalPlanes){
            if(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }

        return hasUnclassifiedPlanes;
    }
}
