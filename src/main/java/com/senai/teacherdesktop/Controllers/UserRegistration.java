package com.senai.teacherdesktop.Controllers;
import com.senai.teacherdesktop.DAO.SchoolClassDAO;
import com.senai.teacherdesktop.Models.SchoolClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class UserRegistration {

    @FXML
    private TextField cdTurmaNova;
    private PrincipalViewController mainController;

    public void setMainController(PrincipalViewController controller){
        this.mainController = controller;
    }

    @FXML
    void btnCadastrar(ActionEvent event) {
        String turmaCadastrante = cdTurmaNova.getText();
        SchoolClass turmaCadastro = new SchoolClass();

        turmaCadastro.setNm_turma(turmaCadastrante);
        SchoolClassDAO turmaDAO = new SchoolClassDAO();


        try{
            turmaDAO.cadastrarTurma(turmaCadastro);


            if(mainController != null){
                mainController.atualizarLista();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro realizado!");
            alert.setHeaderText(null);
            alert.setHeaderText("Turma cadastrada com sucesso!");
            alert.showAndWait();


            Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cdTurmaNova.setText("");
    }



}

