# Loja Online - API

## Integrantes
- Caio Freitas - RM553190
- Caio Hideki - RM553630
- Jorge Booz - RM552700
- Mateus Tibíão - RM553267
- Lana Andrade - RM552596

---

## Requisitos
- **Linguagem:** Java 17+
- **Framework:** Spring Boot 3.5.5
- **Banco de dados:** H2 (em memória) para testes, MySQL opcional para produção
- **Documentação da API:** Swagger/OpenAPI 3

---

## Como rodar
1. Clone o repositório:
```bash
git clone <URL_DO_REPOSITORIO>
cd lojaonline
```
2. Compile e rode a aplicação:
```bash
./mvnw clean install
./mvnw spring-boot:run
```
> Ou, se estiver no Windows, use `mvnw.cmd` no lugar de `./mvnw`.

3. A aplicação será executada em `http://localhost:8080`.

---

## Como acessar o Swagger UI
- Abra no navegador:
```
http://localhost:8080/swagger-ui/index.html
```
- Todos os endpoints disponíveis para `Clientes` e `Produtos` estarão documentados lá.

---

## Exemplos de chamadas

### Criar Cliente
```bash
curl -X POST "http://localhost:8080/clientes" \
-H "Content-Type: application/json" \
-d '{
  "nome": "Monkey D. Luffy",
  "email": "luffy@onepiece.com",
  "documento": "4123400041"
}'
```

### Listar Clientes
```bash
curl -X GET "http://localhost:8080/clientes"
```

### Criar Produto
```bash
curl -X POST "http://localhost:8080/produtos" \
-H "Content-Type: application/json" \
-d '{
  "nome": "Controle Xbox",
  "descricao": "Controle sem fio para Xbox Series X",
  "preco": 350.0,
  "ativo": true
}'
```

### Listar Produtos
```bash
curl -X GET "http://localhost:8080/produtos"
```

---

## Usuários de teste
| Nome               | Email                    | Documento       |
|-------------------|-------------------------|----------------|
| Ninja             | ninja@gaming.com         | 11111111111    |
| PixelMaster       | pixel@gaming.com         | 33333333333    |
| Vinsmoke Sanji    | blacklegs@onepiece.com   | 4123412341     |
| Monkey D. Luffy   | luffy@onepiece.com       | 4123400041     |

## Produtos de teste
| Nome               | Descrição                        | Preço | Ativo |
|-------------------|---------------------------------|-------|-------|
| Controle Xbox      | Controle sem fio para Xbox       | 350.0 | true  |
| Teclado Mecânico   | Teclado RGB para gamers          | 450.0 | true  |
| Mouse Gamer        | Mouse com DPI ajustável          | 200.0 | true  |
| Headset Gamer      | Headset com microfone            | 300.0 | true  |

---

## Observações
- **Decisões:**
    - API RESTful com Spring Boot.
    - Banco H2 em memória para facilitar testes rápidos.
    - Campos `id` gerados automaticamente pelo banco.
    - Campos obrigatórios validados (email/documento únicos).

- **Limitações:**
    - Persistência em H2: dados desaparecem quando a aplicação é reiniciada.
    - Endpoints de update (`PUT`) podem exigir ajustes no frontend para IDs existentes.

- **Melhorias futuras:**
    - Integração com banco MySQL/PostgreSQL persistente.
    - Paginação e filtros para listagem de clientes e produtos.
    - Autenticação e autorização de usuários.
    - Endpoint de pesquisa por nome ou email.

---