package Client;


import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

import HelloWorldApp.*;

public class ClientMain {
    static Hello hello;
    
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = 
            		NamingContextExtHelper.narrow(objRef);
            String name = "Hello";
             hello = HelloHelper.narrow(ncRef.resolve_str(name));
            System.out.println("Obtained a handle on server object: " + hello);
            System.out.println("Message from server: " + hello.HelloMessage());
            
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}