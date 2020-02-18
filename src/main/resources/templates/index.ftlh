<#import "parts/main.ftlh" as m>

<@m.main "Index">

<h1>Welcome to index page!</h1>

<p>Click <a href="/hello">here</a> to see hello!</p>
<p>Click <a href="/users">here</a> to see users!</p>
<p>Click <a href="/create">here</a> to create campaign!</p>
<p>Click <a href="/campaigns/2">here</a> to view campaigns!</p>

<div class="card-deck mt-5">
    <button class="btn btn-outline-primary" type="button">PREV</button>

    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">

    <button class="btn btn-outline-primary" type="button">NEXT</button>
</div>

<div class="card-deck mt-5 mb-5">
    <button class="btn btn-outline-primary" type="button">PREV</button>

    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">

    <button class="btn btn-outline-primary" type="button">NEXT</button>
</div>

</@m.main>