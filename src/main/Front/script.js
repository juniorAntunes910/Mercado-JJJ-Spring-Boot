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

async function carregarCategoria() {
  
try {
  const resposta = await fetch(`http://localhost:8080/categorias`);
  const categorias = await resposta.json();
  if ((!categorias || categorias.length == 0)) {
    console.log("Lista Vazia");
  }

  const listaCategoria = document.getElementById("category-list");
  listaCategoria.innerHTML = "";
  categorias.forEach((categoria) => {
    listaCategoria.innerHTML += `
                        <li class="list-row">
                            <div class="text-4xl font-thin opacity-30 tabular-nums">ID: ${categoria.id}</div>
                            <div class="list-col-grow text-center mt-4 text-black">
                                <div class="text-xs uppercase font-semibold opacity-60">${categoria.nome}</div>
                            </div>
                        </li>
    `;
  });

} catch (error) {
  console.log(error);
}
};

document.addEventListener("DOMContentLoaded", async () => { 
carregarCategoria();
const btnCDD = document.getElementById("btnCriar-categoria")
const nomeCategoria = document.getElementById("categoria-name-add")
btnCDD.addEventListener("click", async () => {
  
  const categoria = {
    nome: nomeCategoria.value
  }
  
  try{
    const resposta = await fetch(`http://localhost:8080/categorias`, {
      method: "POST",
      body: JSON.stringify(categoria),
      headers: { "Content-Type": "application/json"},
    });
    alert("Categoria Cadastrada com sucesso!")
    carregarCategoria();
  } catch(erro){
    console.log("Erro na criação " , erro)
  }
});
});
