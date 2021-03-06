﻿using System;
using System.IO;
using System.Net;
using System.Text;

namespace SilentPackage_Lite.Controllers
{
    class HttpClient
    {
        /// <summary>
        /// Creates an HTTP request.
        /// </summary>
        /// <param name="url">Address URL.</param>
        /// <param name="method">HTTP query type.</param>
        /// <param name="data">Data to be sent in RAW form.</param>
        /// <returns>Server response.</returns>
        public string MakeWebRequest(string url, string method, string data)
        {
            if (string.IsNullOrEmpty(data))
            {
                Console.WriteLine("Error");
                return "Error";
            }
            //Console.WriteLine(data + @"\n");
            var webRequest = WebRequest.Create(url);
            webRequest.Method = method;
            webRequest.ContentType = @"application/json; charset=utf-8";
            try
            {
                using (var stream = new StreamWriter(webRequest.GetRequestStream()))
                {
                    stream.Write(data);
                }
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
            catch (WebException  e)
            {
                Console.WriteLine(e);
                return e.ToString();
            }
            
        }
    }
}
