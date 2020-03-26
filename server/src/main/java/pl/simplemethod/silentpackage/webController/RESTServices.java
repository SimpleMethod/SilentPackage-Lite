package pl.simplemethod.silentpackage.webController;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTServices {

    @PostMapping(value = "/1.0/cpu", consumes = "application/json", produces = "application/json", headers = "Accept=application/json" )
    @ResponseBody
    public String getCPUTelemetry(@RequestBody String raw)
    {
        System.out.println("json = " + raw);
        return "xd";
    }
}
