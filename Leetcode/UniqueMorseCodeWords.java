class Solution {
    public int uniqueMorseRepresentations(String[] words) {
       
        String CODES[] = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> unique_transformations = new HashSet();
        
        for(String word: words){
            StringBuilder transformation = new StringBuilder();
            
            for(char c: word.toCharArray()){
                transformation.append(CODES[c-'a']);
            }
            
            unique_transformations.add(transformation.toString());
        }
        
        return unique_transformations.size();
    }
}