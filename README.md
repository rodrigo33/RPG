Pacote contém a classe BatalhaService, que é responsável por gerenciar as batalhas entre personagens do jogo. Ele se
integra com outros componentes do jogo, como PersonagemController, PersonagemRepository e BatalhaHistoricoRepository.

Dependências Este pacote depende dos seguintes componentes do jogo:
PersonagemController: para atualizar os dados do personagem durante a batalha. PersonagemRepository: para buscar
informações sobre os personagens que estão participando da batalha.

Como usar Para utilizar o BatalhaService, basta criar uma instância da classe e chamar o método iniciar(jogador1,
jogador2), passando como parâmetro dois objetos Personagem que vão participar da batalha. O serviço vai rolar os dados
para determinar qual personagem começa atacando e em seguida executará uma série de turnos até que um dos personagens
seja derrotado.