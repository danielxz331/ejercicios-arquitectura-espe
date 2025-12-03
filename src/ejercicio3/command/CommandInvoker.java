package ejercicio3.command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    
    private List<Command> comandos;

    public CommandInvoker() {
        this.comandos = new ArrayList<>();
    }

    public void agregarComando(Command comando) {
        comandos.add(comando);
    }

    public void ejecutarComando(Command comando) {
        comando.execute();
    }

    public void ejecutarTodosLosComandos() {
        System.out.println(">>> Ejecutando todos los comandos...\n");
        for (Command comando : comandos) {
            comando.execute();
        }
    }
}
