package pl.simplemethod.silentpackage.dataModel.CPU;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "Load"
})
@Component
public class CPULoad {

    @NotEmpty
    @JsonProperty("Name")
    public String name;
    @NotEmpty @Max(1000) @Min(0)
    @JsonProperty("Load")
    public Integer load;

    /**
     * No args constructor for use in serialization
     *
     */
    public CPULoad() {
    }

    /**
     *
     * @param load Current value of load core CPU in %.
     * @param name Name of type sensors.
     */
    public CPULoad(String name, Integer load) {
        super();
        this.name = name;
        this.load = load;
    }

    @Override
    public String toString() {
        return "CPULoad{" +
                "name='" + name + '\'' +
                ", load=" + load +
                '}';
    }
}