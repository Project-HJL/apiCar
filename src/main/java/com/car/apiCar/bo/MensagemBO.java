package com.car.apiCar.bo;

import com.car.apiCar.dao.MensagemDAO;
import com.car.apiCar.model.Conversa;
import com.car.apiCar.model.Mensagem;

import java.util.Date;
import java.util.List;

public class MensagemBO {

    private MensagemDAO mensagemDAO;

    public MensagemBO() {
        this.mensagemDAO = new MensagemDAO();
    }

    public List<Mensagem> listarMensagensPorConversa(Conversa conversa) {
        return mensagemDAO.listarMensagensPorConversa(conversa);
    }

    public boolean inserirMensagem(String conteudo, String tipo, Date dataHora, Conversa conversa) {
        Mensagem mensagem = new Mensagem(conteudo, tipo, dataHora, conversa);
        return mensagemDAO.inserirMensagem(mensagem);
    }
}
