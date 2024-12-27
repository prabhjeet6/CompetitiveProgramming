package gfg.queues;

public class CircularQueues {
    public int circularTour(int[] gas, int[] distance) {
        for (int i = 0; i < gas.length; i++) {
            boolean found = true;
            int total = 0;
            for (int j = i; j < gas.length + i; j++) {
                total += gas[j % gas.length] - distance[j % gas.length];
                if (total < 0) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
