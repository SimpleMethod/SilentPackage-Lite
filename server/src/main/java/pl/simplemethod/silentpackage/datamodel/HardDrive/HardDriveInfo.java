package pl.simplemethod.silentpackage.dataModel.HardDrive;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "DriveName",
        "FirmwareVersion",
        "LogicalDriveName",
        "Format",
        "TotalSize",
        "TotalFreeSpace"
})
@Component
public class HardDriveInfo {

    @NotEmpty
    @JsonProperty("DriveName")
    public String driveName;
    @NotEmpty
    @JsonProperty("FirmwareVersion")
    public String firmwareVersion;
    @NotEmpty
    @JsonProperty("LogicalDriveName")
    public String logicalDriveName;
    @NotEmpty
    @JsonProperty("Format")
    public String format;
    @NotEmpty
    @JsonProperty("TotalSize")
    public Long totalSize;
    @NotEmpty
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
     * @param logicalDriveName Logical location of disc.
     * @param totalSize Total size of disc in bytes.
     * @param totalFreeSpace Total free space on disc in bytes.
     * @param format Format of disc example: NTFS, FAT32 etc.
     * @param driveName Model of disc.
     * @param firmwareVersion Firmware installed on disc.
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

    @Override
    public String toString() {
        return "HardDriveInfo{" +
                "driveName='" + driveName + '\'' +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                ", logicalDriveName='" + logicalDriveName + '\'' +
                ", format='" + format + '\'' +
                ", totalSize=" + totalSize +
                ", totalFreeSpace=" + totalFreeSpace +
                '}';
    }
}