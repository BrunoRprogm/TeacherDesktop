package com.senai.teacherdesktop.DAO;

import com.senai.teacherdesktop.Models.SchoolClass;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolClassDAO {

    public static List<SchoolClass> listClass() throws SQLException {
        List<SchoolClass> schoolClasses = new ArrayList<>();
        String sql = "SELECT * FROM turma";

        try( Connection conn = ConnectDB.connectDB();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM turma");){
            while(rs.next()){
                SchoolClass turma1 = new SchoolClass(rs.getInt("idTurma"),rs.getString("nm_turma"));
                schoolClasses.add(turma1);
            }
        }
        return schoolClasses;
    }

    public void cadastrarTurma(SchoolClass sc) throws SQLException{

        String sql = "INSERT INTO turma (nm_turma) VALUES (?)";

        try(Connection conn = ConnectDB.connectDB();
            PreparedStatement prst = conn.prepareStatement(sql)){
            prst.setString(1,sc.getNm_turma());
            prst.executeUpdate();
        }

    }

    public void excluirTurma(int idTurma) throws SQLException{

        String sql = "DELETE FROM turma where idTurma = ?";

        try( Connection conn = ConnectDB.connectDB();
        PreparedStatement prst = conn.prepareStatement(sql)){
            prst.setInt(1,idTurma);
            prst.executeUpdate();
        }

    }

    public void excluirTurmaPorId(int id) throws SQLException{
        String sql = "DELETE from turma where idTurma ?";
        try(Connection conn = ConnectDB.connectDB();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }

}
