<#import "parts/main.ftlh" as m>
<#import "parts/navbar.ftlh" as n>

<@m.main "Index">
<@n.navbar/>

<div class="container mt-5">
    <h1>Welcome to index page!</h1>

    <p>Click <a href="/hello">here</a> to see hello!</p>
    <p>Click <a href="/comments">here</a> to see/write comments!</p>
    <p>Click <a href="/users">here</a> to see users!</p>


    <div class="card-deck">
        <div class="card">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Название карточки</h5>
                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
            </div>
        </div>

        <div class="card">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Название карточки</h5>
                <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
            </div>
        </div>

        <div class="card">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Название карточки</h5>
                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
            </div>
        </div>
    </div>

</div>

</@m.main>