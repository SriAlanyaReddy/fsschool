class Solution {
    public int longestOnes(int[] a, int k) {
        int cntzero=0;
        int max=Integer.MIN_VALUE;
        int r=0;
        int l=0;
        int n=a.length;
        while(r<n){
            
            if(a[r]==0){
                cntzero++;
            }
            while(cntzero>k){
                if(a[l]==0){
                    cntzero--;
                }
                l++;
            }
            max=Math.max(r-l+1,max);
            r++;
        }
        return max;
    }
}