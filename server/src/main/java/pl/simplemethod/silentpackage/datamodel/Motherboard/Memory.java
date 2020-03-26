package pl.simplemethod.silentpackage.dataModel.Motherboard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "MemoryDeviceManufacturer",
        "MemoryDevicePartNumber",
        "MemoryDeviceLocator",
        "MemoryDeviceBankLocator",
        "MemorySpeed"
})
public class Memory {

    @NotEmpty
    @JsonProperty("MemoryDeviceManufacturer")
    public String memoryDeviceManufacturer;
    @NotEmpty
    @JsonProperty("MemoryDevicePartNumber")
    @NotEmpty
    public String memoryDevicePartNumber;
    @NotEmpty
    @JsonProperty("MemoryDeviceLocator")
    public String memoryDeviceLocator;
    @NotEmpty
    @JsonProperty("MemoryDeviceBankLocator")
    public String memoryDeviceBankLocator;
    @NotEmpty
    @JsonProperty("MemorySpeed")
    public String memorySpeed;

    /**
     * No args constructor for use in serialization
     *
     */
    public Memory() {
    }

    /**
     *
     * @param memorySpeed
     * @param memoryDevicePartNumber
     * @param memoryDeviceLocator
     * @param memoryDeviceManufacturer
     * @param memoryDeviceBankLocator
     */
    public Memory(String memoryDeviceManufacturer, String memoryDevicePartNumber, String memoryDeviceLocator, String memoryDeviceBankLocator, String memorySpeed) {
        super();
        this.memoryDeviceManufacturer = memoryDeviceManufacturer;
        this.memoryDevicePartNumber = memoryDevicePartNumber;
        this.memoryDeviceLocator = memoryDeviceLocator;
        this.memoryDeviceBankLocator = memoryDeviceBankLocator;
        this.memorySpeed = memorySpeed;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "memoryDeviceManufacturer='" + memoryDeviceManufacturer + '\'' +
                ", memoryDevicePartNumber='" + memoryDevicePartNumber + '\'' +
                ", memoryDeviceLocator='" + memoryDeviceLocator + '\'' +
                ", memoryDeviceBankLocator='" + memoryDeviceBankLocator + '\'' +
                ", memorySpeed='" + memorySpeed + '\'' +
                '}';
    }
}