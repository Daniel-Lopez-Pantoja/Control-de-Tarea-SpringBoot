package daniel.lpz.controlTareas.controllers;

import daniel.lpz.controlTareas.entities.Tarea;
import daniel.lpz.controlTareas.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController

public class TareasController {

    @Autowired //Hace que la variable "service" automáticamente se cargue con una inyección de dependencias
    private TareaService service;

    @GetMapping("/tareas/{id}") //Traer Tarea 1
    public Tarea getTarea(@PathVariable Long id){
        return service.getTarea(id);
    }

    @GetMapping("/tareas") // Traer todaas las Tareaas
    public List<Tarea> getAllTareas(){
        return service.getAllTareas();
    }

    @DeleteMapping("/tareas/{id}") // Eliminar Tarea
    public void removeTarea(@PathVariable Long id){
        service.removeTarea(id);
    }

    @PostMapping ("/tareas") // Agregar Tarea
    public void addTarea(@RequestBody Tarea Tarea){
        service.addTarea(Tarea);
    }

    @PutMapping("/tareas/{id}") // Actualizar/Modificar Tarea
    public void updateTarea (@PathVariable Long id, @RequestBody Tarea updateTarea){
        service.updateTarea(id, updateTarea);
    }

    @GetMapping("/tareas/search") // Buscar Tareas
    public List<Tarea> searchTarea(@RequestParam("materia") String materia){ // ejemplo: /Tarea/search?materia=XXX
        return service.searchTarea(materia);
    }
}