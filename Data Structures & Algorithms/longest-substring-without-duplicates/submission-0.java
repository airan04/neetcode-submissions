class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0) return 0;
        int ans=1;
        int left=0;
        HashSet<Character> set=new HashSet<>();
        set.add(s.charAt(left));
        for(int right=1;right<n;right++){
            
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            ans=Math.max(ans,right-left+1);
        }

        return ans;
    }
}