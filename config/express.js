import express from 'express';
import { initKeycloak } from './keycloak-config.js';

const keycloak = await initKeycloak();

function refreshToken(request, response, next) {
  try {
    next();
  } catch (error) {
    console.log(error);
  }
}

const app = express();
app.use(express.json());
app.use(refreshToken);

// refreshToken()

app.get('/users', async (request, response) => {
  const users = await keycloak.users.find();
  return response.json(users);
});

app.get('/users/:id', async (request, response) => {
  const findedUser = await keycloak.users.findOne({ id: request.params.id });
  return response.json(findedUser);
});

app.put('/users/:id', async (request, response) => {
  await keycloak.users.update({
    id: request.params.id,
  }, request.body);
  return response.json().status(200);
});

app.patch('/users/:id', async (request, response) => {
  await keycloak.users.resetPassword({
    id: request.params.id,
    credential: request.body,
  });
  return response.json().status(200);
});

app.delete('/users/:id', async (request, response) => {
  await keycloak.users.update({
    id: request.params.id,
  }, { enabled: false });
  return response.json().status(200);
});

app.post('/users', async (request, response) => {
  const createdUser = await keycloak.users.create(request.body);
  return response.json(createdUser);
});

app.listen(3000, () => {
  console.log('Server started on port 3000!');
});