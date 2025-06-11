package com.senai.teacherdesktop.DAO;

import com.senai.teacherdesktop.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {



    public User autenticar (String email, String senha){
        String sql = "SELECT * FROM professor where email = ? AND senha = ?";

        try(Connection conn = ConnectDB.connectDB();
            PreparedStatement stmt = conn.prepareStatement(sql)){


            stmt.setString(1,email);
            stmt.setString(2,senha);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return new User(
                        rs.getInt("idProfessor"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")


                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
