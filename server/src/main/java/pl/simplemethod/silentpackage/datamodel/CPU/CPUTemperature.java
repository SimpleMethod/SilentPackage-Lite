package pl.simplemethod.silentpackage.dataModel.CPU;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "Temperature"
})
public class CPUTemperature {

    @JsonProperty("Name")
    public String name;
    @JsonProperty("Temperature")
    public Integer temperature;

    /**
     * No args constructor for use in serialization
     */
    public CPUTemperature() {
    }

    /**
     * @param name
     * @param temperature
     */
    public CPUTemperature(String name, Integer temperature) {
        super();
        this.name = name;
        this.temperature = temperature;
    }
}
