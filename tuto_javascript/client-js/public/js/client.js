console.log("Carregando o arquivo client.js");
const config = {
  clientId: "OtherWebApplicationClientId",
  // clientSecret: "OtherWebApplicationClientSecret",
  authorizeUrl: "http://localhost:8082/oauth/authorize",
  tokenUrl: "http://localhost:8082/oauth/token",
  callbackUrl: "http://localhost:8080",
  clientesUrl: "http://localhost:8081/clientes"
};

let accessToken = "";

function generateCodeVerifier() {
  let codeVerifier = generateRandomString(128);
  localStorage.setItem("codeVerifier", codeVerifier);

  return codeVerifier;
}

function generateRandomString(length) {
  let text = "";
  let possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  
  for (let i = 0; i < length; i++) {
    text += possible.charAt(Math.floor(Math.random() * possible.length));
  }
  
  return text;
}

function generateCodeChallenge(codeVerifier) {
  return base64URL(CryptoJS.SHA256(codeVerifier));
}

function getCodeVerifier() {
  return localStorage.getItem("codeVerifier");
}

function base64URL(string) {
  return string.toString(CryptoJS.enc.Base64).replace(/=/g, '').replace(/\+/g, '-').replace(/\//g, '_');
}


function consultar() {
  alert("Consultando recurso com access token " + accessToken);

  $.ajax({
    url: config.clientesUrl,
    type: "get",

    beforeSend: function(request) {
      request.setRequestHeader("Authorization", "Bearer " + accessToken);
    },

    success: function(response) {
      var json = JSON.stringify(response);
      $("#resultado").text(json);
    },

    error: function(error) {
      alert("Erro ao consultar recurso");
    }
  });
}

function gerarAccessToken(code) {
  alert("Gerando access token com code " + code);
  
  let codeVerifier = getCodeVerifier();

  // let clientAuth = btoa(config.clientId + ":" + config.clientSecret);
  
  let params = new URLSearchParams();
  params.append("grant_type", "authorization_code");
  params.append("code", code);
  params.append("redirect_uri", config.callbackUrl);
  params.append("client_id", config.clientId);
  // params.append("client_secret", config.clientSecret);
  params.append("code_verifier", codeVerifier);

  $.ajax({
    url: config.tokenUrl,
    type: "post",
    data: params.toString(),
    contentType: "application/x-www-form-urlencoded",

    // é opcional passar no header o clientID e o ClientSecret
    // beforeSend: function(request) {
    //   request.setRequestHeader("Authorization", "Basic " + clientAuth);
    // },

    success: function(response) {
      accessToken = response.access_token;

      alert("Access token gerado: " + accessToken);
    },

    error: function(error) {
      alert("Erro ao gerar access key");
    }
  });
}

function login() {
  // https://auth0.com/docs/protocols/oauth2/oauth-state

  // state é opcional 
  // let state = btoa(Math.random());
  // localStorage.setItem("clientState", state);
  let codeVerifier = generateCodeVerifier();
  let codeChallenge = generateCodeChallenge(codeVerifier);
  // window.location.href = `${config.authorizeUrl}?response_type=code&client_id=${config.clientId}&state=${state}&redirect_uri=${config.callbackUrl}`;
  window.location.href = `${config.authorizeUrl}?response_type=code&client_id=${config.clientId}&redirect_uri=${config.callbackUrl}&code_challenge_method=s256&code_challenge=${codeChallenge}`;
}

$(document).ready(function() {
  let params = new URLSearchParams(window.location.search);

  let code = params.get("code");
  // state é opcional 
  // let state = params.get("state");
  // let currentState = localStorage.getItem("clientState");

  if (code) {
    // window.history.replaceState(null, null, "/");
    gerarAccessToken(code);
    
    // state é opcional 
    // if (currentState == state) {
    //   gerarAccessToken(code);
    // } else {
    //   alert("State inválido");
    // }
  }
});

$("#btn-consultar").click(consultar);
$("#btn-login").click(login);