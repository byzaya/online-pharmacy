package org.example.controller.item;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.controller.BaseController;
import org.example.dto.item.ItemDto;
import org.example.service.item.ItemCreationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
@Tag(name = "Товар")
public class ItemCreationController extends BaseController {

  private final ItemCreationService itemCreationService;

  @Operation(
      summary = "Добавление товара",
      description = "Добавление товара в базу данных фармацевтом")
  @PostMapping("/add")
  public ResponseEntity<?> addItemByAdmin(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "price") Double price,
      @RequestParam(value = "manufacturer") String manufacturer,
      @RequestParam(value = "picture_url") String pictureUrl,
      @RequestParam(value = "type_id") Long typeId,
      @RequestParam(value = "speciality_id") Long specialityId) {
    return ResponseEntity.ok(
        ItemDto.fromItem(
            itemCreationService.addItem(
                name, price, manufacturer, pictureUrl, typeId, specialityId)));
  }
}
