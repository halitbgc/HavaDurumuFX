package org.example.havadurumufx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    private LinkedList weatherList = null; // class objesi cunku sortta bu veri bana lazim

    @FXML
    private TextField fieldLocation;
    @FXML
    private Label labelLocation;
    @FXML
    private Label labelMain;
    @FXML
    private Label labelNight;
    @FXML
    private Label labelHumidity;
    @FXML
    private Label labelMax;
    @FXML
    private Label labelMin;
    @FXML
    private Label labelDate;

    @FXML
    private Label label0;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;

    @FXML
    private Label labelDegree0;
    @FXML
    private Label labelDegree1;
    @FXML
    private Label labelDegree2;
    @FXML
    private Label labelDegree3;
    @FXML
    private Label labelDegree4;
    @FXML
    private Label labelDegree5;
    @FXML
    private Label labelDegree6;

    @FXML
    private Label labelDurum0;
    @FXML
    private Label labelDurum1;
    @FXML
    private Label labelDurum2;
    @FXML
    private Label labelDurum3;
    @FXML
    private Label labelDurum4;
    @FXML
    private Label labelDurum5;
    @FXML
    private Label labelDurum6;


    @FXML
    private ImageView image0;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;

    @FXML
    public void searchClick(){
        labelMain.setText("Bugün");
        labelLocation.setText(fieldLocation.getText());

        Api api = new Api();
        weatherList = api.getData(fieldLocation.getText());
        weatherList.print();

        labelNight.setText(weatherList.get(0).getNight() + "°");
        labelHumidity.setText("%" + weatherList.get(0).getHumidity());
        labelMax.setText(weatherList.get(0).getMax() + "°");
        labelMin.setText(weatherList.get(0).getMin() + "°");
        labelDate.setText(weatherList.get(0).getDate());

        ImageView imageList[] = {image0, image1, image2, image3, image4, image5, image6};
        Label labelList[] = {label0, label1, label2, label3, label4, label5, label6};
        Label labelDegreeList[] = {labelDegree0, labelDegree1, labelDegree2, labelDegree3, labelDegree4, labelDegree5, labelDegree6};
        Label labelDurumList[] = {labelDurum0, labelDurum1, labelDurum2, labelDurum3, labelDurum4, labelDurum5, labelDurum6};
        for(int i = 0; i < 7; i++) {
            Weather weather = weatherList.get(i);
            ImageView image = imageList[i];
            Label label = labelList[i];
            Label labelDegree = labelDegreeList[i];
            Label labelDurum = labelDurumList[i];

            labelDurum.setText(weather.getDescription());
            label.setText(weatherList.get(i).getDay());
            labelDegree.setText(String.valueOf(weather.getDegree()) + "°");

            if (weather.getDescription().equals("açık")) {
                image.setImage(new Image(getClass().getResourceAsStream("acik.png")));
            } else if (weather.getDescription().equals("kapalı") || weather.getDescription().equals("parçalı bulutlu")) {
                image.setImage(new Image(getClass().getResourceAsStream("kapali_ve_parcali_bulutlu.png")));
            } else if (weather.getDescription().equals("hafif yağmur") || weather.getDescription().equals("orta şiddetli yağmur")) {
                image.setImage(new Image(getClass().getResourceAsStream("hafif_ve_orta_yagmurlu.png")));
            } else if (weather.getDescription().equals("az bulutlu")) {
                image.setImage(new Image(getClass().getResourceAsStream("az_bulutlu.png")));
            } else if (weather.getDescription().equals("parçalı az bulutlu")) {
                image.setImage(new Image(getClass().getResourceAsStream("parcali_az_bulutlu.png")));
            }
        }
    }

    @FXML
    public void sortClick() {
        labelMain.setText("En sıcak gün");
        bubbleSort();

        labelNight.setText(weatherList.get(6).getNight() + "°");
        labelHumidity.setText("%" + weatherList.get(6).getHumidity());
        labelMax.setText(weatherList.get(6).getMax() + "°");
        labelMin.setText(weatherList.get(6).getMin() + "°");
        labelDate.setText(weatherList.get(6).getDate());

        ImageView imageList[] = {image6, image5, image4, image3, image2, image1, image0};

        Stack labelList = new Stack();
        labelList.push(label0);
        labelList.push(label1);
        labelList.push(label2);
        labelList.push(label3);
        labelList.push(label4);
        labelList.push(label5);
        labelList.push(label6);

        Stack labelDegreeList = new Stack();
        labelDegreeList.push(labelDegree0);
        labelDegreeList.push(labelDegree1);
        labelDegreeList.push(labelDegree2);
        labelDegreeList.push(labelDegree3);
        labelDegreeList.push(labelDegree4);
        labelDegreeList.push(labelDegree5);
        labelDegreeList.push(labelDegree6);

        Stack labelDurumList = new Stack();
        labelDurumList.push(labelDurum0);
        labelDurumList.push(labelDurum1);
        labelDurumList.push(labelDurum2);
        labelDurumList.push(labelDurum3);
        labelDurumList.push(labelDurum4);
        labelDurumList.push(labelDurum5);
        labelDurumList.push(labelDurum6);

        for(int i = 0; i < 7; i++) {
            Weather weather = weatherList.get(i);
            ImageView image = imageList[i];
            Label label = labelList.pop();
            Label labelDegree = labelDegreeList.pop();
            Label labelDurum = labelDurumList.pop();

            labelDurum.setText(weather.getDescription());
            label.setText(weatherList.get(i).getDay());
            labelDegree.setText(String.valueOf(weather.getDegree()) + "°");

            if (weather.getDescription().equals("açık")) {
                image.setImage(new Image(getClass().getResourceAsStream("acik.png")));
            } else if (weather.getDescription().equals("kapalı") || weather.getDescription().equals("parçalı bulutlu")) {
                image.setImage(new Image(getClass().getResourceAsStream("kapali_ve_parcali_bulutlu.png")));
            } else if (weather.getDescription().equals("hafif yağmur") || weather.getDescription().equals("orta şiddetli yağmur")) {
                image.setImage(new Image(getClass().getResourceAsStream("hafif_ve_orta_yagmurlu.png")));
            } else if (weather.getDescription().equals("az bulutlu")) {
                image.setImage(new Image(getClass().getResourceAsStream("az_bulutlu.png")));
            } else if (weather.getDescription().equals("parçalı az bulutlu")) {
                image.setImage(new Image(getClass().getResourceAsStream("parcali_az_bulutlu.png")));
            }
        }
    }

    private void bubbleSort() {
        for(int i = 0; i<weatherList.length(); i++) {
            int flag = 0;
            for(int j = 0; j< weatherList.length()-1; j++) {
                if (weatherList.get(j).getDegree() > weatherList.get(j+1).getDegree()) {
                    Weather temp = weatherList.get(j);
                    weatherList.set(j, weatherList.get(j+1));
                    weatherList.set(j+1, temp);
                    flag = 1;
                }
            }
            if (flag == 0) {
                return;
            }
        }
    }

}