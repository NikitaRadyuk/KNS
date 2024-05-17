package diploma.progis.progis.core.dto.components;

import diploma.progis.progis.core.dto.api.IComponent;
import diploma.progis.progis.core.dto.api.IShape;
import diploma.progis.progis.core.dto.shapes.Arc;
import diploma.progis.progis.core.dto.shapes.Line;
import diploma.progis.progis.core.dto.shapes.Point;

import java.util.ArrayList;
import java.util.List;

public class FrontView implements IComponent {
    public Double diamKNS;
    public Double diamPressureLines;
    public Double diamPump;
    public Double diamPipeBranch;
    public Double heightOfPump;
    public Double heightBottomPumpFlangePlane;
    public Double heightBottomPumpBottomWell;

    public FrontView() {
    }

    private List<IShape> drawFrontView(){
        List<IShape> frontView = new ArrayList<>();

        List<Point> wellPoints = new ArrayList<>();

        //нижняя плита
        wellPoints.add(new Point( diamKNS/2 + diamKNS/15, diamKNS + diamKNS/3 + heightOfPump + heightBottomPumpBottomWell));                                  //0
        wellPoints.add(new Point( -diamKNS/2 - diamKNS/15, diamKNS + diamKNS/3 + heightOfPump + heightBottomPumpBottomWell));                                 //1
        wellPoints.add(new Point( -diamKNS/2 - diamKNS/15, diamKNS + diamKNS/3 + heightOfPump + heightBottomPumpBottomWell + diamKNS/15));                    //2
        wellPoints.add(new Point( diamKNS/2 + diamKNS/15, diamKNS + diamKNS/3 + heightOfPump + heightBottomPumpBottomWell+ diamKNS/15));                      //3
        //стенки
        wellPoints.add(new Point(diamKNS/2, diamKNS + diamKNS/3 + heightOfPump + heightBottomPumpBottomWell));                                                   //4
        wellPoints.add(new Point(diamKNS/2, diamKNS + diamKNS/6 ));                                                                                              //5
        wellPoints.add(new Point(diamKNS/2 - 0.05*diamKNS, diamKNS + diamKNS/6 ));                                                                                      //6
        wellPoints.add(new Point(diamKNS/2 - 0.05*diamKNS, diamKNS + diamKNS/3 + heightOfPump + heightBottomPumpBottomWell));                                           //7
        wellPoints.add(new Point(-diamKNS/2, diamKNS + diamKNS/3 + heightOfPump + heightBottomPumpBottomWell));                                                  //8
        wellPoints.add(new Point(-diamKNS/2, diamKNS + diamKNS/6 ));                                                                                             //9
        wellPoints.add(new Point(-diamKNS/2 + 0.05*diamKNS, diamKNS + diamKNS/6 ));                                                                                     //10
        wellPoints.add(new Point(-diamKNS/2 + 0.05*diamKNS, diamKNS + diamKNS/3 + heightOfPump + heightBottomPumpBottomWell));                                          //11
        //крышка
        wellPoints.add(new Point(diamKNS/2, diamKNS + diamKNS/6));                                                                                               //12
        wellPoints.add(new Point(diamKNS/2, diamKNS + diamKNS/12));                                                                                              //13
        wellPoints.add(new Point(-diamKNS/2, diamKNS + diamKNS/12));                                                                                             //14
        wellPoints.add(new Point(-diamKNS/2, diamKNS + diamKNS/6));                                                                                              //15
        //отверстие люка
        wellPoints.add(new Point(- diamKNS/15,diamKNS + diamKNS/6));                                                                                       //16
        wellPoints.add(new Point(- diamKNS/15,diamKNS + diamKNS/12));                                                                                      //17
        wellPoints.add(new Point(- diamKNS/2 + diamKNS/10,diamKNS + diamKNS/12));                                                                              //18
        wellPoints.add(new Point(- diamKNS/2 + diamKNS/10,diamKNS + diamKNS/6));                                                                               //19
        //крышка люка
        wellPoints.add(new Point(-diamKNS/30,diamKNS + diamKNS/12));                                                                                        //20
        wellPoints.add(new Point(-diamKNS/30,diamKNS));                                                                                                     //21
        wellPoints.add(new Point(- diamKNS/2 + diamKNS/15,diamKNS + diamKNS/12));                                                                            //22
        wellPoints.add(new Point(- diamKNS/2 + diamKNS/15,diamKNS));                                                                                         //23
        //
        wellPoints.add(new Point(- diamKNS/20,diamKNS));                                                                                                    //24
        wellPoints.add(new Point(- diamKNS/20,diamKNS + diamKNS/24));                                                                                       //25
        wellPoints.add(new Point(- diamKNS/2 + diamKNS/12.5,diamKNS + diamKNS/24));                                                                            //26
        wellPoints.add(new Point(- diamKNS/2 + diamKNS/12.5,diamKNS));                                                                                         //27
        //
        wellPoints.add(new Point(- diamKNS/10,diamKNS));                                                                                                      //28
        wellPoints.add(new Point(- diamKNS/10,diamKNS + diamKNS/60));                                                                                         //29
        wellPoints.add(new Point(- diamKNS/2 + diamKNS/7.5,diamKNS + diamKNS/60));                                                                         //30
        wellPoints.add(new Point(- diamKNS/2 + diamKNS/7.5,diamKNS));                                                                                      //31
        //фланец
        wellPoints.add(new Point(-diamKNS/2 + 0.05*diamKNS,diamKNS + diamKNS/3 + heightOfPump - heightBottomPumpFlangePlane));                                          //32
        wellPoints.add(new Point(diamKNS/2 - 75,diamKNS + diamKNS/3 + heightOfPump - heightBottomPumpFlangePlane));                                            //33
        wellPoints.add(new Point(-diamKNS/2 + diamKNS/10 - 30,diamKNS + diamKNS/3 + heightOfPump - heightBottomPumpFlangePlane + 125));                         //34
        wellPoints.add(new Point(-diamKNS/2 + diamKNS/10,diamKNS + diamKNS/3 + heightOfPump - heightBottomPumpFlangePlane));                                //35
        wellPoints.add(new Point(-diamKNS/2 + diamKNS/10 + 10,diamKNS + diamKNS/3 + heightOfPump - heightBottomPumpFlangePlane + 125));                         //36
        wellPoints.add(new Point(-diamKNS/2 + diamKNS/10 + 40,diamKNS + diamKNS/3 + heightOfPump - heightBottomPumpFlangePlane));                               //37
        wellPoints.add(new Point(-diamKNS/2 + diamKNS/10 + 50,diamKNS + diamKNS/3 + heightOfPump - heightBottomPumpFlangePlane + 125));                         //38
        wellPoints.add(new Point(-diamKNS/2 + diamKNS/10 + 80,diamKNS + diamKNS/3 + heightOfPump - heightBottomPumpFlangePlane));                               //39

        frontView.add(new Line(wellPoints.get(0),wellPoints.get(1)));
        frontView.add(new Line(wellPoints.get(1),wellPoints.get(2)));
        frontView.add(new Line(wellPoints.get(2),wellPoints.get(3)));
        frontView.add(new Line(wellPoints.get(3),wellPoints.get(0)));
        frontView.add(new Line(wellPoints.get(4),wellPoints.get(7)));
        frontView.add(new Line(wellPoints.get(5),wellPoints.get(4)));
        frontView.add(new Line(wellPoints.get(6),wellPoints.get(5)));
        frontView.add(new Line(wellPoints.get(7),wellPoints.get(6)));
        frontView.add(new Line(wellPoints.get(8),wellPoints.get(11)));
        frontView.add(new Line(wellPoints.get(9),wellPoints.get(8)));
        frontView.add(new Line(wellPoints.get(10),wellPoints.get(9)));
        frontView.add(new Line(wellPoints.get(11),wellPoints.get(10)));
        frontView.add(new Line(wellPoints.get(12),wellPoints.get(15)));
        frontView.add(new Line(wellPoints.get(13),wellPoints.get(12)));
        frontView.add(new Line(wellPoints.get(14),wellPoints.get(13)));
        frontView.add(new Line(wellPoints.get(15),wellPoints.get(14)));
        frontView.add(new Line(wellPoints.get(16),wellPoints.get(17)));
        frontView.add(new Line(wellPoints.get(18),wellPoints.get(19)));
        frontView.add(new Line(wellPoints.get(20),wellPoints.get(21)));
        frontView.add(new Line(wellPoints.get(22),wellPoints.get(23)));
        frontView.add(new Line(wellPoints.get(21),wellPoints.get(23)));
        frontView.add(new Line(wellPoints.get(24),wellPoints.get(25)));
        frontView.add(new Line(wellPoints.get(25),wellPoints.get(26)));
        frontView.add(new Line(wellPoints.get(26),wellPoints.get(27)));
        frontView.add(new Line(wellPoints.get(28),wellPoints.get(29)));
        frontView.add(new Line(wellPoints.get(29),wellPoints.get(30)));
        frontView.add(new Line(wellPoints.get(30),wellPoints.get(31)));
        frontView.add(new Line(wellPoints.get(33),wellPoints.get(32)));
        frontView.add(new Line(wellPoints.get(34),wellPoints.get(35)));
        frontView.add(new Line(wellPoints.get(36),wellPoints.get(37)));
        frontView.add(new Line(wellPoints.get(38),wellPoints.get(39)));

        return frontView;
    }

