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
    public static void plusMinus(List<int> arr)
    {
        int positive =0 ,negative=0, zero = 0;
        arr.ForEach(item => {
            if(item == 0) zero++;
            else if(item > 0) positive++;
            else negative++;
        });
        
        //positive
        Console.WriteLine(string.Format("{0:0.000000#}",((decimal) positive/arr.Count)));
        //negative
        Console.WriteLine(string.Format("{0:0.000000#}",((decimal) negative/arr.Count)));
        //zero
        Console.WriteLine(string.Format("{0:0.000000#}",((decimal) zero/arr.Count)));
        
    }

}

class Solution
{
    public static void Main(string[] args)
    {
        int n = Convert.ToInt32(Console.ReadLine().Trim());

        List<int> arr = Console.ReadLine().TrimEnd().Split(' ').ToList().Select(arrTemp => Convert.ToInt32(arrTemp)).ToList();

        Result.plusMinus(arr);
    }
}
