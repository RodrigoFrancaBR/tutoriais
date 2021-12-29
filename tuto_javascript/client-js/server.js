console.log("Iniciando o arquivo server.js");

var pathIndexHTML="/Users/rodrigocosta/Documents/GitHub/tutoriais/tuto_javascript/client-js/index.html";
var folderPublicJS = "/Users/rodrigocosta/Documents/GitHub/tutoriais/tuto_javascript/client-js/public/js";
const express = require("../node_modules/express");

// clonando o modulo? Instanciando?
const app = express();

// especifica que todos os seus arquivos estáticos serão acessados ​​a partir do publicdiretório:
app.use(express.static(folderPublicJS));

app.get("/", function(request, response){

    // response.send("Hello World!");
    response.sendFile(pathIndexHTML)
});

app.listen(8080);
