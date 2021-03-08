package br.com.mgr.corba.server;

import br.com.mgr.corba.lib.OperacoesApp.Operacoes;
import br.com.mgr.corba.lib.OperacoesApp.OperacoesHelper;
import org.omg.CORBA.*;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import java.util.Properties;

/**
 *
 * @author Mauri Reis
 */
public class CorbaServer {

    public static void main(String args[]) {
        try {
            // Cria e inicializa o ORB e passa os parametros do servidor
            Properties props = new Properties();
            props.put("org.omg.CORBA.ORBInitialPort", "1050");
            props.put("org.omg.CORBA.ORBInitialHost", "");
            ORB orb = ORB.init(args, props);

            // Define a politica de comunicação entre cliente e servidor
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Registra no ORB as regras de comunicação
            OperacoesImpl operacoesImpl = new OperacoesImpl();
            operacoesImpl.setORB(orb);

            // pega a referencia do objeto para o servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(operacoesImpl);
            Operacoes href = OperacoesHelper.narrow(ref);

            // Obtém o contexto de nomeação de raiz
            // A string "NameService" é definido para todos os ORBs CORBA.
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            // ObjRef é uma referência objeto genérico. Devemos reduzi-lo
            // para a interface que precisamos.
            // Usando o NamingContextExt que faz parte do interoperável
            // Naming Service (INS) especificação.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Vincula a referência de objeto com o nome do Serviço.
            String name = "Operacoes";//Serviços prestados
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("Servidor Corba iniciado.");
            System.out.println("Aguardando Conexoes...");

            //Aguarda requizição dos Clíentes
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            //e.printStackTrace(System.out);
        }

        System.out.println("Finalizado Servidor Corba ...");

    }
}
