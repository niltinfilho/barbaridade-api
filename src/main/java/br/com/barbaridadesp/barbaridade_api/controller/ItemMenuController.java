package br.com.barbaridadesp.barbaridade_api.controller;

import br.com.barbaridadesp.barbaridade_api.domain.dto.ItemMenuDTO;
import br.com.barbaridadesp.barbaridade_api.domain.dto.ResponseDTO;
import br.com.barbaridadesp.barbaridade_api.domain.entity.ItemMenu;
import br.com.barbaridadesp.barbaridade_api.domain.form.ItemMenuForm;
import br.com.barbaridadesp.barbaridade_api.service.ItemMenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ItemMenuController {

    private final ItemMenuService service;

    @PostMapping(value = "/menu-item/cadastrar", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDTO> cadastrarItemMenu(@RequestBody ItemMenuForm form) {
        return ResponseEntity.ok(service.cadastrar(form));
    }

    @PutMapping(value = "/menu-item/alterar/{uuidItemMenu}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDTO> alterarItemMenu(@PathVariable UUID uuidItemMenu, @RequestBody ItemMenuForm form) {
        return ResponseEntity.ok(service.alterar(uuidItemMenu, form));
    }

    @DeleteMapping(value = "/menu-item/deletar/{uuidItemMenu}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDTO> excluirItemMenu(@PathVariable UUID uuidItemMenu) {
        return ResponseEntity.ok(service.excluir(uuidItemMenu));
    }

    @GetMapping(value = "/menu-itens", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ItemMenuDTO>> buscarTodosItens() {
        return ResponseEntity.ok(service.buscarTodos().stream().map(ItemMenuDTO::new).toList());
    }

    @GetMapping(value = "/painel/menu-itens", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ItemMenu>> painelBuscarTodosItens() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping(value = "/painel/menu-item/{uuidItemMenu}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ItemMenu> painelBuscarItemMenu(@PathVariable UUID uuidItemMenu) {
        return ResponseEntity.ok(service.buscarPorUuid(uuidItemMenu));
    }
}
