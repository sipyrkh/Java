import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class myDatabase {
        private static final String URL = "jdbc:mysql://localhost:3306/coursedb";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "root";
        private static final String CHECK_USERS = "select Login from authorization";
        private static final String SELECT_ALL = "select * from authorization where Login = ? and Password = ?";
        private static final String SELECT_TAB_PRESALE = "select * from presale";
        private static final String INSERT_REG = "insert into authorization values(?, ?, 0)";
        private static final String INSERT_TAB_AUTOSALON = "select Autosalon_name, Autosalon_adress  from autosalon";
        private static final String INSERT_TAB_AUTOMOBILE = "select Car_name, Car_model, Car_year, Car_color, Car_price, Car_mileage, Car_salon from automobile";
        private static final String INSERT_TAB_CLIENTS = "select Name, Surname, Patronymic,Passport_id from clients";
        private static final String INSERT_TAB_SALE = "select * from sale";
        private static final String INSERT_ALL_AUTOSALON = "insert into autosalon(Autosalon_name, Autosalon_adress) values(?,?)";
        private static final String INSERT_ALL_AUTOMOBILE = "insert into automobile(Car_name, Car_model, Car_year, Car_color, Car_price, Car_mileage, Car_salon) values(?,?,?,?,?,?,?)";
        private static final String INSERT_ALL_CLIENTS = "insert into clients(Name, Surname, Patronymic,Passport_id) values(?,?,?,?)";
        private static final String INSERT_ALL_SALE = "insert into sale values(?,?,?,?,?,?,?)";
        private static final String INSERT_ALL_PRESALE = "insert into presale values(?,?,?,?,?,?,?)";
        private static final String INSERT_TAB_PRESALE = "insert into presale values(?,?,?,?,?,?,?)";
        private static final String DELETE_TAB_AUTOSALON = "DELETE FROM autosalon";
        private static final String DELETE_TAB_AUTOMOBILE = "DELETE FROM automobile";
        private static final String DELETE_TAB_CLIENTS = "DELETE FROM clients";
        private static final String DELETE_TAB_SALE = "DELETE FROM sale";
        private static final String DELETE_TAB_PRESALE = "DELETE FROM presale";

    public static int login(String username, String password) {
        Connection connection;
        PreparedStatement preparedStatement;
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return resultSet.getInt("Role");
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
        return -1;
    }
    public static int registration(String username, String password){
        int error = 0;
        Connection connection;
        PreparedStatement preparedStatement, preparedStatement1;
        ArrayList<String> listcheck = new ArrayList<String>();
        try {
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                preparedStatement1 = connection.prepareStatement(CHECK_USERS);
                ResultSet resultSet = preparedStatement1.executeQuery();
                while(resultSet.next()){
                listcheck.add(resultSet.getString("Login"));
                }
                for(int i=0;i<listcheck.size(); i++){
                    if(listcheck.get(i).equals(username)) {
                        error = 1;
                    }
                }
                if(error != 1) {
                    preparedStatement = connection.prepareStatement(INSERT_REG);
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    preparedStatement.execute();
                    connection.close();
                }
            }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
            return 2;
        }
        return error;
    }public ArrayList<String> selectautosalon(){
        Connection connection;
        PreparedStatement preparedStatement;
        ArrayList<String> autosalon_data = new ArrayList<String>();
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_TAB_AUTOSALON);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                autosalon_data.add(resultSet.getString("Autosalon_name"));
                autosalon_data.add(resultSet.getString("Autosalon_adress"));
            }
            preparedStatement.execute();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
        return autosalon_data;
    }

    public ArrayList<String> selectautomobile(){
        Connection connection;
        PreparedStatement preparedStatement;
        ArrayList<String> automobile_data = new ArrayList<String>();
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_TAB_AUTOMOBILE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                automobile_data.add(resultSet.getString("Car_name"));
                automobile_data.add(resultSet.getString("Car_model"));
                automobile_data.add(String.valueOf(resultSet.getString("Car_year")));
                automobile_data.add(resultSet.getString("Car_color"));
                automobile_data.add(String.valueOf(resultSet.getString("Car_price")));
                automobile_data.add(String.valueOf(resultSet.getString("Car_mileage")));
                automobile_data.add(resultSet.getString("Car_salon"));
            }
            preparedStatement.execute();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
        return automobile_data;
    }
    public ArrayList<String> selectclients(){
        Connection connection;
        PreparedStatement preparedStatement;
        ArrayList<String> clients_data = new ArrayList<String>();
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_TAB_CLIENTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                clients_data.add(resultSet.getString("Surname"));
                clients_data.add(resultSet.getString("Name"));
                clients_data.add(resultSet.getString("Patronymic"));
                clients_data.add(resultSet.getString("Passport_id"));
            }
            preparedStatement.execute();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
        return clients_data;
    }
    public ArrayList<String> selectsale(){
        Connection connection;
        PreparedStatement preparedStatement;
        ArrayList<String> sale_data = new ArrayList<String>();
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_TAB_SALE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                sale_data.add(resultSet.getString("Sale_data"));
                sale_data.add(resultSet.getString("Sale_autosalon_name"));
                sale_data.add(resultSet.getString("Sale_automobile_name"));
                sale_data.add(resultSet.getString("Sale_automobile_model"));
                sale_data.add(resultSet.getString("Sale_clients_surname"));
                sale_data.add(resultSet.getString("Sale_clients_name"));
                sale_data.add(resultSet.getString("Sale_clients_patr"));
            }
            preparedStatement.execute();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
        return sale_data;
    }
    public static void InsertTabAutosalon(List<Autosalon> autosalons){
        Connection connection;
        PreparedStatement preparedStatement, preparedStatement1;
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement1 = connection.prepareStatement(DELETE_TAB_AUTOSALON);
            preparedStatement1.execute();
            preparedStatement = connection.prepareStatement(INSERT_ALL_AUTOSALON);
            for(Autosalon a:autosalons){
                preparedStatement.setString(1, a.getName_salon());
                preparedStatement.setString(2, a.getAdress_salon());
                preparedStatement.execute();

            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
    }
    public static void InsertTabAutomobile(List<Automobile> automobiles){
        Connection connection;
        PreparedStatement preparedStatement, preparedStatement1;
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement1 = connection.prepareStatement(DELETE_TAB_AUTOMOBILE);
            preparedStatement1.execute();
            preparedStatement = connection.prepareStatement(INSERT_ALL_AUTOMOBILE);
            for(Automobile a:automobiles){
                preparedStatement.setString(2, a.getName_auto());
                preparedStatement.setString(1, a.getModel_auto());
                preparedStatement.setInt(3, Integer.parseInt(a.getYear_auto()));
                preparedStatement.setString(4,a.getColor_auto());
                preparedStatement.setInt(5, Integer.parseInt(a.getPrice_auto()));
                preparedStatement.setInt(6, Integer.parseInt(a.getMileage_auto()));
                preparedStatement.setString(7, a.getAutosalon_for_automobiles());
                preparedStatement.execute();
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
    }
    public static void InsertTabClients(List<Clients> clients){
        Connection connection;
        PreparedStatement preparedStatement, preparedStatement1;
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement1 = connection.prepareStatement(DELETE_TAB_CLIENTS);
            preparedStatement1.execute();
            preparedStatement = connection.prepareStatement(INSERT_ALL_CLIENTS);
            for(Clients a:clients){
                preparedStatement.setString(1, a.getName_clients());
                preparedStatement.setString(2, a.getSurname_clients());
                preparedStatement.setString(3 ,a.getPatr_clients());
                preparedStatement.setString(4, a.getPasport_clients());
                preparedStatement.execute();
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
    }
    public static void InsertTabPresale(List<Presale> presale) {
        Connection connection;
        PreparedStatement preparedStatement, preparedStatement1;
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement1 = connection.prepareStatement(DELETE_TAB_PRESALE);
            preparedStatement1.execute();
            preparedStatement = connection.prepareStatement(INSERT_ALL_PRESALE);
            for(Presale a:presale){
                preparedStatement.setString(1, a.getDate_presale());
                preparedStatement.setString(2, a.getAutosalon_name_presale());
                preparedStatement.setString(3 ,a.getAutomobile_name_presale());
                preparedStatement.setString(4, a.getAutomobile_model_presale());
                preparedStatement.setString(5, a.getClients_surname_presale());
                preparedStatement.setString(6, a.getClients_name_presale());
                preparedStatement.setString(7, a.getClients_patr_presale());
                preparedStatement.execute();
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
    }
    public static void InsertTabSale(List<Sale> sale){
        Connection connection;
        PreparedStatement preparedStatement, preparedStatement1;
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement1 = connection.prepareStatement(DELETE_TAB_SALE);
            preparedStatement1.execute();
            preparedStatement = connection.prepareStatement(INSERT_ALL_SALE);
            for(Sale a:sale){
                preparedStatement.setString(1, a.getDate_sale());
                preparedStatement.setString(2, a.getAutosalon_name());
                preparedStatement.setString(3, a.getAutomobile_name());
                preparedStatement.setString(4 ,a.getAutomobile_model());
                preparedStatement.setString(5, a.getClients_surname());
                preparedStatement.setString(6, a.getClients_name());
                preparedStatement.setString(7, a.getClients_patr());
                preparedStatement.execute();
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
    }

    public static void InsertListPresale(ArrayList<String> list) {
        System.out.println(list);
        Connection connection;
        PreparedStatement preparedStatement, preparedStatement1;
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_TAB_PRESALE);
            for(int i =6;i<list.size(); i=i+7) {
                preparedStatement.setString(1, list.get(i-6));
                preparedStatement.setString(2, list.get(i-5));
                preparedStatement.setString(3, list.get(i-4));
                preparedStatement.setString(4, list.get(i-3));
                preparedStatement.setString(5, list.get(i-2));
                preparedStatement.setString(6, list.get(i-1));
                preparedStatement.setString(7, list.get(i));
            }
            preparedStatement.execute();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
    }

    public ArrayList<String> selectpresale() {
        Connection connection;
        PreparedStatement preparedStatement;
        ArrayList<String> sale_data = new ArrayList<String>();
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(SELECT_TAB_PRESALE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                sale_data.add(resultSet.getString("Presale_data"));
                sale_data.add(resultSet.getString("Presale_autosalon_name"));
                sale_data.add(resultSet.getString("Presale_automobile_name"));
                sale_data.add(resultSet.getString("Presale_automobile_model"));
                sale_data.add(resultSet.getString("Presale_clients_surname"));
                sale_data.add(resultSet.getString("Presale_clients_name"));
                sale_data.add(resultSet.getString("Presale_clients_patr"));
            }
            preparedStatement.execute();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
        return sale_data;
    }

    public void InsertUserClients(ArrayList<String> list2) {
        Connection connection;
        PreparedStatement preparedStatement;
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_ALL_CLIENTS);
                preparedStatement.setString(1, list2.get(0));
                preparedStatement.setString(2, list2.get(1));
                preparedStatement.setString(3, list2.get(2));
                preparedStatement.setString(4, list2.get(3));
                preparedStatement.execute();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.err.println("Не удалось загрузить драйвер!");
        }
    }
}