/* class Solution {
    public int minPair(List<Integer> v) {
        int minSum = Integer.MAX_VALUE;
        int pos = -1;
        for(int i = 0; i < v.size() - 1; i ++){
            int sum = v.get(i) + v.get(i + 1);
            if (sum < minSum) {
                minSum = sum;
                pos = i;
            }
        }
        return pos;
    }

    public void mergePair(List<Integer> v, int pos) {
        // v.set(pos, v.get(pos) + v.get(pos + 1));
        // v.remove(pos + 1);

        int rvSum = v.remove(pos) + v.remove(pos);
        v.add(pos, rvSum);
    }

    public int minimumPairRemoval(int[] nums) {
        List<Integer> v = new ArrayList<>();
        for(int x : nums) v.add(x);

        int ops = 0;
        while(!isSorted(v)){
            int pos = minPair(v);
            mergePair(v, pos);
            ops++;
        }
        return ops;
    }

    private boolean isSorted(List <Integer> v) {
        for(int i = 0; i < v.size() - 1; i ++){
            if(v.get(i) > v.get(i + 1)) return false;
        }
        return true;
    }
}  */





/* 
class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int ops = 0;
        while (!isSorted(nums, n)) {
            ops++;
            int minSum = Integer.MAX_VALUE;
            int pos = -1;
            for (int i = 1; i < n ; i++) {
                int sum = nums[i] + nums[i - 1];
                if (sum < minSum) {
                    minSum = sum;
                    pos = i;
                }
            }
            nums[pos-1] = minSum;
            for(int i = pos;i < n-1;i++) {
                nums[i] = nums[i+1];
            }
            n--;
        }
        return ops;
    }

    private boolean isSorted(int[] arr, int n) {
        for (int i = 1; i < n ; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }
} */




class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int ops = 0;
        while (!isSorted(nums, n)) {
            ops++;
            int minSum = Integer.MAX_VALUE;
            int pos = -1;
            for (int i = 0; i < n-1 ; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    pos = i;
                }
            }
            nums[pos] = minSum;
            for(int i = pos+1;i < n-1;i++) {
                nums[i] = nums[i+1];
            }
            n--;
        }
        return ops;
    }

    private boolean isSorted(int[] arr, int n) {
        for (int i = 1; i < n ; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }
}