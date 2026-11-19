package siga;

import java.util.List;

public class RelatorioAcervo {

    private final InventarioEquipamentos inventario;

    public RelatorioAcervo(InventarioEquipamentos inventario) {
        this.inventario = inventario;
    }

    public List<Equipamento> listarTodos() {
        return inventario.listarTodos();
    }

    public void imprimir() {

        System.out.println("   Situacao segundo o relatorio:");

        for (Equipamento item : listarTodos()) {

            System.out.println("     " + item + " - "
                    + (item.isDisponivel() ? "disponivel" : "baixado"));
        }
    }
}