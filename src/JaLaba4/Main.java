package JaLaba4;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Cart> carts = new ArrayList<>();
        ArrayList<Cart> stask = new ArrayList<>();
        FileClass file = new FileClass();
        boolean OK = true;
        String name = "", lName = "", mName ="", name1 = "", lName1 = "", mName1 ="";;
        int n;
        while(OK){
            System.out.println("1.добавить медицинскую карту\n2.по номеру карты вернуть ФИО\n3.наблюд ли 2 пациента в одной клинике\n4.карты в данной поликлинике\n5.Запись в файл\n6.чтение из файла и доп задание 2\n7.выход");
            n = in.nextInt();
            switch (n){
                case 1:
                    addCart(carts);
                    break;
                case 2:
                    //region поиск фио
                    int temp;
                    boolean ok = true;
                    if(carts.size() != 0){
                        try {
                            System.out.print("Введите номер карты: ");
                            temp = Integer.parseInt(in.next());
                            for(Cart i : carts){
                                if(temp == i.getNumberC()) {
                                    System.out.println("ФИО: " + i.getLastN() + " " + i.getName() + " " + i.getMiddleN());
                                    ok = false;
                                    break;
                                }
                            }
                            if(ok)
                                System.out.println("Данной карты не зарегистрировано");
                        }
                        catch (Exception e){
                            System.out.println("Вы не правильно ввели число");
                        }
                    }
                    //endregion
                    break;
                case 3:
                    //region 2 пациента
                    if(carts.size()>1) {
                        Cart a = null, b = null;
                        System.out.print("Введите ФИО первого пациента: ");
                        lName = in.next();
                        name = in.next();
                        mName = in.next();
                        System.out.print("Введите имя второго пациента: ");
                        lName1 = in.next();
                        name1 = in.next();
                        mName1 = in.next();
                        for (Cart i : carts){
                            if(name.equals(i.getName()) && lName.equals(i.getLastN()) && mName.equals(i.getMiddleN()))
                                a = i;
                            else if(name1.equals(i.getName()) && lName1.equals(i.getLastN()) && mName1.equals(i.getMiddleN()))
                                b = i;
                            if(a != null && b != null){
                                if(a.getNumberP() == b.getNumberP()) {
                                    System.out.println("Пациенты наблюдаются в одном заведении");
                                    break;
                                }
                                else{
                                    System.out.println("Пациенты не наблюдаются в одном заведении");
                                    break;
                                }
                            }
                            else {
                                System.out.println("Введенных пациентов нет в поликлинике");
                                break;
                            }
                        }
                    }
                    else{
                        System.out.println("В вашем списке карт меньше 2ух человек");
                    }
                    //endregion
                    break;
                case 4:
                    //region sadreg
                    System.out.print("Введите номер поликлиники:");
                    try {
                        n = Integer.parseInt(in.next());
                        stask = file.read(n);
                        if (stask.size()>0) {
                            System.out.println("Пациенты: ");
                            for (Cart i : stask) {
                                i.print();
                            }
                        }
                        else
                            System.out.println("нет пациентов в этой поликлинике");
                    }catch (Exception e){
                        System.out.print(e.getMessage());
                   }
                    //endregion
                    break;
                case 5:
                    file = new FileClass();
                    try {
                        file.write(carts);
                    }catch (Exception e){
                        System.out.println("errors");
                    }
                    break;
                case 6:
                    try {
                    file.randommm(carts);
                    }catch (Exception e){
                        System.out.println("error");
                    }
                    break;
                case 7:
                    OK = false;
                    break;
            }
        }
    }
    public static void addCart(ArrayList<Cart> carts){
        Cart cart = new Cart();
        Calendar c = new GregorianCalendar();
        int temp,y,m,d;
        String trash = "";
        boolean tmp = true;
        tmp = true;
        while(tmp) {
            try {
                System.out.print("Введите номаер карты: ");
                temp = Integer.parseInt(in.next());
                cart.setNumberC(temp);
                tmp = false;
            } catch (Exception e) {
                System.out.println("Вы не правильно ввели номер поликлиники! Вам нужно исправиться!");
            }
        }   //Ввод номера поликлиники
        System.out.print("Введите ФИО пациента (ЧЕРЕЗ ПРОБЕЛ): ");
        cart.setLastN(in.next());
        cart.setName(in.next());
        cart.setMiddleN(in.next());
        System.out.print("Введите ваш адрес через пробелл: ");
        trash = in.nextLine();
        trash = in.nextLine();
        trash = trash.replace(' ','_');
        cart.setAdress(trash);
        trash = "";
        System.out.print("Введите вашу должность на работе: ");
        trash = in.nextLine();
        trash = trash.replace(' ','_');
        cart.setWork(trash);
        tmp = true;
        while (tmp) {
            try {
                System.out.println("1.дату регистрации будете вводить вручную\n2.выставить текущую дату");
                y = Integer.parseInt(in.next());
                if (y == 1){
                    System.out.print("Введите дату месяц год (через пробел): ");
                    d = Integer.parseInt(in.next());
                    m = Integer.parseInt(in.next());
                    y= Integer.parseInt(in.next());
                    c = new GregorianCalendar(y,m,d);
                    cart.setData(c);
                    tmp = false;
                }
                else if(y == 2){
                    c = new GregorianCalendar();
                    cart.setData(c);
                    tmp = false;
                }
            }
            catch (Exception e){
                System.out.println("Кажется вы ввели все не так и что-то сломалось, повторите ввод!");
            }
        } // Ввод даты
        tmp = true;
        while(tmp) {
            System.out.println("Введите номер поликлиники: ");
            try {
                temp = Integer.parseInt(in.next());
                cart.setNumberP(temp);
                tmp = false;
            } catch (Exception e) {
                System.out.println("Вы не правильно ввели номер поликлиники! Вам нужно исправиться!");
            }
        }   //Ввод номера поликлиники
        cart.print();
        carts.add(cart);

    }
}
