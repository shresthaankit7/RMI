
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer implements Count {

	
	
	/**
	 * @param args
	 */
	public RMIServer(){
		super();
	}
	
	@Override
	public int stringCount(String s) throws RemoteException {
		// TODO Auto-generated method stub
		return 14;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if( System.getSecurityManager() == null ){
			System.setSecurityManager(new SecurityManager());
		}
		try{
			String name = "Count";
			Count svr = new RMIServer();
			Count stub = (Count) UnicastRemoteObject.exportObject(svr,0);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind(name, stub);
			System.out.println("Count engine bound");
		}catch(Exception e){
			System.err.println("Error in binding: Server Side");
			e.printStackTrace();
		}
	}

	

}
