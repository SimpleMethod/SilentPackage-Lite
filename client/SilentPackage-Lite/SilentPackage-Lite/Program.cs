using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using SilentPackage_Lite.IO_Readers;
namespace SilentPackage_Lite
{
    class Program
    {
        static void Main(string[] args)
        {
            Telemetry telemetry = Telemetry.GetInstance();
            Console.WriteLine("CPU:");
            Console.WriteLine(telemetry.CpuTelemetry());
            Console.WriteLine("RAM:");
            Console.WriteLine(telemetry.RamTelemetry());
            Console.WriteLine("GPU:");
            Console.WriteLine(telemetry.GpuTelemetry());
            Console.WriteLine("Mainboard:");
            Console.WriteLine(telemetry.MainboardSpecifications());
            Console.WriteLine("Mainboard:");
            Console.WriteLine(telemetry.DriveTelemetry());
            Console.ReadKey();
        }
        }
    }

