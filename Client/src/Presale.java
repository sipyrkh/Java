import java.io.Serializable;

public class Presale implements Serializable {
    private String Date_presale;
    private String Autosalon_name_presale;
    private String Automobile_name_presale;
    private String Automobile_model_presale;
    private String Clients_surname_presale;
    private String Clients_name_presale;
    private String Clients_patr_presale;

    public String getDate_presale() {
        return Date_presale;
    }

    public void setDate_presale(String date_presale) {
        Date_presale = date_presale;
    }

    public String getAutosalon_name_presale() {
        return Autosalon_name_presale;
    }

    public void setAutosalon_name_presale(String autosalon_name_presale) {
        Autosalon_name_presale = autosalon_name_presale;
    }

    public String getAutomobile_name_presale() {
        return Automobile_name_presale;
    }

    public void setAutomobile_name_presale(String automobile_name_presale) {
        Automobile_name_presale = automobile_name_presale;
    }

    public String getAutomobile_model_presale() {
        return Automobile_model_presale;
    }

    public void setAutomobile_model_presale(String automobile_model_presale) {
        Automobile_model_presale = automobile_model_presale;
    }

    public String getClients_surname_presale() {
        return Clients_surname_presale;
    }

    public void setClients_surname_presale(String clients_surname_presale) {
        Clients_surname_presale = clients_surname_presale;
    }

    public String getClients_name_presale() {
        return Clients_name_presale;
    }

    public void setClients_name_presale(String clients_name_presale) {
        Clients_name_presale = clients_name_presale;
    }

    public String getClients_patr_presale() {
        return Clients_patr_presale;
    }

    public void setClients_patr_presale(String clients_patr_presale) {
        Clients_patr_presale = clients_patr_presale;
    }

    public Presale(String date_presale, String autosalon_name_presale, String automobile_name_presale, String automobile_model_presale, String clients_surname_presale, String clients_name_presale, String clients_patr_presale) {

        Date_presale = date_presale;
        Autosalon_name_presale = autosalon_name_presale;
        Automobile_name_presale = automobile_name_presale;
        Automobile_model_presale = automobile_model_presale;
        Clients_surname_presale = clients_surname_presale;
        Clients_name_presale = clients_name_presale;
        Clients_patr_presale = clients_patr_presale;
    }
}