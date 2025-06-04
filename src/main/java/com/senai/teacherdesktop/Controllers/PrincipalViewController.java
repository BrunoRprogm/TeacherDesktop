package com.senai.teacherdesktop.Controllers;

import com.senai.teacherdesktop.Models.SchoolClass;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

//Classe da tela principal do professor.
public class PrincipalViewController {
    @FXML
    public Button btnExit;

    @FXML
    private TableView<SchoolClass> tableListStudent;

    @FXML
    private TableColumn<SchoolClass, Integer> tableID;

    @FXML
    private TableColumn<SchoolClass, String> tableName;

    @FXML
    private TableColumn<SchoolClass, Void> tableAction;


    @FXML
    public void initialize(){
        //Configura as colunas de nome e id da classe SchoolClass na tabela estática principal do professor.
        tableID.setCellValueFactory(new PropertyValueFactory<>("idClass"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("nameClass"));

        SchoolClass schoolClass1 = new SchoolClass(1,"1° Ano A",30);
        SchoolClass schoolClass2 = new SchoolClass(2,"2° Ano B",25);
        tableListStudent.getItems().addAll(Arrays.asList(schoolClass1,schoolClass2));
    }

    public void btnExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public boolean confirmLogout(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); //

        alert.setTitle("Confirmação de saída");
        alert.setHeaderText(null); // Deixando null para que não haja subtitulo
        alert.setContentText("Realmente deseja sair ?");

        ButtonType buttonYes =new ButtonType ("Sim");
        ButtonType buttonNo = new ButtonType("Não");

        alert.getButtonTypes().setAll(buttonYes,buttonNo);

        Optional<ButtonType> resultado = alert.showAndWait(); //Optional = "Pode haver algo" mas "Pode não haver algo"

        if (resultado.isPresent() && resultado.get() == buttonYes) {
            Platform.exit();
            return true;
        }

        return false;
    }
}
