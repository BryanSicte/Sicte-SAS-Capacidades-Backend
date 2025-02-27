package com.sicte.capacidades.supervision.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.supervision.dto.PlacaFechaDto;
import com.sicte.capacidades.supervision.entity.Registros;

@Repository
public interface RegistrosRepository extends CrudRepository<Registros, String> {
    public Registros findByFecha (String fecha);
    public Registros findByNombre (String nombre);
    public Registros findByPlaca (String placa);
    public Registros findByCedulaCuadrilla (String cedulaCuadrilla);
    public Registros findByNombreCuadrilla (String nombreCuadrilla);
    public Registros findByOt (String ot);
    public Registros findByEpp (String epp);
    public Registros findByEppComentario (String eppComentario);
    public Registros findByAlturas (String alturas);
    public Registros findByAlturasComentario (String alturasComentario);
    public Registros findByAts (String ats);
    public Registros findByAtsComentario (String atsComentario);
    public Registros findByEmpalmes (String empalmes);
    public Registros findByEmpalmesComentario (String empalmesComentario);
    public Registros findByPreoperacional (String preoperacional);
    public Registros findByPreoperacionalComentario (String preoperacionalComentario);
    public Registros findByVehiculo (String vehiculo);
    public Registros findByVehiculoComentario (String vehiculoComentario);
    public Registros findByEmpalmadora (String empalmadora);
    public Registros findByOtdr (String otdr);
    public Registros findByCortadora (String cortadora);
    public Registros findByPinza (String pinza);
    public Registros findByOpm (String opm);
    public Registros findByOnexpert (String onexpert);
    public Registros findByMedidorConductancia (String medidorConductancia);
    public Registros findByMedidorFugas (String medidorFugas);
    public Registros findByObservacion (String observacion);
    public Registros findByFotoNombre (String fotoNombre);
    public Registros findByLatitud (String latitud);
    public Registros findByLongitud (String longitud);

    @Query("SELECT new com.sicte.capacidades.supervision.dto.PlacaFechaDto(p.fecha, p.placa) FROM Registros p")
    List<PlacaFechaDto> findFechaAndPlaca();
}
