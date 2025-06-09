package com.senai.teacherdesktop.Controllers;

import com.senai.teacherdesktop.DAO.UserDAO;
import com.senai.teacherdesktop.Models.User;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private PasswordField txtPassoword;

    @FXML
    private TextField txtUser;

    private UserDAO userDAO = new UserDAO();

    @FXML
    void btnEnter(ActionEvent event) throws IOException {
        String email = txtUser.getText().trim();
        String senha = txtPassoword.getText().trim();

        if(email.isEmpty() || senha.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Inválido");
            alert.setHeaderText(null);
            alert.setContentText("Senha ou Email inválidos");
            alert.show();
            return;
        }

        User user = userDAO.autenticar(email, senha);

        if(user != null) {
            // login OK, abre a próxima tela
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/senai/teacherdesktop/views/principal-view.fxml"));
            Parent root = fxmlLoader.load();


            PrincipalViewController controller = fxmlLoader.getController();

            controller.setTxtNameProfessor(user);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Tela Principal");
            stage.setScene(scene);
            stage.show();

            // fecha janela atual (login)
            Stage stagee  = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stagee.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha no Login");
            alert.setHeaderText(null);
            alert.setContentText("Usuário ou senha incorretos");
            alert.show();
        }
    }

    @FXML
    void btnExit(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
