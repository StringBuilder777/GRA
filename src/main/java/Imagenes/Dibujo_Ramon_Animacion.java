package Imagenes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.animation.RotateTransition;
import javafx.util.Duration;

public class Dibujo_Ramon_Animacion extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        BorderPane roo = new BorderPane();
        
        RadioButton color1 = new RadioButton("Color Rosa");
        RadioButton color2 = new RadioButton("Color Naranja");
        RadioButton color3 = new RadioButton("Color Dorado");
        RadioButton animacion = new RadioButton ("Rotar Pantalones");
        
        ToggleGroup grupo = new ToggleGroup();
        color1.setToggleGroup(grupo);
        color2.setToggleGroup(grupo);
        color3.setToggleGroup(grupo);

        // Crear un contenedor para el dibujo
        Pane drawingContainer = new Pane();

        // Aplicar escala al contenedor
        drawingContainer.setScaleX(1.8);
        drawingContainer.setScaleY(1.8);

        // Ajustar posición para centrar
        drawingContainer.setTranslateX(80);
        drawingContainer.setTranslateY(80);



        String Coordenadas1="m 74.957143,115.41819 c 0,0 1.818365,-28.285711 10.203061,-38.993871 8.384693,-10.70816 8.384693,-10.70816 8.384693,-10.70816 l 16.062243,-17.47653 c 0,0 6.16225,-9.798986 3.63674,-21.618373 0,0 8.99082,8.485716 6.36429,14.041843 0,0 2.2797,-3.808347 2.7083,-11.237297 0,0 2.85729,12.143477 0.35716,17.715187 0,0 7.92897,-14.786466 6.35746,-20.786772 0,0 5.14312,7.500382 4.78596,12.072044 0,0 3.21445,-4.785958 8.429,-7.000357 0,0 -5.71457,8.929025 -3.85733,11.929185 l 8.2147,-11.000566 2.64299,10.429106 2.92872,-7.357521 0.2143,9.000461 9.64335,-7.428952 -3.78591,10.214802 8.50043,-7.786107 c 0,0 -6.71462,13.357827 -4.85739,14.929337 1.85724,1.57151 5.00026,40.28777 5.00026,40.28777 0,0 -0.50003,16.072231 -4.07164,25.787021 0,0 -20.92964,5.00025 -20.42961,9.07189 0,0 -8.71473,-8.8576 -15.50079,-9.50049 0,0 -11.85775,-14.50074 -20.50105,-14.92933 0,0 -14.929333,-0.42859 -21.429664,8.14327";
        String Coordenadas2="m 112.23367,55.763265 c 0,0 6.26327,-9.899999 7.57653,-13.940816";
        String Coordenadas3="m 133.86397,38.609113 c 0,0 -1.92867,15.572222 -6.17889,19.179548";
        String Coordenadas4="m 138.61421,43.180775 c 0,0 -3.1073,4.178784 -0.64289,10.643399";
        String Coordenadas5="m 149.32905,42.930762 c 0,0 -2.60728,6.96464 -5.82173,11.286289";
        String Coordenadas6="m 152.50778,44.252258 c 0,0 -2.07154,15.107912 -3.89306,17.715187";
        String Coordenadas7="m 158.29379,47.109546 c 0,0 -1.53579,8.25042 -1.53579,10.607683";
        
        String Coordenadas8="m 75.462245,116.57755 c 2.929592,-3.53571 9.495918,-3.03061 9.495918,-3.03061 3.232653,-6.36429 19.294897,-8.18265 19.294897,-8.18265 14.14286,1.81836 22.12347,15.3551 22.32551,15.05204 6.26327,-0.50511 15.86021,8.88979 15.86021,8.88979 10.00102,-8.58673 22.62857,-7.27347 22.62857,-7.27347 13.63775,-3.23265 17.37551,13.73878 17.37551,13.73878 l -21.31531,11.81939 c -9.29388,4.04081 -15.96122,-1.41429 -15.96122,-1.41429 -9.9,10.70816 -44.65102,7.27347 -44.65102,7.27347 -20.305106,1.11122 -32.226112,-19.65746 -32.226112,-19.65746 -10.929129,-1.78581 -13.072095,-12.6435 -13.072095,-12.6435 -6.357467,-3.85734 -8.35757,-12.07205 -8.35757,-12.07205 13.857849,-16.21511 27.644267,-1.28578 27.644267,-1.28578 0.150282,0.30063 0.958445,8.78634 0.958445,8.78634 z";
        String Coordenadas9="m 57.07653,108.29388 c 0,0 11.516325,-1.61633 6.768367,8.68775 0,0 -1.010203,6.46531 1.818368,6.46531";
        String Coordenadas10="m 152.03571,140.62041 c 0,0 5.25306,-0.90919 6.26327,-6.76837 0,0 0.80816,-9.59694 14.04184,-3.73775";
        String Coordenadas11="m 117.89082,133.70051 c 0,0 2.9801,1.76786 2.57602,2.9801";
        String Coordenadas12="m 119.96173,134.91275 c 0,0 -20.658669,12.375 -34.245915,2.72755";
        String Coordenadas13="m 91.777041,115.3653 c 0,0 4.192347,-3.18214 7.475508,0 ";
        String Coordenadas14="m 104.16894,58.400515 c 0,0 1.28152,-16.537659 26.0575,-20.382206 ";
        String Coordenadas15="m 102.4852,120.71939 c 0,0 6.01072,-5.4046 7.62704,1.21224";
        String Coordenadas16="m 109.80918,125.01276 c -0.55561,-3.03062 -7.9301,-1.11123 -7.9301,-1.11123 0,0 1.9699,3.18213 4.34388,3.13163 0,0 3.28315,-0.15152 3.58622,-2.0204 z"; 
        String Coordenadas17="m 96.083036,124.96225 c 0.984949,-0.47985 2.557077,-2.2414 2.557077,-2.2414 -1.490051,-1.54056 -6.648405,-0.97232 -6.648405,-0.97232 0,0 0.593496,2.38031 4.091328,3.21372 z";
        String Coordenadas18="m 98.362161,122.6759 c -0.995586,-0.8839 -3.393031,-0.8929 -3.393031,-0.8929 -0.08036,1.15184 2.142966,2.13403 2.142966,2.13403 z";
        String Coordenadas19="m 107.68406,123.48844 c -1.37507,3.41089 -4.12521,0.16072 -4.12521,0.16072 z";
        String Coordenadas20="m 104.71963,113.43436 c 0,0 5.42884,-5.10741 9.89336,1.64294";
        String Coordenadas21="M 114.68442,131.11383 Z";
        String Coordenadas22="m 89.218838,133.79254 c 0,0 -2.250118,2.71442 -5.928876,-1.28578 0,0 -3.464461,-3.28588 2.178684,-6.03602 0,0 5.500281,1.35721 9.393337,-0.46431 0,0 7.321797,-0.67861 11.107707,3.21445 0,0 7.25037,-2.03582 8.6433,1.60722 0,0 1.14292,4.39308 -4.60738,5.64315 L 104.4339,134.364 c 0,0 -10.071942,5.21455 -15.215062,-0.57146 z";
        String Coordenadas23="m 88.308076,131.47099 c 0,0 -0.785755,1.25006 0.82147,2.26797";
        
        String Coordenadas24="m 88.71881,151.29343 c 0,0 -0.571458,4.67881 -2.285831,6.96464 0,0 11.071996,1.1072 12.714937,4.60738 0,0 5.285984,-1.17863 5.464564,-5.50028 0,0 2.4287,6.85749 6.75034,1.1072 0,0 -1.10719,4.32165 3.92878,1.00005 0,0 1.85723,3.60733 4.50023,0.78576 0,0 -0.2143,1.7858 1.67865,2.28583 0,0 -0.32144,7.07179 -9.42905,7.39323 0,0 -11.9649,10.60769 -13.429256,10.57197 0,0 5.428846,3.89306 9.393336,-1.57151 0,0 3.00015,6.57176 7.50038,0.0357 0,0 0.28573,6.96466 6.50033,-0.89289 0,0 -0.78575,1.92867 0,2.39298 l 4.75025,-0.42859 c 0,0 0.64289,-0.28573 0.57145,-2.03582 l -0.42859,-2.57156 c 0,0 1.03577,-3.07158 -0.42859,-4.78596 0,0 1.1072,-4.50023 -0.4286,-5.89315 0,0 1.92867,0.35716 1.57151,-1.28578 0,0 -0.25001,-6.96465 -1.46436,-9.64335 0,0 -22.78687,1.85723 -26.715646,0.0714 l -4.821674,2.64302 -2.821573,-4.46451 z";
        String Coordenadas25="m 92.256887,159.4102 2.399233,-2.94222";
        String Coordenadas26="m 97.621052,158.17771 c 0,0 -0.419666,2.25012 0.758965,3.69662";
        String Coordenadas27="m 120.76509,162.24042 c 0,0 2.58942,-0.23216 2.35726,-2.69657 0,0 0.31252,3.89306 4.25915,5.03598";
        String Coordenadas28="m 107.85191,175.83865 c 0,0 3.68725,2.6139 4.76059,1.98252 0,0 2.89171,-2.42449 3.38418,-6.14961 l 4.8111,4.33125 c 0,0 1.56582,-0.63138 1.45217,-1.02284 0,0 1.30064,3.92717 4.5838,0.83342";
        String Coordenadas29="m 122.29783,175.24515 c 0,0 0.0253,-4.95 -0.15153,-6.23801 0,0 2.62653,4.65957 4.31862,1.22488";
        
        String Coordenadas30="m 86.973844,155.38362 c 0,0 -16.143679,2.82158 -14.750751,13.46498 0,0 1.642941,5.57171 7.678963,5.14312 0,0 9.036176,13.57212 18.750959,6.92892 L 111.9394,169.67007 c 0,0 9.94694,-0.57146 8.94689,-7.00036 0,0 -1.30619,0.12844 -1.10414,-2.5486 0,0 -2.41902,3.45866 -4.49055,-0.70226 0,0 -4.62524,3.92877 -4.2145,-0.92862 0,0 -2.643,5.92887 -6.37533,-0.7679 0,0 -1.33935,4.6431 -5.518138,5.26813 0,0 -1.900979,-3.40347 -12.659652,-4.71674 0,0 1.553256,-2.46974 0.449864,-2.8901 z";
        String Coordenadas31="m 86.751275,158.36212 c 0,0 -5.732909,0.22729 -7.753318,2.68966";
        String Coordenadas32="m 79.896932,173.93744 c 0,0 11.607736,-0.71432 19.393847,-10.96484";
        String Coordenadas33="m 112.0325,169.72294 c 0,0 2.92872,-2.75014 2.81264,-3.07158";
        
        String Coordenadas34="m 102.33367,203.88444 c -6.945149,1.7426 -17.552292,-1.89413 -17.552292,-1.89413 l 0.252551,-8.67513 c -3.030612,-1.04809 -3.25791,-16.88304 -3.25791,-16.88304 0,0 7.879593,11.01122 16.668368,4.29337 0,0 5.489483,3.92677 9.507553,-1.48422 0,0 2.53584,6.66105 7.60753,0.28573 0,0 1.32149,4.91096 6.32175,-0.89291 0,0 -1.1072,2.62514 4.50023,1.78581 l -3.94663,11.23271 1.14291,12.28635 c 0,0 -7.57181,2.92872 -20.14388,2.07153 z";
        String Coordenadas35="m 102.34451,203.8854 -1.80367,-8.12541 c 0,0 -4.125209,1.87509 -9.661205,-1.30364";
        
        String Coordenadas36="m 84.86147,201.99245 c 0,0 11.822033,3.91091 17.2866,1.94652 l 1.4465,2.2144 c 0,0 12.88196,0.63541 19.95339,-2.21842 l 3.33367,17.29974 9.21812,8.68776 c 0,0 0.0758,5.58138 -4.52067,3.66199 0,0 -3.13163,3.15689 -5.42985,0.58087 0,0 -2.60127,3.78826 -6.16224,0.20204 0,0 -3.13163,3.66199 -9.14235,-0.0505 0,0 -3.51046,-0.70716 -5.80867,-3.25792 0,0 -4.29337,2.72755 -11.390051,0.80816 0,0 -2.929592,2.62653 -7.728062,1.45217 0,0 -2.386607,-1.38903 -3.29579,-2.77806 -0.02526,-0.11365 -4.394388,-0.71977 -5.707654,-4.5838 0,0 -0.391454,-3.04324 4.520664,-3.91454 0,0 1.38903,-3.03061 5.354081,-4.2176 0,0 -2.677729,-6.02874 -1.927688,-15.83281 z";
        String Coordenadas37="m 78.182559,228.03842 c 0,0 -0.0625,-3.36625 3.134087,-4.44666";
        String Coordenadas38="m 80.048726,229.48492 c 0,0 -0.392877,-3.50018 2.651921,-4.89311";
        String Coordenadas39="m 151.33334,87.257197 5.17883,5.25027 5.67886,4.53595 2.03582,1.17863 z";
        String Coordenadas40="m 82.49528,230.46711 c 0,0 -1.178634,-4.08056 3.446603,-5.56278";
        String Coordenadas41="m 93.595408,231.80395 c 0,0 1.205932,-0.69451 1.40797,-1.29432";
        String Coordenadas42="m 105.11173,231.10944 c 0,0 -2.07091,-19.0171 -1.91938,-25.38138";
        String Coordenadas43="m 111.88964,234.91377 c 0,0 -1.33043,-1.8751 -1.51794,-3.16981";
        String Coordenadas44="m 119.98826,234.31552 c 0,0 2.50013,-3.23231 -2.16082,-6.53604";
        String Coordenadas45="m 126.18501,234.07444 c 0,0 2.14296,-2.22333 -1.73223,-6.06281";
        String Coordenadas46="m 131.64064,233.55656 c 0,0 2.27691,-2.50906 -1.99117,-5.49135";

        //Cabello
        SVGPath path1 = new SVGPath();
        path1.setContent(Coordenadas1);
        path1.setFill(Color.web("#545365"));
        path1.setStroke(Color.BLACK);
        path1.setStrokeWidth(1);
        SVGPath path2 = new SVGPath();
        path2.setContent(Coordenadas2);
        path2.setFill(Color.web("#545365"));
        path2.setStroke(Color.BLACK);
        path2.setStrokeWidth(1);
        SVGPath path3 = new SVGPath();
        path3.setContent(Coordenadas3);
        path3.setFill(Color.web("#545365"));
        path3.setStroke(Color.BLACK);
        path3.setStrokeWidth(1);
        SVGPath path4 = new SVGPath();
        path4.setContent(Coordenadas4);
        path4.setFill(Color.web("#545365"));
        path4.setStroke(Color.BLACK);
        path4.setStrokeWidth(1);
        SVGPath path5 = new SVGPath();
        path5.setContent(Coordenadas5);
        path5.setFill(Color.web("#545365"));
        path5.setStroke(Color.BLACK);
        path5.setStrokeWidth(1);
        SVGPath path6 = new SVGPath();
        path6.setContent(Coordenadas6);
        path6.setFill(Color.web("#545365"));
        path6.setStroke(Color.BLACK);
        path6.setStrokeWidth(1);
        SVGPath path7 = new SVGPath();
        path7.setContent(Coordenadas7);
        path7.setFill(Color.web("#545365"));
        path7.setStroke(Color.BLACK);
        path7.setStrokeWidth(1);
        
        //Cara
        SVGPath path8 = new SVGPath();
        path8.setContent(Coordenadas8);
        path8.setFill(Color.web("#83bdca"));
        path8.setStroke(Color.BLACK);
        path8.setStrokeWidth(1);
        SVGPath path9 = new SVGPath();
        path9.setContent(Coordenadas9);
        path9.setFill(Color.web("#83bdca"));
        path9.setStroke(Color.BLACK);
        path9.setStrokeWidth(1);
        SVGPath path10 = new SVGPath();
        path10.setContent(Coordenadas10);
        path10.setFill(Color.web("#83bdca"));
        path10.setStroke(Color.BLACK);
        path10.setStrokeWidth(1);
        SVGPath path11 = new SVGPath();
        path11.setContent(Coordenadas11);
        path11.setFill(Color.web("#83bdca"));
        path11.setStroke(Color.BLACK);
        path11.setStrokeWidth(1);
        SVGPath path12 = new SVGPath();
        path12.setContent(Coordenadas12);
        path12.setFill(Color.web("#83bdca"));
        path12.setStroke(Color.BLACK);
        path12.setStrokeWidth(1);
        SVGPath path13 = new SVGPath();
        path13.setContent(Coordenadas13);
        path13.setFill(Color.web("#83bdca"));
        path13.setStroke(Color.BLACK);
        path13.setStrokeWidth(1);
        SVGPath path14 = new SVGPath();
        path14.setContent(Coordenadas14);
        path14.setFill(Color.web("#83bdca"));
        path14.setStroke(Color.BLACK);
        path14.setStrokeWidth(1);
        SVGPath path15 = new SVGPath();
        path15.setContent(Coordenadas15);
        path15.setFill(Color.web("#83bdca"));
        path15.setStroke(Color.BLACK);
        path15.setStrokeWidth(1);
        SVGPath path16 = new SVGPath();
        path16.setContent(Coordenadas16);
        path16.setFill(Color.web("#ffffff"));
        path16.setStroke(Color.BLACK);
        path16.setStrokeWidth(1);
        SVGPath path17 = new SVGPath();
        path17.setContent(Coordenadas17);
        path17.setFill(Color.web("#ffffff"));
        path17.setStroke(Color.BLACK);
        path17.setStrokeWidth(1);
        SVGPath path18 = new SVGPath();
        path18.setContent(Coordenadas18);
        path18.setFill(Color.web("#000000"));
        path18.setStroke(Color.BLACK);
        path18.setStrokeWidth(1);
        SVGPath path19 = new SVGPath();
        path19.setContent(Coordenadas19);
        path19.setFill(Color.web("#000000"));
        path19.setStroke(Color.BLACK);
        path19.setStrokeWidth(1);
        SVGPath path20 = new SVGPath();
        path20.setContent(Coordenadas20);
        path20.setFill(Color.web("#83bdca"));
        path20.setStroke(Color.BLACK);
        path20.setStrokeWidth(1);
        SVGPath path21 = new SVGPath();
        path21.setContent(Coordenadas21);
        path21.setFill(Color.web("#7e8ca7"));
        path21.setStroke(Color.BLACK);
        path21.setStrokeWidth(1);
        SVGPath path22 = new SVGPath();
        path22.setContent(Coordenadas22);
        path22.setFill(Color.web("#7e8ca7"));
        path22.setStroke(Color.BLACK);
        path22.setStrokeWidth(1);
        SVGPath path23 = new SVGPath();
        path23.setContent(Coordenadas23);
        path23.setFill(Color.web("#83bdca"));
        path23.setStroke(Color.BLACK);
        path23.setStrokeWidth(1);
        
        //Ropa
        SVGPath path24 = new SVGPath();
        path24.setContent(Coordenadas24);
        path24.setFill(Color.web("#8fc144"));
        path24.setStroke(Color.BLACK);
        path24.setStrokeWidth(1);
        SVGPath path25 = new SVGPath();
        path25.setContent(Coordenadas25);
        path25.setFill(Color.web("#8fc144"));
        path25.setStroke(Color.BLACK);
        path25.setStrokeWidth(1);
        SVGPath path26 = new SVGPath();
        path26.setContent(Coordenadas26);
        path26.setFill(Color.web("#8fc144"));
        path26.setStroke(Color.BLACK);
        path26.setStrokeWidth(1);
        SVGPath path27 = new SVGPath();
        path27.setContent(Coordenadas27);
        path27.setFill(Color.web("#8fc144"));
        path27.setStroke(Color.BLACK);
        path27.setStrokeWidth(1);
        SVGPath path28 = new SVGPath();
        path28.setContent(Coordenadas28);
        path28.setFill(Color.web("#8fc144"));
        path28.setStroke(Color.BLACK);
        path28.setStrokeWidth(1);
        SVGPath path29 = new SVGPath();
        path29.setContent(Coordenadas29);
        path29.setFill(Color.web("#8fc144"));
        path29.setStroke(Color.BLACK);
        path29.setStrokeWidth(1);
        
        //Brazos
        SVGPath path30 = new SVGPath();
        path30.setContent(Coordenadas30);
        path30.setFill(Color.web("#87c0cf"));
        path30.setStroke(Color.BLACK);
        path30.setStrokeWidth(1);
        SVGPath path31 = new SVGPath();
        path31.setContent(Coordenadas31);
        path31.setFill(Color.web("#87c0cf"));
        path31.setStroke(Color.BLACK);
        path31.setStrokeWidth(1);
        SVGPath path32 = new SVGPath();
        path32.setContent(Coordenadas32);
        path32.setFill(Color.web("#87c0cf"));
        path32.setStroke(Color.BLACK);
        path32.setStrokeWidth(1);
        SVGPath path33 = new SVGPath();
        path33.setContent(Coordenadas33);
        path33.setFill(Color.web("#87c0cf"));
        path33.setStroke(Color.BLACK);
        path33.setStrokeWidth(1);
        
        //Pantalones
        SVGPath path34 = new SVGPath(); 
        path34.setContent(Coordenadas34);
        path34.setFill(Color.web("#6a1b1f"));
        path34.setStroke(Color.BLACK);
        path34.setStrokeWidth(1);
        SVGPath path35 = new SVGPath(); 
        path35.setContent(Coordenadas35);
        path35.setFill(Color.web("#6a1b1f"));
        path35.setStroke(Color.BLACK);
        path35.setStrokeWidth(1);
        
        RotateTransition rotarPantalon1 = new RotateTransition(Duration.seconds(1), path34);
        rotarPantalon1.setByAngle(360);
        rotarPantalon1.setCycleCount(2);
        rotarPantalon1.setAutoReverse(true);
        RotateTransition rotarPantalon2 = new RotateTransition(Duration.seconds(1), path35);
        rotarPantalon2.setByAngle(360);
        rotarPantalon2.setCycleCount(2);
        rotarPantalon2.setAutoReverse(true);
        
        //Piernas
        SVGPath path36 = new SVGPath(); 
        path36.setContent(Coordenadas36);
        path36.setFill(Color.web("#85c1d0"));
        path36.setStroke(Color.BLACK);
        path36.setStrokeWidth(1);
        SVGPath path37 = new SVGPath(); 
        path37.setContent(Coordenadas37);
        path37.setFill(Color.web("#85c1d0"));
        path37.setStroke(Color.BLACK);
        path37.setStrokeWidth(1);
        SVGPath path38 = new SVGPath(); 
        path38.setContent(Coordenadas38);
        path38.setFill(Color.web("#85c1d0"));
        path38.setStroke(Color.BLACK);
        path38.setStrokeWidth(1);
        SVGPath path39 = new SVGPath(); 
        path39.setContent(Coordenadas39);
        path39.setFill(Color.web("#85c1d0"));
        path39.setStroke(Color.BLACK);
        path39.setStrokeWidth(1);
        SVGPath path40 = new SVGPath(); 
        path40.setContent(Coordenadas40);
        path40.setFill(Color.web("#85c1d0"));
        path40.setStroke(Color.BLACK);
        path40.setStrokeWidth(1);
        SVGPath path41 = new SVGPath(); 
        path41.setContent(Coordenadas41);
        path41.setFill(Color.web("#85c1d0"));
        path41.setStroke(Color.BLACK);
        path41.setStrokeWidth(1);
        SVGPath path42 = new SVGPath(); 
        path42.setContent(Coordenadas42);
        path42.setFill(Color.web("#85c1d0"));
        path42.setStroke(Color.BLACK);
        path42.setStrokeWidth(1);
        SVGPath path43 = new SVGPath(); 
        path43.setContent(Coordenadas43);
        path43.setFill(Color.web("#85c1d0"));
        path43.setStroke(Color.BLACK);
        path43.setStrokeWidth(1);
        SVGPath path44 = new SVGPath(); 
        path44.setContent(Coordenadas44);
        path43.setFill(Color.web("#85c1d0"));
        path44.setStroke(Color.BLACK);
        path44.setStrokeWidth(1);
        SVGPath path45 = new SVGPath(); 
        path45.setContent(Coordenadas45);
        path45.setFill(Color.web("#85c1d0"));
        path45.setStroke(Color.BLACK);
        path45.setStrokeWidth(1);
        SVGPath path46 = new SVGPath(); 
        path46.setContent(Coordenadas46);
        path46.setFill(Color.web("#85c1d0"));
        path46.setStroke(Color.BLACK);
        path46.setStrokeWidth(1);
        
        
        
        root.getChildren().addAll(path1,path2,path3,path4,path5,path6,path7,path8,path9,path10,path11,path12,path13,path14,path15,path17,path18,path19,path20,path21,path22,path23,path24,path25,path26,path27,path28,path29,path30,path31,path32,path33
                ,path34,path35,path36,path37,path38,path39,path40,path41,path42,path43,path44,path45,path46);

        drawingContainer.getChildren().addAll(path1,path2,path3,path4,path5,path6,path7,path8,path9,path10,path11,path12,path13,path14,path15,path16,path17,path18,path19,path20,path21,path22,path23,path24,path25,path26,path27,path28,path29,path30,path31,path32,path33
                ,path34,path35,path36,path37,path38,path39,path40,path41,path42,path43,path44,path45,path46);

        root.getChildren().add(drawingContainer);
        roo.setCenter(root);

        VBox radioboton = new VBox(10);
        radioboton.getChildren().addAll(color1, color2, color3, animacion);
        roo.setLeft(radioboton);
        roo.setCenter(root);
        color1.setOnAction(e ->{
            path34.setFill(Color.PINK);
            path35.setFill(Color.PINK);
        });
        color2.setOnAction(e ->{
            path34.setFill(Color.MAGENTA);
            path35.setFill(Color.MAGENTA);
        });
        color3.setOnAction(e ->{
            path34.setFill(Color.GOLD);
            path35.setFill(Color.GOLD);
        });
        animacion.setOnAction(e ->{
            rotarPantalon1.playFromStart();
            rotarPantalon2.playFromStart();
        });
        
        
        Scene scene = new Scene(roo, 600, 600);
        primaryStage.setTitle("Ramon");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

