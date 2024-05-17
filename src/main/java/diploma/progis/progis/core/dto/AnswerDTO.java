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
    private Double waterConsumption;
    @JsonProperty("localResistanceLosses")
    private Double localResistanceLosses;
    @JsonProperty("weight")
    private Double weight;
}
