package pl.simplemethod.silentpackage.dataModel.HardDrive;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "DriveName",
        "FirmwareVersion",
        "LogicalDriveName",
        "Format",
        "TotalSize",
        "TotalFreeSpace"
})
public class HardDriveInfo {

    @JsonProperty("DriveName")
    public String driveName;
    @JsonProperty("FirmwareVersion")
    public String firmwareVersion;
    @JsonProperty("LogicalDriveName")
    public String logicalDriveName;
    @JsonProperty("Format")
    public String format;
    @JsonProperty("TotalSize")
    public Long totalSize;
    @JsonProperty("TotalFreeSpace")
    public Long totalFreeSpace;

    /**
     * No args constructor for use in serialization
     *
     */
    public HardDriveInfo() {
    }

    /**
     *
     * @param logicalDriveName
     * @param totalSize
     * @param totalFreeSpace
     * @param format
     * @param driveName
     * @param firmwareVersion
     */
    public HardDriveInfo(String driveName, String firmwareVersion, String logicalDriveName, String format, Long totalSize, Long totalFreeSpace) {
        super();
        this.driveName = driveName;
        this.firmwareVersion = firmwareVersion;
        this.logicalDriveName = logicalDriveName;
        this.format = format;
        this.totalSize = totalSize;
        this.totalFreeSpace = totalFreeSpace;
    }

}