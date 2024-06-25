package com.sicte.capacidades.Usuarios.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sicte.capacidades.Usuarios.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    public User findByNombre(String nombre);
    public User findByCorreo(String correo);
    public User findByCedula(String cedula);
    public User findByRol(String rol);
    public User findByTelefono(String telefono);
    public User findByContrasena(String contrasena);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery = true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);

}
