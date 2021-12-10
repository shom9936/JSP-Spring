package vo;

import org.springframework.web.multipart.MultipartFile;

/*create table board (
	    SEQ NUMBER NOT NULL,
	    ID VARCHAR2(30) NOT NULL,   
	    NAME VARCHAR2(30) NOT NULL,  
	    TITLE VARCHAR2(255) NOT NULL, 
	    CONTENT VARCHAR2(4000) NOT NULL,
	    FILENAME VARCHAR2(255),  
	    HIT NUMBER,         
	    LOGTIME DATE
	);*/

public class BoardVO {
	private int seq;
	private String id;
	private String name;
	private String title;
	private String content;
	private String filename;
	private int hit;
	private String logtime;
	private MultipartFile photo;
	private int comment_cnt;
	private int recomment_cnt;
	private int decomment_cnt;
	
	public int getDecomment_cnt() {
		return decomment_cnt;
	}
	public void setDecomment_cnt(int decomment_cnt) {
		this.decomment_cnt = decomment_cnt;
	}
	public int getComment_cnt() {
		return comment_cnt;
	}
	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}
	public int getRecomment_cnt() {
		return recomment_cnt;
	}
	public void setRecomment_cnt(int recomment_cnt) {
		this.recomment_cnt = recomment_cnt;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	
	
}
