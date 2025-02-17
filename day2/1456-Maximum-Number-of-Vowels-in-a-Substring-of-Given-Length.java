class Solution {
    public int maxVowels(String s, int k) {
        int c=0;
        int n=s.length();
        for(int i=0;i<k;i++){
            if(isVowel(s.charAt(i))){
                c++;
            }
        }
        int max=c;
        for(int i=k;i<n;i++){
            if(isVowel(s.charAt(i-k))){
                c--;
            }
            if(isVowel(s.charAt(i))){
                c++;
            }
            max=Math.max(c,max);
        }
        return max;
    }
    public static boolean isVowel(char c){
        Set<Character>s=new HashSet<>();
        s.add('a');
        s.add('e');
        s.add('i');
        s.add('i');
        s.add('o');
        s.add('u');
        if(s.contains(c))return true;
        return false;
    }
}