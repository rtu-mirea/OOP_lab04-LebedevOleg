package JaLaba4.Task4;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ClassSeriyazableFile implements Serializable{

    String file = "";
    LinkedList<User> users = new LinkedList<User>();

    ClassSeriyazableFile(String f){
        if (new File(f).exists()){
            file = f;
        }else{
            System.out.println("Файла не существует");
        }
    }

    public void record(User us) throws Exception{
        FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(us);
        oos.close();
    }

    public User read() throws Exception{
        FileInputStream in = new FileInputStream(file);
        ObjectInputStream oin = new ObjectInputStream(in);
        User us = new User();
        us = (User)oin.readObject();
        return us;
    }

    public void collection () throws Exception{
        System.out.println("Сколько объектов заполнить");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i<n; i++){
            System.out.println("Введите имя логин и пароль " + i + "го объекта");
            String log="", pass = "",name = "";
            System.out.print("Name:");
            name = in.next();
            System.out.print("Login:");
            log = in.next();
            System.out.print("Password");
            pass = in.next();
            User u = new User(name,log,pass);
            users.add(u);
        }
        FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(users);
    }

    public void readfile() throws Exception{
        FileInputStream read = new FileInputStream(file);
        ObjectInputStream oin = new ObjectInputStream(read);

        users = (LinkedList)oin.readObject();

    }

    public LinkedList<User> gerArray(){
        return users;
    }

}