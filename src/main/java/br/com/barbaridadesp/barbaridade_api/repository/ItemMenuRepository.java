package br.com.barbaridadesp.barbaridade_api.repository;

import br.com.barbaridadesp.barbaridade_api.domain.entity.ItemMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemMenuRepository extends JpaRepository<ItemMenu, Long> {

    @Query("SELECT im FROM ItemMenu im WHERE im.uuid = :uuidItemMenu AND im.ativo = true")
    ItemMenu findByUuidItemMenu(UUID uuidItemMenu);

    @Query("SELECT im FROM ItemMenu im WHERE im.ativo = true")
    List<ItemMenu> findAllByStatusAtivo();
}
