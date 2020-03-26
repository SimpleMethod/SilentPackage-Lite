package pl.simplemethod.silentpackage.dataModel.CPU;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "Temperature"
})
public class CPUTemperature {

    @NotEmpty
    @JsonProperty("Name")
    public String name;
    @NotEmpty @Min(-127) @Max(127)
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

    @Override
    public String toString() {
        return "CPUTemperature{" +
                "name='" + name + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
