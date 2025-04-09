package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.KsmprovHistorico;

@Repository
public interface KsmprovHistoricoRepository extends CrudRepository<KsmprovHistorico, String> {
    public KsmprovHistorico findByLlave(String llave);

    public KsmprovHistorico findByFecha(String fecha);

    public KsmprovHistorico findByCodproveedor(String codproveedor);

    public KsmprovHistorico findByNombre(String nombre);

    public KsmprovHistorico findByProducto(String producto);

    public KsmprovHistorico findByDescrip(String descrip);

    public KsmprovHistorico findByUnimed(String unimed);

    public KsmprovHistorico findByCantidad(String cantidad);

    public KsmprovHistorico findByObservacion(String observacion);

    public KsmprovHistorico findByUsuario(String usuario);

    public KsmprovHistorico findByFechau(String fechau);

    public KsmprovHistorico findByFechaDescarga(String fechaDescarga);

    public KsmprovHistorico findByBodega(String bodega);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery =
    // true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
