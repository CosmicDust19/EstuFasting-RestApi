package edu.estu.estufastingrestapi.core.repository.dataseeders.concretes;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Privilege;
import edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts.BaseDataSeeder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PrivilegeDataSeeder extends BaseDataSeeder<Privilege, Integer> {

    @Override
    public int getOrder() {
        return 10;
    }

    @Override
    public void setData() {

        Metamodel metamodel = entityManager.getMetamodel();
        Set<EntityType<?>> entities = metamodel.getEntities();

        entities.forEach(e -> {
            data.add(new Privilege(null, "C_" + e.getName(), "c_" + e.getName().toLowerCase()));
            data.add(new Privilege(null, "R_" + e.getName(), "r_" + e.getName().toLowerCase()));
            data.add(new Privilege(null, "U_" + e.getName(), "u_" + e.getName().toLowerCase()));
            data.add(new Privilege(null, "D_" + e.getName(), "d_" + e.getName().toLowerCase()));
        });

    }

}
