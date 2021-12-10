package vo;

import org.springframework.web.multipart.MultipartFile;

/*IDX     NOT NULL NUMBER         
NAME    NOT NULL VARCHAR2(100)  
CONTENT NOT NULL VARCHAR2(2000) 
PWD     NOT NULL VARCHAR2(100)  
IP      NOT NULL VARCHAR2(100)  
REGDATE          DATE     
 */

public class VisitVO {
	private int idx;
	private String name;
	private String content;
	private String pwd;
	private String ip;
	private String regdate;
	private MultipartFile[] photo;
	private String filename1;
	private String filename2;
	
	public VisitVO() {}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getFilename1() {
		return filename1;
	}

	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}

	public String getFilename2() {
		return filename2;
	}

	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}

	public MultipartFile[] getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile[] photo) {
		this.photo = photo;
	}
	
	
}
