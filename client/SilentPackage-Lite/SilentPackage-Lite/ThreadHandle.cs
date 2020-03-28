using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using OpenHardwareMonitor.Collections;
using SilentPackage_Lite.IO_Readers;

namespace SilentPackage_Lite
{
    class ThreadHandle
    {
        private static ThreadHandle _mOInstance = null;
        private static readonly Object Mutex = new object();

        public static ThreadHandle GetInstance()
        {
            if (_mOInstance == null)
            {
                lock (Mutex)
                {
                    if (_mOInstance == null)
                    {
                        _mOInstance = new ThreadHandle();
                    }
                }
            }

            return _mOInstance;
        }
        private ThreadHandle()
        {

        }

        ~ThreadHandle()
        {

        }
        /// <summary>
        /// Method for thread handling.
        /// </summary>
        public void MainThread()
        {
            HttpClient client = new HttpClient();
            Telemetry telemetry = Telemetry.GetInstance();
            string url = Properties.Resources.URL + "/" + Properties.Resources.ApiVersion + "/";
            for (;;)
            {
                client.MakeWebRequest(url+"cpu", "POST", telemetry.CpuTelemetry());
                client.MakeWebRequest(url + "ram", "POST", telemetry.RamTelemetry());
                client.MakeWebRequest(url + "gpu", "POST", telemetry.GpuTelemetry());
                client.MakeWebRequest(url + "motherboard", "POST", telemetry.MainboardSpecifications());
                client.MakeWebRequest(url + "harddrive", "POST", telemetry.DriveTelemetry());
                client.MakeWebRequest(url + "processlist", "POST", telemetry.GetProcessList());
                Thread.Sleep(1000);
            }

        }
    }
}
