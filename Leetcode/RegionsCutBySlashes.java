class Solution {

    int[] arr; 
    public int convert(int i, int j, int n){
        return ((i*(n+1))+j);
    }

    public int uf(int ptr){
        return arr[ptr] == ptr ? ptr : uf(arr[ptr]);
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        arr = new int[((n+1)*(n+1))];
        for(int i=0; i<arr.length; i++)
            arr[i] = i;
        
        for(int i=0; i<=n; i++){
            arr[convert(0, i, n)] = 0;
            arr[convert(n, i, n)] = 0;
            arr[convert(i, 0, n)] = 0;
            arr[convert(i, n, n)] = 0;
        }

        int ans = 1;
        int i = 0;
        int j = 0;
        boolean flag = false;

        for(String s: grid){

            j = 0;
            for(char c: s.toCharArray()){
                if(c=='/'){
                    int a = convert(i, j+1, n);
                    int b = convert(i+1, j, n);
                    int ptr1 = uf(a);
                    int ptr2 = uf(b);

                    if(ptr1==ptr2)
                        ans++;
                    else
                        arr[ptr2] = ptr1;
                }
                else if(c=='\\'){
                    int a = convert(i, j, n);
                    int b = convert(i+1,  j+1, n);
                    int ptr1 = uf(a);
                    int ptr2 = uf(b);

                    if(ptr1==ptr2)
                        ans++;
                    else
                        arr[ptr2] = ptr1;
                }
                j++;
            }
            i++;
        }
        return ans;
    }
}
