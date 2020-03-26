using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Net.Http;
using System.Text.Json;

namespace SilentPackage_Lite
{
    class HttpClient
    {
        public string MakeWebRequest(string url, string method, string data)
        {
            WebRequest webRequest;
            webRequest = WebRequest.Create(url);
            webRequest.Method = method;
            webRequest.ContentType = @"application/json; charset=utf-8";
            using (var stream = new StreamWriter(webRequest.GetRequestStream()))
            {
                stream.Write(data);
            }

            try
            {
                using (HttpWebResponse response = webRequest.GetResponse() as HttpWebResponse)
                {
                    Encoding enc = Encoding.GetEncoding("utf-8");
                    StreamReader loResponseStream = new StreamReader(response.GetResponseStream(), enc);
                    string strResult = loResponseStream.ReadToEnd();
                    loResponseStream.Close();
                    response.Close();
                    return strResult;
                }
            }
            catch (System.Net.WebException  e)
            {
                Console.WriteLine(e);
                return e.ToString();
            }
            
        }
    }
}
