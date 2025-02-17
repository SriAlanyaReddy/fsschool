class Solution {
    public int maxScore(int[] a, int k) {
      
        int sum=0;
        int n=a.length;
        for(int i=0;i<k;i++){
            sum=sum+a[i];
        }
        int l=k-1;
        int r=n-1;
        int max=sum;
        while(r>n-k-1){
            sum-=a[l];
            sum+=a[r];
            r--;
            l--;
            max=Math.max(sum,max);
        }
        return max;
    }
}