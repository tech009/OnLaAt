class Solution {
    public int minSetSize(int[] arr) {
        
        HashMap<Integer, Integer> elem = new HashMap<>();
        for(int val: arr){
            elem.put(val, elem.getOrDefault(val, 0)+1);
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        
        
        for(int val: elem.values())
            queue.offer(val);
        
        
        int len = arr.length;
        
        int sum = len;
        int count = 0;
        
        while(sum > (len/2)){
            
            sum-=queue.poll();
            count++;
        }
        
        return count;
    }
}