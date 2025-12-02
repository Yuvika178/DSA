class Solution {
    public boolean isPerfectSquare(int num) {
     if(num<0){
        return false;
     }
     long l=1,r=num;
     while(l<=r){
        long mid=l+(r-l)/2;
        long sq=mid*mid;
        if(sq==num)return true;
        else if(sq<num) l= mid+1;
        else r=mid-1;

        
     }
     return num==0;
    }
}