package server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankingServer extends UnicastRemoteObject implements IBankingServer{

	private static final long serialVersionUID = 63532626551643254L;

	public BankingServer() throws RemoteException{
		super();
	}

	public boolean pay(String bankAccount, double amount)	throws RemoteException {
		
		System.out.println("$Banking$ Account #" + bankAccount + " pays: " + amount + "€") ;

		return true;
	}
	
	public static void main(String[] args){
		
		if(args.length !=3){
			System.out.println("$ ERR incorrect args");
			System.exit(0);
		}
		
		if(System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		
		String name= "//" + args[0] +  ":" + args[1] + "/" +args[2];
		
		try{
			IBankingServer server= new BankingServer();
			Naming.rebind(name, server);
			System.out.println("$ Server '" + name + "'active and waiting");
		}catch(Exception e){
			System.err.print("$ Exception running server: " + e.getMessage());
			e.printStackTrace();
		}
	}


}
