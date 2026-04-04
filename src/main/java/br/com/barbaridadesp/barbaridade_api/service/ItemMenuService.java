package br.com.barbaridadesp.barbaridade_api.service;

import br.com.barbaridadesp.barbaridade_api.domain.dto.ResponseDTO;
import br.com.barbaridadesp.barbaridade_api.domain.entity.ItemMenu;
import br.com.barbaridadesp.barbaridade_api.domain.form.ItemMenuForm;
import br.com.barbaridadesp.barbaridade_api.repository.ItemMenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ItemMenuService {

    private final ItemMenuRepository repository;

    public ResponseDTO cadastrar(ItemMenuForm form) {
        ItemMenu novoItemMenu = new ItemMenu();
        novoItemMenu.setNome(form.nome());
        novoItemMenu.setDescricao(form.descricao());
        novoItemMenu.setBase64Img(form.base64Img());
        novoItemMenu.setAltDescription(form.altDescription());
        novoItemMenu.setCategoria(form.categoria());
        repository.save(novoItemMenu);
        return new ResponseDTO("Item do menu cadastrado com sucesso!");
    }

    public ResponseDTO alterar(UUID uuidItemMenu, ItemMenuForm form) {
        ItemMenu itemMenu = buscarPorUuid(uuidItemMenu);
        itemMenu.setNome(form.nome());
        itemMenu.setDescricao(form.descricao());
        itemMenu.setBase64Img(form.base64Img());
        itemMenu.setAltDescription(form.altDescription());
        itemMenu.setCategoria(form.categoria());
        repository.save(itemMenu);
        return new ResponseDTO("Item do menu alterado com sucesso!");
    }

    public ResponseDTO excluir(UUID uuidItemMenu) {
        ItemMenu itemMenu = repository.findByUuidItemMenu(uuidItemMenu);
        repository.delete(itemMenu);
        return new ResponseDTO("Item do menu excluído com sucesso!");
    }

    public List<ItemMenu> buscarTodos() {
        return repository.findAllByStatusAtivo();
    }

    public ItemMenu buscarPorUuid(UUID uuidItemMenu) {
        return repository.findByUuidItemMenu(uuidItemMenu);
    }
}
