import java.io.Serializable;
public class Automobile implements Serializable {
    private String Name_auto;
    private String Model_auto;
    private String Year_auto;
    private String Color_auto;
    private String Price_auto;
    private String Mileage_auto;
    private String Autosalon_for_automobiles;
    public Automobile(String Name_auto,String Model_auto,String Year_auto,String Color_auto,String Price_auto,String Mileage_auto, String Autosalon_for_automobiles){
        this.Name_auto = Name_auto;
        this.Model_auto = Model_auto;
        this.Year_auto = Year_auto;
        this.Color_auto = Color_auto;
        this.Price_auto = Price_auto;
        this.Mileage_auto = Mileage_auto;
        this.Autosalon_for_automobiles = Autosalon_for_automobiles;
    }

    public String getAutosalon_for_automobiles() {
        return Autosalon_for_automobiles;
    }

    public void setAutosalon_for_automobiles(String autosalon_for_automobiles) {
        Autosalon_for_automobiles = autosalon_for_automobiles;
    }

    public Automobile(){}

    public String getName_auto() {
        return Name_auto;
    }

    public void setName_auto(String name_auto) {
        Name_auto = name_auto;
    }

    public String getModel_auto() {
        return Model_auto;
    }

    public void setModel_auto(String model_auto) {
        Model_auto = model_auto;
    }

    public String getYear_auto() {
        return Year_auto;
    }

    public void setYear_auto(String year_auto) {
        Year_auto = year_auto;
    }

    public String getColor_auto() {
        return Color_auto;
    }

    public void setColor_auto(String color_auto) {
        Color_auto = color_auto;
    }

    public String getPrice_auto() {
        return Price_auto;
    }

    public void setPrice_auto(String price_auto) {
        Price_auto = price_auto;
    }

    public String getMileage_auto() {
        return Mileage_auto;
    }

    public void setMileage_auto(String mileage_auto) {
        Mileage_auto = mileage_auto;
    }
}