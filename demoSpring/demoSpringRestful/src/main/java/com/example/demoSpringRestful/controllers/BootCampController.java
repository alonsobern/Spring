package com.example.demoSpringRestful.controllers;

import com.example.demoSpringRestful.models.BootCamper;
import com.example.demoSpringRestful.services.BootCamperService;
import jakarta.validation.constraints.Positive;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

//Debo especificar que es un componente y el path
@Component
@Path("/")
public class BootCampController {
    private BootCamperService bootCamperService;

    //Es imperativo crear el constructor, este se ejecuta automáticamente por debajo
    public BootCampController(BootCamperService bootCamperService) {
        this.bootCamperService = bootCamperService;
        this.bootCamperService.add(new BootCamper(1,"Manuel"));
        this.bootCamperService.add(new BootCamper(2,"Alonso"));
        this.bootCamperService.add(new BootCamper(3,"Maria"));
        this.bootCamperService.add(new BootCamper(4,"Auxiliadora"));
    }

    @GET
    public String prueba(){
        return "Hola Mundo Spring";
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<BootCamper> listarTodos(){
        return bootCamperService.getAll();
    }

    //Estructura que se utiliza para leer un parámetro puntual mediante un controller
    @GET
    @Path("/bootcampers/{nombre}")
    @Produces("application/json")
    public BootCamper listaUno(@PathParam("nombre") String nombre){
        return bootCamperService.get(nombre);
    }

    //Para utilizar el método POST la función siempre debe devolver un dato Response
    @POST
    @Path("/bootcampers")
    @Produces("application/json") //Produces indica el formato en que voy a enviar los datos
    @Consumes("application/json") //Consumes indica el formato en que voy a recibir los datos
    public Response addBootCamper(BootCamper bootCamper){
        bootCamperService.add(bootCamper);


        //Estructura básica para devolver dato response en donde me indicará que el nombre ingresado ha sido creado correctamente
        return Response.created(
                URI.create("/bootcampers/"+bootCamper.getNombre())
        ).build();

    }
}
