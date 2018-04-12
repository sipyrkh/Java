//  import com.sun.security.ntlm.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Controller {
    //-------------Окно авторизации----------
    @FXML
    private TextField username_reg;
    @FXML
    private PasswordField password_reg;
    @FXML
    private Button Button_create;
    //-------------Окно регистрации----------
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button Button_log;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField patronymic;
    @FXML
    private TextField passport;
    @FXML
    public void registration() throws IOException { // функция регистрации
        Stage stage = (Stage) Button_create.getScene().getWindow();
        stage = new Stage();
        int error = clientConnection.registration(username_reg.getText(), password_reg.getText());
        if(error == 0){
            JOptionPane.showMessageDialog(null, "Вы успешно зарегистрировались!");
        }else{
            JOptionPane.showMessageDialog(null, "Такой пользователь уже существует!");
        }
        username_reg.clear();
        password_reg.clear();
    }
    @FXML
    public void login() throws IOException {  //функция авторизации
        int role = clientConnection.login(username.getText(), password.getText());
        Check ch = new Check();
        ch.setCheck_log(role);
        System.out.println(role);
        if(role != 1 && role != 0){
            JOptionPane.showMessageDialog(null, "Неверный логин и/или пароль!");
            username.clear();
            password.clear();
        }else{
            try{
                    Stage stage  = (Stage) Button_log.getScene().getWindow();
                    stage.close();
                    stage = new Stage();
                    Parent root1 = FXMLLoader.load(getClass().getResource("adminList.fxml"));
                    stage.setTitle("Программа продажи авто");
                    stage.setScene(new Scene(root1));
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.show();
            }catch (IOException e){
                    e.printStackTrace();
            }
        }
    }
}
