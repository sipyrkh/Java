import java.io.Serializable;

public class Sale implements Serializable {
    private String Date_sale;
    private String Autosalon_name;
    private String Automobile_name;
    private String Automobile_model;
    private String Clients_surname;
    private String Clients_name;
    private String Clients_patr;

    public Sale(String date_sale, String autosalon_name, String automobile_name, String automobile_model, String clients_surname, String clients_name, String clients_patr) {
        Date_sale = date_sale;
        Autosalon_name = autosalon_name;
        Automobile_name = automobile_name;
        Automobile_model = automobile_model;
        Clients_surname = clients_surname;
        Clients_name = clients_name;
        Clients_patr = clients_patr;
    }

    public String getDate_sale() {
        return Date_sale;
    }

    public void setDate_sale(String date_sale) {
        Date_sale = date_sale;
    }

    public String getAutosalon_name() {
        return Autosalon_name;
    }

    public void setAutosalon_name(String autosalon_name) {
        Autosalon_name = autosalon_name;
    }

    public String getAutomobile_name() {
        return Automobile_name;
    }

    public void setAutomobile_name(String automobile_name) {
        Automobile_name = automobile_name;
    }

    public String getAutomobile_model() {
        return Automobile_model;
    }

    public void setAutomobile_model(String automobile_model) {
        Automobile_model = automobile_model;
    }

    public String getClients_surname() {
        return Clients_surname;
    }

    public void setClients_surname(String clients_surname) {
        Clients_surname = clients_surname;
    }

    public String getClients_name() {
        return Clients_name;
    }

    public void setClients_name(String clients_name) {
        Clients_name = clients_name;
    }

    public String getClients_patr() {
        return Clients_patr;
    }

    public void setClients_patr(String clients_patr) {
        Clients_patr = clients_patr;
    }
}