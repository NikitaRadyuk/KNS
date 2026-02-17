package diploma.progis.progis.services;

import diploma.progis.progis.core.dto.CreateDrawingDTO;

import java.net.DatagramPacket;
import java.text.DecimalFormat;

public class CalculateParams {
    DecimalFormat format = new DecimalFormat("0.0000");

    public CalculateParams() {
    }

    public String calculateWaterConsumption(CreateDrawingDTO drawingDTO){
        Double d = drawingDTO.getOutterDiamPipeline();
        Double t = drawingDTO.getThicknessPipeline();
        Double v = drawingDTO.getFluidFlowRate();
        Double result = Math.PI * (Math.pow(d - t, 2) / 4) * v;
        String formRes = format.format(result);
        return formRes;
    }

    public String calcLocalResistanceLosses(CreateDrawingDTO drawingDTO){
        Double v = drawingDTO.getFluidFlowRate();
        double g = 9.81;
        Double eps = 0.5;
        Double localResistanceLosses = eps * Math.pow(v, 2) / (2 * g);
        String formRes = format.format(localResistanceLosses);
        return formRes;
    }

    public String calcWeight(CreateDrawingDTO drawingDTO){
        Double t = drawingDTO.getDiamKNS()*0.05;
        Double d = drawingDTO.getDiamKNS();
        Double l = drawingDTO.getPipeLength();
        Double p = drawingDTO.getDensity();
        Double weight = p * (t / 1000 * Math.PI * (d - t) / 1000 * l);
        String formRes = format.format(weight);
        return formRes;
    }

    public String calcDiam(CreateDrawingDTO drawingDTO){
        Double q = drawingDTO.getConsumption();
        Double v = drawingDTO.getFluidFlowRate();
        Double diam = Math.sqrt(4*1000*q/v/Math.PI);
        String formRes = format.format(diam);
        return formRes;
    }

    public String calcTurningLosses(CreateDrawingDTO drawingDTO){
        Double eps = drawingDTO.getEps();
        Double v = drawingDTO.getFluidFlowRate();
        Double g = 9.81;
        Double turningLosses = eps*Math.pow(v,2)/(2*g);
        String formRes = format.format(turningLosses);
        return formRes;
    }

    public Double calcExpansionLosses(CreateDrawingDTO drawingDTO){
        Double d1 = drawingDTO.getDiamExpansion1();
        Double d2 = drawingDTO.getDiamExpansion2();
        Double q = drawingDTO.getConsumption();
        Double eps = Math.pow((1 - Math.pow(d1/d2,2)),2);
        Double v = 4*q/(Math.PI * Math.pow(d2,2));
        Double g = 9.81;
        Double narrowingLosses = eps * Math.pow(v,2)/(2*g);
        return narrowingLosses;
    }

    public Double calcNarrowingLosses(CreateDrawingDTO drawingDTO){
        Double d1 = drawingDTO.getDiamNarrowing1();
        Double d2 = drawingDTO.getDiamNarrowing2();
        Double q = drawingDTO.getConsumption();
        Double eps = 0.5*Math.pow((1 - Math.pow((d1/d2),2)),2);
        Double v = 4*q/(Math.PI * Math.pow(d2,2));
        Double g = 9.81;
        Double narrowingLosses = eps * Math.pow(v,2)/(2*g);
        return narrowingLosses;
    }

}
