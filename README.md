[En français](https://github.com/leimt/tcc-pucminas-18/blob/master/README.fr.md)
# TCC-PucMinas-18
Trabalho de Conclusão de Curso da PucMinas 2018

# Requisitos:
Ter instalado ou disponível os seguintes softwares:
NPM (Node Package Manager);
Maven;
Java 8;
Wildfly 13;

# Compilação e execução do módulo web

Entre no diretório /logistica-transporte-web-vue.

Na linha de comando, execute o comando $ npm install (para baixar e instalar as dependências do projeto).

$ npm run dev (para rodar o projeto).

Acesse localhost:4200.

# Configuração do certificado digital autoassinado

No diretório certificado/ (git) está o certificado digital autoassinado, o arquivo server.keystore. O arquivo deve ser colocado em $PATH_WILDFLY13/standalone/configuration/.

No mesmo diretório está o arquivo standalone.xml. Ele contém as informações para configuração do XML para que o certificado seja reconhecido pelo servidor.

# Compilação e execução dos módulos Java

Os módulos que devem ser implantados são ModuloSeguranca, ControleCTE e ControleEntregas.

Entre no diretório de cada um dos módulos e digite $ mvn clean package (as dependências serão baixadas e os projetos serão compilados).

Os artefatos .war gerados no diretório /target de cada um dos módulos devem ser implantados em $PATH_WILDFLY13/standalone/deployments/.

Em seguida, deve-se criar arquivos vazios com os seguintes nomes cte.war.dodeploy, entregas.war.dodeploy e seguranca.war.dodeploy.

Para executar o Wildfly, vá em $PATH_WILDFLY13/bin/ pela linha de comando. Execute os arquivos standalone.bat ou standalone.sh.
