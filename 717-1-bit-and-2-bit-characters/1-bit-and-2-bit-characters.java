class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
        int n=bits.length;
        while(i<n-1){
            if(bits[i]==0){
                i=i+1;
            }else{
                 i=i+2;
            }

        }
       return i==n-1;
        }
        
    }
