package com.spc.model;

import java.io.Serializable;

public class RoleDomain  implements Serializable {
    private Integer roleId;  //角色的id

    private String roleName; //角色的名称


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
