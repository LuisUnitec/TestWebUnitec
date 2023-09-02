package co.edu.unc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

    @Override
    List<Usuario> findAll();

    @Query("SELECT U FROM Usuario U WHERE U.peso < 80")
    public List<Usuario> buscarUsuarios();

    @Query("SELECT U FROM Usuario U WHERE U.id = 1")
    public Usuario visualizaUsuario();
}
