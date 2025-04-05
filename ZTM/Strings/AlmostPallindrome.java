package ZTM.Strings;

public class AlmostPallindrome {
    
}

// If there is a mismatch there are two possibility
//      1. Check rest of the string by skipping 'low' pointer
//      2. Check rest of the string by skipping 'high' pointer

// create another method which accepts low and high pointers so that upon mismatch you can 
// just check the remaining String

class Solution {
    public boolean validPalindrome(String s) {
        
        int l = 0, h = s.length() - 1;

        while(l < h){

            if(s.charAt(l) != s.charAt(h))
                return  checkValidPalindrome(s, l, h - 1) ||  checkValidPalindrome(s, l + 1, h);
            l++;
            h--;
        }

        return true;
    }

    public boolean checkValidPalindrome(String s, int l , int h){
        while(l < h ){
            if(s.charAt(l) != s.charAt(h))
                return false;
            l++;
            h--;
        }

        return true;
    }
}



