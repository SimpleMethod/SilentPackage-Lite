using System.Collections.Generic;
using System.Text.Json.Serialization;
using OpenHardwareMonitor.Collections;

namespace SilentPackage_Lite.IO_Readers
{
    
    class DataModel
    {
        public class MemoryRam
        {
            public double TotalPhysicalMemory { get; set; }
            public double TotalAvailableMemory { get; set; }

        }
        public class Drivers
        {
            [JsonPropertyName("Drivers")]
            public Queue<Drive> DriveQueue { get; set; }
        }

        public class CpuTelemetryModel
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
    }
}
