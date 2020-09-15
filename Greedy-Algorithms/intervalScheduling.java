import java.util.*;

public class IntervelScheduling {
    public static void main(String args[]){
        int[][] intervels = {
                {0,3},
                {0,15},
                {5,10},
                {7,12},
                {11,16},
                {12,14},
                {16,20}
        };
        List<int[]> optimalSchedule = schedule(intervels);
        for(int[] array: optimalSchedule){
            for(int i=0; i<array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    private static List<int[]> schedule(int[][] intervels) {
        List<int[]> OptionalIntervalSet = new ArrayList<>();
        Arrays.sort(intervels, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int lastFinishTime = Integer.MIN_VALUE;
        for(int[] intervel: intervels){
            int start = intervel[0];
            if(start > lastFinishTime){
                int end = intervel[1];

                OptionalIntervalSet.add(intervel);
                lastFinishTime = end;
            }
        }
        return OptionalIntervalSet;
    }
}
