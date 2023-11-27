# API-de-gerenciamento-de-tarefas

Uma API que permita o gerenciamento de uma lista de to-dos

## Desenvolvedores

- [@André](https://github.com/KnockDown737)
- [@Victor](https://github.com/VictorVicent)
- [@Diego](https://github.com/DiegoSampaio505)
- [@Pedro](https://github.com/PedroEBC)

##  Documentação da API


| Recursos   |
| :---------------------------------- |
|GET - Para obter todos os to-dos ou detalhes de um to-do.
POST - Criar um novo to-do
DELETE - Excluir um to-do
PUT - Atualizar todo os detalhes do to-do.
PATCH - Atualizar o status do to-do. (Pending para Completed, por exemplo), assim como os demais campos.


**Campos:**

| Task   |
| :---------------------------------- |
|Task
id (Long)
title (String)
description (String)
status (Enum [TODO, IN_PROGRESS, DONE])
dueDate (LocalDate)
priority (Enum [LOW, MEDIUM, HIGH])
