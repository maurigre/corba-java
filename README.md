## corba-java
O projeto CORBA e destinado a troca de dados entre sistemas distribuidos heterogêneos

### Tecnologias utilizadas
- Java: JDK v8
- CORBA

### Packages 
* corba-server
* corba-cliente
* corba-lib

### Build dos packages
Os buildes dos pacotes devem seguir nesta ordem: 
 
- **Corba-Lib** : Execute o comando ` mvn install ` dentro do diretorio raiz do deste projeto.
- **Corba-Server** : Execute o comando ` mvn package` dentro do diretorio raiz do deste projeto.
- **Corba-Cliente** : Execute o comando ` mvn package` dentro do diretorio raiz do deste projeto.


### Informações de como o projeto pode ser executado

No terminal execute este comando deacordo com o seu OS: 
- Linux: `orbd -ORBInitialPort 1050&`
- MS-DOS (Windows): `start orbd -ORBInitialPort 1050`

Exitem duas forma de se executar os projetos:

**Primeiro**:
- Iniciando o corba-server: `java -jar target/corba-server.1.0.1-jar-with-dependencies.jar`, este jar já esta imbutido o corba-lib.
- Iniciando o corba-cliente: `java -jar target/corba-cliente.1.0.1-jar-with-dependencies.jar`, este jar já esta imbutido o corba-lib.

**Segundo**:

### Referencias utilizadas
[Oracle][https://docs.oracle.com/javase/8/docs/technotes/tools/unix/orbd.html#starting] (2021-03-08)
[UFPE][https://www.cin.ufpe.br/~cagf/sdgrad/implementacao_corba.htm] (2021-03-08)
