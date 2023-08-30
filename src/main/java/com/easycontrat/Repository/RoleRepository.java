package com.easycontrat.Repository;

import com.easycontrat.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByLibelle(String libelle);
}
