package pl.simplemethod.silentpackage.dataModel.Mainboard;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
public class MainboardTelemetry {

    @JsonProperty("BiosVendor")
    public String biosVendor;
    @JsonProperty("BiosVersion")
    public String biosVersion;
    @JsonProperty("MainboardManufacturer")
    public String mainboardManufacturer;
    @JsonProperty("MainboardName")
    public String mainboardName;
    @JsonProperty("ProcessorManufacturer")
    public String processorManufacturer;
    @JsonProperty("ProcessorVersion")
    public String processorVersion;
    @JsonProperty("ProcessorCoreCount")
    public String processorCoreCount;
    @JsonProperty("ProcessorThreadCount")
    public String processorThreadCount;
    @JsonProperty("Memory")
    public List<Memory> memory = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public MainboardTelemetry() {
    }

    /**
     *
     * @param biosVersion
     * @param biosVendor
     * @param processorManufacturer
     * @param memory
     * @param processorCoreCount
     * @param mainboardManufacturer
     * @param processorVersion
     * @param processorThreadCount
     * @param mainboardName
     */
    public MainboardTelemetry(String biosVendor, String biosVersion, String mainboardManufacturer, String mainboardName, String processorManufacturer, String processorVersion, String processorCoreCount, String processorThreadCount, List<Memory> memory) {
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