using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace BMICalcREST
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService1" in both code and config file together.
    [ServiceContract]
    public interface IBMICalc
    {
        [OperationContract]
        [WebGet(UriTemplate = "/myBMI?height={height}&weight={weight}")]
        double myBMI(int height, int weight);

        [OperationContract]
        [WebInvoke(Method = "GET", ResponseFormat = WebMessageFormat.Json, UriTemplate = "/myHealth?height={height}&weight={weight}")]
        bmi myHealth(int height, int weight);
    }
}

public class bmi
{
    [DataMember]
    public double BMI { get; set; }

    [DataMember]
    public string Risk { get; set; }

    [DataMember]
    public string[] More { get; set; }

}