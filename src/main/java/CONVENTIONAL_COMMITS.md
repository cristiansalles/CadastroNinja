# 🧭 Guia de Commits Padronizados (Conventional Commits)

## 🏷️ Tipos mais comuns de commits

| Tipo | Significado | Exemplo |
|------|--------------|---------|
| **feat** | Nova funcionalidade | `feat(missao): cria endpoint para listar missões` |
| **fix** | Correção de bug | `fix(ninja): corrige erro ao salvar ninja sem aldeia` |
| **docs** | Mudança em documentação | `docs: adiciona instruções de setup no README` |
| **style** | Alterações de formatação (espaços, ponto e vírgula etc) | `style: ajusta indentação no NinjaController` |
| **refactor** | Refatoração sem mudar comportamento | `refactor: separa lógica de serviço do controlador` |
| **test** | Adição ou correção de testes | `test(missao): adiciona testes para serviço de missão` |
| **chore** | Tarefas de manutenção, build, configs | `chore: atualiza dependências do Maven` |
| **perf** | Melhorias de desempenho | `perf(ninja): otimiza consulta por ID` |
| **build** | Alterações que afetam o sistema de build ou dependências externas (Maven, Gradle, NPM etc.) | `build: adiciona plugin do Lombok no pom.xml` |
| **ops** | Mudanças relacionadas à infraestrutura, deploy, servidores ou scripts operacionais | `ops: atualiza configuração do Docker para ambiente de produção` |

---

## 🧩 Exemplo real com Java + Spring Boot

### Antes (sem padrão)

```bash
git commit -m "atualizei ninja"

Depois (profissional)

git commit -m "feat(ninja): adiciona relacionamento com missões"

Ou:

git commit -m "fix(missao): corrige erro de lazy loading ao listar ninjas"
````
## 🧩 Dica bônus: descrição longa

### Você pode escrever mensagens mais detalhadas com o -m duplo:
```bash
git commit -m "feat(ninja): adiciona validação de nome" -m "Adiciona verificação para impedir criação de ninja com nome duplicado. Também ajusta mensagens de erro no controller."
```