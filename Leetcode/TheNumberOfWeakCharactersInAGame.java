class Solution {
    
    public int[] calc(List<Integer> list, int max, int i){
        int arr[] = new int[] {0, 0};
        int max1 = max;
        int count = 0;
        
        if(i==0){
            while(!list.isEmpty()){
                int x = list.remove(0);
                if(x>max)
                    max = x;
            }
            max1 = max;
        }
        else{
            while(!list.isEmpty()){
                int x = list.remove(0);
                if(x < max)
                    count++;
                else if(x > max){
                    if(x > max1)
                        max1 = x;
                }
            }
        }
        
        arr[0] = count;
        arr[1] = max1;
        
        return arr;
        
    }
    public int numberOfWeakCharacters(int[][] properties) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int arr[] = new int[100001];
        
        int size = properties.length;
        
        for(int i=0; i<size; i++){
            
            if(map.containsKey(properties[i][0]))
                map.get(properties[i][0]).add(properties[i][1]);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(properties[i][1]);
                map.put(properties[i][0], list);
            }
            
            arr[properties[i][0]] = 1;
        }
        
        int rev[] = new int[map.size()];
        int tmp = 0;
        
        for(int i=100000; i>=0; i--)
            if(arr[i]==1)
                rev[tmp++]=i;
        
        int arr1[];
        int max = 0, count = 0;
        
        for(int i=0; i<tmp; i++){
            arr1 = calc(map.get(rev[i]), max, i);
            max = arr1[1];
            count+=arr1[0];
        }
        
        return count;
    }
}