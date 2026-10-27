# Onde parei (26/10/2026)

Branch atual: `feature/cadastro-maquinas`

## Já feito

- [x] Projeto criado no start.spring.io (Maven, Java 25, Spring Web)
- [x] `model/Maquina.java` — molde da máquina (id, nome, tipo, setor, status)
- [x] `repository/MaquinaRepository.java` — lista em memória (salvar, listarTodas)
- [x] `service/MaquinaService.java` — regra: nome obrigatório (senão 400)
- [x] `controller/MaquinaController.java` — `GET /maquinas` e `POST /maquinas/cadastro`
- [x] Testado no Thunder Client: cadastro (201) e listagem (200)

Caminho de uma requisição: Thunder Client → controller → service → repository → lista

## Próximo passo (começar por aqui)

Impedir cadastro com **id repetido** (hoje dá para cadastrar duas máquinas com id 1).

1. Em `MaquinaRepository.java`, embaixo do `listarTodas()`:

```java
    public boolean existeId(Long id) {
        for (Maquina m : maquinas) {
            if (m.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
```

2. Em `MaquinaService.java`, no `cadastrar`, depois do `if` do nome e antes do `return`:

```java
        if (maquina.getId() != null && repository.existeId(maquina.getId())) {
            throw new IllegalArgumentException("Já existe uma máquina com o id " + maquina.getId());
        }
```

3. **Salvar os arquivos (Ctrl + S)**, reiniciar a aplicação e testar o POST duas vezes: 201 e depois 400.
4. `git add .` e `git commit -m "feat: impede cadastro de maquina com id repetido"`

## Depois disso (o que falta do Exercício 1)

- [ ] Página inicial `/` (mensagem de boas-vindas)
- [ ] Merge da `feature/cadastro-maquinas` na `main`
- [ ] Branch `feature/monitoramento`: produção (`POST` e `GET /producao`), `/status`, `/versao`
- [ ] Branch `feature/testes`: testes automáticos (JUnit + MockMvc)
- [ ] Branch `feature/docker`: Dockerfile
- [ ] Branch `feature/pipeline-cicd`: `.github/workflows/pipeline.yml`
- [ ] README.md e RELATORIO.md
- [ ] Exercício 2 — biblioteca-cloudtech (mesmo padrão)

## Comandos úteis (cmd)

```cmd
mvnw.cmd spring-boot:run      (liga a aplicação — Ctrl + C desliga)
git status                    (mostra o que mudou)
git log --oneline             (mostra os commits)
```

Se der "Port 8080 was already in use": tem outra aplicação ligada. Feche o terminal antigo com Ctrl + C.

Em outro computador: instalar um JDK 25 e configurar `JAVA_HOME`, depois `git clone` do repositório.
