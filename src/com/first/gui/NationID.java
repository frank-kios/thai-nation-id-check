/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.first.gui;

/**
 *
 * @author Frank
 */
public class NationID {
    
    private String id; //สำหรับเก็บเลขบัตรมาตรวจสอบ
    
    private boolean isReal; //ส่วนเก็บข้อมูลว่าจริงไม่จริงของเลขบัตร
    
    private int[] id_int; // ตัวเก็บค่าแบบ array 
    
    private int sum_all; //ตัวเก็บผลรวม
    
    private int mod; //ที่เก็บเศษ
    
    private int digit;//ส่วนที่เก็บเลขที่ถูกต้อง

    //เมื่อสร้างobject จะมาเริ่มทำงานตรงนี้
    public NationID(String id) {
        
        this.id = id; //กำหนดข้อมูลเลขบัตร
        
        id_int = new int[id.length()]; //สร้างกำหนดขนาดของตัวแปร array
        
        for (int i = 0; i < id.length(); i++) {
            //แปลงข้อมูลใน string id ไปเป็น int แบบ array เพื่อเข้าถึงที่ละตัวได้
            id_int[i] = Character.getNumericValue(id.charAt(i));
        }
        
        this.isReal = Check(); //เรียกใช้คำสั่งเช็ค
    }
    
    
    //ส่วนตรวจสอบว่าเลขถูกต้อง
    //วิธีตรวจคือ 
    private boolean Check(){
        //เอ้าเลข1-12 มา * ด้วยเลขลำดับ เริ่มจาก 13-2
        for (int i = 0; i < id.length()-1; i++) {
            sum_all += cal(id_int[i], id_int.length-i);
        }
        //System.out.println("Sum = "+sum_all);
        mod = sum_all % 11; //แล้วมาหารหาเศษด้วย 11
        //System.out.println("Mod = "+mod);
        digit = (11-mod)%10; //นำ11มาลบกับเศษที่ได้แล้วเอาเลขตัวหลังสุด ได้ด้วยการ mod 10
        //System.out.println("Digit = "+digit);
        //นำที่เลขได้มาตรวจสอบกับเลขที่ลำดับที่ 13 ว่าตรงกันไหม
        return (digit)==id_int[id.length()-1];
    }
    
    //ที่คำนวนเอาลำดับ*กับเลข
    private int cal(int number,int position){
        return number*position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    

    public boolean isReal() {
        return isReal;
    }
    
}
