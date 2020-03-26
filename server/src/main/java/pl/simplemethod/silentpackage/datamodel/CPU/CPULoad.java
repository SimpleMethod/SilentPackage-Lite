package pl.simplemethod.silentpackage.dataModel.CPU;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "Load"
})
public class CPULoad {

    @JsonProperty("Name")
    public String name;
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
     * @param load
     * @param name
     */
    public CPULoad(String name, Integer load) {
        super();
        this.name = name;
        this.load = load;
    }

}