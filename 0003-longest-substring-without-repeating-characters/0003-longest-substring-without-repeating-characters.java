class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, max = 0, i = 0;
        while(i < s.length()){
            if(map.containsKey(s.charAt(i))){
                i = map.get(s.charAt(i)) + 1;
                map.clear();
                if(count > max)
                    max = count;
                count = 0;
            }
            map.put(s.charAt(i), i);
            count++;
            i++;
        }
        if(count > max)
            max = count;
        return max;
    }
}