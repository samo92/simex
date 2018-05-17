package ib.facmed.unam.mx.simexfacmed.Api;

import ib.facmed.unam.mx.simexfacmed.Models.Programas;
import ib.facmed.unam.mx.simexfacmed.Models.SimexPonentes;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by samo92 on 04/04/2018.
 */

public interface PostApiService {

    @GET("simex/Actividades.json")
    Call<Programas> getPrograma();

    @GET("simex/Ponentes.json")
    Call<SimexPonentes> getPonentes();
}
