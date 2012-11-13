package net.huaixiu.bean;

import java.io.Serializable;

public class ArticleEntity implements Serializable{
	
	private static final long serialVersionUID = 5676444250465141871L;
	
	private String number;
	private String indexurl;
	private String detailurl;
	private String name;
	private String type;
	private String author;
	private String lastchapters;
	private String lastuptime;
	private String status;
	private String size;
	private String all;

	public String getIndexurl() {
		return indexurl;
	}

	public void setIndexurl(String indexurl) {
		this.indexurl = indexurl;
	}

	public String getDetailurl() {
		return detailurl;
	}

	public void setDetailurl(String detailurl) {
		this.detailurl = detailurl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLastchapters() {
		return lastchapters;
	}

	public void setLastchapters(String lastchapters) {
		this.lastchapters = lastchapters;
	}

	public String getLastuptime() {
		return lastuptime;
	}

	public void setLastuptime(String lastuptime) {
		this.lastuptime = lastuptime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	 

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
