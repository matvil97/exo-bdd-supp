package src;

import java.util.List;

public interface Dao<T> {
    void insert(T obj);
    T select(int id);
    void update(T obj);
    void delete(int id);
    List<T> getAll();
}
