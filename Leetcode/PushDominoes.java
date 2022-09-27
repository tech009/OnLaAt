class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder result = new StringBuilder();
        int begin=0; //sliding window begin
        int end=0;   //sliding window end
        boolean fallingRight = false; //found an R?
        for(int i=0; i<dominoes.length(); i++){
            if(dominoes.charAt(i)=='.'){
                end++; //just increase the window
            }else if(dominoes.charAt(i)=='L'){ 
                if(!fallingRight){ 
                    //if it is not falling right, everything falls left
                    for(int j=begin; j<=i; j++){
                        result.append('L');
                    }                    
                }else{
                    //if it is falling right, half falls left, half falls right
                    int count = (end-begin+1)/2;
                    for(int j=0; j<count; j++){
                        result.append('R');
                    }      
                    if((end-begin)%2==0){
                        result.append('.');
                    }
                    for(int j=0; j<count; j++){
                        result.append('L');
                    }  
                }
                //new window, starts next char
                end=begin=i+1;
                fallingRight = false;
            }else{
                //R found
                for(int j=begin; j<i; j++){
                    //append any before according if it is falling or not
                    result.append(fallingRight?'R':'.');
                }  
                //new window, starts on this R
                begin = i;
                fallingRight=true;
                end++;
            } 
        }
        
        //add the rest of the dominoes
        for(int j=begin; j<dominoes.length(); j++){
            result.append(fallingRight?'R':'.');
        }            
            
        return result.toString();
    }
}