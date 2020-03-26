package pl.simplemethod.silentpackage.webController;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.simplemethod.silentpackage.dataModel.CPU.CPUTelemetry;
import pl.simplemethod.silentpackage.dataModel.GPU.GPUTelemetry;
import pl.simplemethod.silentpackage.dataModel.HardDrive.HardDriveTelemetry;
import pl.simplemethod.silentpackage.dataModel.Motherboard.MainboardTelemetry;
import pl.simplemethod.silentpackage.dataModel.RAM.RAMTelemetry;

@RestController
public class RESTServices {

    @PostMapping(value = "/1.0/cpu", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public String getCPUTelemetry(@RequestBody @Validated CPUTelemetry raw)
    {
        System.out.println("json = " + raw.cpuTemperature.get(0).name);
        return "ok";
    }

    @PostMapping(value = "/1.0/gpu", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public void getGPUTelemetry(@RequestBody @Validated GPUTelemetry raw)
    {
    }

    @PostMapping(value = "/1.0/ram", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public void getRamTelemetry(@RequestBody @Validated RAMTelemetry raw)
    {
    }

    @PostMapping(value = "/1.0/motherboard", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public void getMotherboardTelemetry(@RequestBody @Validated MainboardTelemetry raw)
    {
    }

    @PostMapping(value = "/1.0/hardDrive", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public void getHardDriveTelemetry(@RequestBody @Validated HardDriveTelemetry raw)
    {
    }
}
