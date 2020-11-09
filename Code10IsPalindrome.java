/**
 * @Author: ybchen
 * @Date: 2020/11/9 10:39
 */
public class Code10IsPalindrome {

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
       if(x<0||(x>0&&x%10==0)) return false;
       int reverseNumber=0;
       while(reverseNumber<x){
           reverseNumber=reverseNumber*10+x%10;
           x=x/10;
       }
       return reverseNumber==x||reverseNumber/10==x;
    }


}
