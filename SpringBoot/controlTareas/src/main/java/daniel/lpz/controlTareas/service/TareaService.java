package daniel.lpz.controlTareas.service;

import daniel.lpz.controlTareas.entities.Tarea;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service

public class TareaService {

    private List<Tarea> list = new ArrayList<>(); //Lista de Tareas FALSA, despues la conectaremos a una BD

    public TareaService(){
        Tarea t = new Tarea();
        t.setId(1L);
        t.setNombre("Actividad 1");
        t.setMateria("POO");
        t.setFecha("24-09-16");
        t.setIsCompleted(false);
        list.add(t);

        Tarea t2 = new Tarea();
        t2.setId(2L);
        t2.setNombre("Proyecto Modular");
        t2.setMateria("PM2");
        t2.setFecha("24-11-16");
        t2.setIsCompleted(false);
        list.add(t2);

        Tarea t3 = new Tarea();
        t3.setId(3L);
        t3.setNombre("Actividad 1");
        t3.setMateria("Base de Datos");
        t3.setFecha("24-09-16");
        t3.setIsCompleted(true);
        list.add(t3);
    }

    public Tarea getTarea(Long id){
        for (Tarea Tarea: list){
            if (Tarea.getId() == id) {
                return Tarea;
            }
        }
        return null;
    }

    public List<Tarea> getAllTareas(){
        return list;
    }

    public void removeTarea(Long id){
        System.out.println("Intentando eliminar tarea con ID: " + id);
        for (Tarea Tarea: list){
            System.out.println("Entro al for y busca el id: " + id);
            System.out.println("Comparo el id: " + id + ", Con la tarea: " + Tarea.getId());
            if (Tarea.getId() == id) {
                System.out.println("Entro al if");
                list.remove(Tarea);
                System.out.println("Elemento eliminado: " + Tarea);
                break;
            }
        }
    }

    public void addTarea(Tarea Tarea){
        list.add(Tarea);
    }

    public void updateTarea (Long id, Tarea updateTarea){
        for (Tarea Tarea: list){
            if (Tarea.getId() == id) {
                list.remove(Tarea);
                updateTarea.setId(id);
                list.add(updateTarea);
                break;
            }
        }
    }

    public List<Tarea> searchTarea(String materia){ // ejemplo: /Tarea/search?materia=XXX
        List<Tarea> searchResult = new ArrayList<>();
        for (Tarea Tarea: list){
            if (Tarea.getMateria().contains(materia)) {
                searchResult.add(Tarea);
                break;
            }
        }
        return searchResult;
    }
}