package com.senai.teacherdesktop.Controllers;

import com.senai.teacherdesktop.DAO.SchoolClassDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class DeleteClassController {

    @FXML
    private TextField insercaoID;

    private PrincipalViewController mainController;

    public void setMainController(PrincipalViewController mainController) {
        this.mainController = mainController;
    }
    @FXML
  public  void btnExcluirTurma(ActionEvent event){
        try{
            int id = Integer.parseInt(insercaoID.getText());

            SchoolClassDAO dao = new SchoolClassDAO();
            dao.excluirTurma(id);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso!");
            alert.setHeaderText(null);
            alert.setContentText("Turma exluida com sucesso!");
            alert.showAndWait();

            if(mainController != null){
                mainController.atualizarLista();
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Erro!!");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, insira um número de ID válido.");
            alert.showAndWait();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
