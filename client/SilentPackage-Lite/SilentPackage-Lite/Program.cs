﻿using System;
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

        Console.WriteLine("XD");
        telemetry.GetRamTelemetry();
            for (;;)
           {
           //  telemetry.GetRamTelemetry();
          //   Thread.Sleep(5000);
           }
        }
    }
}
