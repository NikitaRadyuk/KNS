package diploma.progis.progis.core.dto.components;

import diploma.progis.progis.core.dto.api.IComponent;
import diploma.progis.progis.core.dto.api.IShape;
import diploma.progis.progis.core.dto.shapes.Circle;
import diploma.progis.progis.core.dto.shapes.Line;
import diploma.progis.progis.core.dto.shapes.Point;

import java.util.ArrayList;
import java.util.List;

public class Influx implements IComponent {
    public Point center;
    public Boolean isVisible;
    public Integer angle;
    public Integer stepladderAngle;
    public Double diamInf;
    public Double diamKNS;
    public Double trashLength;
    public Double trashWidth;
    public Double trashDepth;
    public Boolean trashVisible;

    public Influx() {
    }

    private List<IShape> drawWell(){
        List<IShape> well = new ArrayList<>();
        well.add(new Circle(diamKNS/2,new Point(0,0)));
        well.add(new Circle(diamKNS/2 - 0.05*diamKNS,new Point(0,0)));

        //stepLadder
        List<Point> ladderPoints = new ArrayList<>();
        Double cos = Math.cos(-stepladderAngle * Math.PI/180);
        Double sin = Math.sin(-stepladderAngle * Math.PI/180);
        ladderPoints.add(new Point(diamKNS/2 - diamKNS * 0.10, diamKNS/10));
        ladderPoints.add(new Point(diamKNS/2 - diamKNS * 0.10, -diamKNS/10));
        for (var p: ladderPoints){
            Double x = p.x;
            Double y = p.y;
            p.x = x * cos - y * sin + center.x;
            p.y = x*sin + y*cos + center.y;
        }
        well.add(new Line(ladderPoints.get(0), ladderPoints.get(1)));
        return well;
    }

    private List<IShape> drawTrash(){
        List<IShape> musor = new ArrayList<>();

        List<Point> points = new ArrayList<>();

        Double cos = Math.cos(-angle * Math.PI/180);
        Double sin = Math.sin(-angle * Math.PI/180);

        points.add(new Point(diamKNS/2 - diamKNS * 0.10, trashWidth /2));
        points.add(new Point(diamKNS/2 - diamKNS * 0.10, -trashWidth /2));
        points.add(new Point(diamKNS/2 - trashLength - diamKNS * 0.10, -trashWidth /2));
        points.add(new Point(diamKNS/2 - trashLength - diamKNS * 0.10, trashWidth /2));
        points.add(new Point(diamKNS/2 - trashDepth - diamKNS * 0.10, trashWidth /2));
        points.add(new Point(diamKNS/2 - trashDepth - diamKNS * 0.10, -trashWidth /2));

        for (var p:
             points) {
            Double x = p.x;
            Double y = p.y;
            p.x = x * cos - y * sin + center.x;
            p.y = x*sin + y*cos + center.y;
        }
        musor.add(new Line(points.get(0), points.get(1)));
        musor.add(new Line(points.get(1), points.get(2)));
        musor.add(new Line(points.get(2), points.get(3)));
        musor.add(new Line(points.get(3), points.get(0)));
        musor.add(new Line(points.get(4), points.get(5)));


        return musor;
    }

    private List<IShape> drawInflux(){
        List<IShape> influx = new ArrayList<>();
        Double cos = Math.cos(-angle * Math.PI/180);
        Double sin = Math.sin(-angle * Math.PI/180);

        List<Point> points = new ArrayList<>();

        points.add(new Point(diamKNS/2 - trashDepth - diamKNS * 0.10, -diamInf/2));
        points.add(new Point(diamKNS/2 - trashDepth - diamKNS * 0.10, diamInf/2));
        points.add(new Point(diamKNS/2 - trashDepth + diamKNS/3 - diamKNS * 0.10, diamInf/2));
        points.add(new Point(diamKNS/2 - trashDepth + diamKNS/3 - diamKNS * 0.10, -diamInf/2));

        for (var p:
                points) {
            Double x = p.x;
            Double y = p.y;
            p.x = x * cos - y * sin + center.x;
            p.y = x*sin + y*cos + center.y;
        }

        influx.add(new Line(points.get(0), points.get(1)));
        influx.add(new Line(points.get(1), points.get(2)));
        influx.add(new Line(points.get(2), points.get(3)));
        influx.add(new Line(points.get(3), points.get(0)));

        return influx;
    }

    @Override
    public List<IShape> draw() {
        List<IShape> influx = new ArrayList<>();
        if(trashVisible){
            influx.addAll(drawTrash());
        }
        influx.addAll(drawWell());

        if(isVisible){
            influx.addAll(drawInflux());
        }

        return influx;
    }
}
