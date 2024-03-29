package JaLaba4;
import java.io.*;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FileClass {
    private String fname = "";
    private Scanner in = new Scanner(System.in);

    public void write(ArrayList<Cart> carts) throws Exception {
        System.out.println("Введите имя файла: ");
        fname = in.next();
        fname += ".txt";
        DataOutputStream write = new DataOutputStream(new FileOutputStream(fname));
        for (Cart i : carts) {
            //byte[] text = i.toString().getBytes("UTF-8");
            write.writeInt(i.getNumberC());
            write.writeUTF(i.getName());
            write.writeUTF(i.getLastN());
            write.writeUTF(i.getMiddleN());
            write.writeUTF(i.getAdress());
            write.writeUTF(i.getWork());
            write.writeUTF(i.getData());
            write.writeInt(i.getNumberP());
        }
        File f = new File(fname);
        if (f.exists())
            System.out.println("Найдено");
        else
            System.out.println("Не найдено");
        write.close();

    }

    public ArrayList<Cart> read(int numP) throws Exception {
        ArrayList<Cart> carts = new ArrayList<>();
        String n="",l="",m="",a="",w ="",d = "",d1[] ;
        int c,p;
        DataInputStream read = new DataInputStream(new FileInputStream(fname));
        while (read.available() > 0) {
            c =read.readInt();
            n =read.readUTF();
            l =read.readUTF();
            m =read.readUTF();
            a = read.readUTF();
            w = read.readUTF();
            d = read.readUTF();
            d1 = d.split(" ");
            p = read.readInt();
            if (p == numP) {
                Calendar data = new GregorianCalendar(Integer.parseInt(d1[0]), Integer.parseInt(d1[1]), Integer.parseInt(d1[2]));
                Cart cart = new Cart(c, n, l, m, a, w, data, p);
                carts.add(cart);
            }
        }
        read.close();
        return carts;
    }

    public void randommm(ArrayList<Cart> carts) throws Exception {
        fname.replaceAll(".txt","R" + Math.random());
        fname += ".txt";
        DataOutputStream write = new DataOutputStream(new FileOutputStream(fname));
        for (Cart i : carts) {
            byte[] text = i.toString().getBytes("UTF-8");
            write.write(text);
            write.write("\r\n".getBytes("UTF-8"));
        }
        File f = new File(fname);
        if (f.exists())
            System.out.println("Найдено");
        else
            System.out.println("Не найдено");
        write.close();

        RandomAccessFile rand = new RandomAccessFile(fname, "rw");
        rand.seek(0);
        ArrayList<Cart> temp = new ArrayList<>();
        String[] tmp;
        Cart cart;
        for (int i = 0; i < carts.size(); i++) {
            if (i % 2 == 1) {
                tmp = rand.readLine().split(" ");
                Calendar data = new GregorianCalendar(Integer.parseInt(tmp[8]), Integer.parseInt(tmp[7]), Integer.parseInt(tmp[6]));
                cart = new Cart(Integer.parseInt(tmp[0]), tmp[1], tmp[2], tmp[3], tmp[4], tmp[5], data, Integer.parseInt(tmp[9]));
                cart.setNumberC(Integer.parseInt(tmp[0]) + 10);
                temp.add(cart);
            } else {
                tmp = rand.readLine().split(" ");
                Calendar data = new GregorianCalendar(Integer.parseInt(tmp[8]), Integer.parseInt(tmp[7]), Integer.parseInt(tmp[6]));
                cart = new Cart(Integer.parseInt(tmp[0]), tmp[1], tmp[2], tmp[3], tmp[4], tmp[5], data, Integer.parseInt(tmp[9]));
                temp.add(cart);
            }
        }
        rand.seek(0);
        for (Cart i : temp) {
            byte[] text = i.toString().getBytes("UTF-8");
            rand.write(text);
            rand.write("\r\n".getBytes("UTF-8"));
        }
        rand.close();
    }
}
