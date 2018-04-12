import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class serverConnection {
    public static void serverconnection() {
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;//объявление объекта класса Socket
        ObjectInputStream sois = null;//объявление байтового потока ввода
        ObjectOutputStream soos = null;//объявление байтового потока вывода
        while(true) try {
            System.out.println("Начало работы сервера...");
            serverSocket = new ServerSocket(2525);//создание сокета сервера для заданного порта
            clientAccepted = serverSocket.accept();//выполнение метода, который обеспечивает реальное подключение сервера к клиенту
            System.out.println("Соединение установлено...");//создание потока ввода soos = new
            sois = new ObjectInputStream(clientAccepted.getInputStream());
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());//создание потока вывода
            String pointer = (String) sois.readObject();
            if (pointer.equals("авторизация")) {
                String username = (String) sois.readObject();
                String password = (String) sois.readObject();
                int role = myDatabase.login(username, password);
                soos.writeObject(role);
            }
            if (pointer.equals("регистрация")) {
                String username = (String) sois.readObject();
                String password = (String) sois.readObject();
                int error = myDatabase.registration(username, password);
                soos.writeObject(error);
            }
            if (pointer.equals("автосалон")) {
                myDatabase db = new myDatabase();
                ArrayList<String> list = new ArrayList<String>();
                list = db.selectautosalon();
                soos.writeObject(list);
            }
            if (pointer.equals("автомобиль")) {
                myDatabase db = new myDatabase();
                ArrayList<String> list = new ArrayList<String>();
                list = db.selectautomobile();
                soos.writeObject(list);
            }
            if (pointer.equals("клиенты")) {
                myDatabase db = new myDatabase();
                ArrayList<String> list = new ArrayList<String>();
                list = db.selectclients();
                soos.writeObject(list);
            }
            if (pointer.equals("продажа")) {
                myDatabase db = new myDatabase();
                ArrayList<String> list = new ArrayList<String>();
                list = db.selectsale();
                soos.writeObject(list);
            }
            if (pointer.equals("перезапись")) {
                List<Autosalon> autosalons;
                List<Automobile> automobiles;
                List<Clients> clients;
                List<Sale> sale;
                List<Presale> presale;
                autosalons = (List<Autosalon>) sois.readObject();
                automobiles = (List<Automobile>) sois.readObject();
                clients = (List<Clients>) sois.readObject();
                sale = (List<Sale>) sois.readObject();
                presale = (List<Presale>) sois.readObject();
                for(Automobile a:automobiles) {
                    System.out.println("Тут значения - " + a.getName_auto() + " " + a.getAutosalon_for_automobiles());
                }
                myDatabase.InsertTabAutosalon(autosalons);
                myDatabase.InsertTabAutomobile(automobiles);
                myDatabase.InsertTabClients(clients);
                myDatabase.InsertTabSale(sale);
                myDatabase.InsertTabPresale(presale);
            }
            if(pointer.equals("предзаказ")){
                myDatabase db =new myDatabase();
                ArrayList<String> list = new ArrayList<String>();
                list = (ArrayList<String>) sois.readObject();
                myDatabase.InsertListPresale(list);
                ArrayList<String> list2 = new ArrayList<String>();
                list2 = (ArrayList<String>) sois.readObject();
                db.InsertUserClients(list2);
            }
            if(pointer.equals("предзаказполучаем")){
                myDatabase db = new myDatabase();
                ArrayList<String> list = new ArrayList<String>();
                list = db.selectpresale();
                soos.writeObject(list);
            }
        } catch (Exception e) {
        } finally {
            try {
                sois.close();
                soos.close();
                clientAccepted.close();
                serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();//вызывается метод исключения е
            }
        }
    }
}
