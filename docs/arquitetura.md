
# Arquitetura — Projeto 00

Versão: 0.1

## Tecnologias

- Linguagem: Java
- Framework: Spring Boot
- Banco de dados: PostgreSQL
- Fonte de dados: API pública do PNCP
- Versionamento: Git e GitHub

## Fluxo geral

1. O sistema solicita os dados ao PNCP.
2. A resposta é recebida e validada.
3. Os registros são normalizados.
4. As contratações são classificadas.
5. Os registros relevantes são armazenados.
6. Os resultados ficam disponíveis para consulta.

## Organização prevista

- `controller`: endpoints da aplicação.
- `service`: processamento e regras de negócio.
- `repository`: acesso ao banco de dados.
- `entity`: entidades persistidas.
- `dto`: objetos de transferência de dados.
- `client`: comunicação com serviços externos.

## Evoluções futuras

- Interface web
- Dashboard e indicadores
- Análise de editais em PDF
- Alertas de oportunidades
- Exportação de relatórios

Essas funcionalidades não fazem parte da primeira entrega.
