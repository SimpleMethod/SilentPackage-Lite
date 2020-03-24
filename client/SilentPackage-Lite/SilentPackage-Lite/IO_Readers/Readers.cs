using System;
using System.Collections.Generic;
using System.Runtime.InteropServices;
using OpenHardwareMonitor.Hardware;
using OpenHardwareMonitor.Collections;
using System.Text.Json;


namespace SilentPackage_Lite.IO_Readers
{
    /// <summary>
    /// A class used to get telemetry.
    /// </summary>
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

        /// <summary>
        /// Getting processor telemetry, temeprature, clocking and processor load.
        /// </summary>
        /// <returns>Returned telemetry in JSON format.</returns>
        public string CpuTelemetry()
        {
            List<DataModel.CpuTemp> cpuTempList = new List<DataModel.CpuTemp>();
            List<DataModel.CpuClock> cpuClocksList = new List<DataModel.CpuClock>();
            List<DataModel.CpuLoad> cpuLoadsList = new List<DataModel.CpuLoad>();

            Computer computer = new Computer();
            computer.Open();
            computer.CPUEnabled = true;
            if (computer.Hardware[0].HardwareType == HardwareType.CPU)
            {
                for (int j = 0; j < computer.Hardware[0].Sensors.Length; j++)
                {
                    if (computer.Hardware[0].Sensors[j].SensorType == SensorType.Temperature)
                    {
                        cpuTempList.Add(new DataModel.CpuTemp(computer.Hardware[0].Sensors[j].Name.ToString(),
                            (int)computer.Hardware[0].Sensors[j].Value));
                    }

                    if (computer.Hardware[0].Sensors[j].SensorType == SensorType.Clock)
                    {
                        cpuClocksList.Add(new DataModel.CpuClock(computer.Hardware[0].Sensors[j].Name,
                            (float)computer.Hardware[0].Sensors[j].Value));
                    }

                    if (computer.Hardware[0].Sensors[j].SensorType == SensorType.Load)
                    {
                        cpuLoadsList.Add(new DataModel.CpuLoad(computer.Hardware[0].Sensors[j].Name,
                            (float)computer.Hardware[0].Sensors[j].Value));
                    }
                }
            }
            computer.Close();
            DataModel.CpuTelemetryModel cpuTelemetry = new DataModel.CpuTelemetryModel();
            cpuTelemetry.CpuTemps = cpuTempList;
            cpuTelemetry.CpuClocks = cpuClocksList;
            cpuTelemetry.CpuLoads = cpuLoadsList;
            return JsonSerializer.Serialize(cpuTelemetry);
            
        }

        /// <summary>
        /// Getting telemetry of the Nvidia video card.
        /// </summary>
        /// <returns>Returned telemetry in JSON format.</returns>
        public string GpuTelemetry()
        {
            Computer computer = new Computer();
            computer.Open();
            computer.GPUEnabled = true;
            var temp = computer.Hardware[0].GetReport();
            computer.Close();
            return temp;
        }

        /// <summary>
        /// Getting motherboard and CPU specifications.
        /// </summary>
        /// <returns>Returned specifications in JSON format.</returns>
        public string MainboardSpecifications()
        {
            Computer computer = new Computer();
            computer.Open();
            computer.MainboardEnabled = true;
            var temp = computer.Hardware[0].GetReport();;
            computer.Close();
            return temp;
        }
        /// <summary>
        ///  Getting telemetry of hard drive.
        /// </summary>
        /// <returns>Returned telemetry in JSON format.</returns>
        public string DriveTelemetry()
        {
            DataModel.Drivers drivers = new DataModel.Drivers();
            Queue<Drive> queue = new Queue<Drive>();
            Computer computer = new Computer();
            computer.Open();
            computer.HDDEnabled = true;
            for (int j = 0; j < computer.Hardware.Length; j++)
            {
                if (computer.Hardware[j].HardwareType == HardwareType.HDD)
                {
                    var drive = JsonSerializer.Deserialize<Drive>(computer.Hardware[j].GetReport());
                    queue.Enqueue(drive);
                }
            }
            computer.Close();
            drivers.DriveQueue = queue;
            return JsonSerializer.Serialize(drivers);
        }
        [DllImport("kernel32.dll")]
        public static extern bool GetPhysicallyInstalledSystemMemory(out long totalMemoryInKilobytes);
        /// <summary>
        ///  Getting telemetry of RAM memory.
        /// </summary>
        /// <returns>Returned telemetry in JSON format.</returns>
        public string RamTelemetry()
        {
            DataModel.MemoryRam memoryRam = new DataModel.MemoryRam();
            GetPhysicallyInstalledSystemMemory(out var phymemory);
            var performance = new System.Diagnostics.PerformanceCounter("Memory", "Available KBytes");
            memoryRam.TotalPhysicalMemory = phymemory / 1024.00 / 1024.00;
            memoryRam.TotalAvailableMemory = performance.RawValue / 1024.00;
            return JsonSerializer.Serialize(memoryRam);
        }
    }



}
