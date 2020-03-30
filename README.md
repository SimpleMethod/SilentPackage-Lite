# SilentPackage-Lite

The SilentPackage-Lite project is designed to allow monitoring of Windows system functioning.


The project was developed by Michał Młodawski (1ID21A) [m.mlodawski@simplemethod.io](mailto:m.mlodawski@simplemethod.io)

Teamwork division: 
Michał Młodawski did everything 

The topic of engineering work:
Meteorological system based on the Internet of things.




List of functionalities: 
1. Getting information about the CPU, manufacturer and model, as a temperature, load and clock of each processor core.
2. Getting information about the motherboard, manufacturer, model, BIOS version and BIOS manufacturer.
3. Getting information about the dedicated graphics card. Allows users to download data such as: Manufacturer, model, driver version, driver branch, core temperature, total vRAM and available memory for vRAM allocation.
4. Getting information about hard drives including: Disk name, format, location, free and used space.
5. Getting information about installed RAM including manufacturer, model, speed, bank number and free space.
6. Process lists with the name, identifier and start time of the process.
7. A graphical interface available from the web browser operating in the concept of "one page" handling AJAX requests.
8. Access to API.


Technology list:
 - .NET in Windows telemetry application:
	 - OpenHardwareMonitor Library 
	 - Json.NET Library
- JAVA in client for display data:
   - Spring Framework 

## 1. Used programming languages

1. Java with Spring framework to the core server layer. 
2. C# with .Net Framework version to the aggregation layer.
3. HTML with Bootstrap framework, JavaScript with jQuery and AngularJS framework.
4. JSON as a text format for transparent data.

## 2. software used in project design and implementation

1. Adobe XD CC for quick prototyping of the graphical interface.
2. IntelliJ IDEA as main IDE for core server layer.
3. JavaDoc for code documentation. 
4. JetBrains WebStorm as IDE for the graphical interface.
5. Visual Studio with the ReSharper extension.

## 3. Used the external library 
The source code of Open Hardware Monitor was used to collect device information. Fork of the library was to port to newer version of .NET Framework and add functionality of returning data in the form of JSON files and add telemetry of the RAM memory.
Fork is available at the address: [https://github.com/SimpleMethod/openhardwaremonitor](https://github.com/SimpleMethod/openhardwaremonitor)

## 4. Graphical interface

Graphical interface home page:
![Home](https://raw.githubusercontent.com/SimpleMethod/SilentPackage-Lite/master/doc/mainPage.png)

Java console of the running application:
![Cmd](https://raw.githubusercontent.com/SimpleMethod/SilentPackage-Lite/master/doc/console.png)
