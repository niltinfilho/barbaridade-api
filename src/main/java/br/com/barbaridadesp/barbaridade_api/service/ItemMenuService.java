package br.com.barbaridadesp.barbaridade_api.service;

import br.com.barbaridadesp.barbaridade_api.domain.dto.ItemMenuDetalhesDTO;
import br.com.barbaridadesp.barbaridade_api.domain.dto.ResponseDTO;
import br.com.barbaridadesp.barbaridade_api.domain.entity.ItemMenu;
import br.com.barbaridadesp.barbaridade_api.domain.enums.CategoriaItemMenu;
import br.com.barbaridadesp.barbaridade_api.domain.form.ItemMenuForm;
import br.com.barbaridadesp.barbaridade_api.exceptions.ApiResponseException;
import br.com.barbaridadesp.barbaridade_api.repository.ItemMenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class ItemMenuService {

    private final ItemMenuRepository repository;

    public ResponseDTO cadastrar(ItemMenuForm form) {
        validarItemMenu(null, form);
        ItemMenu novoItemMenu = new ItemMenu();
        novoItemMenu.setNome(form.nome());
        novoItemMenu.setDescricao(form.descricao());
        novoItemMenu.setBase64Image(form.base64Image());
        novoItemMenu.setDescricaoAltImage(form.descricaoAltImage());
        novoItemMenu.setCategoria(form.categoria());
        repository.save(novoItemMenu);
        return new ResponseDTO("Item do menu cadastrado com sucesso!");
    }

    public ResponseDTO editar(UUID uuidItemMenu, ItemMenuForm form) {
        validarItemMenu(uuidItemMenu, form);
        ItemMenu itemMenu = buscarPorUuid(uuidItemMenu);
        itemMenu.setNome(form.nome());
        itemMenu.setDescricao(form.descricao());
        itemMenu.setDescricaoAltImage(form.descricaoAltImage());
        itemMenu.setCategoria(form.categoria());
        if (nonNull(form.base64Image()))
            itemMenu.setBase64Image( form.base64Image());
        repository.save(itemMenu);
        return new ResponseDTO("Item do menu alterado com sucesso!");
    }

    public ResponseDTO excluir(UUID uuidItemMenu) {
        ItemMenu itemMenu = repository.findByUuidItemMenu(uuidItemMenu);
        repository.delete(itemMenu);
        return new ResponseDTO("Item do menu excluído com sucesso!");
    }

    public List<ItemMenuDetalhesDTO> buscarTodos() {
        List<ItemMenuDetalhesDTO> resultados = new ArrayList<>();
        Arrays.stream(CategoriaItemMenu.values()).toList().forEach(categoria -> {
            ItemMenuDetalhesDTO itemMenuDetalhes = new ItemMenuDetalhesDTO();
            List<ItemMenuDetalhesDTO.Item> itens = new ArrayList<>();
            itemMenuDetalhes.setCategoria(categoria);
            itemMenuDetalhes.setDescricaoCategoria(categoria.getDescricao());
            repository.findAllByCategoria(categoria).forEach(item -> {
                itens.add(new ItemMenuDetalhesDTO.Item(item));
            });
            itemMenuDetalhes.setItens(itens);
            resultados.add(itemMenuDetalhes);
        });
        return resultados;
    }

    public ItemMenuDetalhesDTO buscarPorCategoria(CategoriaItemMenu categoria) {
        ItemMenuDetalhesDTO itemMenuDetalhes = new ItemMenuDetalhesDTO();
        List<ItemMenuDetalhesDTO.Item> itens = new ArrayList<>();
        itemMenuDetalhes.setCategoria(categoria);
        itemMenuDetalhes.setDescricaoCategoria(categoria.getDescricao());
        repository.findAllByCategoria(categoria).forEach(itemMenu -> {
            itens.add(new ItemMenuDetalhesDTO.Item(itemMenu));
        });
        itemMenuDetalhes.setItens(itens);
        return itemMenuDetalhes;
    }

    public ItemMenu buscarPorUuid(UUID uuidItemMenu) {
        return repository.findByUuidItemMenu(uuidItemMenu);
    }

    private void validarItemMenu(UUID uuidItemMenu, ItemMenuForm form) {
        if (isNull(form.nome()) || form.nome().isBlank())
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "O nome não pode estar vazio!");
        if (isNull(form.descricao()) || form.descricao().isBlank())
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "A descrição não pode estar vazia!");
        if (isNull(form.categoria()))
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "A categoria não pode estar vazia!");
        if (isNull(form.descricaoAltImage()) || form.descricaoAltImage().isBlank())
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "A descrição alt da imagem não pode estar vazia!");

        if (nonNull(uuidItemMenu)) {
            ItemMenu itemMenu = repository.findByUuidItemMenu(uuidItemMenu);
            if (!form.nome().equals(itemMenu.getNome()) && nonNull(repository.findByNomeItemMenu(form.nome())))
                throw new ApiResponseException(HttpStatus.BAD_REQUEST, "Já existe um item cadastrado com esse nome!");
        } else {
            if (isNull(form.base64Image()) || form.base64Image().isBlank())
                throw new ApiResponseException(HttpStatus.BAD_REQUEST, "A imagem não pode estar vazia!");
            if (nonNull(repository.findByNomeItemMenu(form.nome())))
                throw new ApiResponseException(HttpStatus.BAD_REQUEST, "Já existe um item cadastrado com esse nome!");
        }
    }
}
