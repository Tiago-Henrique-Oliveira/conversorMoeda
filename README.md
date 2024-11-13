
Descrição:

Este projeto é um Conversor de Moedas desenvolvido em Java. Ele permite que os usuários convertam valores entre 
diferentes moedas com base nas taxas de câmbio atualizadas. É uma ferramenta simples e prática para quem precisa fazer 
conversões rapidamente.

Funcionalidades:

Conversão de um valor de uma moeda para outra com base em taxas de câmbio.
Suporte para múltiplas moedas.
Interface de linha de comando (CLI) ou gráfica (GUI) para inserção de valores e escolha de moedas.
Atualização automática das taxas de câmbio a partir de uma API pública (se implementado).

Pré-requisitos:

Java 11 ou superior instalado.
Conexão com a internet (caso as taxas de câmbio sejam obtidas de uma API).
Biblioteca externa (opcional) para conexão com APIs, como OkHttp para chamadas HTTP, se necessário.

Instalação:

Clone este repositório:
git clone https://github.com/Tiago-Henrique-Oliveira/conversorMoeda

Compile o projeto:

javac src/ConversorDeMoeda.java

Execute o projeto:
java -cp src ConversorDeMoeda

Utilização:
Inicie o programa.
Insira o valor que deseja converter.
Escolha a moeda de origem e a moeda de destino.
O conversor exibirá o valor convertido.

Exemplo de uso (CLI):

java -cp src ConversorDeMoeda

Digite o valor a ser convertido: 100

Escolha a moeda de origem: USD

Escolha a moeda de destino: EUR

Resultado: 100 USD = 91 EUR

Estrutura do Código:
ConversorDeMoeda.java: classe principal que contém a lógica de conversão.
Moeda.java: uma classe auxiliar que representa uma moeda e sua taxa de câmbio.
ApiDeCambio.java (opcional): classe responsável por buscar as taxas de câmbio de uma API externa.

Personalização:

Para personalizar o conversor, você pode:
Adicionar novas moedas e taxas de câmbio no arquivo Moeda.java.
Integrar uma API para taxas de câmbio em tempo real, como a Exchange Rates API.

Contribuição:

Sinta-se à vontade para contribuir com o projeto enviando pull requests. Sugestões de melhorias são bem-vindas!

Licença:

Este projeto está licenciado sob a MIT License - veja o arquivo LICENSE para mais detalhes.
