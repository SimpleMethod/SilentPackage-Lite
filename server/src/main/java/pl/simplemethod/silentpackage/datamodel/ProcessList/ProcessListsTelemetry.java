package pl.simplemethod.silentpackage.dataModel.ProcessList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ProcessList"
})
@Component
public class ProcessListsTelemetry {

    @JsonProperty("ProcessList")
    public List<ProcessList> processList = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public ProcessListsTelemetry() {
    }

    /**
     *
     * @param processList List of class.
     */
    public ProcessListsTelemetry(List<ProcessList> processList) {
        super();
        this.processList = processList;
    }

}