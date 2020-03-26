package pl.simplemethod.silentpackage.dataModel.Mainboard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "MemoryDeviceManufacturer",
        "MemoryDevicePartNumber",
        "MemoryDeviceLocator",
        "MemoryDeviceBankLocator",
        "MemorySpeed"
})
public class Memory {

    @JsonProperty("MemoryDeviceManufacturer")
    public String memoryDeviceManufacturer;
    @JsonProperty("MemoryDevicePartNumber")
    public String memoryDevicePartNumber;
    @JsonProperty("MemoryDeviceLocator")
    public String memoryDeviceLocator;
    @JsonProperty("MemoryDeviceBankLocator")
    public String memoryDeviceBankLocator;
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

}