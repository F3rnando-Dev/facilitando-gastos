package com.facilitandogastos.project.repositories;

import com.facilitandogastos.project.models.DespesaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<DespesaModel, Long> {


}
