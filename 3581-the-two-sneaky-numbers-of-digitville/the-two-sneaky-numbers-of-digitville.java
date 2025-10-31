class Solution {
    public int[] getSneakyNumbers(int[] nums) {
     HashSet<Integer> seen =new HashSet<>();
     HashSet<Integer> result =new HashSet<>();
     for( int num:nums){
        if(seen.contains(num)){
            result.add(num);
        }else{
            seen.add(num);
        }
     }
     int res[]= new int[result.size()];
     int i=0;
     for(int n:result){
        res[i++]=n;
     }
     return res;
    }
}