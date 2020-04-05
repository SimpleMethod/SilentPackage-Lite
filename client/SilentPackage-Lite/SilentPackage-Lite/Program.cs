using System;
using System.Diagnostics;
using System.IO;
using System.Reflection;
using System.Runtime.InteropServices;
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
            // ShowWindow(getConsoleWindow, SW_HIDE);
            try
            {
               
                Process process = new Process();
                process.StartInfo.UseShellExecute = false;
                process.StartInfo.FileName = "java";
                process.StartInfo.Arguments = "-jar \u0022" + @Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location) + @"\silentpackage.jar" + "\u0022";
                process.Start();
            }
            catch (UnauthorizedAccessException e)
            {
                Console.WriteLine(e);
            }
            ThreadHandle handle = ThreadHandle.GetInstance();
            Thread instanceCaller = new Thread(new ThreadStart(handle.MainThread));
            instanceCaller.Start();
            
        }
    }
}

