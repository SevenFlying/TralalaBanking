package server;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IBankingServer extends Remote{
	
	boolean pay(String bankAccount, double amount) throws RemoteException;
}
