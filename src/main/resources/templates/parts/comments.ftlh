<#include "security.ftlh">

<#if isUser>
    <a class="btn btn-primary" data-toggle="collapse" href="#addComment" role="button" aria-expanded="false">
        Add comment
    </a>

    <div class="collapse <#if comment??>show</#if> mt-1" id="addComment">
        <form method="post" enctype="multipart/form-data">
            <input name="_csrf" value="${_csrf.token}" type="hidden"/>

            <div class="form-group row">
                <div class="col-6 mr-1 pr-0">
                    <input name="text" class="form-control ${(textError??)?string('is-invalid', '')}" type="text" value="<#if comment??>${comment.text}</#if>" placeholder="Comment">

                    <#if textError??>
                        <div class="invalid-feedback">
                            ${textError}
                        </div>
                    </#if>
                </div>

            <div class="custom-file col-2 mr-1">
                <input class="custom-file-input" name="avatar" type="file" id="file">
                <label class="custom-file-label" for="file"></label>
            </div>

                <button class="btn btn-primary" type="submit">Send</button>
            </div>




        </form>
    </div>
</#if>

<#list comments as comments>
    <div class="media border border-primary bg-primary m-1">
        <#if comments.authorAvatar??>
            <img class="m-2" src="/icons/${comments.authorAvatar}" width="64px">
        </#if>

        <div class="media-body bg-white">
            <p class="m-1"><b><a href="/users/view/${campaign.authorId}">${comments.authorName}</a></b></p>
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