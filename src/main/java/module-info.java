module com.test1.test1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.test1.test1 to javafx.fxml;
    exports com.test1.test1;
}