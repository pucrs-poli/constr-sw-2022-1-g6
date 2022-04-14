import KcAdminClient from '@keycloak/keycloak-admin-client';
import { Issuer } from 'openid-client';
import 'dotenv/config';

let kcAdminClient;

const credentials = {
  grantType: 'password',
  username: process.env.KEYCLOAK_USERNAME,
  password: process.env.KEYCLOAK_PASSWORD,
  clientId: process.env.KEYCLOAK_CLIENT_ID,
};

const keycloakIssuer = await Issuer
  .discover(`${process.env.KEYCLOAK_BASE_URL}/realms/${process.env.KEYCLOAK_REALM}`);

const client = new keycloakIssuer.Client({
  client_id: process.env.KEYCLOAK_CLIENT_ID,
  token_endpoint_auth_method: 'none',
});

let tokenSet = await client.grant({
  grant_type: 'password',
  username: process.env.KEYCLOAK_USERNAME,
  password: process.env.KEYCLOAK_PASSWORD,
});

async function initKeycloak() {
  kcAdminClient = new KcAdminClient.default({
    realmName: process.env.KEYCLOAK_REALM,
    baseUrl: process.env.KEYCLOAK_BASE_URL,
  });

  try {
    await kcAdminClient.auth(credentials);

    return kcAdminClient;
  } catch (error) {
    console.log(error)
  }
}

async function refreshToken() {
  setInterval(async () => {
    const refreshToken = tokenSet.refresh_token;
    tokenSet = await client.refresh(refreshToken);
    kcAdminClient.setAccessToken(tokenSet.access_token);
  }, 300 * 1000); // 300 seconds
}

export { initKeycloak, refreshToken }