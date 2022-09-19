class Solution {
    public List<List<String>> findDuplicate(String[] arr) {
        int n=arr.length;
        
        List<List<String>> ans=new ArrayList<>();
        
        HashMap<String,List<String>> hm=new HashMap<>();
        
        for(String s:arr){
            int pos=s.indexOf(' ');
            String path=s.substring(0,pos);
            String[] files=s.substring(pos+1).split(" ");
            for(String file:files){
                int st=file.indexOf('(');
                int en=file.indexOf(')');
                String name=file.substring(0,st);
                String content=file.substring(st+1, en);
                
                if(hm.containsKey(content)){
                    hm.get(content).add(path+"/"+name);
                }else{
                    List<String> tmp=new ArrayList<>();
                    tmp.add(path+"/"+name);
                    hm.put(content,tmp);
                }
            }
        }
        
        for(String key:hm.keySet()){
            if(hm.get(key).size()<=1){
                continue;
            }
            ans.add(hm.get(key));
        }
        
        
        return ans;
    }
}