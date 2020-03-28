package pl.simplemethod.silentpackage.dataModel.RAM;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TotalPhysicalMemory",
        "TotalAvailableMemory"
})

@Component
public class RAMTelemetry {

    @NotNull
    @JsonProperty("TotalPhysicalMemory")
    public Integer totalPhysicalMemory;
    @NotNull
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
     * @param totalAvailableMemory The size of the available RAM.
     * @param totalPhysicalMemory Total amount of RAM.
     */
    public RAMTelemetry(Integer totalPhysicalMemory, Double totalAvailableMemory) {
        super();
        this.totalPhysicalMemory = totalPhysicalMemory;
        this.totalAvailableMemory = totalAvailableMemory;
    }

    @Override
    public String toString() {
        return "RAMTelemetry{" +
                "totalPhysicalMemory=" + totalPhysicalMemory +
                ", totalAvailableMemory=" + totalAvailableMemory +
                '}';
    }
}