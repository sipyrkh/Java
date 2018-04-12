import java.io.Serializable;
public class Autosalon implements Serializable{
    private String Name_salon;
    private String Adress_salon;

    public Autosalon(String Name_salon, String Adress_salon){
        this.Name_salon = Name_salon;
        this.Adress_salon = Adress_salon;
    }
    public Autosalon(){
    }

    public String getName_salon() {
        return Name_salon;
    }

    public void setName_salon(String name_salon) {
        Name_salon = name_salon;
    }

    public String getAdress_salon() {
        return Adress_salon;
    }

    public void setAdress_salon(String adress_salon) {
        Adress_salon = adress_salon;
    }
}
