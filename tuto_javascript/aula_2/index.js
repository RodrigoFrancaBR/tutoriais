// pegando o modulo http nativo do node
const http =  require('http');
const hostname = '127.0.0.1';
const port = 3000;

// criando um servidor
const server = http.createServer((request, response)=>{
response.statusCode = 200;
response.setHeader('Content-Type', 'text/plain');
response.end('Hello, World!\n');
});

//ouvindo as requisições na porta e no hostname e imprimindo qdo bater nela 
server.listen(port, hostname, ()=>{
    console.log(`Server running at http://${hostname}:${port}/`);
});