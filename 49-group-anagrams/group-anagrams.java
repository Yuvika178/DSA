import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);           // sort the characters
            String key = new String(chars);  // key is sorted version

            // if the key is not in map, put a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // add the original string into the group for this key
            map.get(key).add(s);
        }

        // return all groups
        return new ArrayList<>(map.values());
    }
}
