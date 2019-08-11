package by.tms.onlinestore.service;

import by.tms.onlinestore.entity.Item;
import by.tms.onlinestore.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item getItem(long id) {
        return itemRepository.get(id);
    }

    public List<Item> getAll() {
        return itemRepository.getAll();
    }

    public void create(Item item) {
        itemRepository.create(item);
    }

    public void update(Item item) {
        itemRepository.update(item);
    }

    public void delete(Item item) {
        itemRepository.delete(item);
    }

    public void deleteAll() {
        itemRepository.deleteAll();
    }
}
