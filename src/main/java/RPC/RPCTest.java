package RPC;

import RPC.client.RPCClient;
import RPC.server.HelloService;
import RPC.server.HelloServiceImpl;
import RPC.serverCenter.Server;
import RPC.serverCenter.ServiceCenter;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RPCTest {


    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }
}
