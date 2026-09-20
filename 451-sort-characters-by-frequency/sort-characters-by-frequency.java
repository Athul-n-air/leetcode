class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i<s.length();i++){
            char c = s.charAt(i);
           map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb  = new StringBuilder();
        while(!map.isEmpty()){
            int maxfreq =0;
            char maxchar = ' ';
            for(char c : map.keySet()){
                if(map.get(c)>maxfreq){
                    maxchar =c;
                    maxfreq = map.get(c);
                }
            }
            for(int i =0;i<maxfreq;i++){
                sb.append(maxchar);
            }
            map.remove(maxchar);
        }
        return sb.toString();
    }
}