package ejercicio3.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker del patrón Command.
 * Almacena y ejecuta los comandos.
 */
public class CommandInvoker {
    
    private List<Command> comandos;

    public CommandInvoker() {
        this.comandos = new ArrayList<>();
    }

    /**
     * Agrega un comando a la lista de comandos
     */
    public void agregarComando(Command comando) {
        comandos.add(comando);
    }

    /**
     * Ejecuta un comando específico
     */
    public void ejecutarComando(Command comando) {
        comando.execute();
    }

    /**
     * Ejecuta todos los comandos almacenados
     */
    public void ejecutarTodosLosComandos() {
        System.out.println(">>> Ejecutando todos los comandos...\n");
        for (Command comando : comandos) {
            comando.execute();
        }
    }

    /**
     * Limpia la lista de comandos
     */
    public void limpiarComandos() {
        comandos.clear();
    }
}
