package com.example.j2eeapp.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.engine.spi.RowSelection;
import org.primefaces.component.autocomplete.AutoComplete;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.BeanUtils;

import com.example.j2eeapp.dao.DegreeDao;
import com.example.j2eeapp.dao.JudgeDao;
import com.example.j2eeapp.dao.PlayerDao;
import com.example.j2eeapp.dao.TournamentTypeDao;
import com.example.j2eeapp.domain.JudgeEntity;
import com.example.j2eeapp.domain.PlayerEntity;
import com.example.j2eeapp.domain.PlayerTournamentEntity;
import com.example.j2eeapp.domain.TDegreeEntity;

import com.example.j2eeapp.domain.TTournamentTypeEntity;
import com.example.j2eeapp.domain.TournamentEntity;
import com.example.j2eeapp.services.GeneralTypeService;
import com.example.j2eeapp.services.JudgeService;
import com.example.j2eeapp.services.TournamentTypeService;
import com.example.j2eeapp.utils.CommonUtils;
import com.example.j2eeapp.utils.UnitOfWork;



/**
 * Service providing judge methods to work with data and entity.
 * @author ilia
 *
 */
public class JudgeServiceImpl  implements JudgeService{
	private JudgeDao judgeDao;
	private TournamentTypeDao tournamentTypeDao;
	private DegreeDao degreeDao;
	private PlayerDao playerDao;
	
	private UnitOfWork unitOfWork;
	private TournamentTypeService tournamentTypeService = null;
	private GeneralTypeService generalTypeService = null;
	
	private List<TTournamentTypeEntity> selectItems;
	private List<TDegreeEntity> allDegrees;
	private List<String>tournamentTypeDescriptions;
	private List<String>degreeDescriptions;
	private PlayerEntity player;
	private TournamentEntity tournament;
	private PlayerTournamentEntity selectedPlayerTournament;
	
	public List<TTournamentTypeEntity> getSelectItems() {
		return selectItems;
	}
	public void setSelectItems(List<TTournamentTypeEntity> items) {
		this.selectItems = items;
	}
	
	public List<TDegreeEntity> getAllDegrees() {
		return allDegrees;
	}
	
	public void setAllDegrees(List<TDegreeEntity> degrees) {
		this.allDegrees = degrees;
	}

	public TournamentTypeService getTournamentTypeService() {
    	if (tournamentTypeService == null) {
    		tournamentTypeService = new TournamentTypeServiceImpl();
    	}
    	return tournamentTypeService;
    }
	
	private GeneralTypeService getGeneralTypeService() {
		if (generalTypeService == null) {
			generalTypeService = new GeneralTypeServiceImpl();
		}
		return generalTypeService;
	}

	public void setTournamentTypeDao(TournamentTypeDao tournamentTypeDao) {
		this.tournamentTypeDao = tournamentTypeDao;
	}

	public TournamentTypeDao getTournamentTypeDao() {
		return tournamentTypeDao;
	}
	
	public DegreeDao getDegreeDao() {
		return degreeDao;
	}
	public void setDegreeDao(DegreeDao degreeDao) {
		this.degreeDao = degreeDao;
	}
	public JudgeDao getJudgeDao() {
		return judgeDao;
	}
	
	public void setJudgeDao(JudgeDao judgeDao) {
		this.judgeDao = judgeDao;
	}
	
	public PlayerDao getPlayerDao() {
		return playerDao;
	}
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	public void setUnitOfWork(UnitOfWork unitOfWork) {
		this.unitOfWork = unitOfWork;
	}

	public UnitOfWork getUnitOfWork() {
		return unitOfWork;
	}
	
	public boolean createJudge(JudgeEntity judgeEntity) {
		judgeDao.save(judgeEntity);
		return true;
	}
	
	public boolean createTournament(TournamentEntity tournamnetEntity, JudgeEntity judgeEntity) {
		JudgeEntity existingJudge = judgeDao.loadJudgeByJudgeName(judgeEntity.getName());
		
		if (existingJudge != null) {
			existingJudge.getTournaments().add(tournamnetEntity);
			judgeDao.update(existingJudge);
		} else {
			judgeEntity.getTournaments().add(tournamnetEntity);
			judgeDao.save(judgeEntity);
		}
		return true;
	}
	
	public void initLists(UnitOfWork unitOfWork, TournamentEntity tournament) {
		//tournament.setTournamentName("vasilisa");
		unitOfWork = new UnitOfWork();
		
		//List<TDegreeEntity> DegreeList = degreeDao.findAll();
		//unitOfWork.setAttribute("type", tournamentTypeList);
		List<String> tournamentTypeDescriptions = getGeneralTypeService().getDescriptionList(tournamentTypeDao);
		//List<String> degreeDescriptions = getGeneralTypeService().getDescriptionList(degreeDao);
		//unitOfWork.setAttribute("desc", descriptions);
		//unitOfWork.setTournamentType(tournamentTypeList); 
		
		// Select items type dao
		List<TTournamentTypeEntity> tournamentTypeList = tournamentTypeDao.findAll();
		List<TDegreeEntity> degreeList = degreeDao.findAll();
		setSelectItems(tournamentTypeList);
		setAllDegrees(degreeList);
		setTournamentTypeDescriptions(tournamentTypeDescriptions);
		setDegreeDescriptions(degreeDescriptions);
	}
	
