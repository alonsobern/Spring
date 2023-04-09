package com.example.demoSpringRestful.services;

import com.example.demoSpringRestful.models.BootCamper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Debo especificar que es un servicio
@Service
public class BootCamperService {
    private final List<BootCamper> listaBootCampers = new ArrayList<>();

    //Implemento un método que me devuelva la lista de BootCampers
    public List<BootCamper> getAll(){
        return this.listaBootCampers;
    }

    public BootCamper get(String nombre){
        for(BootCamper usuario:listaBootCampers){
            if(usuario.getNombre().equalsIgnoreCase(nombre)){ //Compara si el nombre buscado existe sin distinción de May-Min
                return usuario;
            }
        }
        return null;
    }
    public void add(BootCamper bootCamper){
        this.listaBootCampers.add(bootCamper);
    }
}
