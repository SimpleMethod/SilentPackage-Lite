package pl.simplemethod.silentpackage.dataModel.RAM;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TotalPhysicalMemory",
        "TotalAvailableMemory"
})
public class RAMTelemetry {

    @JsonProperty("TotalPhysicalMemory")
    public Integer totalPhysicalMemory;
    @JsonProperty("TotalAvailableMemory")
    public Double totalAvailableMemory;

    /**
     * No args constructor for use in serialization
     *
     */
    public RAMTelemetry() {
    }

    /**
     *
     * @param totalAvailableMemory
     * @param totalPhysicalMemory
     */
    public RAMTelemetry(Integer totalPhysicalMemory, Double totalAvailableMemory) {
        super();
        this.totalPhysicalMemory = totalPhysicalMemory;
        this.totalAvailableMemory = totalAvailableMemory;
    }

}