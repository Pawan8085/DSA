package RecursionAndBacktracking.Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    
    public List<String> letterCombinations(String digits) {
        /*
        time O(n ^ m)
        where n is maximum length of characters
        and m is length of digits
         */
                
        List<String> result = new ArrayList<>();

        if(digits.length()==0) return result;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        getAllCombinataion(digits, 0, map, new StringBuilder(), result);
        return result;
    }

    public void getAllCombinataion(String digits, int i, Map<Character, String> map , StringBuilder sb, List<String> result){
      
     // store the result  
     if(i == digits.length()){
        result.add(sb.toString());
        return ;
     }


     String key = map.get(digits.charAt(i));

     for(char c : key.toCharArray()){

        sb.append(c);
        getAllCombinataion(digits, i+1, map, sb, result);
        sb.deleteCharAt(sb.length()-1); // backtrack
     }
    }
}
