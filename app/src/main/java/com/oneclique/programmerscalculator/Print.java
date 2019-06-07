package com.oneclique.programmerscalculator;

import android.content.Context;
import android.view.*;
import android.widget.*;

import com.oneclique.programmerscalculator.Calculator.Calculator;
import com.oneclique.programmerscalculator.Calculator.MyStack;
import com.oneclique.programmerscalculator.NumberConverter.Convert;

class Print extends Convert {
	
	private LogicGates lg = new LogicGates();
	private Calculator calculate = new Calculator();
	private MyStack<String> num = new MyStack<>();
	private MyStack <String> ope = new MyStack<>();
	private String intStr = "0";
	private String lastOp = " ", newOpe = " ";
	private int limit = 0;
	
	void print(Context context, View view,
			   EditText txtView, char type){//types are d = decimal, b = binary, o = octal, h = hexa;
		if(type == 'd'){limit = 20;}
		else if(type == 'h'){limit = 17;} 
		else if(type == 'b'){limit = 64;}
		else if(type == 'o'){limit = 22;}
		switch(view.getId()){
			case R.id.mButton0:
			case R.id.mButton1:
			case R.id.mButton2:
			case R.id.mButton3:
			case R.id.mButton4:
			case R.id.mButton5:
			case R.id.mButton6:
			case R.id.mButton7:
			case R.id.mButton8:
			case R.id.mButton9:
			case R.id.mButtonA:
			case R.id.mButtonB:
			case R.id.mButtonC:
			case R.id.mButtonD:
			case R.id.mButtonE:
			case R.id.mButtonF:
				{//Display numbers 0 to 9 and A to F
				String intNum = ((Button)view).getText().toString();
				if(intStr.equals("0")){
					intStr = intNum;
				}
				else{
					if(intStr.length() < limit){
						intStr += intNum;
					}
				}
				txtView.setText(intStr);
				break;
			}
			//case for Multiplication Operation
			case R.id.mButtonMultiply:{
				num.push(checkType(type, intStr));
				newOpe = "*";
				check(txtView, type);
				intStr = "0";
				break;
			}
			//case for Division Operation
			case R.id.mButtonDivide:{
				num.push(checkType(type, intStr));
				newOpe = "/";
				check(txtView, type);
				intStr = "0";
				break;
			}
			//case for Addition Operation
			case R.id.mButtonAddition:{
				num.push(checkType(type, intStr));
				newOpe = "+";
				check(txtView, type);
				intStr = "0";
				break;
			}
			//case for Subtraction Operation
			case R.id.mButtonSubtract:{
				num.push(checkType(type, intStr));
				newOpe = "-";
				check(txtView, type);
				intStr = "0";
				break;
			}
			case R.id.mButtonDel:{//Delete last character
				String txt = reverseString(intStr);
				StringBuilder newTxt = new StringBuilder();
				for(int i = 1; i < txt.length(); i++){
					newTxt.append(txt.charAt(i));
				}
				txt = reverseString(newTxt.toString());
				intStr = txt;
				if(txt.length() == 0){
					intStr = "0";
				}
				txtView.setText(intStr);
				break;
			}
				
			case R.id.mButtonClear:{//Clear all the numbers
				intStr = "0";
				lastOp = " ";
				num = new MyStack<>();
				ope = new MyStack<>();
				txtView.setText(intStr);
				break;
			}
			//case to convert the input to Positive or Negative
			case R.id.mButtonSign:{
				intStr = Long.toString(Long.parseLong(intStr) * -1);
				txtView.setText(intStr);
				break;
			}
			//case to display Result when the equal button is pressed
			case R.id.mButtonEquals:{
				try{
					switch (newOpe) {
						case "AND": {
							String binary1 = Decimal_To_Binary(num.pop());
							String binary2 = intStr;
							intStr = lg.AND(binary1, binary2);
							txtView.setText(intStr);
							break;
						}
						case "OR": {
							String binary1 = Decimal_To_Binary(num.pop());
							String binary2 = intStr;
							intStr = lg.OR(binary1, binary2);
							txtView.setText(intStr);
							break;
						}
						case "NAND": {
							String binary1 = Decimal_To_Binary(num.pop());
							String binary2 = intStr;
							intStr = lg.NAND(binary1, binary2);
							txtView.setText(intStr);
							break;
						}
						default:
							num.push(checkType(type, intStr));
							String num1, num2, result = "", oper;
							try {
								while (!num.isEmpty() && !ope.isEmpty()) {
									num2 = num.pop();
									num1 = num.pop();
									oper = ope.pop();
									result = calculate.compute(oper.charAt(0), num1, num2);
									num.push(result);

								}
								intStr = result;
							} catch (Exception e) {
								Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
							}
							txtView.setText(checkTypeReverse(type, intStr));
							break;
					}
				}
				catch(Exception exception){
					Toast.makeText(context, "You must input equation first", Toast.LENGTH_LONG).show();
				}
				
				intStr = "0";
				lastOp = " ";
				num = new MyStack<>();
				ope = new MyStack<>();
				break;
			}
			case R.id.mButtonAND:{
				num.push(checkType(type, intStr));
				newOpe = "AND";
				intStr = "0";
				break;
			}
			case R.id.mButtonNAND:{
				num.push(checkType(type, intStr));
				newOpe = "NAND";
				intStr = "0";
				break;
			}
			case R.id.mButtonOR:{
				num.push(checkType(type, intStr));
				newOpe = "OR";
				intStr = "0";
				break;
			}
			case R.id.mButtonNOT:{
				num.push(checkType(type, intStr));
				newOpe = "NOT";
				intStr = "0";
				break;
			}
		}
	}

	private String checkType(char inputType, String input){
		String returnS;
		switch(inputType){
			case 'b':{	returnS =  Binary_To_Decimal(input); break;	}
			case 'o':{	returnS =  Octa_To_Decimal(input);	break;	}
			case 'h':{	returnS =  Hexa_To_Decimal(input);	break;	}
			default : returnS = input;
		}
		return returnS;
		
	}

	private String checkTypeReverse(char inputType, String input){
		String returnS;
		switch(inputType){
			case 'b':{	returnS =  Decimal_To_Binary(input);break;	}
			case 'o':{	returnS =  Decimal_To_Octal(input);	break;	}
			case 'h':{	returnS =  Decimal_To_Hexa(input);	break;	}
			default : returnS = input;
		}
		return returnS;
		
	}
	
	private void check(EditText txtView, char type){
		if(ope.isEmpty()){
			ope.push(newOpe);	
		}
		else{
			lastOp = ope.pop();
			if(calculate.value(newOpe.charAt(0)) > calculate.value(lastOp.charAt(0))){
				ope.push(lastOp);
				ope.push(newOpe);
			}
			else if(calculate.value(newOpe.charAt(0)) == calculate.value(lastOp.charAt(0))){
				ope.push(newOpe);
				calculate.operate(num, lastOp.charAt(0));
			}
			else if(calculate.value(newOpe.charAt(0)) < calculate.value(lastOp.charAt(0))){
				ope.push(newOpe);
				calculate.operate(num, lastOp.charAt(0));
			}
			intStr = num.pop();
			num.push(intStr);
			if(intStr.equals("0")){
				txtView.setText("0");
			}
			txtView.setText(checkTypeReverse(type,intStr));
			intStr = "0";
		}
	}
	
}
