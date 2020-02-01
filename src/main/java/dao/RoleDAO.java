package dao;

import dao.AbstractDAO;
import model.user.Role;

import java.util.List;

public interface RoleDAO {
    void saveRole(Role role);
    Role getRoleById(Integer roleID);
    List<Role> getListRole();
    void update(Integer roleID, Role editedRole);
    void delete(Integer roleID);
    
}
