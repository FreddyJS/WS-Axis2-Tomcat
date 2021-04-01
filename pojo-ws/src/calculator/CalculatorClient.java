package calculator;
 
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.xml.namespace.QName;
 
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
 
public class CalculatorClient {
    public static RPCServiceClient serviceClient;
    public static void main(String[] args1) throws AxisFault {
 
        RPCServiceClient serviceClient = new RPCServiceClient();
        CalculatorClient.serviceClient = serviceClient;
 
        Options options = serviceClient.getOptions();
 
        EndpointReference targetEPR
            = new EndpointReference("http://localhost:8080/axis2/services/CalculatorService");
 
        options.setTo(targetEPR);
 
        String option = "n";
        Scanner scan = new Scanner(new InputStreamReader(System.in));

        while(!option.equals("q")) {
            display_options();
            System.out.println("Introduzca una opción: ");

            option = scan.nextLine();

            if (option.equals("s")) {
                System.out.println("Enter s1: ");
    

                int s1 = scan.nextInt();
                System.out.println("Enter s2: ");
    

                int s2 = scan.nextInt();

                sum(s1, s2);
                continue;

            } else if (option.equals("m")) {
                System.out.println("Enter m1: ");
                int m1 = scan.nextInt();

                System.out.println("Enter m2: ");
                int m2 = scan.nextInt();

                mul(m1, m2);
                continue;

            } else if (option.equals("d")) {
                System.out.println("Enter num: ");
                int num = scan.nextInt();

                System.out.println("Enter den: ");
                int den = scan.nextInt();

                div(num, den);
                continue;

            } else if (option.equals("r")) {
                System.out.println("Enter min: ");
                int min = scan.nextInt();
    
                System.out.println("Enter sus: ");
                int sus = scan.nextInt();

                res(min, sus);
                continue;

            }

        }
 
    }

    public static void sum(int s1, int s2) {
        try {
            QName opSum = new QName("http://calculator", "sumar");
 
            Object[] opSumArgs = new Object[] { s1,  s2 };
            Class[] returnTypes = new Class[] { Integer.class };
     
     
            Object[] response = CalculatorClient.serviceClient.invokeBlocking(opSum,
                    opSumArgs, returnTypes);
     
            Integer result = (Integer) response[0];
     
            if (result == null) {
                System.out.println("CalculatorService didn't initialize!");
                return;
            }
     
            System.out.println("The Sum is: " + result);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return;
    }

    public static void mul(int m1, int m2) {
        try {
            QName opSum = new QName("http://calculator", "multiplicar");
 
            Object[] opSumArgs = new Object[] { m1,  m2 };
            Class[] returnTypes = new Class[] { Integer.class };
     
     
            Object[] response = CalculatorClient.serviceClient.invokeBlocking(opSum,
                    opSumArgs, returnTypes);
     
            Integer result = (Integer) response[0];
     
            if (result == null) {
                System.out.println("CalculatorService didn't initialize!");
                return;
            }
     
            System.out.println("The Mul is: " + result);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return;
    }

    public static void div(int num, int den) {
        try {
            QName opSum = new QName("http://calculator", "dividir");
 
            Object[] opSumArgs = new Object[] { num,  den };
            Class[] returnTypes = new Class[] { Float.class };
     
            Object[] response = CalculatorClient.serviceClient.invokeBlocking(opSum,
                    opSumArgs, returnTypes);
     
            Float result = (Float) response[0];
     
            if (result == null) {
                System.out.println("CalculatorService didn't initialize!");
                return;
            }
     
            System.out.println("The Div is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }

    public static void res(int min, int sus) {
        try {
            QName opSum = new QName("http://calculator", "restar");
 
            Object[] opSumArgs = new Object[] { min,  sus };
            Class[] returnTypes = new Class[] { Integer.class };
     
            Object[] response = CalculatorClient.serviceClient.invokeBlocking(opSum,
                    opSumArgs, returnTypes);
     
            Integer result = (Integer) response[0];
     
            if (result == null) {
                System.out.println("CalculatorService didn't initialize!");
                return;
            }
     
            System.out.println("The Res is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }

    public static void display_options() {
        System.out.println("s) Sumar");
        System.out.println("r) Restar");
        System.out.println("m) Multiplicar");
        System.out.println("d) Dividir");
        System.out.println("q) Salir");

    }
}