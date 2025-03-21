package support.Tecnologia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import support.Tecnologia.entity.Usuarios;


@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {


}
