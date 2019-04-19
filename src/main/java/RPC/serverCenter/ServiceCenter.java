package RPC.serverCenter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceCenter implements Server{
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static final HashMap<String, Class> serviceRegistry = new HashMap<String, Class>();

    private static boolean isRunning = false;

    private static int port;

    public ServiceCenter(int port){
        this.port = port;
    }



    @Override
    public void stop() {
        isRunning = false;
        executor.shutdown();

    }

    @Override
    public void start() throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(port));
        System.out.println("server start");
        try{

            while(true){
                executor.execute(new ServiceTask(server.accept()));
            }


        }catch(Exception e){

        }finally{
            server.close();
        }

    }

    @Override
    public void register(Class serviceInterface, Class impl) {
        serviceRegistry.put(serviceInterface.getName(), impl);


    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPort() {
        return port;
    }

    public class ServiceTask implements Runnable {

        Socket client;
        public ServiceTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            ObjectInputStream input = null;
            ObjectOutputStream output = null;

            try {
                //2.将客户端发送的码流反序列化成对象，反射调用服务实现者，获取执行结果
                input = new ObjectInputStream(client.getInputStream());
                String servicename  = input.readUTF();
                String methodname = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                Object[] arguments = (Object[]) input.readObject();
                Class serviceClass = serviceRegistry.get(servicename);

                if(serviceClass == null){
                    System.out.println(servicename+" is not found");
                }

                Method method = serviceClass.getMethod(methodname, parameterTypes);
                Object result = method.invoke(serviceClass.newInstance(), arguments);

                //将结果返回
                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                if(output !=null)
                {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(input !=null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(client !=null){
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    }

            }


        }
    }





}
