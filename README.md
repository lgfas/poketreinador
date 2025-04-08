# Pokédex do Treinador

Aplicação backend em Java com Spring Boot para gerenciar os Pokémon capturados por treinadores.

## 💡 Objetivo

Esse projeto foi criado com o intuito de aprender conceitos importantes do desenvolvimento backend, como:

- Caching
- Autenticação e segurança web
- Testes
- CI/CD
- Integração com APIs externas (PokeAPI)

## 🗄️ Modelo de Banco de Dados

### Tabela: `treinador`

| Campo         | Tipo       | Descrição                          |
|---------------|------------|------------------------------------|
| id            | SERIAL     | Chave primária                    |
| nome          | VARCHAR(100) | Nome do treinador                 |
| email         | VARCHAR(100) | Email único para login            |
| senha         | VARCHAR(255) | Senha em hash                     |
| data_criacao  | TIMESTAMP  | Data de criação da conta          |

### Tabela: `pokemoncapturado`

| Campo           | Tipo         | Descrição                               |
|------------------|--------------|------------------------------------------|
| id               | SERIAL       | Chave primária                          |
| nome             | VARCHAR(100) | Nome do pokémon                         |
| tipo_principal   | VARCHAR(100) | Tipo primário                           |
| tipo_secundario  | VARCHAR(100) | Tipo secundário (opcional)              |
| sprite_url       | VARCHAR(255) | URL da imagem                           |
| data_captura     | TIMESTAMP    | Data de captura                         |
| treinador_id     | INTEGER      | FK para `treinador(id)`                 |

```sql
CREATE TABLE treinador (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	senha VARCHAR(255) NOT NULL,
	data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE pokemoncapturado (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	tipo_principal VARCHAR(100) NOT NULL,
	tipo_secundario VARCHAR(100),
	sprite_url VARCHAR(255) NOT NULL,
	data_captura TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	treinador_id INTEGER NOT NULL,
	FOREIGN KEY (treinador_id) REFERENCES treinador (id) ON DELETE CASCADE
);
