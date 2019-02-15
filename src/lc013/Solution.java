package lc013;

/**
 * Created on 2019/2/15<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {
    /**
     * boring
     */
    public int romanToInt(String s) {
        char [] a = s.toCharArray();
        int result = 0;
        for(int i = 0; i < a.length; i++){
            if(i==a.length-1){
                result += getInt(a[i]);
            }
            else if(a[i]=='I' && (a[i+1]=='V' || a[i+1]=='X')) {
                result -= getInt(a[i]);
            }
            else if(a[i]=='X' && (a[i+1]=='L' || a[i+1]=='C')) {
                result -= getInt(a[i]);
            }
            else if(a[i]=='C' && (a[i+1]=='D' || a[i+1]=='M')) {
                result -= getInt(a[i]);
            }
            else {
                result += getInt(a[i]);
            }
        }
        return result;
    }

    private int getInt(char a){
        if(a=='I'){
            return 1;
        }
        if(a=='V'){
            return 5;
        }
        if(a=='X'){
            return 10;
        }
        if(a=='L'){
            return 50;
        }
        if(a=='C'){
            return 100;
        }
        if(a=='D'){
            return 500;
        }
        if(a=='M'){
            return 1000;
        }
        return 0;
    }
}
