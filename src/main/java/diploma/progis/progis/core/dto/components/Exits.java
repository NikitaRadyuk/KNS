package diploma.progis.progis.core.dto.components;

import diploma.progis.progis.core.dto.api.IComponent;
import diploma.progis.progis.core.dto.api.IShape;
import diploma.progis.progis.core.dto.shapes.Line;
import diploma.progis.progis.core.dto.shapes.Point;

import java.util.ArrayList;
import java.util.List;

public class Exits implements IComponent {
    public Double diamPipeBranch;
    public Double wellToPumpAxes;
    public Double pressureToPumpAxes;
    public Double diamPressureLine;
    public Integer anglePressure1;
    public Boolean pumpVisibility;

    private List<IShape> drawExitPumps(){
        List<IShape> exitPump = new ArrayList<>();
        List<Point> points = new ArrayList<>();

        //выходные патрубки
        points.add(new Point(diamPipeBranch /2, wellToPumpAxes + pressureToPumpAxes));                                                                                           //1
        points.add(new Point(diamPipeBranch /2 + 1.5*diamPipeBranch, wellToPumpAxes + pressureToPumpAxes));                                                                        //2
        points.add(new Point(diamPipeBranch /2 + 1.5*diamPipeBranch, wellToPumpAxes + pressureToPumpAxes
                + diamPressureLine));                                                     //3
        points.add(new Point(diamPipeBranch /2, wellToPumpAxes + pressureToPumpAxes + diamPressureLine));                                                                        //4

        for (var p: points){
            Double x = p.x - diamPipeBranch/2;
            Double y = p.y - wellToPumpAxes - pressureToPumpAxes - diamPressureLine/2;
            p.x = x*Math.cos(-anglePressure1 * Math.PI/180) - y*Math.sin(-anglePressure1 * Math.PI/180) +
                    diamPipeBranch /2;
            p.y = x*Math.sin(-anglePressure1 * Math.PI/180) + y*Math.cos(-anglePressure1 * Math.PI/180) +
                    wellToPumpAxes + pressureToPumpAxes + diamPressureLine/2;
        }

        exitPump.add(new Line(points.get(0),points.get(1)));
        exitPump.add(new Line(points.get(1),points.get(2)));
        exitPump.add(new Line(points.get(2),points.get(3)));
        exitPump.add(new Line(points.get(3),points.get(0)));

        return exitPump;
    }

    @Override
    public List<IShape> draw() {
        List<IShape> exits = new ArrayList<>();

        if (pumpVisibility) {
            exits.addAll(drawExitPumps());
        }

        return exits;
    }
}
