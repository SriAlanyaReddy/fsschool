class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int countwhite=0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W'){
                countwhite++;
            }
        }
        int min=countwhite;
        for(int i=k;i<n;i++){
            if(blocks.charAt(i-k)=='W'){
                countwhite--;
            }
            if(blocks.charAt(i)=='W'){
                countwhite++;
            }
            min=Math.min(countwhite,min);
        }
        return min;
    }
}