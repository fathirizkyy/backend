package com.backend.backend.service;

import java.util.List;

import com.backend.backend.dto.ItemCreateDto;
import com.backend.backend.dto.ItemDto;
import com.backend.backend.dto.ItemUpdateDto;


public interface ItemService {
ItemDto getItemById(Long id);
ItemCreateDto createItem(ItemCreateDto itemCreateDto);
ItemUpdateDto updateItem(Long id, ItemUpdateDto itemUpdateDto);
void deleteItem(Long id);
List<ItemDto> getAllItems(); 

}
