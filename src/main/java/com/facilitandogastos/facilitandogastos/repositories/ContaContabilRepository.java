package com.facilitandogastos.facilitandogastos.repositories;

import com.facilitandogastos.facilitandogastos.models.ContaContabil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaContabilRepository extends JpaRepository<ContaContabil, Long> {

    ContaContabil findById(long id);

}
