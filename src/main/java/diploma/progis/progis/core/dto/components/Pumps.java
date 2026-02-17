package diploma.progis.progis.core.dto.components;

import diploma.progis.progis.core.dto.api.IComponent;
import diploma.progis.progis.core.dto.api.IShape;
import diploma.progis.progis.core.dto.shapes.Circle;
import diploma.progis.progis.core.dto.shapes.Line;
import diploma.progis.progis.core.dto.shapes.Point;

import java.util.ArrayList;
import java.util.List;

public class Pumps implements IComponent {
    public Double diamPipeBranch;
    public Double wellToPumpAxes;   //колодец-насос по вертикали
    public Double pressureToPumpAxes;       //напор-насос
    public Double diamPump;
    public Double diamPressureLine;
    public Integer anglePressure1;

    private List<IShape> drawPump(){
        List<IShape> pump = new ArrayList<>();

        List<Point> points = new ArrayList<>();

        points.add(new Point(diamPipeBranch/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes));                                                                                          //0
        points.add(new Point(diamPipeBranch/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes - diamPump/15));                                                                            //1
        points.add(new Point(diamPipeBranch/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes - diamPump/15));                                                                            //2
        points.add(new Point(diamPipeBranch/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes));                                                                                          //3

        points.add(new Point(diamPipeBranch/2 + diamPump/4 - diamPump/30,wellToPumpAxes + pressureToPumpAxes - diamPump/15));                                                                       //4
        points.add(new Point(diamPipeBranch/2 + diamPump/4 - diamPump/30,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5));                                                        //5
        points.add(new Point(diamPipeBranch/2 - diamPump/4 + diamPump/30,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5));                                                        //6
        points.add(new Point(diamPipeBranch/2 - diamPump/4 + diamPump/30,wellToPumpAxes + pressureToPumpAxes - diamPump/15));                                                                       //7

        points.add(new Point(diamPipeBranch/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5));                                                             //8
        points.add(new Point(diamPipeBranch/2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5 - diamPump/7.5));                                              //9
        points.add(new Point(diamPipeBranch/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5 - diamPump/7.5));                                              //10
        points.add(new Point(diamPipeBranch/2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5));                                                             //11

        points.add(new Point(diamPipeBranch/2 + diamPump/4 - diamPump/15,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5 - diamPump/7.5));                                         //12
        points.add(new Point(diamPipeBranch/2 + diamPump/4 - diamPump/15,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5 - diamPump/7.5 - diamPump/7.5));                          //13
        points.add(new Point(diamPipeBranch/2 - diamPump/4 + diamPump/15,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5 - diamPump/7.5 - diamPump/7.5));                          //14
        points.add(new Point(diamPipeBranch/2 - diamPump/4 + diamPump/15,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5 - diamPump/7.5));                                         //15

        points.add(new Point(diamPipeBranch/2, wellToPumpAxes + diamPump/2));                                                                                                              //16

        double angTangent = Math.PI/2 - Math.atan((points.get(13).x - diamPipeBranch /2)/(wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5 - diamPump/7.5 - diamPump/7.5))
                            - Math.acos((diamPump/2)/(Math.sqrt(Math.pow(points.get(13).x - diamPipeBranch /2,2)
                            + Math.pow((wellToPumpAxes + pressureToPumpAxes - 20 - 40 - 40 - 40),2))));

        points.add(new Point(diamPipeBranch /2 + diamPump/2 * Math.cos(angTangent),wellToPumpAxes + diamPump/2 * Math.sin(angTangent)));                                                    //17

        points.add(new Point(diamPipeBranch /2,wellToPumpAxes + pressureToPumpAxes + diamPressureLine));                                                                                    //18
        points.add(new Point(diamPipeBranch /5,wellToPumpAxes + pressureToPumpAxes + diamPressureLine));                                                                                    //19
        points.add(new Point(diamPipeBranch /5,wellToPumpAxes + pressureToPumpAxes));                                                                                                       //20
        points.add(new Point(diamPipeBranch /2,wellToPumpAxes + pressureToPumpAxes));                                                                                                       //21

        points.add(new Point(diamPipeBranch /5,wellToPumpAxes + pressureToPumpAxes + diamPressureLine + 50));                                                                               //22
        points.add(new Point(diamPipeBranch /5,wellToPumpAxes + pressureToPumpAxes - 50));                                                                                                  //23

        points.add(new Point(diamPipeBranch /5 - diamPipeBranch /15,wellToPumpAxes + pressureToPumpAxes - 50));                                                                         //24
        points.add(new Point(diamPipeBranch /5 - diamPipeBranch /15,wellToPumpAxes + pressureToPumpAxes + diamPressureLine + 50));                                                      //25

        points.add(new Point(diamPipeBranch /5 - diamPipeBranch /15,wellToPumpAxes + pressureToPumpAxes - 25));                                                                         //26
        points.add(new Point(diamPipeBranch /5 - diamPipeBranch /15,wellToPumpAxes + pressureToPumpAxes + diamPressureLine + 25));                                                      //27
        points.add(new Point(0,wellToPumpAxes + pressureToPumpAxes - 25));                                                                                                                      //28
        points.add(new Point(0,wellToPumpAxes + pressureToPumpAxes + diamPressureLine + 25));                                                                                                   //29

        points.add(new Point(diamPipeBranch /5 - diamPipeBranch /15,wellToPumpAxes + pressureToPumpAxes + diamPressureLine/2));                                                         //30
        points.add(new Point(0,wellToPumpAxes + pressureToPumpAxes + diamPressureLine/2));                                                                                                      //31

        //
        points.add(new Point(diamPipeBranch /2 + diamPump/4,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5 - diamPump/15));                                               //32
        points.add(new Point(diamPipeBranch /2 - diamPump/4,wellToPumpAxes + pressureToPumpAxes - diamPump/15 - diamPump/7.5 - diamPump/15));                                               //33
        //вертикальные линии вид сверху
        points.add(new Point(diamPipeBranch /2, wellToPumpAxes ));                                                                                                                             //34
        points.add(new Point(diamPipeBranch /2,wellToPumpAxes + pressureToPumpAxes + diamPressureLine/2));                                                                                  //35
        //прямоугольники на насосах
        points.add(new Point(diamPipeBranch /2 + diamPump/30, wellToPumpAxes - diamPump/5));                                                                                                //36
        points.add(new Point(diamPipeBranch /2 + diamPump/30, wellToPumpAxes + diamPump/5));                                                                                                //37
        points.add(new Point(diamPipeBranch /2 - diamPump/30, wellToPumpAxes + diamPump/5));                                                                                                //38
        points.add(new Point(diamPipeBranch /2 - diamPump/30, wellToPumpAxes - diamPump/5));                                                                                                //39
        //вертикальные линии насос-напор
        points.add(new Point(diamPipeBranch /2 - diamPump/4 + diamPump/15,wellToPumpAxes + diamPump/2.2));                                                                                  //40
        //перегородка пружинная на напорной линии
        points.add(new Point(diamPipeBranch /5 - diamPipeBranch /15 + diamPipeBranch /30,wellToPumpAxes + pressureToPumpAxes - 50));                                                //41
        points.add(new Point(diamPipeBranch /5 - diamPipeBranch /15 + diamPipeBranch /30,wellToPumpAxes + pressureToPumpAxes + diamPressureLine + 50));                             //42

        pump.add(new Circle(diamPump/2,new Point(diamPipeBranch /2, wellToPumpAxes)));
        pump.add(new Circle(diamPump/4,new Point(diamPipeBranch /2, wellToPumpAxes)));
        pump.add(new Line(points.get(0),points.get(1)));
        pump.add(new Line(points.get(1),points.get(2)));
        pump.add(new Line(points.get(2),points.get(3)));
        pump.add(new Line(points.get(3),points.get(0)));
        pump.add(new Line(points.get(4),points.get(5)));
        pump.add(new Line(points.get(5),points.get(6)));
        pump.add(new Line(points.get(6),points.get(7)));
        pump.add(new Line(points.get(7),points.get(4)));
        pump.add(new Line(points.get(8),points.get(9)));
        pump.add(new Line(points.get(9),points.get(10)));
        pump.add(new Line(points.get(10),points.get(11)));
        pump.add(new Line(points.get(11),points.get(8)));
        pump.add(new Line(points.get(12),points.get(13)));
        pump.add(new Line(points.get(13),points.get(14)));
        pump.add(new Line(points.get(14),points.get(15)));
        pump.add(new Line(points.get(15),points.get(12)));
        pump.add(new Line(points.get(14),points.get(16)));
        pump.add(new Line(points.get(13),points.get(17)));
        pump.add(new Line(points.get(18),points.get(19)));
        pump.add(new Line(points.get(20),points.get(21)));
        pump.add(new Circle(diamPressureLine/2, new Point(diamPipeBranch /2, wellToPumpAxes + pressureToPumpAxes + diamPressureLine/2)));
        pump.add(new Circle(diamPressureLine/4, new Point(diamPipeBranch /2, wellToPumpAxes + pressureToPumpAxes + diamPressureLine/2)));
        pump.add(new Line(points.get(22),points.get(23)));
        pump.add(new Line(points.get(25),points.get(24)));
        pump.add(new Line(points.get(22),points.get(25)));
        pump.add(new Line(points.get(24),points.get(23)));
        pump.add(new Line(points.get(26),points.get(28)));
        pump.add(new Line(points.get(27),points.get(29)));
        pump.add(new Line(points.get(30),points.get(31)));
        pump.add(new Line(points.get(32),points.get(33)));
        pump.add(new Line(points.get(34),points.get(35)));
        pump.add(new Line(points.get(36),points.get(37)));
        pump.add(new Line(points.get(37),points.get(38)));
        pump.add(new Line(points.get(38),points.get(39)));
        pump.add(new Line(points.get(39),points.get(36)));
        pump.add(new Line(points.get(40),points.get(15)));
        pump.add(new Line(points.get(41),points.get(42)));
        pump.add(new Line(new Point(20,0),new Point(-20,0)));
        pump.add(new Line(new Point(0,20),new Point(0,-20)));

        return pump;
    }

    @Override
    public List<IShape> draw() {
        List<IShape> pumps = new ArrayList<>();

        pumps.addAll(drawPump());

        return pumps;
    }
}
