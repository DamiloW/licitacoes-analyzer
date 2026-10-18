
# Regras de Negócio — Projeto 00

Versão: 0.1

## Regras iniciais

**RN-001 — Fonte oficial**

O sistema deve consultar contratações utilizando inicialmente a API pública do PNCP.

**RN-002 — Filtros**

O sistema deve permitir consultas por período e filtragem local por palavras-chave.

**RN-003 — Classificação**

O sistema deve identificar contratações relacionadas a software com base em critérios configuráveis.

**RN-004 — Duplicidade**

Uma contratação não deve ser cadastrada duas vezes quando possuir a mesma identificação oficial.

**RN-005 — Rastreabilidade**

Cada contratação armazenada deve preservar sua identificação, fonte e data de coleta.

**RN-006 — Relatórios**

O sistema deve permitir gerar relatórios das contratações consideradas relevantes.

## Fluxograma

```mermaid
flowchart TD
    A([Iniciar]) --> B[Consultar PNCP]
    B --> C{Consulta funcionou?}
    C -- Não --> D[Registrar erro]
    C -- Sim --> E[Normalizar dados]
    E --> F{É relacionado a software?}
    F -- Não --> G[Ignorar no relatório]
    F -- Sim --> H{Já existe?}
    H -- Não --> I[Salvar registro]
    H -- Sim --> J[Atualizar se necessário]
    I --> K[Próximo registro]
    J --> K
    G --> K
    K --> L{Restam registros?}
    L -- Sim --> E
    L -- Não --> M[Gerar relatório]
    D --> N([Encerrar])
    M --> N
```
