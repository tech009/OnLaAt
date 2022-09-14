class Solution {
    public boolean validUtf8(int[] data) {
        int byteLeft = 0;
        for(int i: data){
            if(byteLeft==0){
                if((i>191)&&(i<=223))
                    byteLeft = 1;
                else if((i>223)&&(i<=239))
                    byteLeft = 2;
                else if((i>239)&&(i<=247))
                    byteLeft = 3;
                else if(i>247)
                    return false;
                else if((i>127)&&(i<=191))
                    return false;
            }
            else{
                if((i>127)&&(i<=191))
                    byteLeft--;
                else
                    return false;
            }
        }
        if(byteLeft>0)
            return false;
        return true;
    }
}