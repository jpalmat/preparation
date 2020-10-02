import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class DisckSpace {
    static ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    static List<Integer> numbs;

    public static void clean_deque(int i, int k) {

        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            int x=deq.getFirst();
            int xx=i - k;
            deq.removeFirst();
        }

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && numbs.get(i) < numbs.get(deq.getLast())) {
            int w=numbs.get(i);
            int ww=numbs.get(deq.getLast());
            deq.removeLast();
        }
    }

    public static int segment(int k, List<Integer> space) {
        numbs = space;
        int min_idx = 0;
        //put the first window to deq and find the min_index
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);// add index to deq
            if (space.get(i) < space.get(min_idx)) min_idx = i;
        }
        int result = space.get(min_idx);

        for (int i = k; i < space.size(); i++) {
            clean_deque(i, k);
            deq.addLast(i);
            result = Math.max(result, space.get(deq.getFirst()));
        }
        return result;
    }

    public static int MaxOfMin(int x,List<Integer> s){
        if(x>s.size()) return 0;
        //we want to get the maximum of min of every windows
        int max = 0;
        for(int i=0;i<= s.size()-x;++i){
            int min=s.get(i);
            //stream?
            final int index = i;
            Function<Integer, Integer> functTest = x1 -> {
                return Math.min(x1,s.get(index));
            };

//            s.stream().skip(i+1).limit(i+x).reduce(x1-> functTest.apply(x1));
            for(int j=i+1;j<i+x;++j){
                min= Math.min(min,s.get(i));
            }
            max=Math.max(max,min);
        }



        return max;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(new Integer[]{8, 2, 4});
        int k = 2;
        System.out.println(segment(k, nums));
    }
}
