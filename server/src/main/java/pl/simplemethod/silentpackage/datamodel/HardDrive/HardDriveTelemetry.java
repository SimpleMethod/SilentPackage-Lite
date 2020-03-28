package pl.simplemethod.silentpackage.dataModel.HardDrive;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Drivers"
})
@Component
public class HardDriveTelemetry {

    @NotEmpty
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
     * @param hardDriveInfoList Lists of HardDriveInfo class.
     */
    public HardDriveTelemetry(List<HardDriveInfo> hardDriveInfoList) {
        super();
        this.hardDrives = hardDriveInfoList;
    }

}