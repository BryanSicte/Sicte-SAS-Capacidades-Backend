package com.sicte.capacidades.supervision.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.supervision.dto.placaFechaDto;
import com.sicte.capacidades.supervision.entity.registros;

@Repository
public interface registrosRepository extends CrudRepository<registros, String> {
    public registros findByFecha (String fecha);
    public registros findByNombre (String nombre);
    public registros findByPlaca (String placa);
    public registros findByCedulaCuadrilla (String cedulaCuadrilla);
    public registros findByNombreCuadrilla (String nombreCuadrilla);
    public registros findByOt (String ot);
    public registros findByEpp (String epp);
    public registros findByEppComentario (String eppComentario);
    public registros findByAlturas (String alturas);
    public registros findByAlturasComentario (String alturasComentario);
    public registros findByAts (String ats);
    public registros findByAtsComentario (String atsComentario);
    public registros findByEmpalmes (String empalmes);
    public registros findByEmpalmesComentario (String empalmesComentario);
    public registros findByPreoperacional (String preoperacional);
    public registros findByPreoperacionalComentario (String preoperacionalComentario);
    public registros findByVehiculo (String vehiculo);
    public registros findByVehiculoComentario (String vehiculoComentario);
    public registros findByEmpalmadora (String empalmadora);
    public registros findByOtdr (String otdr);
    public registros findByCortadora (String cortadora);
    public registros findByPinza (String pinza);
    public registros findByOpm (String opm);
    public registros findByOnexpert (String onexpert);
    public registros findByMedidorConductancia (String medidorConductancia);
    public registros findByMedidorFugas (String medidorFugas);
    public registros findByObservacion (String observacion);
    public registros findByFotoNombre (String fotoNombre);
    public registros findByLatitud (String latitud);
    public registros findByLongitud (String longitud);

    @Query("SELECT new com.sicte.capacidades.supervision.dto.placaFechaDto(p.fecha, p.placa) FROM registros p")
    List<placaFechaDto> findFechaAndPlaca();
}
