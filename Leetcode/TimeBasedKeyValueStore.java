class TimeMap {
    
    HashMap<String, TreeMap<Integer, String>> ds;

    public TimeMap() {
        ds = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tm = ds.getOrDefault(key, new TreeMap());
        tm.put(timestamp, value);
        ds.put(key, tm);
    }
    
    public String get(String key, int timestamp) {
        HashMap  temp = ds;
        if(ds.get(key) != null){
            if(ds.get(key).floorEntry(timestamp) != null) {
                return ds.get(key).floorEntry(timestamp).getValue();
            } else {
                return "";
            }
        }
        return "";
    }
}
