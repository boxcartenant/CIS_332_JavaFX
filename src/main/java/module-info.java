module com.example.javafx_class_1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.javafx_class_1 to javafx.fxml;
    exports com.example.javafx_class_1;

    opens my_new_package to javafx.fxml;
    exports my_new_package;
}