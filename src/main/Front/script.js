const filtro = document.getElementById("buscarProduto");
const btn = document.getElementById("btnBuscar");

btn.addEventListener("click", async () => {
  const nomeProduto = filtro.value;

  try {
    const resposta = await fetch(
      `http://localhost:8080/produtos/nome${nomeProduto}`
    );

    const produtos = await resposta.json();
    if (produtos.nome == undefined) {
      console.log("Produto não encontrado");
      return;
    }

    console.log("Produtos do Back :) ", produtos);

    const listaResultados = document.getElementById("listaResultados");
    listaResultados.innerHTML = "";
    listaResultados.innerHTML += `
               <div class="card bg-base-100 w-96 shadow-sm">
      <div class="card-body">
        <h2 class="card-title">${produtos.nome}</h2>
        <p>Price: R$ ${produtos.preco}</p>
        <p>Category: R$ ${produtos.categoria.nome}</p>


      </div>
    </div>`;
  } catch (erro) {
    alert("Erro: ", erro);
  }
});

const categoria = document.getElementById("categoriaProd");
const nome = document.getElementById("nomeProd");
const preco = document.getElementById("precoProd");
const quantidade = document.getElementById("qttProd");
const btnC = document.getElementById("btnCriar");

btnC.addEventListener("click", async () => {
  const produto = {
    nome: nome.value,
    categoria: categoria.value,
    preco: parseFloat(preco.value),
    quantidadeEstoque: parseInt(quantidade.value),
  };

  try {
    const resposta = await fetch(`http://localhost:8080/produtos`, {
      method: "POST",
      body: JSON.stringify(produto),
      headers: { "Content-Type": "application/json" },
    });
    alert("Produto Cadastrado com sucesso!");
  } catch (error) {
    alert("Erro na criação!: ", error);
    console.log(error);
  }
});
