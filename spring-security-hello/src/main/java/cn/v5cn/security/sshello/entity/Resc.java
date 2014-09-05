package cn.v5cn.security.sshello.entity;

import java.io.Serializable;

public class Resc implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private String res_type;
    private String res_string;
    private Integer priority;
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
	public String getRes_type() {
		return res_type;
	}
	public void setRes_type(String res_type) {
		this.res_type = res_type;
	}
	public String getRes_string() {
		return res_string;
	}
	public void setRes_string(String res_string) {
		this.res_string = res_string;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	@Override
	public String toString() {
		return "Resc [id=" + id + ", name=" + name + ", res_type=" + res_type + ", res_string=" + res_string + ", priority=" + priority + ", descn=" + descn + "]";
	}
}
