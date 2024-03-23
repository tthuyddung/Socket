module com.example.baikiemtracuoiki {
    requires javafx.controls;
    requires javafx.fxml;


    opens bai1 to javafx.fxml;
    exports bai1;
    exports bai2;
}