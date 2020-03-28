using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using SilentPackage_Lite.IO_Readers;
namespace SilentPackage_Lite
{
    class Program
    {
        [DllImport("kernel32.dll")]
        static extern IntPtr GetConsoleWindow();

        [DllImport("user32.dll")]
        static extern bool ShowWindow(IntPtr hWnd, int nCmdShow);

        const int SW_HIDE = 0;
        const int SW_SHOW = 5;
        static void Main(string[] args)
        {
            var getConsoleWindow = GetConsoleWindow();
            ShowWindow(getConsoleWindow, SW_HIDE);
            Process process = new Process();
            process.StartInfo.UseShellExecute = false;
            process.StartInfo.FileName = "java";
            var curDir = Directory.GetCurrentDirectory();
            process.StartInfo.Arguments = "-jar " + curDir+ @"\silentpackage.jar";
            process.Start();
            ThreadHandle handle = ThreadHandle.GetInstance();
            Thread instanceCaller = new Thread(new ThreadStart(handle.MainThread));
            instanceCaller.Start();
        }
        }
    }

