package calculator;
 
import javax.xml.namespace.QName;
 
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
 
/**
 * This program demonstrates consuming a web service by a RCP-based client.
 *
 * @author www.codejava.net
 */
public class CalculatorClient {
    public static void main(String[] args1) throws AxisFault {
 
        RPCServiceClient serviceClient = new RPCServiceClient();
 
        Options options = serviceClient.getOptions();
 
        EndpointReference targetEPR
            = new EndpointReference("http://localhost:8080/axis2/services/CalculatorService");
 
        options.setTo(targetEPR);
 
 
        QName opSum = new QName("http://calculator", "sumar");
 
        Object[] opSumArgs = new Object[] { new Integer(99),  new Integer(28) };
        Class[] returnTypes = new Class[] { Integer.class };
 
 
        Object[] response = serviceClient.invokeBlocking(opSum,
                opSumArgs, returnTypes);
 
        Integer result = (Integer) response[0];
 
        if (result == null) {
            System.out.println("CalculatorService didn't initialize!");
            return;
        }
 
        System.out.println("The Sum is: " + result);
 
    }
}