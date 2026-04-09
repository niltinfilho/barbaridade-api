package br.com.barbaridadesp.barbaridade_api.service;

import br.com.barbaridadesp.barbaridade_api.domain.dto.CategoriaItemMenuResponseDTO;
import br.com.barbaridadesp.barbaridade_api.domain.enums.CategoriaItemMenu;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EnumCategoriaItemMenuService {
    public List<CategoriaItemMenuResponseDTO> listarCategoriasItemMenu() {
        return Arrays.stream(CategoriaItemMenu.values())
                .map(CategoriaItemMenuResponseDTO::new).toList();
    }
}
