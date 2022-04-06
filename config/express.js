import express from 'express';
import config from 'config';

const app = express();

app.use(express.json());

app.get('/test', (request, response) =>
  response.json({ ok: true }),
);

app.listen(config.get('server.port'), () => {
  console.log(`Server started on port ${config.get('server.port')}!`);
})