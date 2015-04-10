package DataService.PlayerDataService;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import DataService.FileHelper.FileHelper;
import Enum.PlayerData;
import Enum.ResultMessage;
import Enum.Season;
import PO.MatchPO;
import PO.PlayerDataOfOneMatchPO;
import PO.PlayerListPO;
import PO.PlayerPO;
import PO.SeasonListPO;
import PO.StandingDataPO;

public class PlayerController implements PlayerDataService{

	public PlayerListPO players ;
	
	public PlayerController(){
		players= new PlayerListPO();
		read("Data/players/info");
	}
	
	public void read(String fileName){
		File file=new File(fileName);
		if(file.isDirectory()){
			File[] allFiles=file.listFiles();
			for(int i=0;i<allFiles.length;i++){    //����info�ļ�����������ļ�
				ArrayList<String> tempString=FileHelper.readByLine(allFiles[i]);
				PlayerPO newPlayer=new PlayerPO();
				for(int j=0;j<tempString.size();j++){
					if(j%2==0)
						continue;
					String data=FileHelper.analysisOfOneLine(tempString.get(j)).get(1);
					switch(j){
					case 1: newPlayer.setName(data); break;
					case 3: newPlayer.setNumber(data); break;
					case 5: newPlayer.setPosition(data); break;
					case 7: newPlayer.setHeight(data); break;
					case 9: newPlayer.setWeight(data); break;
					case 11: newPlayer.setBirth(data); break;
					case 13: newPlayer.setAge(data);
					        break;
					case 15: 
						     newPlayer.setExp(data); break;
					case 17: newPlayer.setSchool(data); break;
					default: break;
					}
				}
				newPlayer.setPortraitURL("Data/players/portrait/"+newPlayer.getName()+".png");
				newPlayer.setActionURL("Data/players/action/"+newPlayer.getName()+".png");
				if(!new File(newPlayer.getPortraitURL()).exists())  //portrait image not exists
					newPlayer.setPortraitURL("images/nba_logo.png");
				if(!new File(newPlayer.getActionURL()).exists())   //action image not exists
					newPlayer.setActionURL("images/nba_logo.png");
			
				players.addPlayer(newPlayer) ;
			}
		}
	}
	
	
	@Override
	public ResultMessage addPlayer(PlayerPO onePlayer) {
		// TODO Auto-generated method stub
		return players.addPlayer(onePlayer) ;
	}

	@Override
	public ArrayList<PlayerPO> findPlayerByName(String name) {
		// TODO Auto-generated method stub
		return players.findPlayerFaintly(name);
	}

	public ArrayList<PlayerPO> getAllPlayers() {
		return players.getAllPlayers();
	}

	@Override
	public void calculateFinalData() {
		// TODO Auto-generated method stub
		for(PlayerPO onePlayer:players.getAllPlayers()){
			onePlayer.calculateFinalData();
		}
	}

}
