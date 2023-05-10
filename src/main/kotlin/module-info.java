module com.example.battleshipgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires carte.controllerfx;
    requires kotlin.reflect;



    opens com.example.battleshipgame.controllers to javafx.fxml;
    exports com.example.battleshipgame;
}