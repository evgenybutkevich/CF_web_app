<#import "parts/main.ftlh" as m>

<@m.main "Index">

<h1>Main page!</h1>

<h4 class="mt-5">Last added campaigns!</h4>
<div class="card-deck p-2">

    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">

</div>

<h4 class="mt-5">Top rated campaigns!</h4>
<div class="card-deck mb-5 p-2">

    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">
    <#include "parts/card.ftlh">

</div>

</@m.main>