package br.com.barbaridadesp.barbaridade_api.controller;

import br.com.barbaridadesp.barbaridade_api.domain.dto.CategoriaItemMenuResponseDTO;
import br.com.barbaridadesp.barbaridade_api.service.EnumCategoriaItemMenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/enums")
@AllArgsConstructor
public class EnumsController {
    private final EnumCategoriaItemMenuService categoriaItemMenuService;

    @GetMapping(value = "/categorias-item-menu", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<CategoriaItemMenuResponseDTO>> listarCategoriasItemMenu() {
        return ResponseEntity.ok(categoriaItemMenuService.listarCategoriasItemMenu());
    }
}
