package JaLaba4;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cart {
    private String numberC;
    private String name;
    private String lastN;
    private String middleN;
    private String adress;
    private String work;
    private Calendar data;
    private int numberP;

    void Cart(){
        numberC = "1111";
        this.name = "aaa";
        lastN = "bbbb";
        middleN = "cccc";
        adress = "grod_prod_11";
        this.work = "dosn't have";
        data = new GregorianCalendar();
        numberP = 0000;
    }
    void Cart(String num,String name, String last, String middle, String adres, String work, Calendar d, int n){
        numberC = num;
        this.name = name;
        lastN = last;
        middleN = middle;
        adress = adres;
        this.work = work;
        data = d;
        numberP = n;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getNumberP() {
        return numberP;
    }
    public String getLastN() {
        return lastN;
    }
    public String getMiddleN() {
        return middleN;
    }
    public String getNumberC() {
        return numberC;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public void setData(Calendar data) {
        this.data = data;
    }
    public void setLastN(String lastN) {
        this.lastN = lastN;
    }
    public void setMiddleN(String middleN) {
        this.middleN = middleN;
    }
    public void setNumberC(String numberC) {
        this.numberC = numberC;
    }
    public void setNumberP(int numberP) {
        this.numberP = numberP;
    }
    public void setWork(String work) {
        this.work = work;
    }
    public void print(){
        System.out.println("Номер карты:"+ numberC +" ФИО:" + lastN + " " + name + " " + middleN + " адресс:"+ adress + " должность:" + work + " дата регистрации:" + data.get(Calendar.DAY_OF_MONTH) + " " + data.get(Calendar.MONTH)+" "+ data.get(Calendar.YEAR) + " номер поликлиники:" + numberP);
    }
}
