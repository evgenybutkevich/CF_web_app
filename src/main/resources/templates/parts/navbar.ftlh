<#include "security.ftlh">

<nav class="navbar navbar-expand-lg sticky-top navbar-dark bg-dark nav-pills">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapseArea" aria-expanded="false">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapseArea">
        <a class="navbar-brand" href="/">
            <img src="/icons/logo-globe.png" width="32" height="32">
        </a>

        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link <#if titleName == 'Index'>active</#if>" href="/">Home</a>
            </li>

            <li class="nav-item">
                <a class="nav-link <#if titleName == 'Campaigns'>active</#if>" href="/campaigns">Campaigns</a>
            </li>

            <li class="nav-item">
                <#if isUser>
                    <a class="nav-link <#if titleName == 'Create campaign'>active</#if>" href="/create">Create</a>
                <#else>
                    <a class="nav-link disabled" href="/create">Create</a>
                </#if>
            </li>

            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link <#if titleName == 'Users'>active</#if>" href="/users">ADMIN: Users</a>
                </li>
            </#if>
        </ul>

        <ul class="navbar-nav">
            <div class="navbar-text mr-3">${name}</div>

            <#if isUser>
                <#include "logoutButton.ftlh">
            <#else>
                <a class="btn btn-primary" href="/login" role="button">Login</a>
            </#if>
        </ul>
    </div>
</nav>