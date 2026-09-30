class Dataset{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    Dataset(int n ){
        for(int i  = 0 ; i<n ;i++){
            parent.add(i);
            size.add(0);
        }
    }
    public int find(int u){
        if(u==parent.get(u)){
            return u;
        }
        int ulp_u = find(parent.get(u));
        parent.set(u,ulp_u);
        return parent.get(u);
    }
    public void union(int u , int v){
        int ulp_u = find(u);
        int ulp_v = find(v);
        if(ulp_u==ulp_v){
            return ;
        }
        if(size.get(ulp_u)<=size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map = new HashMap<>();
        int n  = accounts.size();
        Dataset ds = new Dataset(n);
        for(int i  = 0;i<n;i++){
            for(int j = 1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(map.containsKey(email)){
                    int oldaccount = map.get(email);
                    ds.union(i,oldaccount);
                }else{
                    map.put(email,i);
                }
            }
        }
        HashMap<Integer,ArrayList<String>> groups = new HashMap<>();
        for(String email : map.keySet()){
            int account = ds.find(map.get(email));
            groups.putIfAbsent(account, new ArrayList<>());
            groups.get(account).add(email);
        }
        List<List<String>> ans = new ArrayList<>();

        for (int account : groups.keySet()) {

            ArrayList<String> emails = groups.get(account);

            Collections.sort(emails);

            ArrayList<String> temp = new ArrayList<>();

            temp.add(accounts.get(account).get(0));

            temp.addAll(emails);

            ans.add(temp);
        }

        return ans;
    }
}