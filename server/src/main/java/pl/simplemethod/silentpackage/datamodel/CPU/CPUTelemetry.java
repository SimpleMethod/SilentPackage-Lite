package pl.simplemethod.silentpackage.dataModel.CPU;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CpuTemperature",
        "CpuClock",
        "CpuLoad"
})
public class CPUTelemetry {
    @NotEmpty(message = "The CpuTemperature list cannot be empty.")
    @JsonProperty("CpuTemperature")
    public List<CPUTemperature> cpuTemperature = new ArrayList<>();
    @NotEmpty(message = "The CPUClock list cannot be empty.")
    @JsonProperty("CpuClock")
    public List<CPUClock> cpuClock = new ArrayList<>();
    @NotEmpty(message = "The CPULoad list cannot be empty.")
    @JsonProperty("CpuLoad")
    public List<CPULoad> cpuLoad = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public CPUTelemetry() {
    }

    /**
     *
     * @param cpuTemperature
     * @param cpuLoad
     * @param cpuClock
     */
    public CPUTelemetry(List<CPUTemperature> cpuTemperature, List<CPUClock> cpuClock, List<CPULoad> cpuLoad) {
        super();
        this.cpuTemperature = cpuTemperature;
        this.cpuClock = cpuClock;
        this.cpuLoad = cpuLoad;
    }

    @Override
    public String toString() {
        return "CPUTelemetry{" +
                "cpuTemperature=" + cpuTemperature +
                ", cpuClock=" + cpuClock +
                ", cpuLoad=" + cpuLoad +
                '}';
    }
}