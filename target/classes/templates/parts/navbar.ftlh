<#import "login.ftlh" as l>
<#include "security.ftlh">

<nav class="navbar navbar-expand-lg sticky-top navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-expanded="false">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarContent">
        <a class="navbar-brand" href="/">
            <img src="/icons/logo-globe.png" width="32" height="32">
        </a>

        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/hello">Hello</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>

            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/users">Users</a>
                </li>
            </#if>
        </ul>

        <ul class="navbar-nav">
            <#if isUser>
                <li class="nav-item">
                    <a class="nav-link" href="/create">Create</a>
                </li>
            </#if>

            <div class="navbar-text text-primary border-3 mr-3">Username: ${name}</div>
            <#if isAdmin>
                <@l.logout/>
            </#if>
        </ul>
    </div>
</nav>