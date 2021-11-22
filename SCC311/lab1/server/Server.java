package lab1.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements ICalc{
    public Server() {
        super();
    }
  
    int sum = 1;
    public int factorial(int n) {
    System.out.println("client request handled");
    for(int i=1;i<(n+1);i++){
        sum = sum*i;
    }
    return sum;
    }
  
    /*public static void main(String[] args) {
     Server s = new Server();
     
     int result = s.factorial(7);
     
     System.out.println("result is " + result);
     }*/
     public static void main(String[] args) {
        try {
         Server s = new Server();
         String name = "myserver";
         ICalc stub = (ICalc) UnicastRemoteObject.exportObject(s, 0);
         Registry registry = LocateRegistry.getRegistry();
         registry.rebind(name, stub);
         System.out.println("Server ready");
        } catch (Exception e) {
         System.err.println("Exception:");
         e.printStackTrace();
        }
      }
  }