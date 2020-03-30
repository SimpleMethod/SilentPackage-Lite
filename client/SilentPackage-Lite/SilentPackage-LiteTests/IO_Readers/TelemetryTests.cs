using SilentPackage_Lite.IO_Readers;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace SilentPackage_LiteTests.IO_Readers.Tests
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
        public void MotherboardSpecificationsTest()
        {
            Telemetry telemetry = Telemetry.GetInstance();
            string temp = telemetry.MotherboardSpecifications();
            Assert.IsNotNull(temp);
        }

        [TestMethod()]
        public void HardDriveTelemetryTest()
        {
            Telemetry telemetry = Telemetry.GetInstance();
            string temp = telemetry.HardDriveTelemetry();
            Assert.IsNotNull(temp);
        }

        [TestMethod()]
        public void RamTelemetryTest()
        {
            Telemetry telemetry = Telemetry.GetInstance();
            string temp = telemetry.RamTelemetry();
            Assert.IsNotNull(temp);
        }

        [TestMethod()]
        public void GetProcessListPsTest()
        {
            Telemetry telemetry = Telemetry.GetInstance();
            string temp = telemetry.GetProcessListPs();
            Assert.IsNotNull(temp);
        }
    }
}