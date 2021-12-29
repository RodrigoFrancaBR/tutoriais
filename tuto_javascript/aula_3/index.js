const express = require("../node_modules/express");

// clonando o modulo?
const app = express();

app.get("/", function(request, response){

    // response.send("Hello World!");
    response.sendFile("/Users/rodrigocosta/Documents/GitHub/tutoriais/tuto_javascript/aula_3/index.html")
});

app.listen(8080);
