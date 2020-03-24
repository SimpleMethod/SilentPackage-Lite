using Microsoft.VisualStudio.TestTools.UnitTesting;
using SilentPackage_Lite.IO_Readers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace SilentPackage_Lite.IO_Readers.Tests
{
    [TestClass()]
    public class TelemetryTests
    {
        [TestMethod()]
        public void CpuTelemetryTest()
        {
            Telemetry telemetry = Telemetry.GetInstance();
            string temp = telemetry.CpuTelemetry();
            Assert.IsNotNull(temp);
        }

        [TestMethod()]
        public void GpuTelemetryTest()
        {
            Telemetry telemetry = Telemetry.GetInstance();
            string temp = telemetry.GpuTelemetry();
            Assert.IsNotNull(temp);
        }

        [TestMethod()]
        public void MainboardSpecificationsTest()
        {
            Telemetry telemetry = Telemetry.GetInstance();
            string temp = telemetry.MainboardSpecifications();
            Assert.IsNotNull(temp);
        }

        [TestMethod()]
        public void DriveTelemetryTest()
        {
            Telemetry telemetry = Telemetry.GetInstance();
            string temp = telemetry.DriveTelemetry();
            Assert.IsNotNull(temp);
        }

        [TestMethod()]
        public void RamTelemetryTest()
        {
            Telemetry telemetry = Telemetry.GetInstance();
            string temp = telemetry.RamTelemetry();
            Assert.IsNotNull(temp);
        }

    }
}