package pl.simplemethod.silentpackage.webController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import pl.simplemethod.silentpackage.dataModel.CPU.CPUTelemetry;
import pl.simplemethod.silentpackage.dataModel.GPU.GPUTelemetry;
import pl.simplemethod.silentpackage.dataModel.HardDrive.HardDriveTelemetry;
import pl.simplemethod.silentpackage.dataModel.Motherboard.MotherboardTelemetry;
import pl.simplemethod.silentpackage.dataModel.ProcessList.ProcessListsTelemetry;
import pl.simplemethod.silentpackage.dataModel.RAM.RAMTelemetry;

import static org.junit.jupiter.api.Assertions.*;

class RESTServicesTest {
    RESTServices restServices = new RESTServices();

    @Test
    void setCPUTelemetry() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String mockString="{\"CpuTemperature\":[{\"Name\":\"CPU Core #1\",\"Temperature\":50},{\"Name\":\"CPU Core #2\",\"Temperature\":50}],\"CpuClock\":[{\"Name\":\"CPU Core #1\",\"Clock\":5000},{\"Name\":\"CPU Core #2\",\"Clock\":5000}],\"CpuLoad\":[{\"Name\":\"CPU Core #1\",\"Load\":5},{\"Name\":\"CPU Core #2\",\"Load\":5}]}";
        CPUTelemetry mockObject = objectMapper.readValue(mockString, CPUTelemetry.class);
        assertEquals(restServices.setCPUTelemetry(mockObject).getStatusCodeValue(),200);
    }

    @Test
    void setGPUTelemetry() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String mockString="{\"Name\":\"NVIDIA GPU\",\"DriverVersion\":\"000.01\",\"DriverBranch\":\"r001_20-8\",\"DeviceID\":\"XXXXXDE\",\"RevisionID\":\"X1\",\"CurrentTemp\":11,\"TotalMemory\":36,\"AvailableMemory\":8}";
        GPUTelemetry mockObject = objectMapper.readValue(mockString, GPUTelemetry.class);
        assertEquals(restServices.setGPUTelemetry(mockObject).getStatusCodeValue(),200);
    }

    @Test
    void setRamTelemetry() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String mockString="{\"TotalPhysicalMemory\":1,\"TotalAvailableMemory\":111.111}";
        RAMTelemetry mockObject = objectMapper.readValue(mockString, RAMTelemetry.class);
        assertEquals(restServices.setRamTelemetry(mockObject).getStatusCodeValue(),200);
    }

    @Test
    void setMotherboardTelemetry() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String mockString="{\"BiosVendor\":\"Simplemethod Inc.\",\"BiosVersion\":\"2001\",\"MainboardManufacturer\":\"SUPER COMPUTER INC.\",\"MainboardName\":\"UBER GAMING\",\"ProcessorManufacturer\":\"MORE CORE INC.\",\"ProcessorVersion\":\"RX9000\",\"ProcessorCoreCount\":\"24\",\"ProcessorThreadCount\":\"60\",\"Memory\":[{\"MemoryDeviceManufacturer\":\"XXX\",\"MemoryDevicePartNumber\":\"XXX 3000\",\"MemoryDeviceLocator\":\"ChannelA-DIMM1\",\"MemoryDeviceBankLocator\":\"BANK 0\",\"MemorySpeed\":\"3000\"}]}";
        MotherboardTelemetry mockObject = objectMapper.readValue(mockString, MotherboardTelemetry.class);
        assertEquals(restServices.setMotherboardTelemetry(mockObject).getStatusCodeValue(),200);
    }

    @Test
    void setHardDriveTelemetry() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String mockString="  {\"Drivers\":[{\"DriveName\":\"UUU 5000XD\",\"FirmwareVersion\":\"21.37\",\"LogicalDriveName\":\"C:\\\\\",\"Format\":\"ReFS\",\"TotalSize\":5000105736192,\"TotalFreeSpace\":3602283315200}]}";
        HardDriveTelemetry mockObject = objectMapper.readValue(mockString, HardDriveTelemetry.class);
        assertEquals(restServices.setHardDriveTelemetry(mockObject).getStatusCodeValue(),200);
    }

    @Test
    void setProcessList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String mockString="{\"ProcessList\":[{\"Name\":\"SilentPackage \",\"IdProcess\":4,\"TimeStart\":\"01.01.2020 21:37:00\"}]}";
        ProcessListsTelemetry mockObject = objectMapper.readValue(mockString, ProcessListsTelemetry.class);
        assertEquals(restServices.setProcessList(mockObject).getStatusCodeValue(),200);
    }

}