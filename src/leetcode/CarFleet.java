package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Car {
    int position;
    int speed;

}

class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o2.position - o1.position;
    }
}

//https://leetcode.com/problems/car-fleet/description/
public class CarFleet {


    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t > 0) {
            t--;
            String[] input = bf.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int target = Integer.parseInt(input[1]);
            int[] position = Arrays.stream(bf.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] speed = Arrays.stream(bf.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Car> ls = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Car car = new Car();
                car.position = position[i];
                car.speed = speed[i];
                ls.add(car);
            }
            //cars sorted in descending order of position
            Collections.sort(ls, new CarComparator());

            //if time taken for a car to reach from their  position to target is more than the previous, we
            // increase the fleet count, if there exists a car that comes behind it and takes lesser
            // time to reach target, it joins the fleet, otherwise creates a fleet of its own

            //Example, target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
            //when sorted target = 12, position = [10,8,5,3,0], speed = [2,4,1,3,1]
            // first and second car take 1 second each and there is one fleet
            //third car takes 7  secs and creates its own fleet,
            //fourth car takes 3 secs and joins the previous fleet as otherwise, it would have reached
            // faster

            int fleets = getFleets(ls, target);
            System.out.println(fleets);


        }
    }

    private static int getFleets(List<Car> ls, int target) {
        double fastestTme = 0d;
        int fleets = 0;
        for (Car car : ls) {
            double timeTaken = ((double) (target - car.position)) / car.speed;
            if (timeTaken > fastestTme) {
                fleets++;
                fastestTme = timeTaken;
            }
        }
        return fleets;
    }
}



