const filtro = document.getElementById('buscarProduto');
const btn = document.getElementById('btnBuscar');

btn.addEventListener('click', async () => {
    
    const nomeProduto = filtro.value;

    try {
        const resposta = await fetch(`http://localhost:8080/produtos/nome${nomeProduto}`);

        const produtos = await resposta.json();

        console.log("Produtos do Back :) ", produtos)
    } catch(erro){
        console.log("Erro: " , erro)
    }
})