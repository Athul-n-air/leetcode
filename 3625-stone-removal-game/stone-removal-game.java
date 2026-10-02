class Solution {
    public boolean canAliceWin(int n) {
        int remove  = 10;
        while(n>=remove){
            n = n - remove ;
            remove--;
        }
        if(remove%2==0){
            return false;
        }else{
            return true;
        }
    }
}