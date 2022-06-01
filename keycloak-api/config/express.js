import express from 'express';
import 'dotenv/config';
import api from './axios.js';
import bodyParser from 'body-parser';
import url from 'url';

const app = express();
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(async (request, response, next) => {
  if (!request.path.includes('/login')) {
    const { authorization } = request.headers;

    api.defaults.headers.common = {
      'Authorization': authorization,
    };

    try {
      await api.get(
        `realms/${process.env.KEYCLOAK_REALM}/protocol/openid-connect/userinfo`,
      );
    } catch (error) {
      const { status } = error.response;
      if (status === 401) {
        return response.status(401).send({ message: 'Token is invalid!' });
      }
    }
  }

  next();
});

app.post('/login', async (request, response) => {
  const {
    client_id,
    username,
    password,
    grant_type,
  } = request.body;

  const params = new url.URLSearchParams({
    'client_id': client_id,
    'username': username,
    'password': password,
    'grant_type': grant_type,
  });

  try {
    const { data } = await api.post(
      `realms/${process.env.KEYCLOAK_REALM}/protocol/openid-connect/token`,
      params.toString(),
    );

    // const { data: userProfile } = await api.get(
    //   `admin/realms/${process.env.KEYCLOAK_REALM}/users?username=${username}`,
    // );

    // console.log(userProfile);

    const {
      token_type,
      access_token,
      expires_in,
      refresh_token,
      refresh_expires_in,
    } = data;

    return response.json({
      token_type,
      access_token,
      expires_in,
      refresh_token,
      refresh_expires_in,
    });
  } catch (error) {
    return response.status(401).send({ message: error.message });
  }
});

app.post('/login/refresh', async (request, response) => {
  const {
    client_id,
    grant_type,
    refresh_token,
  } = request.body;

  const params = new url.URLSearchParams({
    'client_id': client_id,
    'grant_type': grant_type,
    'refresh_token': refresh_token,
  });

  const { data } = await api.post(
    `realms/${process.env.KEYCLOAK_REALM}/protocol/openid-connect/token`,
    params.toString(),
  );

  const {
    token_type,
    access_token,
    expires_in,
    refresh_expires_in,
  } = data;

  const newCredentials = {
    token_type,
    access_token,
    expires_in,
    refresh_expires_in,
    refresh_token: data.refresh_token,
  }

  return response.json(newCredentials);
});

// 
app.post('/users', async (request, response) => {
  try {
    await api.post(
      `admin/realms/${process.env.KEYCLOAK_REALM}/users`,
      request.body,
    );

    const { username } = request.body;

    const { data } = await api.get(
      `admin/realms/${process.env.KEYCLOAK_REALM}/users`,
      {
        params: { username },
      },
    );

    return response.status(201).json(data[0]);
  } catch (error) {
    const { data, status } = error.response;
    return response.status(status).send(data);
  }
});

// LISTAR USUÁRIOS
app.get('/users', async (request, response) => {
  try {
    const { data } = await api.get(
      `admin/realms/${process.env.KEYCLOAK_REALM}/users`,
    );

    return response.json(data);
  } catch (error) {
    const { data, status } = error.response;
    return response.status(status).send(data);
  }
});

// BUSCAR USUÁRIO PELO ID
app.get('/users/:id', async (request, response) => {
  const { id } = request.params;

  try {
    const { data } = await api.get(
      `admin/realms/${process.env.KEYCLOAK_REALM}/users/${id}`,
    );

    return response.json(data);
  } catch (error) {
    const { data, status } = error.response;
    return response.status(status).send(data);
  }
});


// ATUALIZAR USUÁRIO
app.put('/users/:id', async (request, response) => {
  const { id } = request.params;

  try {
    await api.put(
      `admin/realms/${process.env.KEYCLOAK_REALM}/users/${id}`,
      request.body,
    );

    return response.status(204).send();
  } catch (error) {
    const { data, status } = error.response;
    return response.status(status).send(data);
  }
});


// RESETAR SENHA
app.patch('/users/:id', async (request, response) => {
  const { id } = request.params;

  try {
    await api.put(
      `admin/realms/${process.env.KEYCLOAK_REALM}/users/${id}/reset-password`,
      request.body,
    );

    return response.status(204).send();
  } catch (error) {
    const { data, status } = error.response;
    return response.status(status).send(data);
  }
});

// EXCLUSÃO LÓGICA DE USUÁRIO
app.delete('/users/:id', async (request, response) => {
  const { id } = request.params;

  try {
    await api.put(
      `admin/realms/${process.env.KEYCLOAK_REALM}/users/${id}`,
      { enabled: false },
    );

    return response.status(204).send();
  } catch (error) {
    const { data, status } = error.response;
    return response.status(status).send(data);
  }
});

app.listen(3000, () => {
  console.log('Server started on port 3000!');
});