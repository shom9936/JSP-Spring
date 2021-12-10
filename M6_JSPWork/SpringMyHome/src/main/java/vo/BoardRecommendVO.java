package vo;

/*
SEQ      NOT NULL NUMBER       
ID                VARCHAR2(30) 
BOARD_NO          NUMBER       
UP                NUMBER       
DOWN              NUMBER     
 */

public class BoardRecommendVO {
	private int seq;
	private String id;
	private int board_no;
	private int up_down;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getUp_down() {
		return up_down;
	}
	public void setUp_down(int up_down) {
		this.up_down = up_down;
	}

	
}
