/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mgr.corba.cliente;

import java.util.Properties;

import br.com.mgr.corba.lib.OperacoesApp.Operacoes;
import br.com.mgr.corba.lib.OperacoesApp.OperacoesHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;

/**
 *
 * @author mauri
 */
public class CorbaCliente {

    static Operacoes operacoesImpl;

    public static void main(String args[]) {
        try {
            // Cria e inicializa o ORB e passa os parametros do servidor
            Properties props = new Properties();
            props.put("org.omg.CORBA.ORBInitialPort", "1050");
            props.put("org.omg.CORBA.ORBInitialHost", "");
            ORB orb = ORB.init(args, props);

            // Obtém o contexto de nomeação de raiz
            // A string "NameService" é definido para todos os ORBs CORBA.
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            // ObjRef é uma referência objeto genérico. Devemos reduzi-lo
            // para a interface que precisamos.
            // Usando o NamingContextExt que faz parte do interoperável
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Vincula a referência de objeto com o nome do Serviço.
            String name = "Operacoes";
            operacoesImpl = OperacoesHelper.narrow(ncRef.resolve_str(name));

            //Executa a chamada do metodo getStatusServidor  no CorbaServidor
            System.out.println("Resposta do servidor: " + operacoesImpl.getStatusServidor());

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }

}
