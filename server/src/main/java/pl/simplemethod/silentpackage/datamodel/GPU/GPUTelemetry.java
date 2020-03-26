package pl.simplemethod.silentpackage.dataModel.GPU;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "DriverVersion",
        "DriverBranch",
        "DeviceID",
        "RevisionID",
        "CurrentTemp",
        "TotalMemory",
        "AvailableMemory"
})
public class GPUTelemetry {

    @JsonProperty("Name")
    public String name;
    @JsonProperty("DriverVersion")
    public String driverVersion;
    @JsonProperty("DriverBranch")
    public String driverBranch;
    @JsonProperty("DeviceID")
    public String deviceID;
    @JsonProperty("RevisionID")
    public String revisionID;
    @JsonProperty("CurrentTemp")
    public Integer currentTemp;
    @JsonProperty("TotalMemory")
    public Integer totalMemory;
    @JsonProperty("AvailableMemory")
    public Integer availableMemory;

    /**
     * No args constructor for use in serialization
     *
     */
    public GPUTelemetry() {
    }

    /**
     *
     * @param revisionID
     * @param totalMemory
     * @param availableMemory
     * @param driverVersion
     * @param name
     * @param currentTemp
     * @param driverBranch
     * @param deviceID
     */
    public GPUTelemetry(String name, String driverVersion, String driverBranch, String deviceID, String revisionID, Integer currentTemp, Integer totalMemory, Integer availableMemory) {
        super();
        this.name = name;
        this.driverVersion = driverVersion;
        this.driverBranch = driverBranch;
        this.deviceID = deviceID;
        this.revisionID = revisionID;
        this.currentTemp = currentTemp;
        this.totalMemory = totalMemory;
        this.availableMemory = availableMemory;
    }

}