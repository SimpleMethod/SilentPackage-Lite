package pl.simplemethod.silentpackage.dataModel.CPU;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "Clock"
})
public class CPUClock {

    @JsonProperty("Name")
    public String name;
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
     * @param name
     * @param clock
     */
    public CPUClock(String name, Integer clock) {
        super();
        this.name = name;
        this.clock = clock;
    }

}