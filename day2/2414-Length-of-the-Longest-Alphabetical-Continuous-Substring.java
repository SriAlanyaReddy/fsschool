class Solution {
    public int longestContinuousSubstring(String s) {
        int count=1;

        int n=s.length();
       int max=1;
       for(int i=1;i<n;i++){
        if(s.charAt(i)==s.charAt(i-1)+1){
            count++;
        }
        else{
            count=1;
        }
        max=Math.max(count,max);
       }
       return max;
    }
}