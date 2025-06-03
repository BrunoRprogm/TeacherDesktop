module com.senai.teacherdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.senai.teacherdesktop to javafx.fxml;
    exports com.senai.teacherdesktop;
    exports com.senai.teacherdesktop.Controllers;
    opens com.senai.teacherdesktop.Controllers to javafx.fxml;
}