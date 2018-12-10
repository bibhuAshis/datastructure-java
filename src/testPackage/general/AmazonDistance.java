package testPackage.general;
import java.util.*;

/**
 * Created by bajmd on 09/12/18.
 */
public class AmazonDistance {

    class Location {
        private List<Integer> coordinate;
        private int distance;
        public Location (List<Integer> coordinate, int distance) {
            this.coordinate = coordinate;
            this.distance = distance;
        }
    }


    List<List<Integer>>  ClosestXdestinations(int numDestinations,
                                              List<List<Integer>> allLocations,
                                              int numDeliveries)
    {
        List<List<Integer>> closestPoints = new ArrayList<>();

        if (numDeliveries == numDestinations)
            return allLocations;

        PriorityQueue<Location> distanceQueue = new PriorityQueue<>();

        for (List<Integer> location:allLocations) {
            distanceQueue.offer(new Location(location, distanceFromOrigin(location)));
        }
        for (int i=0; i<numDeliveries; i++)
            closestPoints.add(distanceQueue.poll().coordinate);

        return closestPoints;
    }

    int distanceFromOrigin (List<Integer> location) {
        return location.get(0)*location.get(0) + location.get(1)*location.get(1);
    }
}
