package com.backend.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.dto.ItemCreateDto;
import com.backend.backend.dto.ItemDto;
import com.backend.backend.dto.ItemUpdateDto;

import com.backend.backend.payload.ApiResponse;
import com.backend.backend.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/items")
public class ItemController {
private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

   @GetMapping
   public ResponseEntity<List<ItemDto>> getAllItems() {
       List<ItemDto> items = itemService.getAllItems();
       return ResponseEntity.ok(items);
   }
    
   @GetMapping("/{id}")
   public ResponseEntity<ItemDto> getItemById(@PathVariable Long id) {
       ItemDto item = itemService.getItemById(id);
       return ResponseEntity.ok(item);
    }

   @PostMapping
   public ResponseEntity<?>createItem(@Valid @RequestBody ItemCreateDto itemCreateDto){
    ItemCreateDto created=itemService.createItem(itemCreateDto);
   ApiResponse<ItemCreateDto> response = new ApiResponse<>(true, "Item created successfully", created);
   return ResponseEntity.status(HttpStatus.CREATED).body(response);
   }

   @PutMapping("/{id}")
   public ResponseEntity<?>updateItem(@PathVariable Long id,
    @Valid @RequestBody ItemUpdateDto itemUpdateDto){
    ItemUpdateDto updated=itemService.updateItem(id, itemUpdateDto);
    ApiResponse<ItemUpdateDto> response = new ApiResponse<>(true, "Item updated successfully", updated);
    return ResponseEntity.ok(response);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteItem(@PathVariable Long id) {
         itemService.deleteItem(id);
         ApiResponse<String> response = new ApiResponse<>(true, "Item deleted successfully", null);
         return ResponseEntity.ok(response);
    }
}
