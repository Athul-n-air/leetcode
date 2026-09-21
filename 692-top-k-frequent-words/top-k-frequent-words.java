class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map =  new HashMap<>();
        for(String s: words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        ArrayList<String> result  = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(map.get(a).equals(map.get(b))){
                return b.compareTo(a);
            }
            return map.get(a)-map.get(b);  
        });

        for(String s: map.keySet()){
            pq.offer(s);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            result.addFirst(pq.poll());
        }
        return result;
    }
}