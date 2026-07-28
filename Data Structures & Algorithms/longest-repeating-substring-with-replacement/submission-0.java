class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        if(n==1){
            return 1;
        }
        int maxAns=1;
        int[] freq=new int[26];
        freq[s.charAt(0)-'A']++;
        int maxFreq=0;
        for(int right=1;right<n;right++){
            char rightChar=s.charAt(right);
            freq[rightChar-'A']++;

            maxFreq=Math.max(maxFreq,freq[rightChar-'A']);

            while((right-left+1)-maxFreq>k){
                char leftChar=s.charAt(left);
                freq[leftChar-'A']--;
                left++;
            }

            maxAns=Math.max(maxAns,right-left+1);
        }
        return maxAns;
    }
}