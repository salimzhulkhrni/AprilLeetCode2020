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

public class Week1_Max_Sum_SubArray {
    
    
    public static int maxSubArray(int[] nums){
    
        if(nums == null || nums.length == 0)
            return 0;
        
        
        // Kadane's algorithm. Logic - currSum so far is the max of (sum of the nums till now, number at the current position). Use maxSumSoFar to track if currSum > maxSumSoFar encountered. 
        // If yes, currSum becomes the maxSumSoFar, if not maxSumSoFar is the sum tracked so far
        
        int currSum = nums[0];
        int maxSumSoFar = currSum;
        
        for(int i=1; i<nums.length; i++){
            
            currSum+= nums[i];
            
            currSum = Math.max(currSum, nums[i]);
            
            if(currSum >= maxSumSoFar)
                maxSumSoFar = currSum;
        }
        
        return maxSumSoFar;
        
    }
    
    public static void main(String[] args){
    
        Week1_Max_Sum_SubArray obj = new Week1_Max_Sum_SubArray();
        int[] arr = new int[] { -2,1,-3,4,-1,2,1,-5,4 };
        
        int sum = obj.maxSubArray(arr);
        
        System.out.println("res: " + (sum == 6));
        
    }
    
}
