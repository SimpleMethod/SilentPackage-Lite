package pl.simplemethod.silentpackage.dataModel.GPU;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @NotEmpty
    @JsonProperty("Name")
    public String name;
    @NotEmpty
    @JsonProperty("DriverVersion")
    public String driverVersion;
    @NotEmpty
    @JsonProperty("DriverBranch")
    public String driverBranch;
    @NotEmpty
    @JsonProperty("DeviceID")
    public String deviceID;
    @NotEmpty
    @JsonProperty("RevisionID")
    public String revisionID;
    @NotEmpty
    @JsonProperty("CurrentTemp")
    public Integer currentTemp;
    @NotEmpty
    @JsonProperty("TotalMemory")
    public Integer totalMemory;
    @NotEmpty
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

    @Override
    public String toString() {
        return "GPUTelemetry{" +
                "name='" + name + '\'' +
                ", driverVersion='" + driverVersion + '\'' +
                ", driverBranch='" + driverBranch + '\'' +
                ", deviceID='" + deviceID + '\'' +
                ", revisionID='" + revisionID + '\'' +
                ", currentTemp=" + currentTemp +
                ", totalMemory=" + totalMemory +
                ", availableMemory=" + availableMemory +
                '}';
    }
}