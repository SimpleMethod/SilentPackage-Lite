package pl.simplemethod.silentpackage.dataModel.Motherboard;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "BiosVendor",
        "BiosVersion",
        "MainboardManufacturer",
        "MainboardName",
        "ProcessorManufacturer",
        "ProcessorVersion",
        "ProcessorCoreCount",
        "ProcessorThreadCount",
        "Memory"
})
@Component
public class MotherboardTelemetry {

    @NotEmpty
    @JsonProperty("BiosVendor")
    public String biosVendor;
    @NotEmpty
    @JsonProperty("BiosVersion")
    public String biosVersion;
    @NotEmpty
    @JsonProperty("MainboardManufacturer")
    public String mainboardManufacturer;
    @NotEmpty
    @JsonProperty("MainboardName")
    public String mainboardName;
    @NotEmpty
    @JsonProperty("ProcessorManufacturer")
    public String processorManufacturer;
    @NotEmpty
    @JsonProperty("ProcessorVersion")
    public String processorVersion;
    @NotEmpty
    @JsonProperty("ProcessorCoreCount")
    public String processorCoreCount;
    @NotEmpty
    @JsonProperty("ProcessorThreadCount")
    public String processorThreadCount;
    @NotEmpty
    @JsonProperty("Memory")
    public List<Memory> memory = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public MotherboardTelemetry() {
    }

    /**
     *
     * @param biosVersion BIOS version.
     * @param biosVendor BIOS manufacturer.
     * @param processorManufacturer CPU manufacturer.
     * @param memory Lists of memory class.
     * @param processorCoreCount CPU core count.
     * @param mainboardManufacturer Motherboard manufacturer.
     * @param processorVersion Model of CPU.
     * @param processorThreadCount Thread count of CPU.
     * @param mainboardName Motherboard model.
     */
    public MotherboardTelemetry(String biosVendor, String biosVersion, String mainboardManufacturer, String mainboardName, String processorManufacturer, String processorVersion, String processorCoreCount, String processorThreadCount, List<Memory> memory) {
        super();
        this.biosVendor = biosVendor;
        this.biosVersion = biosVersion;
        this.mainboardManufacturer = mainboardManufacturer;
        this.mainboardName = mainboardName;
        this.processorManufacturer = processorManufacturer;
        this.processorVersion = processorVersion;
        this.processorCoreCount = processorCoreCount;
        this.processorThreadCount = processorThreadCount;
        this.memory = memory;
    }

}