    private List<IShape> drawPump(int kx){
        List<IShape> pump = new ArrayList<>();

        List<Point> points = new ArrayList<>();

        Double bottomY = diamKNS + diamKNS/3 + heightOfPump;

        //основание насоса
        points.add(new Point((diamPipeBranch/2 + diamPump/2)*kx, bottomY));                                                                                                                             //0
        points.add(new Point((diamPipeBranch/2 - diamPump/2)*kx, bottomY));                                                                                                                             //1
        points.add(new Point((diamPipeBranch/2 - diamPump/2 + diamPump/6)*kx, bottomY));                                                                                                                //2
        points.add(new Point((diamPipeBranch/2 - diamPump/2 + diamPump/3)*kx, bottomY - 0.033*heightOfPump));                                                                                        //3
        points.add(new Point((diamPipeBranch/2 + diamPump/2 - diamPump/6)*kx, bottomY));                                                                                                                //4
        points.add(new Point((diamPipeBranch/2 + diamPump/2 - diamPump/3)*kx, bottomY - 0.033*heightOfPump));                                                                                        //5
        //корпус насоса
        points.add(new Point((diamPipeBranch/2 - diamPump/2)*kx, bottomY - 0.033*heightOfPump - 0.029*heightOfPump));                                                                               //6
        points.add(new Point((diamPipeBranch/2 - diamPump/2)*kx, bottomY - 0.033*heightOfPump - 0.029*heightOfPump - 0.028*heightOfPump));                                                          //7
        points.add(new Point((diamPipeBranch/2 + diamPump/2)*kx, bottomY - 0.033*heightOfPump - 0.029*heightOfPump));                                                                               //8
        points.add(new Point((diamPipeBranch/2 + diamPump/2)*kx, bottomY - 0.033*heightOfPump - 0.029*heightOfPump - 0.028*heightOfPump));                                                          //9
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump));                          //10
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump));                          //11
        //{трубная часть}
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.016*heightOfPump));                                              //12
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump));                                              //13
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump));                                              //14
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.016*heightOfPump));                                              //15
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/4)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.026*heightOfPump));                                              //16
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/4)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.026*heightOfPump));                                              //17
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/4)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump));                                              //18
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/4)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump));                                              //19
        //{здешняя пружинка}
        points.add(new Point((diamPipeBranch/2 + 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump));                                            //20
        points.add(new Point((diamPipeBranch/2 - 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump));                                            //21
        points.add(new Point((diamPipeBranch/2 + 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump));                       //22
        points.add(new Point((diamPipeBranch/2 - 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump));                       //23
        points.add(new Point((diamPipeBranch/2 + 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.004*heightOfPump));                       //24
        points.add(new Point((diamPipeBranch/2 - 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.004*heightOfPump));                       //25
        //
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/3)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump));                                                //26
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/3)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump));                           //27
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/3)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump));                           //28
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/3)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump + 0.016*heightOfPump));      //29
        //
        points.add(new Point((diamPipeBranch/2 + 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump + 0.016*heightOfPump));                                                                 //30
        points.add(new Point((diamPipeBranch/2 - 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump + 0.016*heightOfPump));                                                                 //31
        points.add(new Point((diamPipeBranch/2 + 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump + 0.016*heightOfPump + 0.008*heightOfPump));                                            //32
        points.add(new Point((diamPipeBranch/2 - 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump + 0.016*heightOfPump + 0.008*heightOfPump));                                            //33
        points.add(new Point((diamPipeBranch/2 + 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump + 0.016*heightOfPump + 0.004*heightOfPump));                                            //34
        points.add(new Point((diamPipeBranch/2 - 2.5*diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump + 0.016*heightOfPump + 0.004*heightOfPump));                                            //35
        //
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump + 0.016*heightOfPump + 0.008*heightOfPump));                                                //36
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump + 0.016*heightOfPump + 0.020*heightOfPump));                                               //37
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump + 0.016*heightOfPump + 0.020*heightOfPump));                                               //38
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/6)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump + 0.052*heightOfPump + 0.008*heightOfPump + 0.016*heightOfPump + 0.016*heightOfPump + 0.008*heightOfPump));                                                //39

        pump.add(new Line(points.get(0), points.get(1)));
        pump.add(new Line(points.get(2), points.get(3)));
        pump.add(new Line(points.get(4), points.get(5)));
        pump.add(new Line(points.get(3), points.get(5)));
        pump.add(new Line(points.get(3), points.get(6)));
        pump.add(new Line(points.get(7), points.get(6)));
        pump.add(new Line(points.get(8), points.get(5)));
        pump.add(new Line(points.get(8), points.get(9)));
        pump.add(new Line(points.get(7), points.get(10)));
        pump.add(new Line(points.get(11), points.get(9)));
        pump.add(new Line(points.get(12), points.get(15)));
        pump.add(new Line(points.get(13), points.get(12)));
        pump.add(new Line(points.get(14), points.get(13)));
        pump.add(new Line(points.get(15), points.get(14)));
        pump.add(new Line(points.get(16), points.get(17)));
        pump.add(new Line(points.get(12), points.get(17)));
        pump.add(new Line(points.get(15), points.get(16)));
        pump.add(new Line(points.get(16), points.get(18)));
        pump.add(new Line(points.get(18), points.get(19)));
        pump.add(new Line(points.get(17), points.get(19)));
        pump.add(new Line(points.get(20), points.get(21)));
        pump.add(new Line(points.get(20), points.get(22)));
        pump.add(new Line(points.get(21), points.get(23)));
        pump.add(new Line(points.get(22), points.get(23)));
        pump.add(new Line(points.get(25), points.get(24)));
        pump.add(new Line(points.get(26), points.get(27)));
        pump.add(new Line(points.get(27), points.get(28)));
        pump.add(new Line(points.get(28), points.get(29)));
        pump.add(new Line(points.get(30), points.get(31)));
        pump.add(new Line(points.get(34), points.get(35)));
        pump.add(new Line(points.get(32), points.get(33)));
        pump.add(new Line(points.get(30), points.get(32)));
        pump.add(new Line(points.get(31), points.get(33)));
        pump.add(new Line(points.get(36), points.get(37)));
        pump.add(new Line(points.get(37), points.get(38)));
        pump.add(new Line(points.get(38), points.get(39)));

        return pump;
    }

    private List<IShape> drawPressurePipes(int kx){
        List<IShape> pressurePipes = new ArrayList<>();

        List<Point> points = new ArrayList<>();

        Double bottomY = diamKNS + diamKNS/3 + heightOfPump;
        //блок на длинной части
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump));                                                                                                 //0
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump));                                                                             //1
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump));                                                                             //2
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump));                                                                                                 //3
        //нижняя часть пружинки
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump));                                                       //4
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump));                                                       //5
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));                                  //6
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));                                  //7
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.004*heightOfPump));                                  //8
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.004*heightOfPump));                                  //9
        //длинная часть
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump));                                                                                                                     //10
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump));                                                                                                                     //11
        //пружинка и верхняя часть пружинки
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));                                                        //12
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));                                                        //13
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump));                                   //14
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump));                                   //15
        //
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump));                                   //16
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump));                                   //17
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.004*heightOfPump));              //18
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.004*heightOfPump));              //19
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));              //20
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));              //21
        //тройник типа
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));                                                                             //22
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump));                                                         //23
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));                                                                             //24
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2));                                   //25
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 - diamPressureLines));               //26
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump));                                                         //27
        //нижняя часть верхней пружины
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump));                                   //28
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump));                                   //29
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.004*heightOfPump));         //30
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.004*heightOfPump));         //31
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump));           //32
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump));           //33
        //пружинка верхняя
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump));                                                      //34
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump));                                                      //35
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump));                                 //36
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump));                                 //37
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.016*heightOfPump));                                 //38
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.016*heightOfPump));                                 //39
        //верхняя часть пружины
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump));                                 //40
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump));                                 //41
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.004*heightOfPump));            //42
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.004*heightOfPump));            //43
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));           //44
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2 - diamPressureLines/9)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));           //45
        //блок
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));                               //46
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump));           //47
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump));           //48
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump));                               //49
        //выход
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.048* heightOfPump));                                                  //50
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.048* heightOfPump));                                                  //51
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.048* heightOfPump - diamPressureLines));                              //52
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + 0.04*heightOfPump)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.048* heightOfPump- 0.032*heightOfPump - diamPressureLines));           //53
        points.add(new Point((diamPipeBranch/2 + diamPressureLines/2 + 0.04*heightOfPump)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.20*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.048* heightOfPump- 0.032*heightOfPump));                               //54
        //перегородка
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 - diamPressureLines));                                                                                               //55
        points.add(new Point((diamPipeBranch/2 - diamPressureLines/2)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2));                                                                                                                   //56
        points.add(new Point((diamPipeBranch/2 - diamPipeBranch/3)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 - diamPressureLines));                                                                                                  //57
        points.add(new Point((diamPipeBranch/2 - diamPipeBranch/3)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2));                                                                                                                      //58
        points.add(new Point((diamPipeBranch/2 - diamPipeBranch/3)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 - diamPressureLines - 0.2*diamPressureLines));                                                                          //59
        points.add(new Point((diamPipeBranch/2 - diamPipeBranch/3)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 + 0.2*diamPressureLines));                                                                                              //60
        points.add(new Point((diamPipeBranch/2 - diamPipeBranch/3 - 0.03*diamPipeBranch)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 - diamPressureLines - 0.2*diamPressureLines));                                                    //61
        points.add(new Point((diamPipeBranch/2 - diamPipeBranch/3 - 0.03*diamPipeBranch)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 + 0.2*diamPressureLines));                                                                        //62
        points.add(new Point((diamPipeBranch/2 - diamPipeBranch/3 - 0.06*diamPipeBranch)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 - diamPressureLines - 0.2*diamPressureLines));                                                    //63
        points.add(new Point((diamPipeBranch/2 - diamPipeBranch/3 - 0.06*diamPipeBranch)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 + 0.2*diamPressureLines));                                                                        //64

        points.add(new Point((diamPipeBranch/2 - diamPipeBranch/3 - 0.06*diamPipeBranch)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 - diamPressureLines - 0.2*diamPressureLines + 0.1*diamPressureLines));                            //65
        points.add(new Point((0)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 - diamPressureLines - 0.2*diamPressureLines + 0.1*diamPressureLines));                                                                                    //66
        points.add(new Point((diamPipeBranch/2 - diamPipeBranch/3 - 0.06*diamPipeBranch)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 + 0.1*diamPressureLines));                                                    //67
        points.add(new Point((0)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 + 0.1*diamPressureLines));                                                                                                            //68
        points.add(new Point((diamPipeBranch/2 - diamPipeBranch/3 - 0.06*diamPipeBranch)*kx, bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 - diamPressureLines/2));                                                                          //69
        points.add(new Point((0)*kx,bottomY - 0.033*heightOfPump/2 - 0.029*heightOfPump - 0.028*heightOfPump - 0.089*heightOfPump - 0.016*heightOfPump - 0.39*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - 0.032*heightOfPump - 0.008*heightOfPump - (0.20*heightOfPump-diamPressureLines)/2 - diamPressureLines/2));                                                                                                                                   //70

        pressurePipes.add(new Line(points.get(0),points.get(1)));
        pressurePipes.add(new Line(points.get(0),points.get(3)));
        pressurePipes.add(new Line(points.get(2),points.get(3)));
        pressurePipes.add(new Line(points.get(4),points.get(5)));
        pressurePipes.add(new Line(points.get(8),points.get(9)));
        pressurePipes.add(new Line(points.get(6),points.get(7)));
        pressurePipes.add(new Line(points.get(5),points.get(7)));
        pressurePipes.add(new Line(points.get(6),points.get(4)));
        pressurePipes.add(new Line(points.get(10),points.get(0)));
        pressurePipes.add(new Line(points.get(11),points.get(3)));
        pressurePipes.add(new Line(points.get(12),points.get(15)));
        pressurePipes.add(new Line(points.get(14),points.get(13)));
        pressurePipes.add(new Line(points.get(16),points.get(17)));
        pressurePipes.add(new Line(points.get(19),points.get(18)));
        pressurePipes.add(new Line(points.get(20),points.get(21)));
        pressurePipes.add(new Line(points.get(21),points.get(17)));
        pressurePipes.add(new Line(points.get(20),points.get(16)));
        pressurePipes.add(new Line(points.get(23),points.get(22)));
        pressurePipes.add(new Line(points.get(24),points.get(25)));
        pressurePipes.add(new Line(points.get(26),points.get(27)));
        pressurePipes.add(new Line(points.get(28),points.get(29)));
        pressurePipes.add(new Line(points.get(30),points.get(31)));
        pressurePipes.add(new Line(points.get(32),points.get(33)));
        pressurePipes.add(new Line(points.get(28),points.get(32)));
        pressurePipes.add(new Line(points.get(29),points.get(33)));
        pressurePipes.add(new Line(points.get(34),points.get(37)));
        pressurePipes.add(new Line(points.get(35),points.get(36)));
        pressurePipes.add(new Line(points.get(35),points.get(36)));
        pressurePipes.add(new Line(points.get(38),points.get(39)));
        pressurePipes.add(new Line(points.get(40),points.get(44)));
        pressurePipes.add(new Line(points.get(41),points.get(45)));
        pressurePipes.add(new Line(points.get(40),points.get(41)));
        pressurePipes.add(new Line(points.get(42),points.get(43)));
        pressurePipes.add(new Line(points.get(44),points.get(45)));
        pressurePipes.add(new Line(points.get(46),points.get(47)));
        pressurePipes.add(new Line(points.get(49),points.get(48)));
        pressurePipes.add(new Line(points.get(47),points.get(48)));
        pressurePipes.add(new Line(points.get(47),points.get(51)));
        pressurePipes.add(new Line(points.get(50),points.get(48)));
        pressurePipes.add(new Line(points.get(51),points.get(54)));
        pressurePipes.add(new Line(points.get(53),points.get(54)));
        pressurePipes.add(new Line(points.get(53),points.get(52)));
        if(kx == 1) {
            pressurePipes.add(new Arc(diamPressureLines.intValue(), points.get(52), points.get(50)));
        }else {
            pressurePipes.add(new Arc(diamPressureLines.intValue(), points.get(50), points.get(52)));
        }

        pressurePipes.add(new Line(points.get(58),points.get(56)));
        pressurePipes.add(new Line(points.get(57),points.get(55)));
        pressurePipes.add(new Line(points.get(59),points.get(60)));
        pressurePipes.add(new Line(points.get(62),points.get(61)));
        pressurePipes.add(new Line(points.get(63),points.get(64)));
        pressurePipes.add(new Line(points.get(63),points.get(59)));
        pressurePipes.add(new Line(points.get(60),points.get(64)));
        pressurePipes.add(new Line(points.get(65),points.get(66)));
        pressurePipes.add(new Line(points.get(68),points.get(67)));
        pressurePipes.add(new Line(points.get(70),points.get(69)));

        return pressurePipes;
    }



    @Override
    public List<IShape> draw() {
        List<IShape> frontView = new ArrayList<>();
        frontView.addAll(drawFrontView());
        frontView.addAll(drawPump(1));
        frontView.addAll(drawPump(-1));
        frontView.addAll(drawPressurePipes(1));
        frontView.addAll(drawPressurePipes(-1));
        return frontView;
    }
}
