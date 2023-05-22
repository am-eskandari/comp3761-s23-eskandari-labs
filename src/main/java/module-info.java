module com.example.comp3761s23eskandarilabs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comp3761s23eskandarilabs to javafx.fxml;
    exports com.example.comp3761s23eskandarilabs;
}