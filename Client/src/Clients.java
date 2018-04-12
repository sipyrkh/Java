import java.io.Serializable;

public class Clients implements Serializable {
    private String Surname_clients;
    private String Name_clients;
    private String Pasport_clients;
    private String Patr_clients;

    public Clients(String Surname_clients, String Name_clients,String Pasport_clients, String Patr_clients) {
        this.Surname_clients = Surname_clients;
        this.Name_clients = Name_clients;
        this.Pasport_clients = Pasport_clients;
        this.Patr_clients = Patr_clients;
    }

    public String getPatr_clients() {
        return Patr_clients;
    }

    public void setPatr_clients(String patr_clients) {
        Patr_clients = patr_clients;
    }

    public String getSurname_clients() {
        return Surname_clients;
    }

    public void setSurname_clients(String surname_clients) {
        Surname_clients = surname_clients;
    }

    public String getName_clients() {
        return Name_clients;
    }

    public void setName_clients(String name_clients) {
        Name_clients = name_clients;
    }

    public String getPasport_clients() {
        return Pasport_clients;
    }

    public void setPasport_clients(String pasport_clients) {
        Pasport_clients = pasport_clients;
    }
}