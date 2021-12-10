package vo;

public class CommentRecommendVO {
	private int seq;
	private String id;
	private int comment_no;
	private int up_down;
	
	public CommentRecommendVO() {}
	
	public CommentRecommendVO(int seq, String id, int comment_no, int up_down) {
		this.seq = seq;
		this.id = id;
		this.comment_no = comment_no;
		this.up_down = up_down;
	}

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

	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}

	public int getUp_down() {
		return up_down;
	}

	public void setUp_down(int up_down) {
		this.up_down = up_down;
	}
	
}
