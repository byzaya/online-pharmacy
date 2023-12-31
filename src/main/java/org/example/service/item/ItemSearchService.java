package org.example.service.item;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.entities.item.Item;
import org.example.repository.item.ItemRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemSearchService {

  private final ItemRepository itemRepository;

  public List<Item> searchItemByName(String search) {
    List<Item> matchingItems = new ArrayList<>();
    List<Item> itemList = itemRepository.findAll();

    for (Item item : itemList) {
      if (item.getName().contains(search)) {
        matchingItems.add(item);
      }
    }

    return matchingItems;
  }
}
