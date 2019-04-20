package Tris;

import java.util.Arrays;

public class Tris {

	public Sign[][] tris;
	public Player player1;
	public Player player2;
	public int turn = 0;

	public Tris(String name1, String name2, Sign sign1, Sign sign2) {
		tris = new Sign[3][3];
		player1 = new Player(name1, sign1);
		player2 = new Player(name2, sign2);
	}
	
	public String startGame(){
		if(Math.random()*2+1 == 1) {
			this.player1.completedTurn = false;
			return "Inizia " + this.player1.name;
		}
		else {
			this.player2.completedTurn = false;
			return "Inizia " + this.player2.name;
		}
	}
	
	public String set(int x, int y, Character sign){
		if(this.tris[x][y]==null){
			String  victory="";
			this.tris[x][y] = new Sign(sign);
			this.turn++;
			if(((tris[0][0]!=null && tris[0][0].typeSign.equals(sign)) && (tris[0][1]!=null && tris[0][1].typeSign.equals(sign)) && (tris[0][2]!=null && tris[0][2].typeSign.equals(sign)))||
				((tris[1][0]!=null && tris[1][0].typeSign.equals(sign)) && (tris[1][1]!=null && tris[1][1].typeSign.equals(sign)) && (tris[1][2]!=null && tris[1][2].typeSign.equals(sign)))||
				((tris[2][0]!=null && tris[2][0].typeSign.equals(sign)) && (tris[2][1]!=null && tris[2][1].typeSign.equals(sign)) && (tris[2][2]!=null && tris[2][2].typeSign.equals(sign)))||
				((tris[0][0]!=null && tris[0][0].typeSign.equals(sign)) && (tris[1][0]!=null && tris[1][0].typeSign.equals(sign)) && (tris[2][0]!=null && tris[2][0].typeSign.equals(sign)))||
				((tris[0][1]!=null && tris[0][1].typeSign.equals(sign)) && (tris[1][1]!=null && tris[1][1].typeSign.equals(sign)) && (tris[2][1]!=null && tris[2][1].typeSign.equals(sign)))||
				((tris[0][2]!=null && tris[0][2].typeSign.equals(sign)) && (tris[1][2]!=null && tris[1][2].typeSign.equals(sign)) && (tris[2][2]!=null && tris[2][2].typeSign.equals(sign)))||
				((tris[0][0]!=null && tris[0][0].typeSign.equals(sign)) && (tris[1][1]!=null && tris[1][1].typeSign.equals(sign)) && (tris[2][2]!=null && tris[2][2].typeSign.equals(sign)))||
				((tris[0][2]!=null && tris[0][2].typeSign.equals(sign)) && (tris[1][1]!=null && tris[1][1].typeSign.equals(sign)) && (tris[2][0]!=null && tris[2][0].typeSign.equals(sign)))){

				if(!player1.completedTurn) {
					victory += player1.name + " ha vinto";
					this.turn=9;
				}
				else if(!player2.completedTurn) {
					victory += player2.name + " ha vinto";
					this.turn = 9;
				}
				return victory;
			}
			if(this.turn == 9){
				return "Pareggio";
			}

			return "";
		}

		else {
			this.checkTurn();
			return "Sezione occupata. Riprova \n" + this.toString();
		}
	}
	
	public void reset(){
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3;j++)
				if(this.tris[i][j] != null)
					this.tris[i][j] = null;
		}
		this.turn=0;
	}

	public boolean checkTurn(){
		if(!this.player1.completedTurn) {
			this.player1.completedTurn = true;
			this.player2.completedTurn = false;
			return true;
		}
		else{
			this.player2.completedTurn = true;
			this.player1.completedTurn = false;
			return false;
		}
	}

	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3;j++)

				if(j<2 && this.tris[j][i] != null) s +=" "+ this.tris[j][i].typeSign+" |";
				else if(this.tris[j][i] != null) s +=" "+ this.tris[j][i].typeSign;
				else if(j<2) s +="   |";

			if(i<2) s += "\n-----------\n";
		}
		return s;
	}
	
	
	
}
