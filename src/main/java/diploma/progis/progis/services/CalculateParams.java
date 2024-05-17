package diploma.progis.progis.services;

import diploma.progis.progis.core.dto.CreateDrawingDTO;

public class CalculateParams {
    private final Double v = 1.5;
    private final Double eps = 0.5;
    private final Double g = 9.81;
    private final Double p = 7850.0;

    public CalculateParams() {
    }

    public Double calculateWaterConsumption(CreateDrawingDTO drawingDTO){
        Double d = drawingDTO.getDiamKNS();
        Double t = drawingDTO.getDiamKNS()*0.05;
        Double waterConsumption = Math.PI * (Math.pow(d - t, 2) / 4) * v;
        return waterConsumption;
    }

    public Double calcLocalResistanceLosses(){
        Double localResistanceLosses = eps * Math.pow(v, 2) / (2 * g);
        return localResistanceLosses;
    }

    public Double calcWeight(CreateDrawingDTO drawingDTO){
        Double t = drawingDTO.getDiamKNS()*0.05;
        Double d = drawingDTO.getDiamKNS();
        Double l = 1.0;
        Double weight = p * (t / 1000 * Math.PI * (d - t) / 1000 * l);
        return weight;
    }
}
