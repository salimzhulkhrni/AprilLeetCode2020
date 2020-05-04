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

public class Week1_Single_Number {
    
    
    public static int singleNumber(int[] nums){
        
        if(nums == null || nums.length == 0)
            return 0;
        
//        Approach 1: Use HashSet
//        insert into hash when you find an element. When you encounter again, remove it. Final element in the hash is the single element
//        
//        Set<Integer> set = new HashSet<>();
//        
//        for(int num : nums){
//            
//            if(set.contains(num))
//                set.remove(num);
//            else
//                set.add(num);
//        }
//        
//        for(int num : set)
//            return num;
//        
//        return -1;



//         Approach 2: Use XOR. same number xor = 0, any number XOR 0 = any number
                 
            
           int num = nums[0];
           
           for(int i=1; i<nums.length; i++)
               num^= nums[i];
           
           return num;

    }
    
    
    public static void main(String[] args){
        
        
        Week1_Single_Number obj = new Week1_Single_Number();
        int[] nums1 = { 2, 2, 1};
        int[] nums2 = { 4, 1, 2, 1, 2};
        int ans1 = obj.singleNumber(nums1);
        int ans2 = obj.singleNumber(nums2);
        
        System.out.println("input1 - res: " + (ans1 == 1) + " input2 - res: " + (ans2 == 4));
        
        
    }
    
}
