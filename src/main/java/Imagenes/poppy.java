package Imagenes;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class poppy extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        // Path 1 - Pelo
        Path path1 = new Path();
        path1.getElements().addAll(
                new MoveTo(73.05, 13.95),
                new LineTo(76.95, 18.45),
                new LineTo(78, 22.35),
                new LineTo(75.75, 26.700001),
                new LineTo(60.900002, 37.350002),
                new LineTo(53.700001, 44.7),
                new LineTo(51.450001, 50.700001),
                new LineTo(51.750001, 56.85),
                new LineTo(52.800001, 59.4),
                new LineTo(55.499999, 61.05),
                new LineTo(57.75, 59.25),
                new LineTo(55.349999, 56.999999),
                new LineTo(55.65, 55.95),
                new LineTo(58.499999, 55.65),
                new LineTo(59.25, 54.3),
                new LineTo(60.299998, 55.65),
                new LineTo(61.799997, 54.75),
                new LineTo(63.749998, 55.499998),
                new LineTo(69.299998, 53.249998),
                new LineTo(68.55, 51.15),
                new LineTo(70.35, 49.5),
                new LineTo(73.65, 49.949999),
                new LineTo(75.3, 51.150001),
                new LineTo(75.749998, 48.9),
                new LineTo(76.499999, 48.6),
                new LineTo(77.250001, 49.649998),
                new LineTo(77.1, 51.449999),
                new LineTo(80.25, 49.949999),
                new LineTo(83.099999, 49.799999),
                new LineTo(84.599999, 50.249999),
                new LineTo(84.749999, 51.899998),
                new LineTo(82.949999, 53.099998),
                new LineTo(85.049999, 52.499999),
                new LineTo(93.449999, 55.349998),
                new LineTo(94.2, 54.15),
                new LineTo(95.549999, 54.45),
                new LineTo(97.049999, 56.400001),
                new LineTo(97.95, 55.95),
                new LineTo(98.699999, 56.999999),
                new LineTo(102.3, 56.849999),
                new LineTo(102.9, 58.050001),
                new LineTo(102, 59.25),
                new LineTo(104.7, 64.5),
                new LineTo(107.7, 60.9),
                new LineTo(109.65, 55.349998),
                new LineTo(109.35, 51),
                new LineTo(105.6, 43.35),
                new LineTo(98.249998, 30.300001),
                new LineTo(98.399998, 25.65),
                new LineTo(102.45, 21.6),
                new LineTo(107.4, 19.65),
                new LineTo(100.95, 19.95),
                new LineTo(105.9, 18),
                new LineTo(110.1, 18.15),
                new LineTo(115.2, 19.8),
                new LineTo(107.55, 15),
                new LineTo(101.7, 14.4),
                new LineTo(95.399998, 15.45),
                new LineTo(91.499997, 17.25),
                new LineTo(90.749999, 18.3),
                new LineTo(94.049999, 14.1),
                new LineTo(99.449999, 12.15),
                new LineTo(94.049999, 12.45),
                new LineTo(98.1, 9.1499998),
                new LineTo(91.349998, 10.2),
                new LineTo(87, 13.35),
                new LineTo(84.449998, 16.5),
                new LineTo(82.500001, 10.65),
                new LineTo(77.849999, 5.6999999),
                new LineTo(80.25, 10.05),
                new LineTo(82.2, 14.25),
                new LineTo(81.9, 17.1),
                new LineTo(78.75, 11.1),
                new LineTo(70.799999, 7.6499999),
                new LineTo(76.049999, 11.85),
                new LineTo(79.199999, 16.8),
                new ClosePath()
        );
        path1.setFill(Color.rgb(212, 23, 111));
        path1.setStroke(Color.BLACK);
        path1.setStrokeWidth(0.265);

        // Path 4
        Path path4 = new Path();
        path4.getElements().addAll(
                new MoveTo(56.250001, 55.95),
                new LineTo(58.499999, 55.65),
                new LineTo(60.45, 56.400001),
                new CubicCurveTo(60.576182, 55.310304, 61.286377, 55.193962, 61.8, 54.75),
                new LineTo(63.899999, 55.65),
                new LineTo(64.65, 57.9),
                new LineTo(62.55, 57.9),
                new LineTo(62.249999, 59.7),
                new LineTo(60.953033, 62.374263),
                new LineTo(59.55, 61.05),
                new LineTo(59.25, 58.200001),
                new LineTo(55.95, 57.75),
                new CubicCurveTo(55.287223, 56.863959, 55.313482, 56.236305, 56.25, 55.95),
                new ClosePath()
        );
        path4.setFill(Color.rgb(55, 168, 230));
        path4.setStroke(Color.BLACK);
        path4.setStrokeWidth(0.265);

        // Path 5
        Path path5 = new Path();
        path5.getElements().addAll(
                new MoveTo(68.550001, 52.2),
                new LineTo(71.249999, 53.85),
                new LineTo(74.699999, 53.85),
                new LineTo(73.799999, 55.65),
                new LineTo(75.449999, 58.050001),
                new LineTo(79.049999, 57.6),
                new LineTo(79.199999, 54.3),
                new LineTo(83.25, 53.249999),
                new LineTo(84.9, 51.299998),
                new CubicCurveTo(85.135292, 50.582772, 84.596867, 50.08661, 83.85, 49.65),
                new LineTo(78.75, 50.25),
                new LineTo(76.8, 52.05),
                new LineTo(73.65, 49.95),
                new LineTo(70.2, 49.65),
                new CubicCurveTo(69.147221, 50.284524, 68.61288, 51.141236, 68.55, 52.2),
                new ClosePath()
        );
        path5.setFill(Color.rgb(55, 168, 230));
        path5.setStroke(Color.BLACK);
        path5.setStrokeWidth(0.265);

        // Path 6
        Path path6 = new Path();
        path6.getElements().addAll(
                new MoveTo(93.449999, 57.149999),
                new LineTo(94.35, 59.25),
                new LineTo(95.099999, 61.949999),
                new LineTo(97.65, 63.300001),
                new LineTo(97.65, 62.7),
                new CubicCurveTo(98.848124, 63.407505, 100.07342, 64.00632, 101.55, 63.599998),
                new LineTo(102, 62.249999),
                new LineTo(99.45, 60.449999),
                new LineTo(102.75, 58.649999),
                new LineTo(102.6, 56.699999),
                new LineTo(99.3, 57.149999),
                new LineTo(98.1, 58.200001),
                new LineTo(97.35, 56.25),
                new LineTo(95.85, 54.45),
                new LineTo(94.2, 53.85),
                new CubicCurveTo(93.63865, 54.742433, 93.174762, 55.699841, 93.45, 57.149999),
                new ClosePath()
        );
        path6.setFill(Color.rgb(55, 168, 230));
        path6.setStroke(Color.BLACK);
        path6.setStrokeWidth(0.265);

        // Path 7
        Path path7 = new Path();
        path7.getElements().addAll(
                new MoveTo(60.149999, 61.500001),
                new LineTo(58.349998, 63),
                new LineTo(55.65, 61.05),
                new LineTo(57.75, 58.949999),
                new LineTo(55.65, 57.6),
                new LineTo(59.25, 58.499998),
                new ClosePath()
        );
        path7.setFill(Color.rgb(85, 230, 55));
        path7.setStroke(Color.BLACK);
        path7.setStrokeWidth(0.265);

        // Path 9
        Path path9 = new Path();
        path9.getElements().addAll(
                new MoveTo(58.949999, 54.750001),
                new CubicCurveTo(59.199268, 53.730652, 60.247913, 55.64235, 60.9, 56.1),
                new LineTo(60.599999, 56.549999),
                new CubicCurveTo(58.345871, 55.476631, 58.738436, 55.138456, 58.949999, 54.750001),
                new ClosePath()
        );
        path9.setFill(Color.rgb(85, 230, 55));
        path9.setStroke(Color.BLACK);
        path9.setStrokeWidth(0.265);

        // Path 10
        Path path10 = new Path();
        path10.getElements().addAll(
                new MoveTo(64.275001, 57.600001),
                new CubicCurveTo(64.798674, 57.970532, 64.974196, 58.480322, 64.5, 59.25),
                new LineTo(63.899999, 60.149999),
                new LineTo(62.25, 58.875),
                new CubicCurveTo(62.527041, 58.131633, 63.006298, 57.550039, 64.275001, 57.6),
                new ClosePath()
        );
        path10.setFill(Color.rgb(85, 230, 55));
        path10.setStroke(Color.BLACK);
        path10.setStrokeWidth(0.265);

        // Path 11
        Path path11 = new Path();
        path11.getElements().addAll(
                new MoveTo(64.950001, 58.050001),
                new LineTo(70.350001, 55.8),
                new LineTo(73.65, 55.95),
                new LineTo(74.549999, 53.85),
                new LineTo(71.55, 54),
                new LineTo(69.6, 52.800001),
                new LineTo(64.049999, 55.499999),
                new ClosePath()
        );
        path11.setFill(Color.rgb(85, 230, 55));
        path11.setStroke(Color.BLACK);
        path11.setStrokeWidth(0.265);

        // Path 12
        Path path12 = new Path();
        path12.getElements().addAll(
                new MoveTo(79.649999, 55.65),
                new LineTo(83.249999, 56.250001),
                new LineTo(82.05, 54.45),
                new LineTo(91.499997, 56.849999),
                new LineTo(93, 58.050001),
                new LineTo(92.25, 58.949999),
                new LineTo(93.899999, 59.25),
                new LineTo(93.749999, 57.3),
                new LineTo(93.299998, 54.899999),
                new LineTo(85.049999, 52.65),
                new LineTo(83.55, 53.099998),
                new LineTo(79.649999, 54.45),
                new CubicCurveTo(78.851941, 54.317961, 79.195974, 54.947317, 79.65, 55.65),
                new ClosePath()
        );
        path12.setFill(Color.rgb(85, 230, 55));
        path12.setStroke(Color.BLACK);
        path12.setStrokeWidth(0.265);

        // Path 13
        Path path13 = new Path();
        path13.getElements().addAll(
                new MoveTo(75.15, 50.55),
                new LineTo(76.049999, 48.75),
                new LineTo(77.1, 49.500001),
                new LineTo(77.399998, 51.599999),
                new LineTo(77.1, 52.2),
                new ClosePath()
        );
        path13.setFill(Color.rgb(85, 230, 55));
        path13.setStroke(Color.BLACK);
        path13.setStrokeWidth(0.265);

        // Path 14
        Path path14 = new Path();
        path14.getElements().addAll(
                new MoveTo(97.5, 63.599998),
                new LineTo(99, 63.749999),
                new LineTo(100.35, 65.399999),
                new LineTo(102.15, 66.299999),
                new LineTo(104.85, 64.799999),
                new CubicCurveTo(103.79992, 63.049374, 102.46105, 59.132843, 101.7, 59.549999),
                new LineTo(99.281802, 60.424261),
                new LineTo(101.85, 62.099998),
                new LineTo(101.63787, 63.784833),
                new ClosePath()
        );
        path14.setFill(Color.rgb(85, 230, 55));
        path14.setStroke(Color.BLACK);
        path14.setStrokeWidth(0.265);

        // Path 15
        Path path15 = new Path();
        path15.getElements().addAll(
                new MoveTo(96.749998, 56.400001),
                new LineTo(98.1, 56.1),
                new LineTo(99.3, 57.45),
                new LineTo(97.8, 58.649999),
                new ClosePath()
        );
        path15.setFill(Color.rgb(85, 230, 55));
        path15.setStroke(Color.BLACK);
        path15.setStrokeWidth(0.265);

        // Path 16 - Oreja izquierda
        Path path16 = new Path();
        path16.getElements().addAll(
                new MoveTo(53.249999, 59.55),
                new LineTo(59.1, 63.449998),
                new CubicCurveTo(57.963776, 66.859437, 56.104617, 68.461539, 54.6, 70.949999),
                new CubicCurveTo(51.982449, 71.139086, 49.46967, 70.647149, 47.25, 68.25),
                new CubicCurveTo(46.248059, 66.353881, 44.958442, 65.033116, 44.699999, 61.65),
                new CubicCurveTo(44.767499, 60.071879, 45.83302, 59.741275, 46.65, 59.099999),
                new CubicCurveTo(47.841258, 58.385363, 50.740422, 59.134649, 53.25, 59.55),
                new ClosePath()
        );
        path16.setFill(Color.rgb(249, 120, 185));
        path16.setStroke(Color.BLACK);
        path16.setStrokeWidth(0.265);

        // Path 17 - Pelo mas para abajo
        Path path17 = new Path();
        path17.getElements().addAll(
                new MoveTo(54.45, 71.099999),
                new LineTo(52.950001, 74.399999),
                new LineTo(60.45, 69.149999),
                new LineTo(61.650001, 71.55),
                new LineTo(63, 66.45),
                new LineTo(68.25, 59.55),
                new LineTo(72.15, 58.799999),
                new LineTo(77.250001, 59.999998),
                new LineTo(75.15, 57.9),
                new LineTo(78, 57.9),
                new CubicCurveTo(80.483169, 60.378052, 83.317233, 62.271277, 86.4, 63.749999),
                new LineTo(88.349999, 64.5),
                new LineTo(84.300001, 60.749999),
                new LineTo(87.6, 60.299999),
                new LineTo(90.299999, 64.8),
                new LineTo(92.7, 65.100001),
                new LineTo(91.799999, 66.6),
                new LineTo(94.2, 65.699999),
                new LineTo(92.999998, 67.199999),
                new LineTo(94.35, 67.499999),
                new LineTo(93.149998, 68.549999),
                new LineTo(97.8, 72.299998),
                new LineTo(107.4, 73.35),
                new LineTo(108.75, 72.749999),
                new LineTo(105.3, 71.7),
                new LineTo(111.6, 69.299999),
                new LineTo(112.2, 68.1),
                new CubicCurveTo(109.7492, 68.401061, 107.17909, 68.861216, 105.3, 68.4),
                new CubicCurveTo(103.30032, 68.43066, 101.24945, 67.118736, 102, 65.999998),
                new CubicCurveTo(99.518292, 65.401916, 99.469515, 64.108709, 98.249998, 63.15),
                new LineTo(94.949999, 61.5),
                new LineTo(93.599999, 58.649999),
                new LineTo(92.7, 59.1),
                new LineTo(92.85, 57.45),
                new LineTo(90.75, 56.400001),
                new LineTo(82.05, 54.45),
                new LineTo(82.95, 55.95),
                new LineTo(79.35, 55.199999),
                new LineTo(79.35, 57.6),
                new LineTo(75.450001, 57.6),
                new LineTo(73.65, 55.95),
                new CubicCurveTo(71.825253, 55.9589, 69.812834, 55.529942, 68.55, 56.849999),
                new CubicCurveTo(68.321748, 56.325367, 65.392436, 57.532527, 65.1, 58.65),
                new LineTo(64.35, 59.4),
                new LineTo(63, 59.4),
                new LineTo(61.650001, 60.9),
                new LineTo(61.2, 62.099999),
                new LineTo(59.7, 61.949999),
                new LineTo(58.200001, 63),
                new LineTo(59.4, 63.599998),
                new ClosePath()
        );
        path17.setFill(Color.rgb(230, 55, 137));
        path17.setStroke(Color.BLACK);
        path17.setStrokeWidth(0.265);

        // Path 18
        Path path18 = new Path();
        path18.getElements().addAll(
                new MoveTo(74.399999, 64.049999),
                new CubicCurveTo(72.899999, 64.65, 72.749999, 66.15, 72.749999, 66.15),
                new LineTo(73.799999, 68.1),
                new LineTo(76.199997, 68.55),
                new LineTo(76.8, 67.349999),
                new LineTo(75.45, 67.349999),
                new CubicCurveTo(74.814258, 66.978579, 75.014667, 66.328443, 74.925, 65.774999),
                new LineTo(75.749997, 64.574999),
                new ClosePath()
        );
        path18.setFill(Color.rgb(230, 55, 137));
        path18.setStroke(Color.BLACK);
        path18.setStrokeWidth(0.265);

        // Path 19
        Path path19 = new Path();
        path19.getElements().addAll(
                new MoveTo(90.6, 69.299999),
                new CubicCurveTo(89.180169, 69.739661, 88.277869, 69.144261, 87.45, 68.4),
                new CubicCurveTo(85.879355, 66.305882, 86.563445, 64.265522, 88.087499, 64.949998),
                new CubicCurveTo(88.474274, 64.510322, 89.328951, 65.436856, 90, 65.85),
                new CubicCurveTo(89.450694, 66.203471, 88.925416, 65.825583, 88.95, 66.6),
                new LineTo(89.849999, 67.95),
                new CubicCurveTo(90.127553, 67.91953, 90.794048, 67.776369, 91.35, 67.649999),
                new CubicCurveTo(91.235243, 68.23864, 91.36624, 68.897496, 90.6, 69.299999),
                new ClosePath()
        );
        path19.setFill(Color.rgb(230, 55, 137));
        path19.setStroke(Color.BLACK);
        path19.setStrokeWidth(0.265);

        // Path 20
        Path path20 = new Path();
        path20.getElements().addAll(
                new MoveTo(74.399998, 63.974998),
                new LineTo(70.050001, 63.562501),
                new CubicCurveTo(68.674844, 64.385782, 67.095478, 65.791403, 66.937499, 66.4875),
                new CubicCurveTo(67.109739, 67.923848, 71.283251, 68.234476, 73.35, 67.8),
                new CubicCurveTo(73.232574, 67.3, 72.956068, 66.8, 72.749999, 66.3),
                new CubicCurveTo(73.148514, 65.401484, 73.379210, 64.745787, 74.399999, 63.974998),
                new ClosePath()
        );
        path20.setFill(Color.WHITE);
        path20.setStroke(Color.BLACK);
        path20.setStrokeWidth(0.265);

        // Path 21 - Parte de los ojos
        Path path21 = new Path();
        path21.getElements().addAll(
                new MoveTo(88.8, 69.75),
                new CubicCurveTo(89.183712, 70.538185, 82.14011, 71.358383, 81.959998, 70.3125),
                new CubicCurveTo(79.416401, 68.897395, 81.690398, 66.390644, 83.31, 65.699999),
                new CubicCurveTo(84.16467, 64.757784, 85.538495, 64.680826, 86.985, 64.725001),
                new CubicCurveTo(86.736372, 65.7, 86.232209, 66.675, 86.535, 67.65),
                new ClosePath()
        );
        path21.setFill(Color.WHITE);
        path21.setStroke(Color.BLACK);
        path21.setStrokeWidth(0.265);

        // Path 22
        Path path22 = new Path();
        path22.getElements().addAll(
                new MoveTo(66.900001, 66.525),
                new LineTo(66.3375, 64.95),
                new LineTo(65.249998, 63.749999),
                new CubicCurveTo(65.163978, 63.337229, 66.088847, 63.80899, 66.75, 64.05),
                new LineTo(66.45, 62.55),
                new LineTo(67.8, 63.300001),
                new LineTo(67.65, 61.500001),
                new LineTo(69.45, 62.400001),
                new LineTo(73.05, 63.225),
                new LineTo(74.399999, 63.599998),
                new LineTo(69.9, 63.599998),
                new CubicCurveTo(68.67226, 64.385215, 67.534679, 65.245565, 66.9, 66.525),
                new ClosePath()
        );
        path22.setFill(Color.BLACK);
        path22.setStroke(Color.BLACK);
        path22.setStrokeWidth(0.265);

        // Path 24 - Cara
        Path path24 = new Path();
        path24.getElements().addAll(
                new MoveTo(56.625, 71.999999),
                new CubicCurveTo(56.242878, 72.63687, 59.500215, 75.994446, 59.55, 76.35),
                new CubicCurveTo(59.756397, 77.82404, 68.855077, 81.842671, 68.925, 81.375001),
                new LineTo(82.35, 82.500002),
                new CubicCurveTo(87.30744, 83.303104, 90.739366, 81.273112, 94.35, 79.575001),
                new CubicCurveTo(95.914669, 78.729338, 97.453135, 77.83127, 98.625, 76.2),
                new LineTo(98.85, 72.299999),
                new LineTo(97.424999, 72.224999),
                new LineTo(93.525001, 68.774999),
                new LineTo(90.9, 70.05),
                new LineTo(82.275, 70.274999),
                new CubicCurveTo(81.877119, 68.301411, 82.543135, 67.035755, 83.327002, 65.85),
                new CubicCurveTo(84.877307, 64.92439, 85.985632, 64.882735, 87.151999, 64.725),
                new LineTo(90.151999, 64.725),
                new CubicCurveTo(89.363692, 63.2, 88.258622, 61.675, 87.827, 60.15),
                new CubicCurveTo(85.923067, 60.21421, 85.091574, 60.492915, 84.152002, 60.75),
                new LineTo(88.202, 64.5),
                new LineTo(84.602, 62.399999),
                new CubicCurveTo(80.840619, 61.337126, 80.086227, 59.271925, 77.927001, 57.675),
                new LineTo(74.927001, 57.975),
                new LineTo(77.552001, 60.225),
                new LineTo(72.077002, 58.575),
                new LineTo(68.027002, 59.55),
                new LineTo(67.502002, 61.2),
                new LineTo(69.677002, 62.4),
                new LineTo(75.077002, 63.75),
                new LineTo(76.727002, 66.525),
                new LineTo(75.752001, 69.075),
                new LineTo(66.677002, 66.6),
                new LineTo(66.377002, 64.725),
                new LineTo(65.177002, 63.9),
                new LineTo(62.927002, 66.675),
                new LineTo(61.577002, 71.7),
                new LineTo(60.152002, 68.925),
                new CubicCurveTo(59.41005, 69.971514, 58.215574, 70.842685, 56.627003, 72),
                new ClosePath()
        );
        path24.setFill(Color.rgb(249, 120, 185));
        path24.setStroke(Color.BLACK);
        path24.setStrokeWidth(0.265);

        // Path 25
        Path path25 = new Path();
        path25.getElements().addAll(
                new MoveTo(66.3, 62.099999),
                new LineTo(67.649999, 63),
                new LineTo(67.425, 60.675001),
                new ClosePath()
        );
        path25.setFill(Color.rgb(249, 120, 185));
        path25.setStroke(Color.BLACK);
        path25.setStrokeWidth(0.265);

        // Path 26
        Path path26 = new Path();
        path26.getElements().addAll(
                new MoveTo(66.224998, 62.249999),
                new LineTo(66.6, 63.675),
                new LineTo(65.475, 63.374999),
                new ClosePath()
        );
        path26.setFill(Color.rgb(249, 120, 185));
        path26.setStroke(Color.BLACK);
        path26.setStrokeWidth(0.265);

        // Path 27 - CORREGIDO
        Path path27 = new Path();
        path27.getElements().addAll(
                new MoveTo(102.45, 65.999999),
                new LineTo(105.225, 64.724999),
                new CubicCurveTo(107.23302, 64.080037, 109.44345, 63.772413, 112.05, 64.125001),
                new CubicCurveTo(113.81432, 64.767839, 113.58506, 66.40747, 113.85, 67.799998),
                new LineTo(113.85, 67.799998), // Eliminé las comillas extra
                new CubicCurveTo(113.85, 67.799998, 112.19791, 71.458284, 111.825, 71.849998),
                new CubicCurveTo(111.39645, 72.300158, 105.38297, 76.630757, 105.225, 75.524997),
                new CubicCurveTo(102.93339, 77.266071, 101.10178, 76.20724, 99.0, 76.05),
                new LineTo(99.0, 72.45),
                new LineTo(108.0, 73.5),
                new LineTo(109.2, 72.749999),
                new LineTo(109.2, 72.749999), // Eliminé las comillas extra
                new CubicCurveTo(109.2, 72.749999, 104.925, 71.624999, 105.225, 71.624999),
                new CubicCurveTo(105.525, 71.624999, 111.45, 69.375001, 111.45, 69.375001),
                new LineTo(112.5, 67.95),
                new CubicCurveTo(110.28164, 68.238279, 108.19237, 68.784739, 105.6, 68.324999),
                new CubicCurveTo(103.05488, 68.330499, 100.88559, 66.669814, 102.45, 65.999999),
                new ClosePath()
        );
        path27.setFill(Color.rgb(249, 120, 185));
        path27.setStroke(Color.BLACK);
        path27.setStrokeWidth(0.265);

        // Path 28
        Path path28 = new Path();
        path28.getElements().addAll(
                new MoveTo(71.774999, 82.2),
                new CubicCurveTo(72.511641, 83.526715, 73.620258, 84.10948, 74.774999, 84.599998),
                new CubicCurveTo(77.04607, 84.775964, 79.087407, 83.480317, 80.1, 82.274998),
                new CubicCurveTo(76.581836, 82.114878, 71.013848, 81.582062, 71.774999, 82.2),
                new ClosePath()
        );
        path28.setFill(Color.rgb(249, 120, 185));
        path28.setStroke(Color.BLACK);
        path28.setStrokeWidth(0.265);

        // Path 29 - Brazo derecho
        Path path29 = new Path();
        path29.getElements().addAll(
                new MoveTo(81.225, 88.95),
                new CubicCurveTo(81.793295, 88.393295, 85.878273, 85.353273, 86.175, 85.65),
                new LineTo(93.6, 100.725),
                new CubicCurveTo(95.16014, 100.19965, 96.352058, 100.59486, 97.65, 100.725),
                new LineTo(98.4, 101.325),
                new CubicCurveTo(98.139083, 102.04845, 97.713305, 102.67298, 96.75, 102.975),
                new CubicCurveTo(97.650349, 103.0694, 98.120232, 103.67735, 99.281804, 104.20607),
                new LineTo(99, 105.75),
                new LineTo(98.025, 106.125),
                new LineTo(97.875, 107.1),
                new CubicCurveTo(94.434259, 107.0458, 91.059769, 106.69354, 87.9, 105.375),
                new LineTo(85.875, 107.4),
                new CubicCurveTo(84.970928, 107.72036, 84.163093, 107.55954, 83.4, 107.175),
                new LineTo(83.4, 105.9),
                new LineTo(85.2, 102.9),
                new LineTo(82.2, 95.175),
                new ClosePath()
        );
        path29.setFill(Color.rgb(249, 120, 184));
        path29.setStroke(Color.BLACK);
        path29.setStrokeWidth(0.265);

        // Path 30 - Brazo izquierdo
        Path path30 = new Path();
        path30.getElements().addAll(
                new MoveTo(58.725, 96.825),
                new LineTo(60.225, 93.000001),
                new CubicCurveTo(61.403472, 92.203472, 63.0555, 91.880499, 64.5, 91.349997),
                new LineTo(65.4, 90.449998),
                new LineTo(69.15, 90.524998),
                new LineTo(70.125, 89.474999),
                new CubicCurveTo(69.7172, 89.071793, 69.35001, 88.424932, 68.849998, 88.575002),
                new LineTo(69.525001, 87.225),
                new LineTo(68.4, 86.099998),
                new CubicCurveTo(67.317712, 85.373784, 66.983919, 84.97232, 66.45, 84.337501),
                new CubicCurveTo(65.342194, 84.432811, 64.438628, 84.323871, 63.525001, 84.225001),
                new LineTo(61.875001, 83.925001),
                new CubicCurveTo(57.815425, 85.018015, 54.655764, 86.496792, 51.6, 88.275002),
                new CubicCurveTo(50.57651, 89.089934, 49.548856, 89.870939, 48.975, 90.712501),
                new CubicCurveTo(48.123788, 91.644516, 47.804632, 93.006854, 48.15, 94.425001),
                new CubicCurveTo(49.446032, 95.934325, 50.933344, 96.391612, 52.425, 96.825002),
                new CubicCurveTo(54.708806, 97.192612, 56.840664, 97.256326, 58.725001, 96.824998),
                new ClosePath()
        );
        path30.setFill(Color.rgb(249, 120, 184));
        path30.setStroke(Color.BLACK);
        path30.setStrokeWidth(0.265);

        // Path 31
        Path path31 = new Path();
        path31.getElements().addAll(
                new MoveTo(62.249999, 83.774999),
                new CubicCurveTo(64.87606, 82.745076, 67.910986, 82.226234, 71.1, 81.9),
                new CubicCurveTo(72.494069, 83.238138, 73.661188, 84.122377, 74.775, 84.899999),
                new CubicCurveTo(76.761827, 84.361827, 78.381673, 83.456673, 79.95, 82.5),
                new LineTo(83.25, 82.724999),
                new LineTo(86.1, 85.574998),
                new CubicCurveTo(84.609738, 86.380522, 82.922033, 87.580933, 81.15, 88.95),
                new CubicCurveTo(77.75, 91.750032, 74.35, 94.560954, 70.95, 97.5),
                new CubicCurveTo(69.725, 97.99184, 68.5, 97.8517, 67.275, 97.5),
                new CubicCurveTo(66.318188, 97.122718, 65.629962, 96.342557, 64.95, 95.55),
                new LineTo(64.275001, 93.375),
                new LineTo(64.65, 91.274999),
                new LineTo(65.762131, 90.587133),
                new LineTo(69.15377, 90.696967),
                new LineTo(70.221966, 89.46746),
                new LineTo(69.375001, 88.5),
                new LineTo(69.674998, 86.775002),
                new CubicCurveTo(69.248328, 87.308339, 65.806213, 83.621482, 66.6, 83.924999),
                new CubicCurveTo(66.855404, 84.022659, 62.417417, 84.444674, 62.25, 83.774999),
                new ClosePath()
        );
        path31.setFill(Color.rgb(47, 135, 226));
        path31.setStroke(Color.BLACK);
        path31.setStrokeWidth(0.265);

        // Path 32
        Path path32 = new Path();
        path32.getElements().addAll(
                new MoveTo(81.225, 89.174999),
                new LineTo(82.649998, 96.675),
                new MoveTo(82.649998, 96.675),
                new CubicCurveTo(82.649998, 96.675, 81.75, 96.825, 81.675001, 97.424998),
                new CubicCurveTo(81.600001, 98.024999, 81.600001, 98.849999, 81.600001, 98.849999),
                new LineTo(82.95, 100.575),
                new CubicCurveTo(82.05, 100.6191, 81.150001, 100.92877, 80.25, 101.25),
                new LineTo(79.95, 101.925),
                new CubicCurveTo(80.925, 102.09068, 81.899999, 102.17952, 82.875, 101.925),
                new LineTo(81.824998, 104.4),
                new CubicCurveTo(80.95661, 105.10661, 79.083851, 104.80885, 77.7, 105),
                new LineTo(74.85, 102.75),
                new LineTo(77.925, 102.6),
                new LineTo(78.9, 101.85),
                new LineTo(77.85, 101.325),
                new LineTo(75.9, 101.55),
                new LineTo(75.75, 98.925),
                new LineTo(74.7, 97.574998),
                new CubicCurveTo(74.236766, 97.358085, 73.787837, 97.105407, 73.05, 97.574998),
                new CubicCurveTo(72.504101, 97.717901, 71.911818, 97.752575, 71.775, 98.85),
                new CubicCurveTo(71.303209, 99.677422, 71.651517, 100.41372, 72.45, 101.1),
                new LineTo(73.35, 101.55),
                new LineTo(70.274999, 101.4),
                new CubicCurveTo(69.445321, 101.53313, 69.021443, 101.82858, 69.6, 102.525),
                new CubicCurveTo(71.181029, 103.22411, 72.496083, 102.85933, 73.8, 102.45),
                new LineTo(72.599999, 104.7),
                new LineTo(69.9, 105.6),
                new LineTo(65.999999, 103.65),
                new LineTo(67.874998, 102.3),
                new LineTo(67.275, 100.95),
                new LineTo(65.175, 101.7),
                new LineTo(64.8, 98.849999),
                new CubicCurveTo(64.429668, 98.416851, 64.286553, 97.85747, 62.7, 98.1),
                new CubicCurveTo(61.919658, 98.9, 62.143388, 99.7, 62.325001, 100.5),
                new LineTo(63.074999, 101.325),
                new LineTo(60.6, 101.55),
                new LineTo(60.675, 102.675),
                new CubicCurveTo(62.059247, 103.25531, 62.83619, 103.07649, 63.675, 102.975),
                new LineTo(61.949997, 104.55),
                new LineTo(58.425, 103.8),
                new LineTo(57.974999, 102.675),
                new LineTo(59.25, 102.3),
                new CubicCurveTo(59.515371, 101.49629, 59.13933, 101.27128, 58.2, 100.95),
                new CubicCurveTo(57.811851, 99.60237, 58.21018, 98.412036, 58.5, 97.2),
                new LineTo(60.225, 93.225),
                new CubicCurveTo(61.475421, 92.300422, 63.219161, 91.869162, 64.725, 91.2),
                new LineTo(64.2, 93.524999),
                new LineTo(65.025, 95.999999),
                new LineTo(67.575002, 97.874998),
                new LineTo(71.175001, 97.574998),
                new LineTo(80.625, 89.324999),
                new ClosePath()
        );
        path32.setFill(Color.rgb(47, 135, 226));
        path32.setStroke(Color.BLACK);
        path32.setStrokeWidth(0.265);
        // Path 33 - EXACTAMENTE EL ORIGINAL DEL SVG
        Path path33 = new Path();
        path33.getElements().addAll(
                new MoveTo(58.499999, 104.025),
                new CubicCurveTo(58.424999, 104.775, 58.424999, 105.75, 58.424999, 105.75),
                new LineTo(64.199998, 106.95),
                new LineTo(75.899998, 107.325),
                new LineTo(83.399998, 106.05),
                new LineTo(85.274997, 102.675),
                new LineTo(82.724998, 96.9),
                new LineTo(81.6, 97.424999),
                new LineTo(81.525, 99.074998),
                new LineTo(83.1, 100.875),
                new CubicCurveTo(81.284586, 100.41472, 81.015846, 100.98556, 80.4, 101.325),
                new LineTo(79.95, 101.925),
                new LineTo(82.875, 101.775),
                new LineTo(81.75, 104.325),
                new LineTo(79.95, 105.075),
                new LineTo(77.999999, 103.125),
                new LineTo(80.15, 102.45),
                new LineTo(81.275, 101.7),
                new LineTo(79.1, 101.475),
                new LineTo(77.45, 101.625),
                new CubicCurveTo(78.210431, 101.11334, 78.193901, 99.980121, 78.275, 98.925),
                new LineTo(74.625001, 97.574998),
                new LineTo(73.209099, 97.397702),
                new LineTo(71.9159, 97.758274),
                new CubicCurveTo(70.906206, 98.754099, 71.82381, 100.43442, 72.300098, 101.02499),
                new LineTo(73.425099, 101.4),
                new LineTo(70.500099, 101.325),
                new CubicCurveTo(69.754871, 101.50659, 69.470858, 101.11166, 69.285671, 100.5932),
                new CubicCurveTo(70.560672, 101.43211, 72.525101, 101.12239, 73.800102, 100.91139),
                new LineTo(72.150102, 103.53639),
                new LineTo(69.600102, 103.83639),
                new CubicCurveTo(68.050829, 102.9659, 66.305937, 101.84389, 65.700101, 102.18539),
                new CubicCurveTo(66.533668, 101.51301, 67.446477, 100.78781, 67.8751, 100.38539),
                new CubicCurveTo(68.050942, 99.89022, 67.483094, 99.54379, 66.975102, 99.18539),
                new LineTo(65.025102, 100.16039),
                new CubicCurveTo(65.219083, 99.21039, 64.933782, 98.26039, 64.875101, 97.31039),
                new CubicCurveTo(64.490864, 98.028486, 63.644079, 97.94161, 62.7001, 98.024999),
                new CubicCurveTo(62.44423, 98.649595, 61.748952, 98.709239, 62.400099, 100.5),
                new LineTo(63.375099, 101.4),
                new LineTo(60.684199, 101.49739),
                new CubicCurveTo(60.689099, 102.4875, 61.013795, 102.8382, 61.584199, 102.69739),
                new CubicCurveTo(62.205158, 103.03451, 62.771738, 103.11051, 63.675101, 102.59739),
                new LineTo(61.950101, 104.84739),
                new ClosePath()
        );
        path33.setFill(Color.rgb(205, 226, 248));
        path33.setStroke(Color.BLACK);
        path33.setStrokeWidth(0.265);


        //Path 34 - Pierna derecha
        Path path34 = new Path();
        path34.getElements().addAll(
                new MoveTo(73.65, 107.325),
                new LineTo(81.375, 127.275),
                new CubicCurveTo(85.51801, 128.99005, 89.437456, 129.58729, 93.3, 129.9),
                new LineTo(96.3, 129.45),
                new LineTo(98.324999, 129.15),
                new LineTo(98.024999, 127.65),
                new LineTo(98.399998, 127.05),
                new LineTo(95.774998, 125.175),
                new CubicCurveTo(90.786769, 119.72294, 87.625, 113.175, 83.55, 107.175),
                new LineTo(83.399999, 106.2),
                new CubicCurveTo(80.89988, 106.9506, 78.483815, 107.28092, 76.125, 107.325),
                new ClosePath()
        );
        path34.setFill(Color.rgb(249, 120, 184));
        path34.setStroke(Color.BLACK);
        path34.setStrokeWidth(0.265);

        //Path 35 - Pierna izquierda
        Path path35 = new Path();
        path35.getElements().addAll(
                new MoveTo(80.25, 128.475),
                new CubicCurveTo(80.725, 128.35838, 81.200001, 128.11431, 81.675001, 127.575),
                new LineTo(73.65, 107.25),
                new LineTo(64.724999, 106.875),
                new CubicCurveTo(66.167243, 112.125, 67.280302, 117.375, 67.875, 122.625),
                new CubicCurveTo(65.695603, 124.05511, 63.828327, 124.98373, 62.775001, 126.6),
                new CubicCurveTo(62.329634, 128.22415, 63.028244, 128.60899, 64.275002, 128.4),
                new CubicCurveTo(65.124953, 129.75027, 66.306463, 129.27696, 67.425001, 129.15),
                new CubicCurveTo(71.802577, 130.36106, 76.005169, 129.1224, 80.25, 128.475),
                new ClosePath()
        );
        path35.setFill(Color.rgb(249, 120, 184));
        path35.setStroke(Color.BLACK);
        path35.setStrokeWidth(0.265);
        // Path 36
        Path path36 = new Path();
        path36.getElements().addAll(
                new MoveTo(69.048976, 126.64282),
                new LineTo(67.404953, 128.12775),
                new LineTo(67.404953, 129.08234),
                new LineTo(67.404953, 128.18078),
                new CubicCurveTo(67.863652, 127.48951, 68.451342, 127.05622, 69.048976, 126.64282),
                new ClosePath()
        );
        path36.setFill(Color.BLACK);
        path36.setStroke(Color.BLACK);
        path36.setStrokeWidth(0.265);

        // Path 37
        Path path37 = new Path();
        path37.getElements().addAll(
                new MoveTo(64.382072, 128.33988),
                new LineTo(64.594205, 127.38528),
                new LineTo(65.707764, 126.74889),
                new LineTo(66.609326, 126.58979),
                new LineTo(65.495631, 126.74889),
                new LineTo(64.594072, 127.43832),
                new ClosePath()
        );
        path37.setFill(Color.BLACK);
        path37.setStroke(Color.BLACK);
        path37.setStrokeWidth(0.265);

        // Path 38
        Path path38 = new Path();
        path38.getElements().addAll(
                new MoveTo(96.599625, 129.26796),
                new CubicCurveTo(96.542605, 128.87905, 96.187728, 128.49014, 95.777612, 128.10123),
                new CubicCurveTo(95.336762, 127.7156, 95.034073, 127.29367, 94.66392, 127.12012),
                new ClosePath()
        );
        path38.setFill(Color.BLACK);
        path38.setStroke(Color.BLACK);
        path38.setStrokeWidth(0.265);

        // Path 39
        Path path39 = new Path();
        path39.getElements().addAll(
                new MoveTo(96.228394, 126.77541),
                new CubicCurveTo(96.360976, 126.77541, 97.92545, 127.62393, 97.92545, 127.62393),
                new ClosePath()
        );
        path39.setFill(Color.BLACK);
        path39.setStroke(Color.BLACK);
        path39.setStrokeWidth(0.265);

        // Path 40
        Path path40 = new Path();
        path40.getElements().addAll(
                new MoveTo(68.775, 88.724999),
                new CubicCurveTo(68.183722, 89.081062, 67.490181, 89.573979, 66.225, 89.7375),
                new LineTo(64.3125, 89.9625),
                new CubicCurveTo(63.855543, 90.05424, 63.361299, 89.732216, 62.962502, 89.4375),
                new LineTo(62.362502, 89.2875),
                new LineTo(60.037502, 91.200001),
                new CubicCurveTo(60.862603, 90.592521, 61.886612, 90.024822, 62.250001, 89.324999),
                new CubicCurveTo(62.203391, 88.444322, 62.347161, 87.525569, 61.837501, 86.7375),
                new LineTo(61.65, 86.324998),
                new LineTo(63.074999, 86.887501),
                new LineTo(62.587499, 87.075001),
                new LineTo(62.625, 88.800003),
                new CubicCurveTo(62.625, 88.800003, 64.387501, 88.837503, 64.237501, 88.800003),
                new CubicCurveTo(64.087501, 88.762503, 64.612503, 89.137503, 64.612503, 89.137503),
                new LineTo(64.8, 89.775),
                new LineTo(64.7625, 89.8125),
                new ClosePath()
        );
        path40.setFill(Color.BLACK);
        path40.setStroke(Color.BLACK);
        path40.setStrokeWidth(0.265);

        // Path 41
        Path path41 = new Path();
        path41.getElements().addAll(
                new MoveTo(66.825, 88.349999),
                new CubicCurveTo(66.825, 88.349999, 62.480281, 90.232629, 66.45, 88.6125),
                new CubicCurveTo(66.788297, 88.474434, 67.4625, 87.3, 67.4625, 87.3),
                new LineTo(67.837499, 85.8375),
                new ClosePath()
        );
        path41.setFill(Color.BLACK);
        path41.setStroke(Color.BLACK);
        path41.setStrokeWidth(0.265);

        // Path 42
        Path path42 = new Path();
        path42.getElements().addAll(
                new MoveTo(65.775, 86.325),
                new LineTo(65.6625, 88.237499),
                new LineTo(65.775, 86.45),
                new LineTo(65.249998, 85.799998),
                new LineTo(63.525, 84.224999),
                new ClosePath()
        );
        path42.setFill(Color.BLACK);
        path42.setStroke(Color.BLACK);
        path42.setStrokeWidth(0.265);

        // Path 43
        Path path43 = new Path();
        path43.getElements().addAll(
                new MoveTo(64.3125, 88.762498),
                new LineTo(65.587501, 88.199999),
                new ClosePath()
        );
        path43.setFill(Color.BLACK);
        path43.setStroke(Color.BLACK);
        path43.setStrokeWidth(0.265);

        // Path 44
        Path path44 = new Path();
        path44.getElements().addAll(
                new MoveTo(65.699999, 84.412501),
                new LineTo(65.7, 86.175),
                new ClosePath()
        );
        path44.setFill(Color.BLACK);
        path44.setStroke(Color.BLACK);
        path44.setStrokeWidth(0.265);

        // Path 45
        Path path45 = new Path();
        path45.getElements().addAll(
                new MoveTo(57.824999, 94.649998),
                new LineTo(57.15, 94.875),
                new LineTo(53.1, 95.325001),
                new ClosePath()
        );
        path45.setFill(Color.BLACK);
        path45.setStroke(Color.BLACK);
        path45.setStrokeWidth(0.265);

        // Path 46
        Path path46 = new Path();
        path46.getElements().addAll(
                new MoveTo(57.524999, 94.762501),
                new LineTo(60.075, 93.412499),
                new ClosePath()
        );
        path46.setFill(Color.BLACK);
        path46.setStroke(Color.BLACK);
        path46.setStrokeWidth(0.265);

        // Path 47
        Path path47 = new Path();
        path47.getElements().addAll(
                new MoveTo(67.245854, 94.239656),
                new LineTo(69.526273, 93.338096),
                new LineTo(70.799065, 93.285066),
                new LineTo(70.746035, 93.603262),
                new LineTo(68.783816, 94.398758),
                new LineTo(67.404956, 94.61089),
                new ClosePath()
        );
        path47.setFill(Color.WHITE);
        path47.setStroke(Color.BLACK);
        path47.setStrokeWidth(0.265);

        // Path 48
        Path path48 = new Path();
        path48.getElements().addAll(
                new MoveTo(93.550226, 103.09617),
                new LineTo(96.732208, 103.20223),
                new CubicCurveTo(97.598318, 103.47778, 98.568135, 103.56537, 99.171724, 104.36896),
                new LineTo(96.732208, 103.1492),
                new ClosePath()
        );
        path48.setFill(Color.WHITE);
        path48.setStroke(Color.BLACK);
        path48.setStrokeWidth(0.265);

        // Path 49
        Path path49 = new Path();
        path49.getElements().addAll(
                new MoveTo(98.111065, 105.90692),
                new CubicCurveTo(97.552585, 105.46498, 97.246465, 105.07607, 95.883678, 104.63412),
                new LineTo(93.709325, 103.99773),
                new LineTo(95.830645, 104.63413),
                new ClosePath()
        );
        path49.setFill(Color.WHITE);
        path49.setStroke(Color.BLACK);
        path49.setStrokeWidth(0.265);

        // Path 50
        Path path50 = new Path();
        path50.getElements().addAll(
                new MoveTo(58.071143, 102.72494),
                new LineTo(58.124173, 101.02788),
                new LineTo(59.131801, 101.50518),
                new LineTo(59.237867, 102.24764),
                new ClosePath()
        );
        path50.setFill(Color.WHITE);
        path50.setStroke(Color.BLACK);
        path50.setStrokeWidth(0.265);

        // Path 51
        Path path51 = new Path();
        path51.getElements().addAll(
                new MoveTo(67.199999, 72.825001),
                new LineTo(69.149999, 72.375),
                new LineTo(69.824999, 74.175001),
                new CubicCurveTo(71.240404, 75.126011, 72.62757, 76.006426, 73.65, 75.975001),
                new CubicCurveTo(75.150555, 76.299723, 77.180184, 76.359909, 79.05, 76.5),
                new LineTo(83.25, 76.425),
                new LineTo(86.4, 75.225),
                new LineTo(86.85, 74.85),
                new LineTo(88.35, 75.225),
                new LineTo(86.925001, 74.85),
                new LineTo(83.099999, 76.499999),
                new LineTo(73.65, 75.975),
                new LineTo(69.9, 74.249999),
                new LineTo(68.774998, 72.825001),
                new ClosePath()
        );
        path51.setFill(Color.BLACK);
        path51.setStroke(Color.BLACK);
        path51.setStrokeWidth(0.265);

        // Path 52
        Path path52 = new Path();
        path52.getElements().addAll(
                new MoveTo(63.45, 67.275001),
                new LineTo(66.524999, 66.674999),
                new ClosePath()
        );
        path52.setFill(Color.BLACK);
        path52.setStroke(Color.BLACK);
        path52.setStrokeWidth(0.265);

        // Path 53
        Path path53 = new Path();
        path53.getElements().addAll(
                new MoveTo(91.199998, 69.749999),
                new LineTo(93.375, 70.725),
                new LineTo(94.650001, 71.774998),
                new ClosePath()
        );
        path53.setFill(Color.BLACK);
        path53.setStroke(Color.BLACK);
        path53.setStrokeWidth(0.265);

        // Path 54
        Path path54 = new Path();
        path54.getElements().addAll(
                new MoveTo(71.624999, 71.474998),
                new CubicCurveTo(72.390183, 72.034815, 72.863946, 72.886052, 74.175, 72.899999),
                new CubicCurveTo(74.143889, 73.64685, 75.636706, 74.139716, 76.724999, 74.7),
                new LineTo(80.1, 74.625),
                new LineTo(81.3, 73.8),
                new LineTo(84.6, 73.05),
                new LineTo(84.825001, 72.525),
                new CubicCurveTo(83.786436, 71.869282, 83.30359, 70.935705, 80.775, 71.025),
                new CubicCurveTo(80.625004, 70.424998, 79.974996, 70.025001, 78.825, 69.824999),
                new LineTo(77.025, 70.2),
                new LineTo(76.725002, 70.8),
                new CubicCurveTo(75.455968, 70.4679, 74.519107, 70.232318, 73.874999, 70.575),
                new CubicCurveTo(72.676556, 70.171246, 72.282722, 70.411177, 72.075, 70.799999),
                new ClosePath()
        );
        path54.setFill(Color.rgb(219, 62, 133));
        path54.setStroke(Color.BLACK);
        path54.setStrokeWidth(0.265);

        // Path 55
        Path path55 = new Path();
        path55.getElements().addAll(
                new MoveTo(72.262499, 67.95),
                new LineTo(73.237499, 67.875),
                new LineTo(74.212499, 68.175001),
                new LineTo(75.975, 68.550003),
                new LineTo(75.749998, 69.0),
                new ClosePath()
        );
        path55.setFill(Color.BLACK);
        path55.setStroke(Color.BLACK);
        path55.setStrokeWidth(0.265);

        // Path 56
        Path path56 = new Path();
        path56.getElements().addAll(
                new MoveTo(76.387499, 67.275),
                new LineTo(75.262498, 67.3125),
                new LineTo(74.85, 65.8875),
                new LineTo(75.675, 64.837501),
                new LineTo(76.65, 66.487501),
                new ClosePath()
        );
        path56.setFill(Color.BLACK);
        path56.setStroke(Color.BLACK);
        path56.setStrokeWidth(0.265);

        // Path 57
        Path path57 = new Path();
        path57.getElements().addAll(
                new MoveTo(75.112501, 64.3125),
                new LineTo(74.325, 63.825),
                new LineTo(75.0, 63.599998),
                new ClosePath()
        );
        path57.setFill(Color.BLACK);
        path57.setStroke(Color.BLACK);
        path57.setStrokeWidth(0.265);

        // Path 58
        Path path58 = new Path();
        path58.getElements().addAll(
                new MoveTo(89.7375, 67.8),
                new LineTo(91.0875, 67.5),
                new LineTo(90.9375, 69.15),
                new LineTo(89.475, 69.3),
                new LineTo(88.35, 69.0),
                new LineTo(89.062502, 69.7875),
                new LineTo(88.9125, 70.200001),
                new LineTo(90.9, 70.012498),
                new LineTo(91.837498, 69.449999),
                new LineTo(93.337501, 68.7375),
                new LineTo(93.112499, 68.25),
                new LineTo(94.274999, 67.4625),
                new LineTo(93.149998, 67.349999),
                new LineTo(94.0125, 65.8125),
                new LineTo(92.25, 66.3),
                new LineTo(92.474999, 65.1375),
                new LineTo(88.537499, 64.875),
                new LineTo(90.075, 65.85),
                new LineTo(89.175, 66.1125),
                new LineTo(89.025, 66.7125),
                new ClosePath()
        );
        path58.setFill(Color.BLACK);
        path58.setStroke(Color.BLACK);
        path58.setStrokeWidth(0.265);

        // Path 59
        Path path59 = new Path();
        path59.getElements().addAll(
                new MoveTo(48.224999, 58.949999),
                new CubicCurveTo(50.140164, 61.365985, 51.908777, 62.902663, 53.625001, 64.125001),
                new LineTo(57.149999, 66.374999),
                new LineTo(53.549999, 64.2),
                new ClosePath()
        );
        path59.setFill(Color.BLACK);
        path59.setStroke(Color.BLACK);
        path59.setStrokeWidth(0.265);

        // Path 60
        Path path60 = new Path();
        path60.getElements().addAll(
                new MoveTo(54.074999, 73.5),
                new LineTo(57.524999, 70.124999),
                new LineTo(59.925, 66.224998),
                new LineTo(57.524999, 70.124999),
                new ClosePath()
        );
        path60.setFill(Color.BLACK);
        path60.setStroke(Color.BLACK);
        path60.setStrokeWidth(0.265);

        // Path 61
        Path path61 = new Path();
        path61.getElements().addAll(
                new MoveTo(60.75, 70.200001),
                new LineTo(61.875, 65.024999),
                new LineTo(65.925, 59.624999),
                new LineTo(61.8, 65.1),
                new ClosePath()
        );
        path61.setFill(Color.BLACK);
        path61.setStroke(Color.BLACK);
        path61.setStrokeWidth(0.265);

        // Path 62
        Path path62 = new Path();
        path62.getElements().addAll(
                new MoveTo(65.699999, 58.349998),
                new LineTo(65.849999, 62.774999),
                new ClosePath()
        );
        path62.setFill(Color.BLACK);
        path62.setStroke(Color.BLACK);
        path62.setStrokeWidth(0.265);

        // Path 63
        Path path63 = new Path();
        path63.getElements().addAll(
                new MoveTo(69.225, 56.625),
                new LineTo(68.024999, 59.7),
                new ClosePath()
        );
        path63.setFill(Color.BLACK);
        path63.setStroke(Color.BLACK);
        path63.setStrokeWidth(0.265);

        // Path 64
        Path path64 = new Path();
        path64.getElements().addAll(
                new MoveTo(71.175001, 57.6),
                new LineTo(68.174999, 59.324999),
                new ClosePath()
        );
        path64.setFill(Color.BLACK);
        path64.setStroke(Color.BLACK);
        path64.setStrokeWidth(0.265);

        // Path 65
        Path path65 = new Path();
        path65.getElements().addAll(
                new MoveTo(71.099999, 57.6),
                new LineTo(74.85, 57.675),
                new ClosePath()
        );
        path65.setFill(Color.BLACK);
        path65.setStroke(Color.BLACK);
        path65.setStrokeWidth(0.265);

        // Path 66
        Path path66 = new Path();
        path66.getElements().addAll(
                new MoveTo(83.7, 60.525),
                new LineTo(79.499999, 55.499999),
                new ClosePath()
        );
        path66.setFill(Color.BLACK);
        path66.setStroke(Color.BLACK);
        path66.setStrokeWidth(0.265);

        // Path 67
        Path path67 = new Path();
        path67.getElements().addAll(
                new MoveTo(81.225, 56.250001),
                new LineTo(85.874999, 59.025001),
                new ClosePath()
        );
        path67.setFill(Color.BLACK);
        path67.setStroke(Color.BLACK);
        path67.setStrokeWidth(0.265);

        // Path 68
        Path path68 = new Path();
        path68.getElements().addAll(
                new MoveTo(83.774999, 60.599999),
                new LineTo(86.099998, 58.799999),
                new ClosePath()
        );
        path68.setFill(Color.BLACK);
        path68.setStroke(Color.BLACK);
        path68.setStrokeWidth(0.265);

        // Path 69
        Path path69 = new Path();
        path69.getElements().addAll(
                new MoveTo(88.349999, 59.025001),
                new LineTo(85.874999, 58.875),
                new ClosePath()
        );
        path69.setFill(Color.BLACK);
        path69.setStroke(Color.BLACK);
        path69.setStrokeWidth(0.265);

        // Path 70
        Path path70 = new Path();
        path70.getElements().addAll(
                new MoveTo(92.85, 62.924999),
                new CubicCurveTo(91.499021, 61.263485, 90.164191, 59.457038, 88.425, 58.949999),
                new ClosePath()
        );
        path70.setFill(Color.BLACK);
        path70.setStroke(Color.BLACK);
        path70.setStrokeWidth(0.265);

        // Path 71
        Path path71 = new Path();
        path71.getElements().addAll(
                new MoveTo(87.674999, 60.225),
                new LineTo(92.624999, 62.85),
                new ClosePath()
        );
        path71.setFill(Color.BLACK);
        path71.setStroke(Color.BLACK);
        path71.setStrokeWidth(0.265);

        // Path 72
        Path path72 = new Path();
        path72.getElements().addAll(
                new MoveTo(92.85, 61.35),
                new LineTo(96.224999, 64.5),
                new LineTo(101.175, 67.575001),
                new LineTo(96.224999, 64.349997),
                new ClosePath()
        );
        path72.setFill(Color.BLACK);
        path72.setStroke(Color.BLACK);
        path72.setStrokeWidth(0.265);

        // Path 73
        Path path73 = new Path();
        path73.getElements().addAll(
                new MoveTo(97.95, 68.024999),
                new LineTo(103.35, 69.824999),
                new LineTo(107.85, 70.05),
                new LineTo(103.575, 69.824998),
                new ClosePath()
        );
        path73.setFill(Color.BLACK);
        path73.setStroke(Color.BLACK);
        path73.setStrokeWidth(0.265);

        // Path 74
        Path path74 = new Path();
        path74.getElements().addAll(
                new MoveTo(102.9, 71.025),
                new LineTo(98.174999, 70.575),
                new LineTo(94.875, 68.925),
                new ClosePath()
        );
        path74.setFill(Color.BLACK);
        path74.setStroke(Color.BLACK);
        path74.setStrokeWidth(0.265);

        // Path 75
        Path path75 = new Path();
        path75.getElements().addAll(
                new MoveTo(53.828502, 57.646879),
                new LineTo(53.086042, 55.843757),
                new LineTo(52.979975, 52.767843),
                new LineTo(53.086042, 55.843757),
                new ClosePath()
        );
        path75.setFill(Color.BLACK);
        path75.setStroke(Color.BLACK);
        path75.setStrokeWidth(0.265);

        // Path 76
        Path path76 = new Path();
        path76.getElements().addAll(
                new MoveTo(55.843757, 51.229886),
                new LineTo(56.002856, 46.244782),
                new LineTo(57.699912, 42.691571),
                new LineTo(60.563696, 39.562624),
                new LineTo(57.593846, 42.797637),
                new LineTo(56.002856, 46.244782),
                new ClosePath()
        );
        path76.setFill(Color.BLACK);
        path76.setStroke(Color.BLACK);
        path76.setStrokeWidth(0.265);

        // Path 77
        Path path77 = new Path();
        path77.getElements().addAll(
                new MoveTo(61.412222, 52.237512),
                new LineTo(61.306156, 45.449288),
                new LineTo(62.950182, 41.100581),
                new LineTo(66.397327, 36.751876),
                new LineTo(62.791083, 41.206647),
                new LineTo(61.306156, 45.50235),
                new ClosePath()
        );
        path77.setFill(Color.BLACK);
        path77.setStroke(Color.BLACK);
        path77.setStrokeWidth(0.265);

        // Path 78
        Path path78 = new Path();
        path78.getElements().addAll(
                new MoveTo(65.76093, 51.866281),
                new LineTo(66.185195, 46.244782),
                new LineTo(68.200449, 42.214276),
                new LineTo(73.66283, 37.123105),
                new LineTo(67.988298, 42.320342),
                new LineTo(66.079109, 46.244782),
                new ClosePath()
        );
        path78.setFill(Color.BLACK);
        path78.setStroke(Color.BLACK);
        path78.setStrokeWidth(0.265);

        // Path 79
        Path path79 = new Path();
        path79.getElements().addAll(
                new MoveTo(79.602546, 17.076629),
                new LineTo(80.875337, 21.16017),
                new LineTo(80.079844, 26.463471),
                new LineTo(78.011556, 30.918245),
                new LineTo(80.132877, 26.569537),
                new LineTo(80.981403, 21.213147),
                new ClosePath()
        );
        path79.setFill(Color.BLACK);
        path79.setStroke(Color.BLACK);
        path79.setStrokeWidth(0.265);

        // Path 80
        Path path80 = new Path();
        path80.getElements().addAll(
                new MoveTo(82.466327, 30.918245),
                new LineTo(82.519357, 25.190679),
                new LineTo(83.792151, 21.78167),
                new LineTo(86.178635, 18.387558),
                new LineTo(88.830286, 15.841973),
                new LineTo(93.656289, 13.296389),
                new LineTo(88.72422, 15.895006),
                new LineTo(86.178635, 18.387558),
                new LineTo(83.792151, 21.728637),
                new LineTo(82.57239, 25.91922),
                new ClosePath()
        );
        path80.setFill(Color.BLACK);
        path80.setStroke(Color.BLACK);
        path80.setStrokeWidth(0.265);

        // Path 81
        Path path81 = new Path();
        path81.getElements().addAll(
                new MoveTo(85.171012, 26.09224),
                new LineTo(85.064946, 26.14527),
                new LineTo(85.224045, 31.872835),
                new LineTo(85.754376, 33.357758),
                new ClosePath()
        );
        path81.setFill(Color.BLACK);
        path81.setStroke(Color.BLACK);
        path81.setStrokeWidth(0.265);

        // Path 82
        Path path82 = new Path();
        path82.getElements().addAll(
                new MoveTo(84.958879, 26.09224),
                new LineTo(87.0802, 21.16017),
                new ClosePath()
        );
        path82.setFill(Color.BLACK);
        path82.setStroke(Color.BLACK);
        path82.setStrokeWidth(0.265);

        // Path 83
        Path path83 = new Path();
        path83.getElements().addAll(
                new MoveTo(89.36062, 26.251339),
                new LineTo(92.489567, 20.682873),
                new ClosePath()
        );
        path83.setFill(Color.BLACK);
        path83.setStroke(Color.BLACK);
        path83.setStrokeWidth(0.265);

        // Path 84
        Path path84 = new Path();
        path84.getElements().addAll(
                new MoveTo(105.53569, 15.16744),
                new LineTo(95.883679, 18.243355),
                new ClosePath()
        );
        path84.setFill(Color.BLACK);
        path84.setStroke(Color.BLACK);
        path84.setStrokeWidth(0.265);

        // Path 85
        Path path85 = new Path();
        path85.getElements().addAll(
                new MoveTo(92.436533, 20.735906),
                new LineTo(95.883679, 18.349421),
                new ClosePath()
        );
        path85.setFill(Color.BLACK);
        path85.setStroke(Color.BLACK);
        path85.setStrokeWidth(0.265);

        // Path 86
        Path path86 = new Path();
        path86.getElements().addAll(
                new MoveTo(101.13395, 20.152543),
                new LineTo(95.936712, 22.857227),
                new LineTo(92.701699, 27.577163),
                new LineTo(92.754729, 32.350135),
                new LineTo(94.451785, 37.812535),
                new LineTo(92.966861, 32.456145),
                new LineTo(92.807762, 27.524075),
                new LineTo(95.565477, 23.17537),
                new ClosePath()
        );
        path86.setFill(Color.BLACK);
        path86.setStroke(Color.BLACK);
        path86.setStrokeWidth(0.265);

        // Path 87
        Path path87 = new Path();
        path87.getElements().addAll(
                new MoveTo(78.966149, 37.017039),
                new LineTo(76.844828, 40.835415),
                new LineTo(76.3145, 45.025028),
                new LineTo(76.950894, 40.782397),
                new ClosePath()
        );
        path87.setFill(Color.BLACK);
        path87.setStroke(Color.BLACK);
        path87.setStrokeWidth(0.265);

        // Path 88
        Path path88 = new Path();
        path88.getElements().addAll(
                new MoveTo(82.466327, 36.274578),
                new LineTo(84.693714, 42.267309),
                new LineTo(86.54987, 47.729708),
                new LineTo(87.504465, 51.12382),
                new ClosePath()
        );
        path88.setFill(Color.BLACK);
        path88.setStroke(Color.BLACK);
        path88.setStrokeWidth(0.265);

        // Path 89
        Path path89 = new Path();
        path89.getElements().addAll(
                new MoveTo(92.277434, 51.919314),
                new LineTo(92.489567, 49.797996),
                new LineTo(92.171371, 45.926604),
                new LineTo(92.542603, 49.638915),
                new ClosePath()
        );
        path89.setFill(Color.BLACK);
        path89.setStroke(Color.BLACK);
        path89.setStrokeWidth(0.265);

        // Path 90
        Path path90 = new Path();
        path90.getElements().addAll(
                new MoveTo(95.512447, 46.56298),
                new LineTo(91.481938, 40.676316),
                new LineTo(89.095455, 35.160884),
                new LineTo(91.588007, 40.782397),
                new ClosePath()
        );
        path90.setFill(Color.BLACK);
        path90.setStroke(Color.BLACK);
        path90.setStrokeWidth(0.265);

        // Path 91
        Path path91 = new Path();
        path91.getElements().addAll(
                new MoveTo(100.49755, 45.343222),
                new LineTo(103.6265, 51.707184),
                new LineTo(104.15683, 59.396971),
                new LineTo(103.67953, 51.707184),
                new ClosePath()
        );
        path91.setFill(Color.BLACK);
        path91.setStroke(Color.BLACK);
        path91.setStrokeWidth(0.265);

        // Path 92
        Path path92 = new Path();
        path92.getElements().addAll(
                new MoveTo(106.27815, 49.479797),
                new LineTo(107.28578, 55.843757),
                new LineTo(106.013, 61.624355),
                new LineTo(107.07366, 55.684099),
                new ClosePath()
        );
        path92.setFill(Color.BLACK);
        path92.setStroke(Color.BLACK);
        path92.setStrokeWidth(0.265);

        // Agregar TODOS los paths al grupo root
        root.getChildren().addAll(
                path1, path4, path5, path6, path7, path9, path10, path11, path12, path13,
                path14, path15, path16, path17, path18, path19, path20, path21, path22, path24,
                path25, path26, path27, path28, path29, path30, path31, path32,path33, path34, path35,
                path36, path37, path38, path39, path40, path41, path42, path43, path44, path45,
                path46, path47, path48, path49, path50, path51, path52, path53, path54, path55,
                path56, path57, path58, path59, path60, path61, path62, path63, path64, path65,
                path66, path67, path68, path69, path70, path71, path72, path73, path74, path75,
                path76, path77, path78, path79, path80, path81, path82, path83, path84, path85,
                path86, path87, path88, path89, path90, path91, path92
        );

        // TRANSFORMACIONES PARA MEJOR VISUALIZACIÓN
        Scale scale = new Scale(3, 3); // Escala ajustada
        Translate translate = new Translate(50, 50); // Mover más para ver el pelo completo

        root.getTransforms().addAll(scale, translate);

        // Crear la escena con un tamaño adecuado
        Scene scene = new Scene(root, 550, 570);
        primaryStage.setTitle("Dibujo SVG Completo - 92 Paths");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}