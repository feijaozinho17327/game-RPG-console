import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ChatClient implements Runnable{
    private final String SERVER_ADDRESS = "127.0.0.1";
    private ClientSocket clientSocket;

    private Scanner scan;


    public ChatClient() {
        scan = new Scanner(System.in);




    }
    public void start() throws IOException {


        try {
            clientSocket = new ClientSocket(new Socket(SERVER_ADDRESS, 5000));
            new Thread(this).start();
            messageLoop();
        } finally {
            clientSocket.close();
        }

    }
    @Override
    public void run() {
        String msg;

        while ((msg = clientSocket.getMessage()) != null) {
            System.out.println( clientSocket.getRemoteSocketAddress() + " : " + msg);
        }
    }
    public void messageLoop() throws IOException {
        String msg;

        do {
            System.out.print("Digite uma mensagem: ");
            msg = scan.nextLine();

            if (msg.startsWith("--chat")) {

                String messageToSend = msg.substring(6).trim();
                clientSocket.sendMsg(messageToSend);
            }

            if(msg.startsWith("--start")) {

                int aux;

                System.out.println("escolha a sua classe \n 1- arqueiro \n" +
                        " 2- guerreiro \n 3- mago \n");
                aux = scan.nextInt();


                GameStart gameStart = new GameStart();

                clientSocket.sendMsg(gameStart.chooseClassAndCombat(aux));




            }


        } while (!msg.equals("--sair"));
    }




    public static void main(String[] args) {


        try {
            ChatClient chatClient = new ChatClient();
            chatClient.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar cliente " + e.getMessage());
        }

    }


}
