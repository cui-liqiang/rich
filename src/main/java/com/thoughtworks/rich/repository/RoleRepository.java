package com.thoughtworks.rich.repository;

import com.thoughtworks.rich.model.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    private List<Role> allRole = new ArrayList<Role>();

    public RoleRepository() {
        allRole.add(new Role('A', "赵小A"));
        allRole.add(new Role('B', "钱小B"));
        allRole.add(new Role('C', "孙小C"));
    }

    public List<Role> all() {
        return allRole;
    }

    public Role findBySymbol(char symbol) {
        for (Role role : allRole) {
            if(role.getSymbol() == symbol)
                return role;
        }
        return null;
    }
}
