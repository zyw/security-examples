package cn.v5cn.security.shiro_spring.entity;

import java.io.Serializable;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class Resource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id; //编号
    private String name; //资源名称
    private String type; //资源类型
    private String url; //资源路径
    private String permission; //权限字符串
    private Long parent_Id; //父编号
    private String parent_Ids; //父编号列表
    private Boolean available = Boolean.FALSE;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
    	this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParent_Id() {
        return parent_Id;
    }

    public void setParent_Id(Long parent_Id) {
        this.parent_Id = parent_Id;
    }

    public String getParent_Ids() {
        return parent_Ids;
    }

    public void setParent_Ids(String parent_Ids) {
        this.parent_Ids = parent_Ids;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public boolean isRootNode() {
        return parent_Id == 0;
    }

    public String makeSelfAsParentIds() {
        return getParent_Ids() + getId() + "/";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (id != null ? !id.equals(resource.id) : resource.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", type=" + type
				+ ", url=" + url + ", permission=" + permission
				+ ", parent_Id=" + parent_Id + ", parent_Ids=" + parent_Ids
				+ ", available=" + available + "]";
	}
}
