
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Count extends Remote{
	public int stringCount(String s) throws RemoteException;
}
