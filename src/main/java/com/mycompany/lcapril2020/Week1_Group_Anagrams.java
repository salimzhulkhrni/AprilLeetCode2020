/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lcapril2020;

/**
 *
 * @author salim
 */

import java.util.*; 

public class Week1_Group_Anagrams {
 
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs == null || strs.length == 0)
            return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        for(String str : strs){
        
            String string_hash_key = getStringForHash(str);  // get hash key for a string. anagramme'd words will have same hash string key. eg: "ate" = 1#0#0#..1#(at 'e') ..0# ..1#(at 't')....#0
            
            if(!map.containsKey(string_hash_key))
                map.put(string_hash_key, new ArrayList<>()); // new hash key; add to the map
             
            List<String> anagramList = map.get(string_hash_key); // get the list of the existing hash key and add this anagram word in the existing hash key's list (even if it is a  fresh new hash key, the word used will be added to its list )
            anagramList.add(str);  //add this anagram word in the existing hash key's list 
            
        }
        
        
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            
            List<String> anagramList = entry.getValue();
            res.add(anagramList);
        }
        
        return res;
        
    }
    
    private static String getStringForHash(String s){
        
        int[] arr = new int[26];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++)
            arr[s.charAt(i) - 'a']++;
        
        for(int i=0; i<arr.length; i++)
            sb.append(arr[i] + "#");
        
        return sb.toString();
            
    }
    
    public static void main(String[] args){
        
        Week1_Group_Anagrams obj = new Week1_Group_Anagrams();
        String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> res = obj.groupAnagrams(strs);
        
        for(int i=0; i<res.size(); i++){
            
            List<String> anagramList = res.get(i);
            
            for(String str : anagramList){
                
                System.out.print(" " + str + " ");
            }
            
            System.out.println("");
        }
    }
}
