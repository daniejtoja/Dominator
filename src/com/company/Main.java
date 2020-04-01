// you can also use imports, for example:
// import java.util.*;
import java.util.Map;
import java.util.HashMap;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {

        if(A.length == 0){
            return -1;
        }

        if(A.length == 1){
            return 0;
        }

        if(A.length == 2 && A[0] != A[1]){
            return -1;
        } else if (A.length == 2 && A[0] == A[1]) {
            return 0;
        }

        Map<Integer, Integer> whoIsDominating = new HashMap<Integer, Integer>();
        int maxOccurence = 0;

        for(int i = 0,howManyTimesOccured = 0; i<A.length; ++i){



            if(whoIsDominating.get(A[i]) == null){
                howManyTimesOccured = 1;
                whoIsDominating.put(new Integer(A[i]), new Integer(howManyTimesOccured));
                continue;

            } else {
                howManyTimesOccured = whoIsDominating.get(A[i]) + 1;
                whoIsDominating.put(A[i], howManyTimesOccured);

                if(maxOccurence < howManyTimesOccured){
                    maxOccurence = howManyTimesOccured;
                }

                if(howManyTimesOccured > A.length/2){
                    return i;
                }
            }
            if ((A.length)-(i+1) + maxOccurence < A.length/2){     
                return -1;
            }


        }

        return -1;

    }
}