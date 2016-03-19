package SocketServer;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import ObjectStructure.Message;
import ObjectStructure.Player;
import Tool.ST;

public class Server implements Runnable {
	private Center CC;
	private String LogName = "SocketServer";
	
	public Server(Center inputCenter){
		CC=inputCenter;
		ST.showOnScreen(LogName, "Socket server init complete");
	}
	@Override
    public void run(){
    	Thread clientThread=null;
    	ServerSocket Server = null;
    	
    	boolean isServerStart = false;
    	
    	int [] PortList = Option.PortList;
    	
    	for(int i = 0 ; i< PortList.length ; i++){
			try {
				Server = new ServerSocket(PortList[i]);
			} catch (IOException e) {
				ST.showOnScreen(LogName, "Socket server try to start at " + PortList[i] + " port fail");
				continue;
			}
			ST.showOnScreen(LogName, "Socket server start at " + PortList[i] + " port success");
			isServerStart = true;
			break;
    	}
		while(isServerStart){
    		Socket ClientSocket = null;
			try {
				ClientSocket = Server.accept();//
				clientThread=new Thread(new Service(ClientSocket, CC));
				clientThread.start();
			} catch (IOException e) {
				return;
			}
    	}
    }
	public static void main(String[] args) {
		System.out.print("BomberGameBOT Server v1.0.16.0319 beta\n");
		Center ControlCenter= new Center();
		Thread SocketServer=new Thread(new Server(ControlCenter));
		SocketServer.start();
		
//		ST.showOnScreen("TEST", ST.OptionToString(new Option()));
//		
//		Option test1 = new Option();
//		Option test2 = new Option();
//		
//		ST.showOnScreen("TEST", "Test1 = " + test1.InitScore);
//		ST.showOnScreen("TEST", "Test2 = " + test2.InitScore);
//				
//		ST.showOnScreen("TEST", ST.OptionToString(new Option()));
		
//		Player test = new Player();
//		test.setID("testID");
//		test.setPassWord("testPW");
//		
//		String result;
//		ST.showOnScreen("TEST", result = ST.PlayerToString(test));
//		Player test3 = ST.StringToPlayer(result);
//		ST.showOnScreen("TEST", test3.getID());
		
//		String result;
//		ST.showOnScreen("TEST", result = ST.StringToHex("Yo man!!!"));
//		ST.showOnScreen("TEST", ST.HexToString(result));
		
//		ST.showOnScreen("TEST", ST.SHA256("Hi"));
		
//		int ScoreA = 1600, ScoreB = 1600;
//		ERSystem.newScore(ScoreA, ScoreB);
//		ST.showOnScreen("TEST", (ERSystem.newScore(ScoreA, ScoreB) + ""));
		
//		Timer test = new Timer(Option.timeInterval);
//		new Thread(test).start();
		
//		String testResult;
//		Message test = new Message();
//		
//		test.setMsg("Name", "Truth");
//		test.setMsg("Age", "2");
//		
//		ST.showOnScreen("TEST", test.getMsg("Name"));
//		ST.showOnScreen("TEST", test.getMsg("Age"));
//		
//		ST.showOnScreen("TEST", testResult = ST.MessageToString(test));
//		
//		test = ST.StringToMessage(testResult);
//		
//		ST.showOnScreen("TEST", test.getMsg("Name"));
//		ST.showOnScreen("TEST", test.getMsg("Age"));
//		ST.showOnScreen("TEST", test.getMsg("Out") == null ? "True" : "False");
		
	}
}
 