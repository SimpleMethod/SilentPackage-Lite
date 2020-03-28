package pl.simplemethod.silentpackage.webController;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.simplemethod.silentpackage.ApplicationConfig;
import pl.simplemethod.silentpackage.dataModel.CPU.CPUTelemetry;
import pl.simplemethod.silentpackage.dataModel.GPU.GPUTelemetry;
import pl.simplemethod.silentpackage.dataModel.HardDrive.HardDriveTelemetry;
import pl.simplemethod.silentpackage.dataModel.Motherboard.MotherboardTelemetry;
import pl.simplemethod.silentpackage.dataModel.ProcessList.ProcessListsTelemetry;
import pl.simplemethod.silentpackage.dataModel.RAM.RAMTelemetry;

import javax.validation.Valid;

@RestController
public class RESTServices {
    AnnotationConfigApplicationContext ctx =new AnnotationConfigApplicationContext(ApplicationConfig.class);
    CPUTelemetry cpuTelemetry = ctx.getBean(CPUTelemetry.class);
    GPUTelemetry gpuTelemetry = ctx.getBean(GPUTelemetry.class);
    RAMTelemetry ramTelemetry = ctx.getBean(RAMTelemetry.class);
    MotherboardTelemetry motherboardTelemetry = ctx.getBean(MotherboardTelemetry.class);
    HardDriveTelemetry hardDriveTelemetry = ctx.getBean(HardDriveTelemetry.class);
    ProcessListsTelemetry processList = ctx.getBean(ProcessListsTelemetry.class);

    /**
     * Saves CPU telemetry.
     * @param raw Object to deserialize.
     * @return HTTP status code.
     */
    @PostMapping(value = "/1.0/cpu", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<CPUTelemetry> setCPUTelemetry(@Valid @RequestBody CPUTelemetry raw)
    {
        cpuTelemetry=raw;
      return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * Saves GPU specifications.
     * @param raw Object to deserialize.
     * @return HTTP status code.
     */
    @PostMapping(value = "/1.0/gpu", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<GPUTelemetry> setGPUTelemetry(@Valid @RequestBody GPUTelemetry raw)
    {
        gpuTelemetry=raw;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Saves RAM memory specifications.
     * @param raw Object to deserialize.
     * @return HTTP status code.
     */
    @PostMapping(value = "/1.0/ram", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<RAMTelemetry> setRamTelemetry(@Valid @RequestBody RAMTelemetry raw)
    {
        ramTelemetry=raw;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Saves motherboard specifications.
     * @param raw Object to deserialize.
     * @return HTTP status code.
     */
    @PostMapping(value = "/1.0/motherboard", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<MotherboardTelemetry> setMotherboardTelemetry(@Valid @RequestBody MotherboardTelemetry raw)
    {
        motherboardTelemetry=raw;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Saves a list of hard drivers.
     * @param raw Object to deserialize.
     * @return HTTP status code.
     */
    @PostMapping(value = "/1.0/harddrive", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<HardDriveTelemetry> setHardDriveTelemetry(@Valid @RequestBody HardDriveTelemetry raw)
    {
        hardDriveTelemetry=raw;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *  Saves a list of processes.
     * @param raw Object to deserialize.
     * @return HTTP status code.
     */
    @PostMapping(value = "/1.0/processlist", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<ProcessListsTelemetry> setProcessList(@Valid @RequestBody ProcessListsTelemetry raw)
    {
        processList=raw;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Returns a information about CPU  specifications.
     * @return HTTP status code and JSON object.
     */
    @GetMapping(value = "/1.0/cpu", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<CPUTelemetry> getCPUTelemetry()
    {
        if(cpuTelemetry.cpuTemperature.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
        return new ResponseEntity<>(cpuTelemetry,HttpStatus.OK);
    }

    /**
     * Returns a information about GPU specifications.
     * @return HTTP status code and JSON object.
     */
    @GetMapping(value = "/1.0/gpu", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<GPUTelemetry> getGPUTelemetry()
    {
        if(gpuTelemetry.totalMemory==null)
        {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
        return new ResponseEntity<>(gpuTelemetry,HttpStatus.OK);
    }

    /**
     * Returns a information about RAM memory specifications.
     * @return HTTP status code and JSON object.
     */
    @GetMapping(value = "/1.0/ram", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<RAMTelemetry> getRamTelemetry()
    {
        if(ramTelemetry.totalAvailableMemory==null)
        {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
        return new ResponseEntity<>(ramTelemetry,HttpStatus.OK);
    }

    /**
     * Returns a information about motherboard, CPU and RAM memory specifications.
     * @return HTTP status code and JSON object.
     */
    @GetMapping(value = "/1.0/motherboard", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<MotherboardTelemetry> getMotherboardTelemetry()
    {
        if(motherboardTelemetry.memory.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
        return new ResponseEntity<>(motherboardTelemetry,HttpStatus.OK);
    }

    /**
     * Returns a list of hard drives.
     * @return HTTP status code and JSON object.
     */
    @GetMapping(value = "/1.0/harddrive", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<HardDriveTelemetry> getHardDriveTelemetry()
    {
        if(hardDriveTelemetry.hardDrives.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
        return new ResponseEntity<>(hardDriveTelemetry,HttpStatus.OK);
    }

    /**
     * Returns a list of processes.
     * @return HTTP status code and JSON object.
     */
    @GetMapping(value = "/1.0/processlist", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public ResponseEntity<ProcessListsTelemetry> getProcessList()
    {
        if(processList.processList.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
        return new ResponseEntity<>(processList,HttpStatus.OK);
    }
}
