class Solution {
    public int smallestNumber(int n, int t) {
        int p =1;
        int i = n;
        while(i<100){
            if(i<10){
                if(i%t==0){
                    return i;
                }
            }
            if(i>=10){
                int temp = i;
                while(temp>0){
                    int temp1= temp%10;
                    temp = temp/10;
                    p = p*temp1;
                }
                
                if(p%t==0){
                    return i;
                }
            }
            i++;
            p=1;
        }
        return i;
    }
}