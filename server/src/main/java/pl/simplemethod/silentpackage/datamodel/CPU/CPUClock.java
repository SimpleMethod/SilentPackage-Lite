package pl.simplemethod.silentpackage.dataModel.CPU;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "Clock"
})
@Component
public class CPUClock {

    @NotEmpty
    @JsonProperty("Name")
    public String name;
    @NotNull
    @Min(1)
    @JsonProperty("Clock")
    public Integer clock;

    /**
     * No args constructor for use in serialization
     *
     */
    public CPUClock() {
    }

    /**
     *
     * @param name Name of type sensors.
     * @param clock Value of current clock on core CPU in MHz.
     */
    public CPUClock(String name, Integer clock) {
        super();
        this.name = name;
        this.clock = clock;
    }

    @Override
    public String toString() {
        return "CPUClock{" +
                "name='" + name + '\'' +
                ", clock=" + clock +
                '}';
    }
}