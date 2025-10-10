class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> result= new HashMap<>();
        
        for(int num:nums){
            if(result.containsKey(num)){
                return true;
        
        }else{
            result.put(num,1);
        }
        }
      return false;  
    }
}