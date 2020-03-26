package pl.simplemethod.silentpackage.webController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import javax.validation.Valid;

@RestController
public class RESTServices {

    @PostMapping(value = "/1.0/cpu", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<CPUTelemetry> getCPUTelemetry(@Valid @RequestBody CPUTelemetry raw)
    {

     System.out.println(raw.cpuTemperature.get(0).name.toString());
        //System.out.println("json = " + raw.cpuTemperature.get(0).name);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/1.0/gpu", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<GPUTelemetry> getGPUTelemetry(@Valid @RequestBody GPUTelemetry raw)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/1.0/ram", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<RAMTelemetry> getRamTelemetry(@Valid @RequestBody RAMTelemetry raw)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/1.0/motherboard", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<MainboardTelemetry> getMotherboardTelemetry(@Valid @RequestBody MainboardTelemetry raw)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/1.0/hardDrive", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<HardDriveTelemetry> getHardDriveTelemetry(@Valid @RequestBody HardDriveTelemetry raw)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
