module com.example.hr_fx {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.hr_fx to javafx.fxml;
    exports com.example.hr_fx;
}