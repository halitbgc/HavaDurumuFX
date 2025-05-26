module org.example.havadurumufx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires java.net.http;
    requires org.json;
    requires java.desktop;


    opens org.example.havadurumufx to javafx.fxml;
    exports org.example.havadurumufx;
}