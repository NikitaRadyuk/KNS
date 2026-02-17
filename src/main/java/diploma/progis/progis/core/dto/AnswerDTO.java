package diploma.progis.progis.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@RequiredArgsConstructor
@Data
public class AnswerDTO {
    @JsonProperty("svg")
    private String svg;
    @JsonProperty("waterConsumption")
    private String waterConsumption;
    @JsonProperty("localResistanceLosses")
    private String localResistanceLosses;
    @JsonProperty("weight")
    private String weight;
    @JsonProperty("diameter")
    private String diameter;
    @JsonProperty("turningLosses")
    private String turningLosses;
    @JsonProperty("expansionLosses")
    private Double expansionLosses;
    @JsonProperty("narrowingLosses")
    private Double narrowingLosses;
}
