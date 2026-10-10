🏋️‍♂️ GYM8
📌 Nome do sistema

Gym8 - Encontre parceiros de treino.
🎯 Objetivo

O Gym8 tem como objetivo facilitar o gerenciamento da rotina fitness do usuário, permitindo o cadastro detalhado de treinos e dietas. Além disso, o sistema visa conectar praticantes de atividades físicas da mesma região, promovendo parcerias de treino através de um algoritmo de geolocalização e envio de convites interativos.
🏢 Domínio escolhido

Gestão de Saúde/Fitness e Rede Social Esportiva.
O domínio abrange o acompanhamento nutricional e físico pessoal (dieta, exercícios, repetições, grupos musculares) combinado com funcionalidades de networking baseadas em localização geográfica.
👥 Integrantes

    Kauan Ortiz

🚀 Principais funcionalidades

    Autenticação e Sessão: Sistema de Login e Cadastro de usuários com gestão de sessão ativa (SessaoUsuario).

    Gestão de Treinos: Criação de rotinas de treino, adição de exercícios específicos, ordenação alfabética e visualização detalhada.

    Gestão de Dieta: Controle de refeições diárias e alimentos segmentados por tipo e calorias.

    Geolocalização (Fórmula de Haversine): Cálculo preciso da distância em quilômetros entre o usuário logado e possíveis parceiros de treino, utilizando coordenadas (Latitude/Longitude).

    Filtros de Busca: Pesquisa de parceiros disponíveis na região filtrada por Sexo e Nível/Classificação (Iniciante, Intermediário, Avançado).

    Sistema de Convites: Envio, recebimento, aceite ou recusa de convites para treinar com outros usuários, incluindo visualização do perfil do remetente.

    Interface Gráfica: UI desenvolvida em Java Swing utilizando a arquitetura MVC (Model-View-Controller).

📦 Lista das entidades

A modelagem do sistema é baseada nos conceitos de Orientação a Objetos e inclui:

    Pessoa (Classe Abstrata base)

    Usuario (Herda de Pessoa)

    Treino (Implementa interface de formatação visual)

    Exercicio

    Dieta

    Refeicao

    Alimento

    Convite

    Enums: Classificacao, DiasDaSemana, GrupoMuscular, Objetivo, Sexo, TipoAlimento.

📝 Lista dos cadastros

Os processos de entrada de dados (CRUD) do sistema contemplam:

    Cadastro de Usuário: Dados pessoais, endereço e nível.

    Cadastro de Treinos: Criação do treino vinculado a um dia da semana.

    Cadastro de Exercícios: Inclusão de exercícios (séries, repetições e grupo muscular) dentro de um treino.

    Cadastro de Dietas: Inicialização do plano alimentar.

    Cadastro de Refeições e Alimentos: Inserção de até 4 itens alimentares por refeição com controle de quantidade e calorias.

🔍 Lista das consultas

    Consulta de Parceiros: Listagem de usuários cadastrados no banco em ordem de distância e com aplicação de filtros de busca.

    Consulta de Detalhes do Treino: Leitura e formatação dos exercícios cadastrados em um treino específico utilizando funções lambda (java.util.function.Function).

    Consulta de Detalhes da Refeição: Visualização formatada da dieta do usuário.

    Consulta de Convites: Verificação em tempo real da caixa de entrada de convites recebidos e seus respectivos status.

⚙️ Lista dos movimentos

As ações e regras de negócio dinâmicas do sistema incluem:

    Inicialização e encerramento da Sessão do Usuário (Login/Logout).

    Cálculo matemático de distância geográfica entre coordenadas (Haversine).

    Transição dinâmica entre formulários e painéis (GestorDeTelas).

    Emissão de um novo Convite de Treino para o perfil de destino.

    Atualização do Status do Convite (Movimento de Aceitar/Recusar).

    Ordenação dinâmica de listas de exercícios utilizando Comparator.

💻 Instruções para execução

Pré-requisitos:

    Java Development Kit (JDK): Versão 8 ou superior (Recomendado Java 11 ou superior devido ao uso de Streams e Interfaces Funcionais).

    IDE Recomendada: Eclipse, IntelliJ IDEA ou Visual Studio Code.

Passo a passo:

    Clone este repositório para a sua máquina local:
    Bash

    git clone https://github.com/seu-usuario/gym8.git

    Abra a pasta do projeto na sua IDE preferida.

    Certifique-se de que a codificação do projeto está configurada para UTF-8 (para evitar problemas de acentuação na interface).

    (Opcional) Caso esteja utilizando o FlatLaf para o tema moderno, adicione o arquivo .jar do FlatLaf no Build Path / Libraries do projeto.

    Navegue até o pacote responsável pela inicialização do sistema (app.Main).

    Execute a classe principal (Run as > Java Application).

    Para testar o sistema de buscas, cadastre pelo menos dois usuários com endereços diferentes.
