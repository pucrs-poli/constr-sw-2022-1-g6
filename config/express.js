import express from 'express';
import { initKeycloak, _refreshToken } from './keycloak-config.js';

let keycloak = await initKeycloak();

const app = express();
app.use(express.json());

app.get('/users', async (request, response) => {
  try {
    const users = await keycloak.users.find();
    return response.json(users);
  } catch (error) {
    if(error.response.status === 401) {
      keycloak = await _refreshToken();

      const users = await keycloak.users.find();
      return response.json(users);
    }
  }
});

app.get('/users/:id', async (request, response) => {
  try {
    const findedUser = await keycloak.users.findOne({ id: request.params.id });
    return response.json(findedUser);
  } catch (error) {
    if(error.response.status === 401) {
      keycloak = await _refreshToken();

      const findedUser = await keycloak.users.findOne({ id: request.params.id });
      return response.json(findedUser);
    }
  }
});

app.put('/users/:id', async (request, response) => {
  try {
    await keycloak.users.update({
      id: request.params.id,
    }, request.body);
    return response.json().status(200);
  } catch (error) {
    if(error.response.status === 401) {
      keycloak = await _refreshToken();

      await keycloak.users.update({
        id: request.params.id,
      }, request.body);
      return response.json().status(200);
    }
  }
});

app.patch('/users/:id', async (request, response) => {
  try {
    await keycloak.users.resetPassword({
      id: request.params.id,
      credential: request.body,
    });
    return response.json().status(200);
  } catch (error) {
    if(error.response.status === 401) {
      keycloak = await _refreshToken();

      await keycloak.users.resetPassword({
        id: request.params.id,
        credential: request.body,
      });
      return response.json().status(200);
    }
  }
});

app.delete('/users/:id', async (request, response) => {
  try {
    await keycloak.users.update({
      id: request.params.id,
    }, { enabled: false });
    return response.json().status(200);
  } catch (error) {
    if(error.response.status === 401) {
      keycloak = await _refreshToken();

      await keycloak.users.update({
        id: request.params.id,
      }, { enabled: false });
      return response.json().status(200);
    }
  }
});

app.post('/users', async (request, response) => {
  try {
    const createdUser = await keycloak.users.create(request.body);
    return response.json(createdUser);
  } catch (error) {
    if(error.response.status === 401) {
      keycloak = await _refreshToken();

      const createdUser = await keycloak.users.create(request.body);
      return response.json(createdUser);
    }
  }
});

app.listen(3000, () => {
  console.log('Server started on port 3000!');
});