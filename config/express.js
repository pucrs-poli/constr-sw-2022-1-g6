import express from 'express';
import { initKeycloak, refreshToken } from './keycloak-config.js';

const keycloak = await initKeycloak();

const app = express();
app.use(express.json());

refreshToken()

app.get('/users', async (request, response) => {
  const users = await keycloak.users.find();
  return response.json(users);
})

app.post('/users', async (request, response) => {
  // TODO: REALIZAR A CRIAÇÃO DE UM USUÁRIO
})

app.listen(3000, () => {
  console.log('Server started on port 3000!');
})