
package Imagenes;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Dibujo_Diamantito_Animacion extends Application{

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        BorderPane roo = new BorderPane();

        Pane drawingContainer = new Pane();

        // Aplicar escala al contenedor
        drawingContainer.setScaleX(1.8);
        drawingContainer.setScaleY(1.8);

        // Ajustar posición para centrar
        drawingContainer.setTranslateX(600);
        drawingContainer.setTranslateY(200);
        
        CheckBox mover = new CheckBox("Mover cabello");
        CheckBox rotar = new CheckBox("Rotar cabello");
        CheckBox escalar = new CheckBox("Escalar cabello");

        String Coordenadas1="m 78.861165,122.57768 c 0,0 -4.714526,-25.715596 6.928924,-42.216439 0,0 17.715191,-36.430428 12.357775,-48.931066 0,0 5.000256,7.036073 6.107456,12.072044 0,0 -2.53584,-7.643247 -1.53579,-15.786519 0,0 1.46436,9.286188 3.50017,11.322006 0,0 2.07418,-11.257094 -5.90643,-22.268318 0,0 6.66734,3.384183 10.25357,12.223469 0,0 1.96989,-0.656632 -1.06072,-6.010714 0,0 6.39265,10.376702 6.4998,16.44844 0,0 0.75004,-3.750191 -0.78576,-7.89326 0,0 19.84413,28.4688 21.25841,53.2188 0,0 2.52551,23.840817 -3.33367,38.993877 0,0 -5.70983,2.82789 -7.92423,7.04239 l -6.82177,-3.71448 c 0,0 -2.67871,-4.60738 -7.07179,-5.67886 0,0 -1.07148,-1.25006 -6.89321,0.32145 0,0 -3.03587,-0.4286 -6.964642,0.17858 0,0 -3.821623,3.75019 -7.214653,6.50033 l -5.357417,1.67865 c 0,0 -1.000053,-2.893 -6.036023,-7.50038 z";
        String Coordenadas2="m 110.54158,28.866581 c 0,0 4.54592,10.607143 3.96505,12.728572";
        
        String Coordenadas3="m -880.82767,-187.29769 h 1640.84 v 73.28155 h -1640.84 z";
        String Coordenadas4="m 81.397194,144.93903 c 0,0 -2.752807,1.7426 -7.222961,-2.85383 0,0 -4.773213,-12.77908 -1.338519,-17.93112 0,0 3.295791,-4.31231 12.084567,6.34534 l 5.762917,-1.93929 c 0,0 4.910965,-5.82173 7.303944,-6.01816 0,0 5.446708,-0.62504 6.518188,-0.2143 0,0 7.5361,-4.17879 12.42921,4.32165 l 8.32185,4.35736 c 0,0 4.23236,-6.26817 8.83974,-6.80391 0,0 4.83953,-1.98225 4.37522,8.66115 -0.10715,0.46431 -3.892,17.09124 -10.42805,13.12675 0,0 -2.17187,6.04504 -17.1734,6.65117 0,0 -14.395409,0.45459 -21.466839,-1.9699 0,0 -4.798469,-0.40408 -8.005867,-5.73291 z";
        String Coordenadas5="m 79.856631,140.31735 c 0,0 -3.308416,0.0505 -2.171938,-5.98546 0,0 2.651787,-3.53572 -3.232652,-7.19771";
        String Coordenadas6="m 81.555039,145.00217 c 0,0 -0.997358,-4.74501 -0.158031,-7.24514";
        String Coordenadas7="m 84.86147,130.41737 c 0,0 -0.946475,0.3393 -1.821521,2.19654";
        String Coordenadas8="m 128.06862,146.15128 c 0,0 1.19962,-3.662 0.84605,-6.74312";
        String Coordenadas9="m 130.61939,140.62041 c 0,0 2.2477,-2.27296 2.2477,-4.01557 0,-1.7426 -0.17679,-2.34872 -0.17679,-2.34872 0,0 -0.17678,-4.34387 3.08113,-6.56632";
        String Coordenadas10="m 125.24005,130.6699 c 0,0 1.21225,1.21224 1.33852,1.89413 0.12628,0.68189 -0.17679,0.85867 0.12628,0.68189";
        String Coordenadas11="m 96.941708,127.34885 c 0,0 3.220022,-4.3565 6.364282,-2.36135";
        String Coordenadas12="m 106.55127,124.69707 c 0,0 5.75817,-2.29822 7.19771,2.42449";
        String Coordenadas13="m 90.897495,138.20348 1.428644,-0.78576";
        String Coordenadas14="m 91.736822,137.82846 c 0,0 10.800078,13.30314 27.126388,0.60717";
        String Coordenadas15="m 118.28059,138.14098 1.04693,0.91299 ";
        String Coordenadas16="m 100.75214,143.97155 c -3.88929,3.63674 -4.116585,-1.56581 -4.116585,-1.56581 0,0 2.727549,1.33851 4.116585,1.56581 z";
        String Coordenadas17="m 100.95616,144.13183 c 0,0 2.1972,5.72028 4.77322,0.41671";
        String Coordenadas18="m 106.31695,144.44912 c 0,0 2.85383,4.25548 4.53329,-0.5935";
        String Coordenadas19="m 111.33712,143.33129 c 0,0 3.03061,2.47179 3.49783,-1.56902";
        String Coordenadas20="m 105.26326,133.85204 c 0,0 -0.22729,0.88393 -2.22244,1.56581 l -4.874238,-0.17678 c 0,0 -2.879082,4.29337 1.060714,4.14184 0,0 3.260074,0.93675 2.706474,-1.47409 0,0 3.42875,6.16996 7.35752,-0.4018 l -0.6161,1.10719 c 0,0 2.77692,1.44651 4.99132,-0.125 0,0 1.8126,-2.75907 -2.36619,-3.19659 l -3.71447,0.0982 c 0,0 -1.27,-0.33638 -2.32259,-1.5388 z";
        String Coordenadas21="m 98.015051,133.06913 c 0,0 0.492474,-4.19235 3.068499,-4.0787 0,0 4.12921,0.82079 3.44732,4.45753 0,0 -2.22245,2.46237 -6.515819,-0.37883 z";
        String Coordenadas22="m 103.65707,133.94433 c 0.3393,-0.60717 -0.38394,-2.30369 -0.38394,-2.30369 0,0 -1.17864,-1.13398 -2.33048,-0.16072 -1.151846,0.97327 -0.58039,2.41977 -0.58039,2.41977 0,0 1.5715,1.15184 3.29481,0.0446 z";
        String Coordenadas23="m 101.14668,134.1993 c 0,0 -0.87761,-1.49005 0.70715,-2.37398 0,0 1.53424,0.1831 1.23118,2.32978";
        String Coordenadas24="m 100.38012,132.32818 c 0,0 2.7055,1.12506 0.8929,-1.02684";
        String Coordenadas25="m 106.22296,133.99094 c 0,0 -0.26518,-3.119 1.49005,-4.47015 0,0 3.82615,-2.31084 4.74796,3.62411 0,0 -1.85625,2.10879 -6.23801,0.84604 z";
        String Coordenadas26="m 106.7912,134.04145 c 0,0 -0.31569,-2.50025 1.18699,-2.7528 0,0 2.36135,-0.45459 2.03303,2.99273";
        String Coordenadas27="m 106.91747,132.61454 c 0,0 2.07092,0.44196 0.64401,-1.07334";
        String Coordenadas28="m 107.48571,134.16773 -0.0253,-1.3764 c 0,0 0.89655,0.21466 0.69451,-0.88393 0,0 1.74266,-0.20204 1.33858,2.38661";
       
        String Coordenadas29="m -880.82767,-187.29769 h 1640.84 v 73.28155 h -1640.84 z";
        String Coordenadas30="m 111.3614,152.7416 -1.59377,2.30856 c 8.1524,-0.6182 11.78427,3.43869 11.78427,3.43869 8.42286,3.78642 -1.41025,12.71156 -1.41025,12.71156 0.65683,1.02388 -1.66139,4.34666 -1.66139,4.34666 l 1.33298,-1.5648 c 2.33754,3.14891 -2.04776,4.79098 -2.04776,4.79098 -1.41025,1.46821 -6.12396,-2.10571 -6.12396,-2.10571 l -1.70398,2.06293 6.47495,24.61573 c 1.78949,0.83328 2.73205,7.23993 2.73205,7.23993 3.38773,4.97232 -1.59316,3.58698 -1.59316,3.58698 0.51908,-1.17478 -0.26463,-3.25914 -0.26463,-3.25914 1.50262,5.70998 -3.27188,3.70289 -3.27188,3.70289 0.46445,-1.39334 0.13002,-3.457 0.13002,-3.457 0.73766,7.32188 -3.98592,3.23913 -3.98592,3.23913 0.42346,-1.36602 0.11094,-2.9775 0.11094,-2.9775 0.15455,9.31151 -4.67632,0.95413 -4.67632,0.95413 l -1.51629,-3.01892 -0.87796,0.36477 c -2.85913,0.27042 -8.925136,0.23182 -8.925136,0.23182 -5.525087,1.81594 -5.679635,-2.31822 -5.679635,-2.31822 -0.193185,-1.62275 1.738664,-3.51596 1.738664,-3.51596 2.16367,-2.66596 3.477327,-3.36142 3.477327,-3.36142 1.236383,-6.14328 -1.27502,-21.2117 -1.27502,-21.2117 2.588677,0.73411 6.066004,1.3523 6.066004,1.3523 -6.259189,-0.54092 -9.620605,-4.75235 -9.620605,-4.75235 -1.352294,0.42501 -4.018245,-9.65924 -4.018245,-9.65924 -1.700023,-1.42957 -1.622753,-6.52965 -1.622753,-6.52965 4.520526,-7.80467 14.527499,-5.13872 14.527499,-5.13872 0.115911,-2.00912 -1.390931,-2.47276 -1.390931,-2.47276 0,0 10.567211,1.25571 14.884891,0.39603 z";
        String Coordenadas31="m 111.65873,176.73607 c 0,0 -3.2434,-5.41975 0.9294,-10.05619 4.17279,-4.63644 4.16587,-3.95921 4.16587,-3.95921";
        String Coordenadas32="m 88.68222,207.96336 c 0,0 0.409808,-1.43432 1.734849,-2.02172 1.325044,-0.58739 1.2021,-0.81961 1.2021,-0.81961";
        String Coordenadas33="m 103.93344,209.41237 -1.12047,-24.99812";
        String Coordenadas34="m 102.82056,184.54972 c 0,0 0.0136,-3.68826 -1.70753,-3.64728 l 1.65289,5.8739 z";
        String Coordenadas35="m 89.173988,176.29894 c 0,0 -1.475303,-9.56216 3.114532,-12.97722 0.191246,0.10929 3.524342,-2.97793 4.043431,-4.04342";
        String Coordenadas36="m 94.892393,160.80706 c -0.05795,0 -3.013683,-0.12557 -3.786423,0.82104 0,0 -0.598871,0.74376 1.110815,1.62275";
        String Coordenadas37="m 88.807072,161.01956 2.298898,0.86934";
        String Coordenadas38="m 114.82904,164.11052 c -1.83525,-1.9898 -5.29326,-2.41481 -5.29326,-2.41481 l -0.0193,2.80118 2.2989,3.12959 c 0.19565,0.0178 2.20975,-2.55814 3.01366,-3.51596 z";
         
        //Cabello
        SVGPath path1 = new SVGPath();
        path1.setContent(Coordenadas1);
        path1.setFill(Color.web("#d2d6e1"));
        path1.setStroke(Color.BLACK);
        path1.setStrokeWidth(1);
        SVGPath path2 = new SVGPath();
        path2.setContent(Coordenadas2);
        path2.setFill(Color.web("#d2d6e1"));
        path2.setStroke(Color.BLACK);
        path2.setStrokeWidth(1);
        
        TranslateTransition moverCabello1 = new TranslateTransition(Duration.seconds(1), path1);
        moverCabello1.setByX(100);
        moverCabello1.setAutoReverse(true);
        moverCabello1.setCycleCount(2);
        TranslateTransition moverCabello2 = new TranslateTransition(Duration.seconds(1), path2);
        moverCabello2.setByX(100);
        moverCabello2.setAutoReverse(true);
        moverCabello2.setCycleCount(2);
        
        RotateTransition rotarCabello1 = new RotateTransition(Duration.seconds(1), path1);
        rotarCabello1.setByAngle(360);
        rotarCabello1.setCycleCount(2);
        rotarCabello1.setAutoReverse(true);
        RotateTransition rotarCabello2 = new RotateTransition(Duration.seconds(1), path2);
        rotarCabello2.setByAngle(360);
        rotarCabello2.setCycleCount(2);
        rotarCabello2.setAutoReverse(true);
        
        ScaleTransition escalarCabello1 = new ScaleTransition(Duration.seconds(1.5), path1);
        escalarCabello1.setFromX(1);
        escalarCabello1.setFromY(1);
        escalarCabello1.setToX(1.5);
        escalarCabello1.setToY(1.5);
        escalarCabello1.setCycleCount(ScaleTransition.INDEFINITE);
        escalarCabello1.setAutoReverse(true);
      
        //Cara
        SVGPath path3 = new SVGPath();
        path3.setContent(Coordenadas3);
        path3.setFill(Color.web("#000000"));
        path3.setStroke(Color.BLACK);
        path3.setStrokeWidth(1);
        SVGPath path4 = new SVGPath();
        path4.setContent(Coordenadas4);
        path4.setFill(Color.web("#aabbd4"));
        path4.setStroke(Color.BLACK);
        path4.setStrokeWidth(1);
        SVGPath path5 = new SVGPath();
        path5.setContent(Coordenadas5);
        path5.setFill(Color.web("#aabbd4"));
        path5.setStroke(Color.BLACK);
        path5.setStrokeWidth(1);
        SVGPath path6 = new SVGPath();
        path6.setContent(Coordenadas6);
        path6.setFill(Color.web("#aabbd4"));
        path6.setStroke(Color.BLACK);
        path6.setStrokeWidth(1);
        SVGPath path7 = new SVGPath();
        path7.setContent(Coordenadas7);
        path7.setFill(Color.web("#aabbd4"));
        path7.setStroke(Color.BLACK);
        path7.setStrokeWidth(1);
        SVGPath path8 = new SVGPath();
        path8.setContent(Coordenadas8);
        path8.setFill(Color.web("#aabbd4"));
        path8.setStroke(Color.BLACK);
        path8.setStrokeWidth(1);
        SVGPath path9 = new SVGPath();
        path9.setContent(Coordenadas9);
        path9.setFill(Color.web("#aabbd4"));
        path9.setStroke(Color.BLACK);
        path9.setStrokeWidth(1);
        SVGPath path10 = new SVGPath();
        path10.setContent(Coordenadas10);
        path10.setFill(Color.web("#aabbd4"));
        path10.setStroke(Color.BLACK);
        path10.setStrokeWidth(1);
        SVGPath path11 = new SVGPath();
        path11.setContent(Coordenadas11);
        path11.setFill(Color.web("#aabbd4"));
        path11.setStroke(Color.BLACK);
        path11.setStrokeWidth(1);
        SVGPath path12 = new SVGPath();
        path12.setContent(Coordenadas12);
        path12.setFill(Color.web("#aabbd4"));
        path12.setStroke(Color.BLACK);
        path12.setStrokeWidth(1);
        SVGPath path13 = new SVGPath();
        path13.setContent(Coordenadas13);
        path13.setFill(Color.web("#aabbd4"));
        path13.setStroke(Color.BLACK);
        path13.setStrokeWidth(1);
        SVGPath path14 = new SVGPath();
        path14.setContent(Coordenadas14);
        path14.setFill(Color.web("#aabbd4"));
        path14.setStroke(Color.BLACK);
        path14.setStrokeWidth(1);
        SVGPath path15 = new SVGPath();
        path15.setContent(Coordenadas15);
        path15.setFill(Color.web("#aabbd4"));
        path15.setStroke(Color.BLACK);
        path15.setStrokeWidth(1);
        SVGPath path16 = new SVGPath();
        path16.setContent(Coordenadas16);
        path16.setFill(Color.web("#eef3ff"));
        path16.setStroke(Color.BLACK);
        path16.setStrokeWidth(1);
        SVGPath path17 = new SVGPath();
        path17.setContent(Coordenadas17);
        path17.setFill(Color.web("#eef3ff"));
        path17.setStroke(Color.BLACK);
        path17.setStrokeWidth(1);
        SVGPath path18 = new SVGPath();
        path18.setContent(Coordenadas18);
        path18.setFill(Color.web("#eef3ff"));
        path18.setStroke(Color.BLACK);
        path18.setStrokeWidth(1);
        SVGPath path19 = new SVGPath();
        path19.setContent(Coordenadas19);
        path19.setFill(Color.web("#eef3ff"));
        path19.setStroke(Color.BLACK);
        path19.setStrokeWidth(1);
        SVGPath path20 = new SVGPath();
        path20.setContent(Coordenadas20);
        path20.setFill(Color.web("#90c342"));
        path20.setStroke(Color.BLACK);
        path20.setStrokeWidth(1);
        SVGPath path21 = new SVGPath();
        path21.setContent(Coordenadas21);
        path21.setFill(Color.web("#ffffff"));
        path21.setStroke(Color.BLACK);
        path21.setStrokeWidth(1);
        SVGPath path22 = new SVGPath();
        path22.setContent(Coordenadas22);
        path22.setFill(Color.web("#658b8b"));
        path22.setStroke(Color.BLACK);
        path22.setStrokeWidth(1);
        SVGPath path23 = new SVGPath();
        path23.setContent(Coordenadas23);
        path23.setFill(Color.web("#000000"));
        path23.setStroke(Color.BLACK);
        path23.setStrokeWidth(1);
        SVGPath path24 = new SVGPath();
        path24.setContent(Coordenadas24);
        path24.setFill(Color.web("#ffffff"));
        path24.setStroke(Color.BLACK);
        path24.setStrokeWidth(1);
        SVGPath path25 = new SVGPath();
        path25.setContent(Coordenadas25);
        path25.setFill(Color.web("#ffffff"));
        path25.setStroke(Color.BLACK);
        path25.setStrokeWidth(1);
        SVGPath path26 = new SVGPath();
        path26.setContent(Coordenadas26);
        path26.setFill(Color.web("#658b8b"));
        path26.setStroke(Color.BLACK);
        path26.setStrokeWidth(1);
        SVGPath path27 = new SVGPath();
        path27.setContent(Coordenadas27);
        path27.setFill(Color.web("#ffffff"));
        path27.setStroke(Color.BLACK);
        path27.setStrokeWidth(1);
        SVGPath path28 = new SVGPath();
        path28.setContent(Coordenadas28);
        path28.setFill(Color.web("#000000"));
        path28.setStroke(Color.BLACK);
        path28.setStrokeWidth(1);
        
        //Piernas
        SVGPath path29 = new SVGPath();
        path29.setContent(Coordenadas29);
        path29.setFill(Color.web("#000000"));
        path29.setStroke(Color.BLACK);
        path29.setStrokeWidth(1);
        SVGPath path30 = new SVGPath();
        path30.setContent(Coordenadas30);
        path30.setFill(Color.web("#aabbd4"));
        path30.setStroke(Color.BLACK);
        path30.setStrokeWidth(1);
        SVGPath path31 = new SVGPath();
        path31.setContent(Coordenadas31);
        path31.setFill(Color.web("#aabbd4"));
        path31.setStroke(Color.BLACK);
        path31.setStrokeWidth(1);
        SVGPath path32 = new SVGPath();
        path32.setContent(Coordenadas32);
        path32.setFill(Color.web("#aabbd4"));
        path32.setStroke(Color.BLACK);
        path32.setStrokeWidth(1);
        SVGPath path33 = new SVGPath();
        path33.setContent(Coordenadas33);
        path33.setFill(Color.web("#cce1ff"));
        path33.setStroke(Color.BLACK);
        path33.setStrokeWidth(1);
        SVGPath path34 = new SVGPath(); 
        path34.setContent(Coordenadas34);
        path34.setFill(Color.web("#ffffff"));
        path34.setStroke(Color.BLACK);
        path34.setStrokeWidth(1);
        SVGPath path35 = new SVGPath(); 
        path35.setContent(Coordenadas35);
        path35.setFill(Color.web("#aabbd4"));
        path35.setStroke(Color.BLACK);
        path35.setStrokeWidth(1);
        SVGPath path36 = new SVGPath(); 
        path36.setContent(Coordenadas36);
        path36.setFill(Color.web("#ffffff"));
        path36.setStroke(Color.BLACK);
        path36.setStrokeWidth(1);
        SVGPath path37 = new SVGPath(); 
        path37.setContent(Coordenadas37);
        path37.setFill(Color.web("#ffffff"));
        path37.setStroke(Color.BLACK);
        path37.setStrokeWidth(1);
        SVGPath path38 = new SVGPath(); 
        path38.setContent(Coordenadas38);
        path38.setFill(Color.web("#ffffff"));
        path38.setStroke(Color.BLACK);
        path38.setStrokeWidth(1);


        root.getChildren().addAll(path1,path2,path3,path4,path5,path6,path7,path8,path9,path10,path11,path12,path13,path14,path15,path16,path17,path18,path19,path20,path21,path22,path23,path24,path25,path26,path27,path28,path29,path30,path31,path32,path33
                ,path34,path35,path36,path37,path38);

        VBox cajacheck = new VBox(10);
        cajacheck.getChildren().addAll(mover, rotar, escalar);
        roo.setLeft(cajacheck);
        roo.setCenter(root);
        mover.setOnAction(e ->{
            moverCabello1.playFromStart();
            moverCabello2.playFromStart();
        });

        rotar.setOnAction(e ->{
            rotarCabello1.playFromStart();
            rotarCabello2.playFromStart();
        });
        escalar.setOnAction(e ->{
            escalarCabello1.playFromStart();
        });

        drawingContainer.getChildren().addAll(path1,path2,path3,path4,path5,path6,path7,path8,path9,path10,path11,path12,path13,path14,path15,path16,path17,path18,path19,path20,path21,path22,path23,path24,path25,path26,path27,path28,path29,path30,path31,path32,path33
                ,path34,path35,path36,path37,path38);

        root.getChildren().add(drawingContainer);
        roo.setCenter(root);

        Scene scene = new Scene(roo, 600, 600);
        primaryStage.setTitle("Diamantito");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}
