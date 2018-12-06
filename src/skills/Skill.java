package skills;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import entity.character.*;
import javafx.scene.image.ImageView;

public abstract class Skill extends Pane {
	protected int team;
	protected int damage;
	protected int turn;
	protected int mana;
	protected Image body;
	protected Image hitPic;
	
	protected int posx;
	protected int posy;
	protected int posz;
	
	protected int rx;
	protected int ry;
	protected int rz;
	
	protected boolean blockable;
	protected boolean dead,hit;
	protected int tilldead,effdu;
	
	protected ImageView iv;
	
	public Skill(int team,int damage,int turn,int mana,Image body,Image hitPic,int posx,int posy,int posz,int rx,int ry,int rz,boolean blockable,int effdu) {
		super();
		this.team=team;
		this.damage=damage;
		this.turn=turn;
		this.mana=mana;
		this.body=body;
		this.hitPic=hitPic;
		this.posx=posx;
		this.posy=posy;
		this.posz=posz;
		this.rx=rx;
		this.ry=ry;
		this.rz=rz;
		this.blockable=blockable;
		this.dead=false;
		this.tilldead=0;
		this.hit=false;
		this.effdu=effdu;
		
		iv= new ImageView();
		iv.setFitHeight(60);
		iv.setFitWidth(60);
		iv.setImage(body);
		this.getChildren().add(iv);
	}
	
	public boolean isdead() {
		return dead;
	}
	
	public void sigDead() {
		dead=true;
		if(this.hit) {
			iv.setImage(hitPic);
			tilldead=effdu;
		}
	}
	
	public boolean des() {
		return dead&&tilldead==0;
	}
	
	public abstract boolean checkhit(players p);
	public abstract void update();
}