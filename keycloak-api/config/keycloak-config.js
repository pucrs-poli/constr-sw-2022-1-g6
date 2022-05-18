import KcAdminClient from '@keycloak/keycloak-admin-client';
import 'dotenv/config';

let kcAdminClient;

async function initKeycloak(customCredentials) {
  kcAdminClient = new KcAdminClient.default({
    realmName: process.env.KEYCLOAK_REALM,
    baseUrl: process.env.KEYCLOAK_BASE_URL,
  });

  try {
    await kcAdminClient.auth(customCredentials);

    return kcAdminClient;
  } catch (error) {
    throw new Error(error);
  }
}

async function _refreshToken() {
  return initKeycloak({
  grantType: 'refresh_token',
  clientId: process.env.KEYCLOAK_CLIENT_ID,
  refreshToken: kcAdminClient.refreshToken,
  });
}

export { initKeycloak, _refreshToken }