class Solution {
    class ListComparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> l1, List<Integer> l2)
        {
            if(l1.get(0)<l2.get(0))
                return 1;
            else if(l1.get(0)>l2.get(0))
                return -1;
            else{
                if(l1.get(1)<l2.get(1))
                    return 1;
                else if(l1.get(1)>l2.get(1))
                    return -1;
                else
                    return 0;
            }
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        if(k==1){
            if(n==1)
                return (speed[0]*efficiency[0]);
            else{
                int max = 0;
                for(int i=0; i<n; i++)
                    if(max<(speed[i]*efficiency[i]))
                        max = speed[i]*efficiency[i];
                return max;
            }
        }
        else{
            
            PriorityQueue<List<Integer>> queue = new PriorityQueue<List<Integer>>(n, new ListComparator());
            for(int i=0; i<n; i++)
                queue.add(new ArrayList<Integer>(Arrays.asList(efficiency[i], speed[i])));
            
            int sum = 0, ans = Integer.MIN_VALUE, eff = 0;
            
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
            while(!queue.isEmpty()){
                
                List<Integer> list = queue.poll();
                heap.add(list.get(1));
                
                eff = list.get(0);
                sum+=list.get(1);
                
                if((heap.size())>k)
                    sum-=heap.poll();
                
                if((sum*eff)>ans)
                    ans = sum*eff;
                
                ans%=1000000007;
            }
            
            return ans;
        }
    }
}