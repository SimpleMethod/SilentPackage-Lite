using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Linq;
using System.Management;
using System.Text;
using OpenHardwareMonitor.Hardware;
using OpenHardwareMonitor.Collections;
using OpenHardwareMonitor;
using SilentPackage_Lite.IO_Readers;
using System.Text.Json;
using System.Text.Json.Serialization;

namespace SilentPackage_Lite.IO_Readers
{

    public class TelemetryModel
    {
        [JsonPropertyName("CpuTemperature")]
        public List<CpuTemp> CpuTemps { get; set; }
        [JsonPropertyName("CpuClock")]
        public List<CpuClock> CpuClocks { get; set; }
        [JsonPropertyName("CpuLoad")]
        public List<CpuLoad> CpuLoads { get; set; }
    }

    public class CpuTemp
    {
        public string Name { get; set; }
        public int Temperature { get; set; }
        public CpuTemp(string name, int temperature)
        {
            Name = name;
            Temperature = temperature;
        }
    }

    public class CpuClock
    {
        public string Name { get; set; }
        public float Clock { get; set; }
        public CpuClock(string name, float clock)
        {
            Name = name;
            Clock = clock;
        }
    }


    public class CpuLoad
    {
        public string Name { get; set; }
        public float Load { get; set; }
        public CpuLoad(string name, float load)
        {
            Name = name;
            Load = load;
        }

    }

    public sealed class Telemetry
    {
        private static Telemetry _mOInstance = null;
        private static readonly Object Mutex = new object();

        public static Telemetry GetInstance()
        {
            if (_mOInstance == null)
            {
                lock (Mutex)
                {
                    if (_mOInstance == null)
                    {
                        _mOInstance = new Telemetry();
                    }
                }
            }

            return _mOInstance;
        }

        private Telemetry()
        {

        }

        ~Telemetry()
        {

        }

        public void GetCpuTelemetry()
        {
            List<CpuTemp> cpuTempList = new List<CpuTemp>();
            List<CpuClock> cpuClocksList = new List<CpuClock>();
            List<CpuLoad> cpuLoadsList = new List<CpuLoad>();

            Computer computer = new Computer();
            computer.Open();
            computer.CPUEnabled = true;
            if (computer.Hardware[0].HardwareType == HardwareType.CPU)
            {
                for (int j = 0; j < computer.Hardware[0].Sensors.Length; j++)
                {
                    if (computer.Hardware[0].Sensors[j].SensorType == SensorType.Temperature)
                    {
                        cpuTempList.Add(new CpuTemp(computer.Hardware[0].Sensors[j].Name.ToString(),
                            (int) computer.Hardware[0].Sensors[j].Value));
                    }

                    if (computer.Hardware[0].Sensors[j].SensorType == SensorType.Clock)
                    {
                        cpuClocksList.Add(new CpuClock(computer.Hardware[0].Sensors[j].Name,
                            (float) computer.Hardware[0].Sensors[j].Value));
                    }

                    if (computer.Hardware[0].Sensors[j].SensorType == SensorType.Load)
                    {
                        cpuLoadsList.Add(new CpuLoad(computer.Hardware[0].Sensors[j].Name,
                            (float) computer.Hardware[0].Sensors[j].Value));
                    }
                }
            }

            TelemetryModel test = new TelemetryModel();
            test.CpuTemps = cpuTempList;
            test.CpuClocks = cpuClocksList;
            test.CpuLoads = cpuLoadsList;
            string json = JsonSerializer.Serialize(test);
            Console.WriteLine(json);
            computer.Close();
        }


        public void GetRamTelemetry()
        {
            Computer computer = new Computer();
            
            computer.Open();
            computer.MainboardEnabled = true;
            Console.WriteLine(computer.Hardware[0].GetReport());
        }
    }



}
