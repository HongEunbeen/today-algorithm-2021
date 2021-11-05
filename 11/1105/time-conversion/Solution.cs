using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Result
{
    public static string timeConversion(string s)
    {
        string[] arr = s.Split(':');
        
        if(arr[2].Contains('P')){
            arr[0] = int.Parse(arr[0]) + 12 + "";
            if(arr[0].Equals("24")) arr[0] = "12";
        }
        else{
            if(arr[0].Equals("12")) arr[0] = "00";
        }
        
        return $"{arr[0]}:{arr[1]}:{arr[2].Substring(0,2)}";
    }

}

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string s = Console.ReadLine();

        string result = Result.timeConversion(s);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
