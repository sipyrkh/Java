import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class clientConnection {
    public static int login(String username, String password) {
        try {
            System.out.println("Начало работы клиента...");
            Socket clientSocket = new Socket("127.0.0.1", 2525);//установление соединения между локальной машиной и указанным портом узла сети
            System.out.println("Соединение установлено...");
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание потока вывода
            ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());//создание потока ввода
            coos.writeObject("авторизация");
            coos.writeObject(username);
            coos.writeObject(password);
            return (int) cois.readObject();
        } catch (Exception e) {
            e.printStackTrace();//выполнение метода исключения е
        }
        return -1;
    }
    public static int registration(String username_reg, String password_reg) throws EOFException{
        int error = 2;
        try{
            System.out.println("Начало работы клиента...");
            Socket clientSocket = new Socket("127.0.0.1", 2525);
            System.out.println("Соединение установлено...");
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());
            coos.writeObject("регистрация");
            coos.writeObject(username_reg);
            coos.writeObject(password_reg);
            error = (int) cois.readObject();
            clientSocket.close();
            cois.close();
            coos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return error;
    }
    public ArrayList<String> method_autosalon() throws IOException{
        ArrayList<String> data_autosalon = new ArrayList<String>();
        Socket clientSocket = new Socket("127.0.0.1", 2525);
        ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание потока вывода
        ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());//создание потока ввода
        try{
            coos.writeObject("автосалон");
            data_autosalon = (ArrayList<String>) cois.readObject();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        clientSocket.close();
        cois.close();
        coos.close();
        return data_autosalon;
    }
    public ArrayList<String> method_automobile() throws IOException{
        ArrayList<String> data_automobile = new ArrayList<String>();
        Socket clientSocket = new Socket("127.0.0.1", 2525);
        ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание потока вывода
        ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());//создание потока ввода
        try{
            coos.writeObject("автомобиль");
            data_automobile = (ArrayList<String>) cois.readObject();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
    }
        clientSocket.close();
        cois.close();
        coos.close();
        return data_automobile;
    }
    public ArrayList<String> method_clients() throws IOException{
        ArrayList<String> data_clients = new ArrayList<String>();
        Socket clientSocket = new Socket("127.0.0.1", 2525);
        ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание потока вывода
        ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());//создание потока ввода
        try{
            coos.writeObject("клиенты");
            data_clients = (ArrayList<String>) cois.readObject();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        clientSocket.close();
        cois.close();
        coos.close();
        return data_clients;
    }
    public ArrayList<String> method_sale() throws IOException{
        ArrayList<String> data_sale = new ArrayList<String>();
        Socket clientSocket = new Socket("127.0.0.1", 2525);
        ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание потока вывода
        ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());//создание потока ввода
        try{
            coos.writeObject("продажа");
            data_sale = (ArrayList<String>) cois.readObject();
        }catch (ClassNotFoundException e){
            method_sale();
        }
        clientSocket.close();
        cois.close();
        coos.close();
        return data_sale;
    }
    public static void sendAllTables(List<Autosalon> listautosalon, List<Automobile> listautomobile, List<Clients> listclients, List<Sale> listsale, List<Presale> listpresale) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 2525);
        ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание потока вывода
        try{
            coos.writeObject("перезапись");
            coos.writeObject(listautosalon);
            coos.writeObject(listautomobile);
            coos.writeObject(listclients);
            coos.writeObject(listsale);
            coos.writeObject(listpresale);
        }catch (Exception e){
            e.printStackTrace();
        }
        clientSocket.close();
        coos.close();
    }

    public static void sendTablePresale(ArrayList<String> list, ArrayList<String> list2) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 2525);
        ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание потока вывода
        ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());//создание потока ввода
        try{
            coos.writeObject("предзаказ");
            coos.writeObject(list);
            coos.writeObject(list2);
        }catch (Exception e){
            e.printStackTrace();
        }
        clientSocket.close();
        cois.close();
        coos.close();
    }

    public ArrayList<String> method_presale() throws IOException {
        ArrayList<String> data_presale = new ArrayList<String>();
        Socket clientSocket = new Socket("127.0.0.1", 2525);
        ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание потока вывода
        ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());//создание потока ввода
        try{
            coos.writeObject("предзаказполучаем");
            data_presale = (ArrayList<String>) cois.readObject();
        }catch (ClassNotFoundException e){
            method_presale();
        }
        clientSocket.close();
        cois.close();
        coos.close();
        return data_presale;
    }
}
