# Dicionário Java RMI

Este repositório hospeda um aplicativo de dicionário simples implementado em Java, utilizando a tecnologia Remote Method Invocation (RMI). O aplicativo permite que os usuários pesquisem o significado das palavras no dicionário, adicinem novas palavras e removam palavras.

# Pré-requisitos

Para compilar e executar este projeto, você precisa ter:

- JDK 8 ou superior
- Apache Maven

# Compilação

# Para compilar o projeto, siga as etapas abaixo:

Clone o repositório para sua máquina local:

```sh
git clone https://github.com/luanaf4/DicionarioJavaRMI.git
```

Navegue até o diretório do projeto 
```sh
cd DicionarioJavaRMI
```

Acesse o diretório src
```sh
cd src
```

Acesse o diretório main

```sh
cd main
```

Para compilar o projeto:

```sh
maven clean install
```

# Execução

Para executar o projeto, siga as etapas abaixo:

- Inicie o servidor rodando Server.java
- Inicie o Client rodando Client.java
- Depois de iniciar o client, você pode utilizar o dicionário por meio da interface gráfica.

# Bibliotecas

- Gson: biblioteca open-source para converter objetos Java em sua representação JSON. Foi utilizado para a persistência dos dados.
- Swing: biblioteca gráfica para Java.
