package cn.v5cn.security.sshello.entity;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
    private String name;
    private String descn;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", descn=" + descn + "]";
	}
    
}
