class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list=new ArrayList<>();
        int maxlength=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            while(list.contains(c)){

                list.remove(0);
             } 
             list.add(c);
             maxlength =Math.max(maxlength,list.size());
        }
             return maxlength;

    }
}