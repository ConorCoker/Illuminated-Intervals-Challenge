/*
There are some lamps placed on a coordinate line. Each of these lamps illuminates 
some space around it within a given radius. You are given the coordinates of the lamps 
on the line, and the effective radius of each of the lamps' light.

In other words, you are given a two-dimensional array `lamps`, where `lamps[i]` 
contains information about the ith lamp.

- `lamps[i][0]` is an integer representing the lamp's coordinate;
- `lamps[i][1]` is a positive integer representing the lamp's effective radius.

This means that the ith lamp illuminates everything in a range from 
`lamps[i][0] - lamps[i][1]` to `lamps[i][0] + lamps[i][1]` inclusive.

Your task is to find the number of integer coordinates that are illuminated 
by exactly 1 lamp.

Example:
----------
For `lamps = [[-2, 3], [2, 3], [2, 1]]`, the output should be `solution(lamps) = 6`.

- The first lamp illuminates everything in range `[-5, 1]`.
- The second lamp illuminates everything in range `[-1, 5]`.
- The third lamp illuminates everything in range `[1, 3]`.

The points that are illuminated by exactly 1 lamp are `[-5, -4, -3, -2, 4, 5]`, 
hence the answer is 6.

For `lamps = [[-2, 1], [2, 1]]`, the output should be `solution(lamps) = 6`.

- The given lamps illuminate ranges `[-3, -1]` and `[1, 3]` respectively. 
  Every point in these ranges is illuminated by exactly 1 lamp, so the answer is 6.

Input/Output:
-------------
- [input] array.array.integer `lamps`
   - A two-dimensional array containing information about the lamps. 
     Each lamp is described by a two-element array containing the coordinate 
     and the effective radius of the lamp.
   - Guaranteed constraints:
       1 ≤ `lamps.length` ≤ 10^5,
       `lamps[i].length` = 2,
       -10^9 ≤ `lamps[i][0]` ≤ 10^9,
       1 ≤ `lamps[i][1]` ≤ 10^5.

- [output] integer
   - The number of integer coordinates that are illuminated by exactly one lamp.
*/

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] lamps = {
            {-2, 3},
            {2, 3},
            {2, 1}
        };
        System.out.println(solution(lamps));
    }
    // coord rad
    public static int solution(int[][] lamps) {
        HashMap<Integer,Integer>illumintatedPoints = new HashMap<>();
        for (int[] lamp : lamps) {
            int coord = lamp[0];
            int radius = lamp[1];
            for (int point : returnPointsInRange(coord, radius)) {
                illumintatedPoints.put(point, illumintatedPoints.getOrDefault(point, 0) + 1);
            }
        }
        int counter = 0;
        for (int point : illumintatedPoints.keySet()) {
            if (illumintatedPoints.get(point) == 1) {
                counter++;
            }
        }
        return counter;
    }

    public static ArrayList<Integer> returnPointsInRange(int start, int range) {
        ArrayList<Integer>points = new ArrayList<>();
        // negative direction
        for (int i = start - range; i < start; i++) {
            points.add(i);
        }
        // positive direction
        for(int i = start; i <= start + range; i++) {
            points.add(i);
        }
        return points;
    }
}
