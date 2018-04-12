import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.Calendar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerAdmin {
    //---------------Кнопка выхода из учётной записи----
    @FXML
    private Button exit;
    //---------------Кнопкка сохранения-----------------
    @FXML
    private Button Save_changes;
    @FXML
    private Tab Tab_sale;
    @FXML
    private Tab List_clients;
    @FXML
    private Button Button_file;
    @FXML
    private Group group_auto;
    @FXML
    private Group group_salon;
    @FXML
    private Button Button_presale;
    @FXML
    private Group group_presale;
    @FXML
    private Label Label_sale;
    @FXML
    private Button delete_client;
    //------------ID-файлы для таблицы предродажи-------
    @FXML
    private TableView<Presale> Table_presale;
    @FXML
    private TableColumn<Presale, String> Date_presale;
    @FXML
    private TableColumn<Presale, String> Autosalon_name_presale;
    @FXML
    private TableColumn<Presale, String> Automobile_name_presale;
    @FXML
    private TableColumn<Presale, String> Automobile_model_presale;
    @FXML
    private TableColumn<Presale, String> Clients_surname_presale;
    @FXML
    private TableColumn<Presale, String> Clients_name_presale;
    @FXML
    private TableColumn<Presale, String> Clients_patr_presale;
    @FXML
    private ObservableList<Presale> listpresale = FXCollections.observableArrayList();
    @FXML
    private TextField Presale_surname;
    @FXML
    private TextField Presale_name;
    @FXML
    private TextField Presale_patronymic;
    @FXML
    private TextField Presale_passport;
    //------------ID-файлы для таблицы продажа----------
    @FXML
    private ObservableList<Sale> sale = FXCollections.observableArrayList();
    @FXML
    private TableView<Sale> Table_sale;
    @FXML
    private TableColumn<Sale, String> Date_sale;
    @FXML
    private TableColumn<Sale, String> Autosalon_name;
    @FXML
    private TableColumn<Sale, String> Automobile_name;
    @FXML
    private TableColumn<Sale, String> Automobile_model;
    @FXML
    private TableColumn<Sale, String> Clients_surname;
    @FXML
    private TableColumn<Sale, String> Clients_name;
    @FXML
    private TableColumn<Sale, String> Clients_patr;
    @FXML
    private TextField Date_input;
    @FXML
    private Button Button_sale;
    // -----------ID-файлы для таблицы автосалона-------
    @FXML
    private ObservableList<Autosalon> autosalons = FXCollections.observableArrayList();
    @FXML
    private TableView<Autosalon> Table_salon;
    @FXML
    private TableColumn<Autosalon, String> Name_salon;
    @FXML
    private TableColumn<Autosalon, String> Adress_salon;
    @FXML
    private TextField Add_name_salon;
    @FXML
    private TextField Add_adress_salon;
    // -----------ID-файлы для таблицы автомобилей-------
    @FXML
    private ObservableList<Automobile> automobiles = FXCollections.observableArrayList();
    @FXML
    private TableView<Automobile> Table_auto;
    @FXML
    private TableColumn<Automobile, String> Name_auto;
    @FXML
    private TableColumn<Automobile, String> Model_auto;
    @FXML
    private TableColumn<Automobile, String> Year_auto;
    @FXML
    private TableColumn<Automobile, String> Color_auto;
    @FXML
    private TableColumn<Automobile, String> Price_auto;
    @FXML
    private TableColumn<Automobile, String> Mileage_auto;
    @FXML
    private TableColumn<Automobile, String> Autosalon_for_automobiles;
    @FXML
    private TextField Add_name_auto;
    @FXML
    private TextField Add_model_auto;
    @FXML
    private TextField Add_year_auto;
    @FXML
    private TextField Add_color_auto;
    @FXML
    private TextField Add_price_auto;
    @FXML
    private TextField Add_mileage_auto;
    @FXML
    private TextField Add_Autosalon_for_automobiles;
    @FXML
    private ComboBox<String> cmpresale;
    @FXML
    ObservableList<String> obspresale = FXCollections.observableArrayList();
    // -----------ID-файлы для таблицы клиенты-------
    @FXML
    private ObservableList<Clients> clients =FXCollections.observableArrayList();
    @FXML
    private TableView<Clients> Table_clients;
    @FXML
    private TableColumn<Clients, String> Surname_clients;
    @FXML
    private TableColumn<Clients, String> Name_clients;
    @FXML
    private TableColumn<Clients, String> Pasport_clients;
    @FXML
    private TableColumn<Clients, String> Patr_clients;
    @FXML
    private TextField Add_surname_clients;
    @FXML
    private TextField Add_name_clients;
    @FXML
    private TextField Add_patronymic_clients;
    @FXML
    private TextField Add_passport_clients;
    @FXML
    private PieChart pieChart;
    @FXML
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    @FXML
    private void initialize() throws IOException {
        if(Check.getCheck_log() == 0){
            Tab_sale.setText("Предзаказ");
            List_clients.setDisable(true);
            Save_changes.setVisible(false);
            Button_file.setVisible(false);
            Button_sale.setVisible(false);
            group_auto.setVisible(false);
            group_salon.setVisible(false);
            Table_salon.setPrefHeight(368);
            Table_auto.setPrefHeight(369);
            Table_sale.setVisible(false);
            //--------Изменение кнопки пожелания------
            Button_presale.setPrefHeight(37);
            Button_presale.setPrefWidth(641);
            Button_presale.setLayoutX(6);
            Button_presale.setLayoutY(351);
            exit.setLayoutY(138);
            Label_sale.setText("Дата предзаказа");
            Button_presale.setVisible(true);
            Table_presale.setVisible(false);
            delete_client.setVisible(false);
            group_presale.setVisible(true);
        }
        Button_sale.setPrefWidth(645);
        Table_sale.setPrefHeight(155);
        Table_presale.setLayoutY(143);
        Table_presale.setPrefHeight(154);

        initData();
        Diagram();
        Name_salon.setCellValueFactory(new PropertyValueFactory<Autosalon, String>("Name_salon"));
        Adress_salon.setCellValueFactory(new PropertyValueFactory<Autosalon, String>("Adress_salon"));
        Table_salon.setItems(autosalons);

        Name_auto.setCellValueFactory(new PropertyValueFactory<Automobile, String>("Name_auto"));
        Model_auto.setCellValueFactory(new PropertyValueFactory<Automobile, String>("Model_auto"));
        Year_auto.setCellValueFactory(new PropertyValueFactory<Automobile, String>("Year_auto"));
        Color_auto.setCellValueFactory(new PropertyValueFactory<Automobile, String>("Color_auto"));
        Price_auto.setCellValueFactory(new PropertyValueFactory<Automobile, String>("Price_auto"));
        Mileage_auto.setCellValueFactory(new PropertyValueFactory<Automobile, String>("Mileage_auto"));
        Autosalon_for_automobiles.setCellValueFactory(new PropertyValueFactory<Automobile, String>("Autosalon_for_automobiles"));
        Table_auto.setItems(automobiles);

        Surname_clients.setCellValueFactory(new PropertyValueFactory<Clients, String>("Surname_clients"));
        Name_clients.setCellValueFactory(new PropertyValueFactory<Clients, String>("Name_clients"));
        Patr_clients.setCellValueFactory(new PropertyValueFactory<Clients, String>("Patr_clients"));
        Pasport_clients.setCellValueFactory(new PropertyValueFactory<Clients, String>("Pasport_clients"));
        Table_clients.setItems(clients);

        Date_sale.setCellValueFactory(new PropertyValueFactory<Sale, String>("Date_sale"));
        Autosalon_name.setCellValueFactory(new PropertyValueFactory<Sale, String>("Autosalon_name"));
        Automobile_name.setCellValueFactory(new PropertyValueFactory<Sale, String>("Automobile_name"));
        Automobile_model.setCellValueFactory(new PropertyValueFactory<Sale, String>("Automobile_model"));
        Clients_surname.setCellValueFactory(new PropertyValueFactory<Sale, String>("Clients_surname"));
        Clients_name.setCellValueFactory(new PropertyValueFactory<Sale, String>("Clients_name"));
        Clients_patr.setCellValueFactory(new PropertyValueFactory<Sale, String>("Clients_patr"));
        Table_sale.setItems(sale);

        Date_presale.setCellValueFactory(new PropertyValueFactory<Presale, String>("Date_presale"));
        Autosalon_name_presale.setCellValueFactory(new PropertyValueFactory<Presale, String>("Autosalon_name_presale"));
        Automobile_name_presale.setCellValueFactory(new PropertyValueFactory<Presale, String>("Automobile_name_presale"));
        Automobile_model_presale.setCellValueFactory(new PropertyValueFactory<Presale, String>("Automobile_model_presale"));
        Clients_surname_presale.setCellValueFactory(new PropertyValueFactory<Presale, String>("Clients_surname_presale"));
        Clients_name_presale.setCellValueFactory(new PropertyValueFactory<Presale, String>("Clients_name_presale"));
        Clients_patr_presale.setCellValueFactory(new PropertyValueFactory<Presale, String>("Clients_patr_presale"));
        Table_presale.setItems(listpresale);

        cmpresale.setItems(obspresale);

        pieChart.setTitle("Статистика продаж автомобилей") ;
        pieChart.setClockwise(true) ;
        pieChart.setLabelLineLength(50) ;
        pieChart.setLabelsVisible(true) ;
        pieChart.setStartAngle(180) ;
    }
    private void initData() throws IOException {
        clientConnection cl = new clientConnection();
        ArrayList<String> list;
        ArrayList<String> list2;
        ArrayList<String> list3;
        ArrayList<String> listsale;
        ArrayList<String> listpresale1;
        try {
            list = cl.method_autosalon();
        } catch (IOException e) {
            list = cl.method_autosalon();
        }
        for(int i =1;i<list.size();i=i+2){
            autosalons.add(new Autosalon(list.get(i-1), list.get(i)));
        }
        try {
            list2 = cl.method_automobile();
        } catch (IOException e) {
            list2 = cl.method_automobile();
        }
        for(int i = 6;i< list2.size(); i=i+7){
            automobiles.add(new Automobile(list2.get(i-5), list2.get(i-6), list2.get(i-4), list2.get(i-3), list2.get(i-2), list2.get(i-1), list2.get(i)));
        }
        try {
            list3 = cl.method_clients();
        } catch (IOException e) {
            list3 = cl.method_clients();
        }
        for(int i=3;i<list3.size();i=i+4){
            clients.add(new Clients(list3.get(i-3), list3.get(i-2), list3.get(i), list3.get(i-1)));
        }
        try {
            listsale = cl.method_sale();
        } catch (IOException e) {
            listsale = cl.method_sale();
        }
        for(int i = 6; i<listsale.size(); i = i+7){
            sale.add(new Sale(listsale.get(i-6), listsale.get(i-5), listsale.get(i-4), listsale.get(i-3), listsale.get(i-2), listsale.get(i-1), listsale.get(i)));
        }
        try {
            listpresale1 = cl.method_presale();
        } catch (IOException e) {
            listpresale1 = cl.method_presale();
        }
        for(int i = 6; i<listpresale1.size(); i = i+7){
            listpresale.add(new Presale(listpresale1.get(i-6), listpresale1.get(i-5), listpresale1.get(i-4), listpresale1.get(i-3), listpresale1.get(i-2), listpresale1.get(i-1), listpresale1.get(i)));
        }
        ArrayList<String> list4 = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);
        String day2 = String.valueOf(day);
        String month2 = String.valueOf(month);
        String year2 = String.valueOf(year);
        list4.add(day2);
        list4.add(month2);
        list4.add(year2);
        String date = day2 + "."+ month2 + "." +year2;
        Date_input.setText(date);
        ArrayList<String> list_name_autosalons = new ArrayList<String>();
        for(Autosalon a:autosalons){
            list_name_autosalons.add(a.getName_salon());
        }
        for(int i =0;i<list_name_autosalons.size(); i++){
            obspresale.add(list_name_autosalons.get(i));
        }
        cmpresale.setValue(list_name_autosalons.get(0));
    }
    @FXML
    private void Button_addsalo() throws IOException, InterruptedException {
        int error_add = 0;
        ArrayList<String> listaddsalon = new ArrayList<String>();
        String name_salon = Add_name_salon.getText().trim();
        obspresale.add(name_salon);
        String adress_salon = Add_adress_salon.getText().trim();
        if(name_salon.isEmpty() || adress_salon.isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля для добавления!");
            error_add = 1;
        }
        for(Autosalon a:autosalons){
            if(a.getName_salon().equals(name_salon) || a.getAdress_salon().equals(adress_salon)){
                JOptionPane.showMessageDialog(null, "Такой автосалон уже существует!!");
                error_add = 1;
            }
        }
        if(error_add == 0) {
            listaddsalon.add(name_salon);
            listaddsalon.add(adress_salon);
            autosalons.add(new Autosalon(listaddsalon.get(0), listaddsalon.get(1)));
            Add_name_salon.clear();
            Add_adress_salon.clear();
        }
    }
    @FXML
    private void Button_addsauto() throws IOException, InterruptedException{
        int error_add = 0;
        ArrayList<String> listaddauto = new ArrayList<String>();
        String name_auto = Add_name_auto.getText().trim();
        String model_auto = Add_model_auto.getText().trim();
        String year_auto = Add_year_auto.getText().trim();
        String color_auto = Add_color_auto.getText().trim();
        String price_auto = Add_price_auto.getText().trim();
        String mileage_auto = Add_mileage_auto.getText().trim();
        String autosalon_automobiles = cmpresale.getValue();
        if(name_auto.isEmpty() || model_auto.isEmpty() || year_auto.isEmpty() || color_auto.isEmpty() || price_auto.isEmpty() || mileage_auto.isEmpty() || autosalon_automobiles.isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля для добавления!");
            error_add = 1;
        }
        for(Automobile a:automobiles){
            if(a.getAutosalon_for_automobiles().equals(autosalon_automobiles) & a.getName_auto().equals(name_auto) & a.getModel_auto().equals(model_auto) & a.getYear_auto().equals(year_auto) & a.getPrice_auto().equals(price_auto) & a.getMileage_auto().equals(mileage_auto) & a.getColor_auto().equals(color_auto)){
                JOptionPane.showMessageDialog(null, "Такой автомобиль уже существует!");
                error_add = 1;
            }
        }
        if(error_add == 0){
            listaddauto.add(name_auto);
            listaddauto.add(model_auto);
            listaddauto.add(year_auto);
            listaddauto.add(color_auto);
            listaddauto.add(price_auto);
            listaddauto.add(mileage_auto);
            listaddauto.add(autosalon_automobiles);
            automobiles.add(new Automobile(listaddauto.get(0), listaddauto.get(1), listaddauto.get(2), listaddauto.get(3), listaddauto.get(4), listaddauto.get(5), listaddauto.get(6)));
            Add_name_auto.clear();
            Add_model_auto.clear();
            Add_year_auto.clear();
            Add_color_auto.clear();
            Add_price_auto.clear();
            Add_mileage_auto.clear();
        }
    }
    @FXML
    private void Button_addsclients() throws IOException, InterruptedException{
        int error_add = 0;
        ArrayList<String> listaddclients = new ArrayList<String>();
        String surname_clients = Add_surname_clients.getText();
        String name_clients = Add_name_clients.getText();
        String patronymic_clients = Add_patronymic_clients.getText();
        String passport_clients = Add_passport_clients.getText();
        if(surname_clients.isEmpty() || name_clients.isEmpty() || patronymic_clients.isEmpty() || passport_clients.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Заполните все поля для добавления!");
        }
        for(Clients a:clients){
            if(a.getSurname_clients().equals(surname_clients) & a.getName_clients().equals(name_clients) & a.getPatr_clients().equals(patronymic_clients) & a.getPasport_clients().equals(passport_clients)){
                JOptionPane.showMessageDialog(null, "Такой клиент уже существует в базу!");
                error_add = 1;
            }
        }
        if(error_add == 0){
            listaddclients.add(surname_clients);
            listaddclients.add(name_clients);
            listaddclients.add(patronymic_clients);
            listaddclients.add(passport_clients);
            clients.add(new Clients(listaddclients.get(0), listaddclients.get(1), listaddclients.get(3), listaddclients.get(2)));
            Add_surname_clients.clear();
            Add_name_clients.clear();
            Add_patronymic_clients.clear();
            Add_passport_clients.clear();
        }
    }
    @FXML
    private void SetSalon(){
        int selectedIndex = Table_salon.getSelectionModel().getSelectedIndex();
        Autosalon auto = new Autosalon(Add_name_salon.getText(), Add_adress_salon.getText());
        if(Add_name_salon.getText().isEmpty() || Add_adress_salon.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля для изменения!");
        }else {
            Table_salon.getItems().set(selectedIndex, auto);
            Add_name_salon.clear();
            Add_adress_salon.clear();
        }
    }
    @FXML
    private void SetAuto(){
        int selectedIndex = Table_auto.getSelectionModel().getSelectedIndex();
        Automobile auto = new Automobile(Add_name_auto.getText(), Add_model_auto.getText(), Add_year_auto.getText(), Add_color_auto.getText(), Add_price_auto.getText(), Add_mileage_auto.getText(), Add_Autosalon_for_automobiles.getText());
        if(Add_name_auto.getText().isEmpty() || Add_model_auto.getText().isEmpty() || Add_year_auto.getText().isEmpty() || Add_color_auto.getText().isEmpty() || Add_price_auto.getText().isEmpty() || Add_mileage_auto.getText().isEmpty() || Add_Autosalon_for_automobiles.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля для изменения!");
        }else {
            Table_auto.getItems().set(selectedIndex, auto);
            Add_name_auto.clear();
            Add_model_auto.clear();
            Add_year_auto.clear();
            Add_color_auto.clear();
            Add_price_auto.clear();
            Add_mileage_auto.clear();
            Add_Autosalon_for_automobiles.clear();
        }
    }
    @FXML
    private void SetClients(){
        int selectedIndex = Table_clients.getSelectionModel().getSelectedIndex();
        Clients clients = new Clients(Add_surname_clients.getText(), Add_name_clients.getText(), Add_passport_clients.getText(), Add_patronymic_clients.getText());
        if(Add_surname_clients.getText().isEmpty() || Add_name_clients.getText().isEmpty() || Add_passport_clients.getText().isEmpty() || Add_patronymic_clients.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все поля для изменения!");
        }else{
            Table_clients.getItems().set(selectedIndex, clients);
            Add_surname_clients.clear();
            Add_name_clients.clear();
            Add_patronymic_clients.clear();
            Add_passport_clients.clear();
        }
    }
    @FXML
    private void DeleteSalon() {
        int selectedIndex = Table_salon.getSelectionModel().getSelectedIndex();
        Table_salon.getItems().remove(selectedIndex);
    }
    @FXML
    private void DeleteAutomobile() {
        int selectedIndex = Table_auto.getSelectionModel().getSelectedIndex();
        Table_auto.getItems().remove(selectedIndex);
    }
    @FXML
    private void DeleteClients() {
        int selectedIndex = Table_clients.getSelectionModel().getSelectedIndex();
        System.out.println(selectedIndex);
        Table_clients.getItems().remove(selectedIndex);
    }
    @FXML
    private void method_exit() throws IOException {
        try {
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();
            stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("StartWindow.fxml"));
            stage.setTitle("Авторизация");
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }catch (IOException e){
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();
            stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("StartWindow.fxml"));
            stage.setTitle("Авторизация");
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }
    }
    @FXML
    private void method_save() throws IOException, ClassNotFoundException {
        List <Autosalon> listautosalon;
        listautosalon = Table_salon.getItems().parallelStream().collect(Collectors.toList());
        List <Automobile> listautomobile;
        listautomobile = Table_auto.getItems().parallelStream().collect(Collectors.toList());
        List <Clients> listclients;
        listclients = Table_clients.getItems().parallelStream().collect(Collectors.toList());
        List <Sale> listsale;
        listsale = Table_sale.getItems().parallelStream().collect(Collectors.toList());
        List<Presale> listpresale;
        listpresale = Table_presale.getItems().parallelStream().collect(Collectors.toList());
        clientConnection.sendAllTables(listautosalon, listautomobile, listclients, listsale, listpresale);
    }
    @FXML
    public void method_sale() throws IOException {
        List<Autosalon> listautosalon = Table_salon.getSelectionModel().getSelectedItems();
        List<Automobile> listautomobile = Table_auto.getSelectionModel().getSelectedItems();
        List<Clients> listclients = Table_clients.getSelectionModel().getSelectedItems();
        String Date = Date_input.getText();
        String Autosalon_name = "", Automobile_name = "", Automobile_model = "", Surname_clients = "", Name_clients = "", Patr_clients = "";
        for(Autosalon a:listautosalon){
            Autosalon_name = a.getName_salon();
        }
        for(Automobile a:listautomobile){
            Automobile_name = a.getName_auto();
            Automobile_model = a.getModel_auto();
            Autosalon_name = a.getAutosalon_for_automobiles();
        }
        for(Clients a:listclients){
            Surname_clients = a.getSurname_clients();
            Name_clients = a.getName_clients();
            Patr_clients = a.getPatr_clients();
        }
        ArrayList<String> listsale = new ArrayList<String>();
        listsale.add(Date);
        listsale.add(Autosalon_name);
        listsale.add(Automobile_name);
        listsale.add(Automobile_model);
        listsale.add(Surname_clients);
        listsale.add(Name_clients);
        listsale.add(Patr_clients);
        if(Date.isEmpty() || Autosalon_name.isEmpty() || Automobile_model.isEmpty() || Automobile_name.isEmpty() || Surname_clients.isEmpty() || Name_clients.isEmpty() || Patr_clients.isEmpty()){
            JOptionPane.showMessageDialog(null, "Не выбрано одно из полей!");
        }
        else{
            DeleteAutomobile();
            DeleteClients();
            sale.add(new Sale(listsale.get(0), listsale.get(1), listsale.get(2), listsale.get(3), listsale.get(4), listsale.get(5), listsale.get(6)));
        }
        Diagram();
    }
    public void Diagram()
    {
        pieChartData.clear();
        ArrayList<String> diagrams_name = new ArrayList<String>();
        ArrayList<Integer> diagrams_number = new ArrayList<Integer>();
        for(int i = 0; i < sale.size(); i++){
            diagrams_name.add(sale.get(i).getAutomobile_name());
        }
        for(int i =0; i<diagrams_name.size(); i++){
            for(int j = i+1; j < diagrams_name.size(); j++){
                if(diagrams_name.get(i).equals(diagrams_name.get(j))){
                    diagrams_name.remove(j);
                    j--;
                }
            }
        }
        int k = 0;
        for(int i =0; i<diagrams_name.size(); i++){
            k =0;
            for(int j = 0; j < sale.size(); j++){
                if(diagrams_name.get(i).equals(sale.get(j).getAutomobile_name())){
                    k++;
                }
            }
            diagrams_number.add(k);
        }
        for(int i =0; i<diagrams_name.size(); i++) {
            pieChartData.add(new PieChart.Data(diagrams_name.get(i), diagrams_number.get(i)));
        }
        pieChart.setData(pieChartData);
    }
    @FXML
    public void method_save_file() throws IOException {
        JOptionPane.showMessageDialog(null, "Оформленные продажи автомобилей будут сохранены в файл .../Statistic.txt");
        List <Sale> list_file;
        list_file = Table_sale.getItems().parallelStream().collect(Collectors.toList());
        ArrayList<String> list_string = new ArrayList<String>();
        for(Sale a:list_file){
            list_string.add(a.getDate_sale());
            list_string.add(a.getAutosalon_name());
            list_string.add(a.getAutomobile_name());
            list_string.add(a.getAutomobile_model());
            list_string.add(a.getClients_surname());
            list_string.add(a.getClients_name());
            list_string.add(a.getClients_patr());
            list_string.add(System.lineSeparator());
        }
        System.out.println(list_string);
        FileWriter wf = new FileWriter("Statistic.txt");
        wf.write(String.valueOf(list_string));
        wf.close();
    }
    @FXML
    public void method_presale() throws IOException {
        List<Automobile> listautomobile = Table_auto.getSelectionModel().getSelectedItems();
        String Autosalon_name = "", Automobile_name = "", Automobile_model = "";
        String Date = Date_input.getText();
        for(Automobile a:listautomobile){
            Automobile_name = a.getName_auto();
            Automobile_model = a.getModel_auto();
            Autosalon_name = a.getAutosalon_for_automobiles();
        }
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add(Presale_name.getText());
        list2.add(Presale_surname.getText());
        list2.add(Presale_patronymic.getText());
        list2.add(Presale_passport.getText());
        ArrayList<String> list = new ArrayList<String>();
        list.add(Date);
        list.add(Autosalon_name);
        list.add(Automobile_name);
        list.add(Automobile_model);
        list.add(Presale_surname.getText());
        list.add(Presale_name.getText());
        list.add(Presale_patronymic.getText());
        if(Date.isEmpty() || Autosalon_name.isEmpty() || Automobile_model.isEmpty() || Automobile_name.isEmpty() || Presale_surname.getText().isEmpty() || Presale_name.getText().isEmpty() || Presale_patronymic.getText().isEmpty() || Presale_passport.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Заполните все данные!");
        }
        else {
            listpresale.add(new Presale(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6)));
            Presale_name.clear();
            Presale_patronymic.clear();
            Presale_surname.clear();
            Presale_passport.clear();
            clientConnection.sendTablePresale(list, list2);
            JOptionPane.showMessageDialog(null, "Вы успешно оставили заявку на автомобиль!");
        }
    }
    @FXML
    public void Del_presale(){
        int selectedIndex = Table_presale.getSelectionModel().getSelectedIndex();
        Table_presale.getItems().remove(selectedIndex);
    }
}