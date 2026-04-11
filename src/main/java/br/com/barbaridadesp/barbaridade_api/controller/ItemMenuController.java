package br.com.barbaridadesp.barbaridade_api.controller;

import br.com.barbaridadesp.barbaridade_api.domain.dto.ItemMenuDTO;
import br.com.barbaridadesp.barbaridade_api.domain.dto.ItemMenuDetalhesDTO;
import br.com.barbaridadesp.barbaridade_api.domain.dto.ResponseDTO;
import br.com.barbaridadesp.barbaridade_api.domain.entity.ItemMenu;
import br.com.barbaridadesp.barbaridade_api.domain.enums.CategoriaItemMenu;
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

    @PutMapping(value = "/menu-item/editar/{uuidItemMenu}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDTO> editarItemMenu(@PathVariable UUID uuidItemMenu, @RequestBody ItemMenuForm form) {
        return ResponseEntity.ok(service.editar(uuidItemMenu, form));
    }

    @DeleteMapping(value = "/menu-item/deletar/{uuidItemMenu}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDTO> excluirItemMenu(@PathVariable UUID uuidItemMenu) {
        return ResponseEntity.ok(service.excluir(uuidItemMenu));
    }

    @GetMapping(value = "/menu-item/{uuidItemMenu}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ItemMenuDTO> buscarItemMenu(@PathVariable UUID uuidItemMenu) {
        return ResponseEntity.ok(new ItemMenuDTO(service.buscarPorUuid(uuidItemMenu)));
    }

    @GetMapping(value = "/menu-item/{categoria}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ItemMenuDetalhesDTO> buscarItensPorCategoria(@PathVariable CategoriaItemMenu categoria) {
        return ResponseEntity.ok(service.buscarPorCategoria(categoria));
    }

    @GetMapping(value = "/menu-itens", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ItemMenuDetalhesDTO>> buscarTodosItens() {
        return ResponseEntity.ok(service.buscarTodos());
    }

}
