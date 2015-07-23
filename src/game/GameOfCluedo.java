package game;

import game.cards.*;
import game.cards.person.*;
import game.cards.item.*;


import java.util.ArrayList;
import java.util.Collections;

public class GameOfCluedo {
	
	private int numPlayers;
	protected ArrayList<Player> players = new ArrayList<Player>();
	
	private ArrayList<ItemCard> itemCards = new ArrayList<ItemCard>();
	private ArrayList<RoomCard> roomCards = new ArrayList<RoomCard>();
	private ArrayList<PersonCard> personCards = new ArrayList<PersonCard>();
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<Card> envelop = new ArrayList<Card>();
	
	protected Board board;
	
	public GameOfCluedo (int numPlayers){
		this.board = new Board();
		initCards();
		
		this.numPlayers = numPlayers;
		for(int i = 0; i < numPlayers || i < 4; i++){
			addPlayer();
		}
		
		dealCards();
		
	}
	
	private void dealCards() {
		Collections.shuffle(this.deck);
		for(int pos = 0; !this.deck.isEmpty(); pos++){
			if(pos >= numPlayers) pos = 0;
			this.players.get(pos).giveCard(this.deck.remove(0));
		}
	}

	private void initCards() {
		this.personCards.add(new MissScarlett());
		this.personCards.add(new ColonelMustard());
		this.personCards.add(new MrsWhite());
		this.personCards.add(new ReverandGreen());
		this.personCards.add(new MrsPeacock());
		this.personCards.add(new ProfessorPlum());
		
		this.itemCards.add(new LeadPipe());
		this.itemCards.add(new Spanner());
		this.itemCards.add(new Revolver());
		this.itemCards.add(new Rope());
		this.itemCards.add(new CandleStick());
		this.itemCards.add(new Dagger());
	}

	private void addPlayer(){
		PersonCard identity = getRandomPersonCard();
		this.players.add(new Player(identity));
		this.personCards.remove(identity);
	}

	
	
	private PersonCard getRandomPersonCard() {
		Collections.shuffle(this.personCards);
		return this.personCards.get(0);
	}
	
	private ItemCard getRandomItemCard() {
		Collections.shuffle(this.itemCards);
		return this.itemCards.get(0);
	}
	
	private RoomCard getRandomRoomCard() {
		Collections.shuffle(this.roomCards);
		return this.roomCards.get(0);
	}
}
