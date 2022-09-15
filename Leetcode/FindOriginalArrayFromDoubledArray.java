class Solution {
     
    public int[] findOriginalArray(int[] changed) {
        
        int n=changed.length;
        if((n%2)==1)
            return new int[0];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: changed)
            map.put(i, (map.getOrDefault(i, 0)+1));
        
        int[] res = new int[(n/2)];
        if((map.size()==1)&&(changed[0]==0)){
            for(int i=0; i<res.length; i++)
                res[i] = changed[i];
            return res;
        }
        
        Set<Integer> set = map.keySet();
        Iterator<Integer> value  = set.iterator();
        
        int arr[] = new int[(set.size())];
        int count=0;
        
        while(value.hasNext())
            arr[count++]=value.next();
        
        count = 0;
        Arrays.sort(arr);
        
        for(int i: arr){
            if(map.get(i)>0){
                if(i==(i*2)){

                    int x = map.get(i);
                    if((x%2)==0){
                        map.put(i, 0);
                        for(int j=1; j<=(x/2); j++)
                            res[count++] = i;
                    }
                    else
                        return new int[0];
                }
                else{
                    int x = i*2;
                    if((map.containsKey(x))&&(map.get(x)>=map.get(i))){
                        int y = map.get(i);
                        map.put(x, (map.get(x)-map.get(i)));
                        map.put(i, 0);
                        for(int j=1; j<=y; j++)
                            res[count++] = i;
                    }
                    else
                        return new int[0];
                }
            }
        }
        
        return res;
    }
}