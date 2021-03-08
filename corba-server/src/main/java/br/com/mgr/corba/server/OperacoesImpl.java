/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mgr.corba.server;

import br.com.mgr.corba.lib.OperacoesApp.OperacoesPOA;
import org.omg.CORBA.ORB;

/**
 *
 * @author Mauri Reis
 */
public class OperacoesImpl extends OperacoesPOA {

    private ORB orb;

    public void setORB(ORB objOrb) {
        orb = objOrb;
    }


    public String getStatusServidor() {
        System.out.println("Consulta realizada: StatusServidor");
        return "Conexão com o Servidor ativa.";
    }
}
