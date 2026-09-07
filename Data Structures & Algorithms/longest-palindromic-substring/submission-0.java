class Solution {
    private boolean isPalindrome(String s,int i,int j){
        String str=s.substring(i,j);
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        String ans="";
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isPalindrome(s,i,j) && s.substring(i,j+1).length()>ans.length()){
                    ans=s.substring(i,j+1);
                }
            }
        }
        if(ans.isEmpty() && n > 0) return s.substring(0, 1);
        
        return ans;
    }
}