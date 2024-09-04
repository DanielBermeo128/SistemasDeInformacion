// Arreglo para almacernar las tareas
let tareas = [];

// Funcion para mostrar opciones
function mostrarMenu(){
// No es comilla simple, es apostrofe invertida
    return parseInt(prompt(`
        "Opciones disponibles"    
        1.- Agregar tareas
        2.- Ver todas la tareas
        3.- Marcar mis tareas como completadas
        4.- Salir
        `));
} // Fin de mostrar Menu

// Funcion principal de manejo del programa
function iniciarPrograma(){
    let continuar = true;
    while(continuar){
        let opcion = mostrarMenu();
        switch(opcion){
            case 1:
                agregarTarea();
                break;
            case 2:
                verTareas();
                break;
            case 3: 
                marcarTareaCompletada();
                break;
            case 4: 
                alert("Saliendo del programa ...");
                continuar = false;
                break;
            default:
                alert("Opcion no valida\nIntenta nuevamente");
        } // Fin de switch
    } // Fin de while
    alert("Programa finalizado");
}// Fin de iniciarPrograma

// Funcion que agrega una nueva tarea al arreglo
function agregarTarea(){
    let nombre = prompt("Ingresa el nombre de la tarea");
    // Valida que haya existido una entrada
    if(nombre){
        // Objeto tipo JSON: tipo de objetos de JS
        let tarea = {
            nombre: nombre, 
            completada: false
        };
        tareas.push(tarea);
        alert("La tarea a sido agregada");
    }else{
        alert("El nombre es un requisito obligatorio");
        agregarTarea();
    }
}// Fin de agregarTarea
function verTareas(){
    // Valida si tengo tareas
    if(tareas.length === 0){
        alert("No hay ninguna tarea en la lista");
    }else{
        let mensaje = "Lista de tareas: \n";
        // El parentesis del forEach contiene una funcion flecha
        tareas.forEach((t,index) => {
            
        }); // Fin de la funcion flecha
        {

        };
    }
}// Fin de verTareas
function marcarTareaCompletada(){
}// Fin de marcarTareaCompletada

iniciarPrograma();