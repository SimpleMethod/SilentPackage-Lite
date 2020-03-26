package pl.simplemethod.silentpackage.dataModel.HardDrive;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Drivers"
})
public class HardDriveTelemetry {

    @JsonProperty("Drivers")
    public List<HardDriveInfo> hardDrives = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public HardDriveTelemetry() {
    }

    /**
     *
     * @param hardDriveInfoList
     */
    public HardDriveTelemetry(List<HardDriveInfo> hardDriveInfoList) {
        super();
        this.hardDrives = hardDriveInfoList;
    }

}