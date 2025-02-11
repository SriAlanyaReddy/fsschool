class Solution {
    public int minSubArrayLen(int target, int[] a) {
        int n=a.length;
        int min=Integer.MAX_VALUE;
        int r=0;
        int l=0;
        int sum=0;
        while(r<n){
          sum=sum+a[r];
          while(sum>=target){
            min=Math.min(r-l+1,min);
            sum=sum-a[l];

            l++;
          }
          
          r++;
        }
    
    return min==Integer.MAX_VALUE?0:min;
    }
}