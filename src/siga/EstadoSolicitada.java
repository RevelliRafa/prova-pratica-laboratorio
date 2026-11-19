package siga;

public class EstadoSolicitada implements EstadoReserva {

    @Override
    public void retirar(Reserva reserva) {
        reserva.setEstado(new EstadoEmUso());
    }

    @Override
    public void devolver(Reserva reserva) {
        throw new IllegalStateException(
            "Nao e possivel devolver em SOLICITADA."
        );
    }

    @Override
    public void cancelar(Reserva reserva) {
        reserva.setEstado(new EstadoEncerrada());
    }

    @Override
    public String getSituacao() {
        return "SOLICITADA";
    }
}