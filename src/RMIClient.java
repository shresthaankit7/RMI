
import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if( System.getSecurityManager() == null ){
			System.setSecurityManager(new SecurityManager());
		}
		try{
			String name = "Count";
			Registry registry = LocateRegistry.getRegistry(args[0]);
			Count c = (Count) registry.lookup(name);
			int stringLength = c.stringCount("ABCDE");
			System.out.println("LENGTH: " + stringLength);
		}catch(Exception e){
			System.err.println("Error in binding: Client Side");
			e.printStackTrace();
		}
	}

}
