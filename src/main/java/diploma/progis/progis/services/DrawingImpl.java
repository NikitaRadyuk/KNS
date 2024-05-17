package diploma.progis.progis.services;

import diploma.progis.progis.core.dto.AnswerDTO;
import diploma.progis.progis.core.dto.CreateDrawingDTO;
import diploma.progis.progis.core.dto.api.IShape;
import diploma.progis.progis.core.dto.components.Exits;
import diploma.progis.progis.core.dto.components.FrontView;
import diploma.progis.progis.core.dto.components.Influx;
import diploma.progis.progis.core.dto.components.Pumps;
import diploma.progis.progis.core.dto.shapes.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrawingImpl implements IDrawingService{

    public String drawStation(CreateDrawingDTO createDrawingDTO) {
        Influx influx1 = new Influx();
        Influx influx2 = new Influx();

        //Influx1
        influx1.diamKNS = createDrawingDTO.getDiamKNS();
        influx1.stepladderAngle = createDrawingDTO.getStepladderAngle();
        influx1.center = new Point(0,0);
        influx1.angle = createDrawingDTO.getInf1Angle();
        influx1.diamInf = createDrawingDTO.getDiamInf1();
        influx1.isVisible = createDrawingDTO.getInf1visibility();
        influx1.trashDepth = createDrawingDTO.getTrashDepth();
        influx1.trashWidth = createDrawingDTO.getTrashHeight();
        influx1.trashLength = createDrawingDTO.getTrashLength();
        influx1.trashVisible = createDrawingDTO.getTrash1Visible();
        //Influx2
        influx2.diamKNS = createDrawingDTO.getDiamKNS();
        influx2.stepladderAngle = createDrawingDTO.getStepladderAngle();
        influx2.center = new Point(0,0);
        influx2.angle = createDrawingDTO.getInf2Angle();
        influx2.diamInf = createDrawingDTO.getDiamInf2();
        influx2.isVisible = createDrawingDTO.getInf2visibility();
        influx2.trashDepth = createDrawingDTO.getTrashDepth();
        influx2.trashWidth = createDrawingDTO.getTrashHeight();
        influx2.trashLength = createDrawingDTO.getTrashLength();
        influx2.trashVisible = createDrawingDTO.getTrash2Visible();

        //Pumps
        Pumps pumps = new Pumps();
        pumps.diamPressureLine = createDrawingDTO.getDiamPressureLines();
        pumps.wellToPumpAxes = createDrawingDTO.getWellToPumpAxes();
        pumps.pressureToPumpAxes = createDrawingDTO.getPressureToPumpAxes();
        pumps.diamPump = createDrawingDTO.getDiamPump();
        pumps.diamPipeBranch = createDrawingDTO.getDiamPipeBranch();
        pumps.anglePressure1 = - createDrawingDTO.getAnglePressure1();

        Pumps pumps1 = new Pumps();
        pumps1.diamPressureLine = createDrawingDTO.getDiamPressureLines();
        pumps1.wellToPumpAxes = createDrawingDTO.getWellToPumpAxes();
        pumps1.pressureToPumpAxes = createDrawingDTO.getPressureToPumpAxes();
        pumps1.diamPump = createDrawingDTO.getDiamPump();
        pumps1.diamPipeBranch = -createDrawingDTO.getDiamPipeBranch();
        pumps1.anglePressure1 = createDrawingDTO.getAnglePressure1();

        FrontView frontView = new FrontView();
        frontView.diamKNS = createDrawingDTO.getDiamKNS();
        frontView.diamPressureLines = createDrawingDTO.getDiamPressureLines();
        frontView.diamPump = createDrawingDTO.getDiamPump();
        frontView.diamPipeBranch = createDrawingDTO.getDiamPipeBranch();
        frontView.heightOfPump = createDrawingDTO.getHeightOfPump();
        frontView.heightBottomPumpFlangePlane = createDrawingDTO.getHeightBottomPumpFlangePlane();
        frontView.heightBottomPumpBottomWell = createDrawingDTO.getHeightBottomPumpBottomWell();

        Exits exit1 = new Exits();
        exit1.diamPipeBranch = createDrawingDTO.getDiamPipeBranch();
        exit1.wellToPumpAxes = createDrawingDTO.getWellToPumpAxes();
        exit1.pressureToPumpAxes = createDrawingDTO.getPressureToPumpAxes();
        exit1.diamPressureLine = createDrawingDTO.getDiamPressureLines();
        exit1.anglePressure1 = createDrawingDTO.getAnglePressure1();
        exit1.pump1Visibility = createDrawingDTO.getPressure1visibility();

        Exits exit2 = new Exits();
        exit2.diamPipeBranch = - createDrawingDTO.getDiamPipeBranch();
        exit2.wellToPumpAxes = createDrawingDTO.getWellToPumpAxes();
        exit2.pressureToPumpAxes = createDrawingDTO.getPressureToPumpAxes();
        exit2.diamPressureLine = createDrawingDTO.getDiamPressureLines();
        exit2.anglePressure1 = createDrawingDTO.getAnglePressure1();
        exit2.pump1Visibility = createDrawingDTO.getPressure2visibility();

        List<IShape> shapes = influx2.draw();
        shapes.addAll(influx1.draw());
        shapes.addAll(pumps.draw());
        shapes.addAll(pumps1.draw());
        shapes.addAll(frontView.draw());

        SVGBuilder svgBuilder = new SVGBuilder(1000,2500,8000.0,8000.0, new Point(1700,1200));
        for(
                IShape shape: shapes
        ){
            shape.drawToSVG(svgBuilder);
        }

        return svgBuilder.build();
    }

    public AnswerDTO calculateAnswer(CreateDrawingDTO drawingDTO){
        AnswerDTO answerDTO = new AnswerDTO();
        CalculateParams calc = new CalculateParams();
        answerDTO.setWeight(calc.calcWeight(drawingDTO));
        answerDTO.setSvg(drawStation(drawingDTO));
        answerDTO.setLocalResistanceLosses(calc.calcLocalResistanceLosses());
        answerDTO.setWaterConsumption(calc.calculateWaterConsumption(drawingDTO));
        return answerDTO;
    }
}
