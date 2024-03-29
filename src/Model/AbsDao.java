/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author HP PC
 */
abstract public class AbsDao<Entity,Key> {
    
    abstract public void insert(Entity e);
    abstract public void update(Entity e);
    abstract public void delete(Key id);
    abstract public Entity selectById(Key id);
    abstract public List<Entity> selectAll();
    abstract protected List<Entity> selectBySql(String sql, Object...a);
}
