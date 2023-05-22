<h1> Projeto Naruto - Mateus Rodrigues</h1>


<h2>Exercício de Programação Orientada a Objetos (POO) em Java - Anime Naruto</h2>
<p>Neste desafio, vamos praticar nossas habilidades em programação orientada a objetos utilizando o anime Naruto como exemplo. Para isso, vamos criar classes em Java que representem os personagens do anime Naruto e utilizá-las para mostrar como herança e interface podem ser usadas para organizar classes relacionadas.</p>
<h2>Requisitos</h2>
<h3>Atributos do Personagem:</h3>
<ul>
  <li>Nome (String)</li>
  <li>Idade (int)</li>
  <li>Aldeia (String)</li>
  <li>Jutsus (array de Strings)</li>
  <li>Chakra (int)</li>
</ul>
<h3>Métodos:</h3>
<ul>
  <li>Um construtor que inicialize os atributos do personagem.</li>
  <li>Um método que permita adicionar um novo jutsu ao array de jutsus.</li>
  <li>Um método que permita aumentar o chakra do personagem em uma quantidade específica.</li>
  <li>Um método que permita exibir todas as informações do personagem (nome, idade, aldeia, jutsus e chakra).</li>
</ul>
<h3>Interface Ninja:</h3>
<h4>Métodos:</h4>
<ul>
  <li><code>usarJutsu()</code>: exibe uma mensagem na tela indicando que o personagem está usando um jutsu.</li>
  <li><code>desviar()</code>: exibe uma mensagem na tela indicando que o personagem está desviando de um ataque.</li>
</ul>
<h3>Classes:</h3>
<ul>
  <li>NinjaDeTaijutsu: classe que representa um personagem especializado em Taijutsu.</li>
  <ul>
    <li>Métodos:</li>
    <li><code>usarJutsu()</code>: exibe uma mensagem na tela indicando que o personagem está usando um golpe de Taijutsu.</li>
    <li><code>desviar()</code>: exibe uma mensagem na tela indicando que o personagem está desviando de um ataque usando sua habilidade em Taijutsu.</li>
  </ul>
  <li>NinjaDeNinjutsu: classe que representa um personagem especializado em Ninjutsu.</li>
  <ul>
    <li>Métodos:</li>
    <li><code>usarJutsu()</code>: exibe uma mensagem na tela indicando que o personagem está usando um jutsu de Ninjutsu.</li>
    <li><code>desviar()</code>: exibe uma mensagem na tela indicando que o personagem está desviando de um ataque usando sua habilidade em Ninjutsu.</li>
  </ul>
  <li>NinjaDeGenjutsu: classe que representa um personagem especializado em Ninjutsu.</li>
<li>Métodos:</li>
    <li><code>usarJutsu()</code>: exibe uma mensagem na tela indicando que o personagem está usando um jutsu de Genjutsu.</li>
    <li><code>desviar()</code>: exibe uma mensagem na tela indicando que o personagem está desviando de um ataque usando sua habilidade em Genjutsu</li>
<h2>Instruções</h2>
<ol>
<li>Crie uma classe <code>Personagem</code> que atenda aos requisitos acima.</li>
<li>Crie uma interface <code>Ninja</code> que defina os métodos <code>usarJutsu()</code> e <code>desviar()</code>.</li>
<li>Crie as classes <code>NinjaDeTaijutsu</code>, <code>NinjaDeNinjutsu</code> e <code>NinjaDeGenjutsu</code>, que estendem a classe <code>Personagem</code> e implementam a interface <code>Ninja</code>, cada uma com seus próprios métodos <code>usarJutsu()</code> e <code>desviar()</code>.</li>
</ol>
