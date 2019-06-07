package com.oneclique.programmerscalculator;

import com.oneclique.programmerscalculator.NumberConverter.ConversionUtils;

public class LogicGates extends ConversionUtils {

	protected String calculateBinary(String binary1, String binary2, String operator, int maxLength){
		String result = "";
		if(operator == "AND"){
			for(int i = 0; i < maxLength; i++){
				if(binary1.charAt(i) == '1' && binary2.charAt(i) == '1'){
					result += "1";
				}
				else if(binary1.charAt(i) == '0' && binary2.charAt(i) == '1' || 
						binary1.charAt(i) == '1' && binary2.charAt(i) == '0' ||
						binary1.charAt(i) == '0' && binary2.charAt(i) == '0'){
					result += "0";
				}
			}
		}
		else if(operator == "OR"){
			for(int i = 0; i < maxLength; i++){
				if(binary1.charAt(i) == '0' && binary2.charAt(i) == '0'){
					result += "0";
				}
				else if(binary1.charAt(i) == '0' && binary2.charAt(i) == '1' || 
						binary1.charAt(i) == '1' && binary2.charAt(i) == '0' ||
						binary1.charAt(i) == '1' && binary2.charAt(i) == '1'){
					result += "1";
				}
			}
		}
		else if(operator == "NAND"){
			for(int i = 0; i < maxLength; i++){
				if(binary1.charAt(i) == '1' && binary2.charAt(i) == '1'){
					result += "0";
				}
				else if(binary1.charAt(i) == '0' && binary2.charAt(i) == '1' || 
						binary1.charAt(i) == '1' && binary2.charAt(i) == '0' ||
						binary1.charAt(i) == '0' && binary2.charAt(i) == '0'){
					result += "1";
				}
			}
		}
		return result;
	}
	
	protected int maxLength(String binary1, String binary2){
		int len1 = binary1.length();
		int len2 = binary2.length();
		if(len1 > len2){
			return len1;
		}
		else if(len1 <  len2){
			return len2;
		}
		return len1;
	}
	
	public String OR(String binary1, String binary2){
		int len = maxLength(binary1, binary2);
		String result = "";
		binary1 = reverseString(binary1);
		binary2 = reverseString(binary2);
		if(binary2.length() == binary1.length()){
			result = calculateBinary(binary1, binary2, "OR", len);
			return reverseString(result);
		}
		if(len > binary2.length()){
			for(int i = 0 + binary2.length() - 1; i < len; i ++){
				binary2 += "0";
			}
		}
		else if(len > binary1.length()){
			for(int i = 0 + binary1.length() - 1; i < len; i ++){
				binary1 += "0";
			}
		}
		result = calculateBinary(binary1, binary2, "OR", len);
		return reverseString(result);
	}
	
	public String NAND(String binary1, String binary2){
		if(binary1 == "1" && binary2 == "1"){return "0";}
		else if(binary1 == "0" && binary2 == "0" || 
				binary1 == "1" && binary2 == "0" || 
				binary1 == "0" && binary2 == "1"){return "1";}
		
		int len = maxLength(binary1, binary2);
		String result = "";
		binary1 = reverseString(binary1);
		binary2 = reverseString(binary2);
		if(binary2.length() == binary1.length()){
			result = calculateBinary(binary1, binary2, "NAND", len);
			binary1 = "";
			result = reverseString(result);
			for(int i = 0; i < len; i++){
				if(result.charAt(i) == '1'){
					for(int j = i; j < len; j++){
						binary1 += Character.toString(result.charAt(j));
					}
					break;
				}
			}
			return binary1;
		}
		else if(len > binary2.length()){
			for(int i = 0 + binary2.length() - 1; i < len; i ++){
				binary2 += "0";
			}
		}
		else if(len > binary1.length()){
			for(int i = 0 + binary1.length() - 1; i < len; i ++){
				binary1 += "0";
			}
		}
		result = calculateBinary(binary1, binary2, "NAND", len);
		binary1 = "";
		result = reverseString(result);
		for(int i = 0; i < len; i++){
			if(result.charAt(i) == '1'){
				for(int j = i; j < len; j++){
					binary1 += Character.toString(result.charAt(j));
				}
				break;
			}
		}
		return binary1;
	}
	
	public String AND(String binary1, String binary2){ 
		int len = maxLength(binary1, binary2);
		String result = "";
		binary1 = reverseString(binary1);
		binary2 = reverseString(binary2);
		if(binary2.length() == binary1.length()){
			result = calculateBinary(binary1, binary2, "AND", len);
			return reverseString(result);
		}
		if(len > binary2.length()){
			for(int i = 0 + binary2.length() - 1; i < len; i ++){
				binary2 += "0";
			}
		}
		else if(len > binary1.length()){
			for(int i = 0 + binary1.length() - 1; i < len; i ++){
				binary1 += "0";
			}
		}
		result = calculateBinary(binary1, binary2, "AND", len);
		binary1 = "";
		result = reverseString(result);
		for(int i = 0; i < len; i++){
			if(result.charAt(i) == '1'){
				for(int j = i; j < len; j++){
					binary1 += Character.toString(result.charAt(j));
				}
			}
		}
		return binary1;
	}
}
