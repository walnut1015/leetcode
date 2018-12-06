package Other.rmitests;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author tanya
 * @date 2018/9/11 21:15
 */
public interface MyRemote extends Remote{
    public String sendMsg(String msg)throws RemoteException;

}
