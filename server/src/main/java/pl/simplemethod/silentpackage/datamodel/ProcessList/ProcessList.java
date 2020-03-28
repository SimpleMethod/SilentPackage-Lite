package pl.simplemethod.silentpackage.dataModel.ProcessList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "IdProcess",
        "TimeStart"
})
public class ProcessList {

    @NotEmpty
    @JsonProperty("Name")
    public String name;
    @JsonProperty("IdProcess")
    public Integer idProcess;
    @NotEmpty
    @JsonProperty("TimeStart")
    public String timeStart;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProcessList() {
    }

    /**
     *
     * @param timeStart Time of start process.
     * @param name Name of process.
     * @param idProcess ID of process.
     */
    public ProcessList(String name, Integer idProcess, String timeStart) {
        super();
        this.name = name;
        this.idProcess = idProcess;
        this.timeStart = timeStart;
    }

}