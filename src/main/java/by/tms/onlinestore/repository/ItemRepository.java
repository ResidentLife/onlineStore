package by.tms.onlinestore.repository;

import by.tms.onlinestore.entity.Item;

import java.util.List;

public interface ItemRepository {

    Item get(long id);

    List<Item> getAll();

    void create(Item item);

    void update(Item item);

    void delete(Item item);

    void deleteAll();
}
