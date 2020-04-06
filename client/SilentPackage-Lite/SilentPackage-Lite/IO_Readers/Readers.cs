using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices;
using OpenHardwareMonitor.Hardware;
using OpenHardwareMonitor.Collections;
using System.Text.Json;
using System.Management.Automation;
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
        /// Getting processor telemetry, temperature, clocking and processor load.
        /// </summary>
        /// <returns>Returned telemetry in JSON format.</returns>
        public string CpuTelemetry()
        {
            try
            {
                List<DataModel.CpuTemp> cpuTempList = new List<DataModel.CpuTemp>();
                List<DataModel.CpuClock> cpuClocksList = new List<DataModel.CpuClock>();
                List<DataModel.CpuLoad> cpuLoadsList = new List<DataModel.CpuLoad>();

                Computer computer = new Computer();
                computer.Open();
                computer.CPUEnabled = true;
                try
                {
                    if (computer.Hardware[0].HardwareType == HardwareType.CPU)
                    {
                        for (int j = 0; j < computer.Hardware[0].Sensors.Length; j++)
                        {
                            if (computer.Hardware[0].Sensors[j].SensorType == SensorType.Temperature)
                            {
                                if (computer.Hardware[0].Sensors[j].Value != null)
                                {
                                    cpuTempList.Add(new DataModel.CpuTemp(computer.Hardware[0].Sensors[j].Name.ToString(),
                                        (int)computer.Hardware[0].Sensors[j].Value));
                                }
                            
                            }

                            if (computer.Hardware[0].Sensors[j].SensorType == SensorType.Clock)
                            {
                                if (computer.Hardware[0].Sensors[j].Value != null)
                                {
                                    cpuClocksList.Add(new DataModel.CpuClock(computer.Hardware[0].Sensors[j].Name.ToString(),
                                        (int)computer.Hardware[0].Sensors[j].Value));
                                }
                            }

                            if (computer.Hardware[0].Sensors[j].SensorType == SensorType.Load)
                            {
                                if (computer.Hardware[0].Sensors[j].Value != null)
                                {
                                    cpuLoadsList.Add(new DataModel.CpuLoad(computer.Hardware[0].Sensors[j].Name.ToString(),
                                        (int)computer.Hardware[0].Sensors[j].Value));
                                }
                            }
                        }
                    }
                }
                catch (Exception e)
                {
                    Console.WriteLine(e);
                    return null;
                }
                computer.Close();
                DataModel.CpuTelemetryModel cpuTelemetry = new DataModel.CpuTelemetryModel();
                cpuTelemetry.CpuTemps = cpuTempList;
                cpuTelemetry.CpuClocks = cpuClocksList;
                cpuTelemetry.CpuLoads = cpuLoadsList;
                return JsonSerializer.Serialize(cpuTelemetry);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return null;
            }
            
        }

        /// <summary>
        /// Getting telemetry of the Nvidia video card.
        /// </summary>
        /// <returns>Returned telemetry in JSON format.</returns>
        public string GpuTelemetry()
        {
            try
            {
                Computer computer = new Computer();
                computer.Open();
                computer.GPUEnabled = true;
                var temp = computer.Hardware[0].GetReport();
                computer.Close();
                return temp;
            }
            catch (IndexOutOfRangeException e)
            {
                Console.WriteLine(e);
                return null;
            }
        }

        /// <summary>
        /// Getting motherboard and CPU specifications.
        /// </summary>
        /// <returns>Returned specifications in JSON format.</returns>
        public string MotherboardSpecifications()
        {
            try
            {
                Computer computer = new Computer();
                computer.Open();
                computer.MainboardEnabled = true;
                var temp = computer.Hardware[0].GetReport();;
                computer.Close();
                return temp;
            }
            catch (IndexOutOfRangeException e)
            {
                Console.WriteLine(e);
                return null;
            }
        }
        /// <summary>
        ///  Getting telemetry of hard drive.
        /// </summary>
        /// <returns>Returned telemetry in JSON format.</returns>
        public string HardDriveTelemetry()
        {
            try
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
            catch (IndexOutOfRangeException e)
            {
                Console.WriteLine(e);
                return null;
            }

        }
        [DllImport("kernel32.dll")]
        public static extern bool GetPhysicallyInstalledSystemMemory(out long totalMemoryInKilobytes);
        /// <summary>
        ///  Getting telemetry of RAM memory.
        /// </summary>
        /// <returns>Returned telemetry in JSON format.</returns>
        public string RamTelemetry()
        {
            try
            {
                DataModel.MemoryRam memoryRam = new DataModel.MemoryRam();
                GetPhysicallyInstalledSystemMemory(out var phymemory);
                var performance = new PerformanceCounter("Memory", "Available KBytes");
                memoryRam.TotalPhysicalMemory = phymemory / 1024.00 / 1024.00;
                memoryRam.TotalAvailableMemory = performance.RawValue / 1024.00;
                return JsonSerializer.Serialize(memoryRam);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return null;
            }
        }


        /// <summary>
        ///  Getting process lists.
        /// </summary>
        /// <returns>Returned telemetry in JSON format.</returns>
        //  [ObsoleteAttribute("This method has been deprecated. Use GetProcessListPs instead.", true)]
        public string GetProcessList()
        {
            try
            {
                List<DataModel.ProcessList> processLists= new List<DataModel.ProcessList>();
                DataModel.ProcessListModel processListModel = new DataModel.ProcessListModel();
                foreach (var preprocess in Process.GetProcesses())
                {
                    try
                    {
                        string processName = preprocess.ProcessName;
                        int processId = preprocess.Id;
                        string startTime = "";
                        try
                        {
                            startTime = preprocess.StartTime.ToString();
                        }
                        catch (Win32Exception)
                        {
                        }
                        processLists.Add(new DataModel.ProcessList(processName, processId, startTime));
                    }
                    catch (ArgumentOutOfRangeException e)
                    {
                        Console.WriteLine(e);
                        return null;
                    }
                    catch (Win32Exception e)
                    {
                        Console.WriteLine(e);
                        return null;
                    }
                }

                processListModel.ProcessLists = processLists;
                return JsonSerializer.Serialize(processListModel);
            }
            catch (Win32Exception e)
            {
                Console.WriteLine(e);
                return null;
            }
        }

        /// <summary>
        ///  Getting process lists.
        /// </summary>
        /// <returns>Returned telemetry in JSON format.</returns>
        public string GetProcessListPs()
        {
            List<DataModel.ProcessList> processLists = new List<DataModel.ProcessList>();
            DataModel.ProcessListModel processListModel = new DataModel.ProcessListModel();
            using (PowerShell ps = PowerShell.Create())
            {
                ps.AddScript("ps");
                Collection<PSObject> results = ps.Invoke();
                foreach (PSObject result in results)
                {
                    object baseObj = result.BaseObject;
                    if (baseObj is Process)
                    {

                        Process preprocess = baseObj as Process;
                        try
                        {
                            string processName = preprocess.ProcessName;
                            int processId = preprocess.Id;
                            string startTime = "";
                            try
                            {
                                startTime = preprocess.StartTime.ToString();
                            }
                            catch (Win32Exception)
                            {
                            }
                            processLists.Add(new DataModel.ProcessList(processName, processId, startTime));
                        }
                        catch (ArgumentOutOfRangeException e)
                        {
                            Console.WriteLine(e);
                            return null;
                        }
                        catch (InvalidOperationException e)
                        {
                            Console.WriteLine(e);
                            return null;
                        }

                    }

                }
                processListModel.ProcessLists = processLists;
                return JsonSerializer.Serialize(processListModel);
            }
        }
    }



}