	public List<String> complete(String prefix) {
		List<String> results = new ArrayList<String>();
		List<PlayerEntity> players = playerDao.findAll();
		if (players != null) {
			for (PlayerEntity player : players) {
				String playerName = player.getPlayerName();
				String lastName = player.getPlayerLastName();
				if(playerName != null && lastName != null) {
					if (playerName.concat(lastName).toLowerCase().startsWith(prefix.toLowerCase()) ||
						lastName.concat(playerName).toLowerCase().startsWith(prefix.toLowerCase())	) {
						results.add(playerName + " " + lastName);
					}
	            }
			}
		}
		return results;
	}
	
	public List<PlayerEntity> completePlayer(String prefix) {
        List<PlayerEntity> allPlayers = playerDao.findAll();
        List<PlayerEntity> filteredPlayers = new ArrayList<PlayerEntity>();
        if (allPlayers != null) { 
	        for (PlayerEntity player : allPlayers) {
	        	String playerName = player.getPlayerName();
				String lastName = player.getPlayerLastName();
				if(playerName != null && lastName != null) {
					if (playerName.concat(" ").concat(lastName).toLowerCase().startsWith(prefix.toLowerCase()) ||
						lastName.concat(" ").concat(playerName).toLowerCase().startsWith(prefix.toLowerCase())	) {
						filteredPlayers.add(player);
					}
	            }
	        }
        }
        return filteredPlayers;
    }
	
	public void handleChange(SelectEvent event) {
		AutoComplete inputText = (AutoComplete) event.getSource();
		PlayerEntity playerobj = (PlayerEntity) event.getObject();
		PlayerEntity player = (PlayerEntity) inputText.getValue();
		player.setPlayerRating(1000L);
		playerobj.setPlayerRating(1001L);
		BeanUtils.copyProperties(playerobj,player);
		/*String value = (String) inputText.getValue();
		Long id = Long.valueOf(value);
		if (id != null) {
			PlayerEntity playerEntity = playerDao.findById(id);
			FacesContext context = FacesContext.getCurrentInstance();
			PlayerEntity currentPlayer = (PlayerEntity)CommonUtils.getBean("player", context);
			currentPlayer.setPlayerName("vasilisovich");
			currentPlayer.setPlayerDegree(playerEntity.getPlayerDegree());
			currentPlayer.setPlayerRating(1454L);
			BeanUtils.copyProperties(playerEntity,currentPlayer);
			currentPlayer.getPlayerRating();
		}*/
		//String playerName = value.getPlayerName();
		// playerLastName = value.getPlayerLastName();
		
	}
	
	//action listener event
	public void attrListener(ActionEvent event){
	 
		player = (PlayerEntity)event.getComponent().getAttributes().get("player");
		tournament = (TournamentEntity)event.getComponent().getAttributes().get("tournament");
	 
	}
	
	public void addPlayerTournament() {
		PlayerTournamentEntity playerTournamentEntity = new PlayerTournamentEntity();
		PlayerEntity newPlayer = new PlayerEntity();
		BeanUtils.copyProperties(player,newPlayer);
		playerTournamentEntity.setPlayerEntity(newPlayer);
		tournament.getPlayerTournaments().add(playerTournamentEntity);
		tournament.setTournamentName(tournament.getTournamentName());
		setSelectedPlayerTournament(playerTournamentEntity);
	}
	
	public void deletePlayerTournament() {
		if(selectedPlayerTournament != null){
			tournament.getPlayerTournaments().remove(selectedPlayerTournament);
			selectedPlayerTournament = null;
		}
		
	}
	
 
	
	private void setDegreeDescriptions(List<String> degreeDescriptions) {
		this.degreeDescriptions = degreeDescriptions;
	}
	
	public List<String> getDegreeDescriptions() {
		return degreeDescriptions;
	}
	
	public void setTournamentTypeDescriptions(
			List<String> tournamentTypeDescriptions) {
		this.tournamentTypeDescriptions = tournamentTypeDescriptions;
	}
	public List<String> getTournamentTypeDescriptions() {
		return tournamentTypeDescriptions;
	}
	public PlayerEntity getPlayer() {
		return player;
	}
	public void setPlayer(PlayerEntity player) {
		this.player = player;
	}
	public TournamentEntity getTournament() {
		return tournament;
	}
	public void setTournament(TournamentEntity tournament) {
		this.tournament = tournament;
	}
	public PlayerTournamentEntity getSelectedPlayerTournament() {
		return selectedPlayerTournament;
	}
	public void setSelectedPlayerTournament(
			PlayerTournamentEntity selectedPlayerTournament) {
		this.selectedPlayerTournament = selectedPlayerTournament;
	}
	
	
}
