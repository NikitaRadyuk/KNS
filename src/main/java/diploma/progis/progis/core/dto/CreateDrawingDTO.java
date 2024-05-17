package diploma.progis.progis.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@RequiredArgsConstructor
@Data
public class CreateDrawingDTO {
    @JsonProperty("diamKNS")
    private Double diamKNS;
    @JsonProperty("inf1visibility")
    private Boolean inf1visibility;
    @JsonProperty("inf1Angle")
    private Integer inf1Angle;
    @JsonProperty("diamInf1")
    private Double diamInf1;
    @JsonProperty("trash1Visible")
    private Boolean trash1Visible;
    @JsonProperty("inf2visibility")
    private Boolean inf2visibility;
    @JsonProperty("inf2Angle")
    private Integer inf2Angle;
    @JsonProperty("diamInf2")
    private Double diamInf2;
    @JsonProperty("trash2Visible")
    private Boolean trash2Visible;
    @JsonProperty("diamPressureLines")
    private Double diamPressureLines;
    @JsonProperty("trashLength")
    private Double trashLength;
    @JsonProperty("trashDepth")
    private Double trashDepth;
    @JsonProperty("trashHeight")
    private Double trashHeight;
    @JsonProperty("wellToPumpAxes")
    private Double wellToPumpAxes;
    @JsonProperty("pressureToPumpAxes")
    private Double pressureToPumpAxes;
    @JsonProperty("diamPump")
    private Double diamPump;
    @JsonProperty("diamPipeBranch")
    private Double diamPipeBranch;
    @JsonProperty("heightOfPump")
    private Double heightOfPump;
    @JsonProperty("heightBottomPumpFlangePlane")
    private Double heightBottomPumpFlangePlane;
    @JsonProperty("heightBottomPumpBottomWell")
    private Double heightBottomPumpBottomWell;
    @JsonProperty("stepladderAngle")
    private Integer stepladderAngle;
    @JsonProperty("anglePressure1")
    private Integer anglePressure1;
    @JsonProperty("pressure1visibility")
    private Boolean pressure1visibility;
    @JsonProperty("pressure2visibility")
    private Boolean pressure2visibility;
}
