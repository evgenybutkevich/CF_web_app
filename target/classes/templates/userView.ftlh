<#import "parts/main.ftlh" as m>
<#include "parts/security.ftlh">

<@m.main "User ${user.id}">

<h1>User ${user.id} page! <#if isAdmin><a href="/users/edit/${user.id}">EDIT</a></#if></h1>

<form class="p-3">
    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Login: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">${user.username}</label>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Email: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">${user.email}</label>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Registration date: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">${user.stringRegistrationDate}</label>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">First name: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">${user.firstName}</label>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Last name: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">${user.lastName}</label>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Sex: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">${user.sex}</label>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Birth date: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">
            <#if user.birthDate??>${user.stringBirthDate}<#else>INDEFINED</#if>
        </label>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Avatar: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">
            <#if user.avatar??>
                <img class="m-2" src="/icons/${user.avatar}" width="128px">
            </#if>
        </label>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Roles: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">
            <#list user.roles as role>${role}<#sep>, </#list>
        </label>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Active: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">${user.active?string('active', 'inactive')}</label>
    </div>
</form>

</@m.main>