package pl.simplemethod.silentpackage;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SilentpackageApplication {

    /**
     * Creating a new system process and open web browser.
     * @throws Exception Exception during process creation problem.
     */
    private static void openUrl() throws Exception {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c start ", " http://127.0.0.1:8090/");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        p.exitValue();
        p.destroy();
    }

    public static void main(String[] args) {
        SpringApplication.run(SilentpackageApplication.class, args);
        try {
            openUrl();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
