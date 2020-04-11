using System;
using System.Threading;

namespace SilentPackage_Lite.Controllers
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
                client.MakeWebRequest(url + "motherboard", "POST", telemetry.MotherboardSpecifications());
                client.MakeWebRequest(url + "harddrive", "POST", telemetry.HardDriveTelemetry());
                client.MakeWebRequest(url + "processlist", "POST", telemetry.GetProcessListPs());
                Thread.Sleep(1000);
            }

        }
    }
}
