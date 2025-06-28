package com.backend.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.backend.ItemRepository;
import com.backend.backend.dto.ItemCreateDto;
import com.backend.backend.dto.ItemDto;
import com.backend.backend.dto.ItemUpdateDto;
import com.backend.backend.exception.DataNotFoundException;
import com.backend.backend.exception.EmptyDatabaseException;
import com.backend.backend.model.Item;

@Service
public class ItemServiceImpl implements ItemService {
private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemDto> getAllItems(){
        List<ItemDto> items=itemRepository.findAll().stream()
                .map(item -> new ItemDto(item.getId(), item.getName(),item.getDescription()))
                .toList();
                if (items.isEmpty()) {
                    throw new EmptyDatabaseException();
                    
                }
                return items;
        
    }
    @Override
    public ItemDto getItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new DataNotFoundException(id));
        return new ItemDto(item.getId(), item.getName(), item.getDescription());
    }
    @Override
    public ItemCreateDto createItem(ItemCreateDto itemCreateDto){
        Item item=new Item(null,itemCreateDto.getName(),itemCreateDto.getDescription());
        Item savedItem=itemRepository.save(item);
        return new ItemCreateDto(savedItem.getId(), savedItem.getName(), savedItem.getDescription());
        
    }

    @Override
    public ItemUpdateDto updateItem(Long id, ItemUpdateDto itemUpdateDto) {
        Item item=itemRepository.findById(id).orElseThrow(()->new DataNotFoundException(id));
        if (itemUpdateDto.getName() != null) {
            item.setName(itemUpdateDto.getName());
            
        }
        if (itemUpdateDto.getDescription() != null) {
            item.setDescription(itemUpdateDto.getDescription());
            
        }
        Item updatedItem=itemRepository.save(item);
        return new ItemUpdateDto(updatedItem.getId(), updatedItem.getName(), updatedItem.getDescription());
    }

    @Override
    public void deleteItem(Long id) {
        Item item=itemRepository.findById(id).orElseThrow(()->new DataNotFoundException(id));
        itemRepository.delete(item);
    }
   
}
