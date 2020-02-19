<#include "security.ftlh">

<#if isAdmin>
    <a class="btn btn-primary" data-toggle="collapse" href="#addComment" role="button" aria-expanded="false">
        Add comment
    </a>

    <div class="collapse mt-3" id="addComment">
        <form method="post" enctype="multipart/form-data">
            <input name="_csrf" value="${_csrf.token}" type="hidden"/>

            <div class="form-group row mb-1">
                <div class="col-sm-6 pr-1">
                    <input name="text" class="form-control" type="text" placeholder="enter the comment...">
                </div>

                <button class="btn btn-primary" type="submit">Send</button>
            </div>

            <input name="file" class="form-control-file" type="file">

        </form>
    </div>
</#if>

<#list comments as comments>
    <div class="media border border-primary bg-primary m-1">
        <img class="m-2" src="/icons/user-male.png" width="64px" height="64px">

        <div class="media-body bg-white">
            <p class="m-1"><b>${comments.authorName}</b></p>
            <p class="text-break ml-3 m-1"><mark class="bg-warning">- ${comments.text}</mark></p>

            <div>
                <#if comments.filename??>
                    <img src="/img/${comments.filename}" height="128px">
                </#if>
            </div>

            <p class="m-1"><b>${comments.stringDateOfCreation}</b></p>
        </div>
    </div>
<#else>
    <p class="m-1"><b>No comments yet...</b></p>
</#list>