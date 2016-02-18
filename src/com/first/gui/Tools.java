package com.first.gui;

/**
 *
 * @author Frank
 */
public class Tools {
    //ส่วนตรวจสอบว่าเป็นตัวเลขไหม
    public static boolean isNumber(String s){
        try{
            Double.parseDouble(s); 
            /*แปลงจากตัวอักษรไปเป็นตัวเลข 
            ถ้าแปลงผ่านจะส่งกลับเป็น true
            */
            return true; 
        }catch(NumberFormatException nfe){   
            
            return false;
        }        
    }
}
