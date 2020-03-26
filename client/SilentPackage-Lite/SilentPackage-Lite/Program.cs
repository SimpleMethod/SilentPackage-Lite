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
            HttpClient client = new HttpClient();
            Telemetry telemetry = Telemetry.GetInstance();
            Console.WriteLine("CPU:");
            client.MakeWebRequest(@"http://127.0.0.1:2137/1.0/cpu", "POST", telemetry.CpuTelemetry());
            Console.WriteLine("RAM:");
            client.MakeWebRequest(@"http://127.0.0.1:2137/1.0/cpu", "POST", telemetry.RamTelemetry());
            Console.WriteLine("GPU:");
            client.MakeWebRequest(@"http://127.0.0.1:2137/1.0/gpu", "POST", telemetry.GpuTelemetry());
            Console.WriteLine("Mainboard:");
            client.MakeWebRequest(@"http://127.0.0.1:2137/1.0/motherboard", "POST", telemetry.MainboardSpecifications());
            Console.WriteLine("Mainboard:");
            client.MakeWebRequest(@"http://127.0.0.1:2137/1.0/hardDrive", "POST", telemetry.DriveTelemetry());
            Console.ReadKey();
        }
        }
    }

