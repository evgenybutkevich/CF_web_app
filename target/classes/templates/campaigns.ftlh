<#import "parts/main.ftlh" as m>

<@m.main "Campaigns">

<h1>Campaigns page!</h1>

<form class="p-3">
    <#if campaigns?size != 0>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Campaign name</th>
                    <th scope="col">Author</th>
                    <th scope="col"></th>
                    <th scope="col">Date of creation</th>
                </tr>
            </thead>

            <tbody>
                <#list campaigns as campaigns>
                    <tr>
                        <th scope="row">${campaigns?counter}</th>
                        <td><b><a href="/campaigns/${campaigns.id}">${campaigns.campaignName}</a></b></td>
                        <td><a href="/users/view/${campaigns.authorId}">${campaigns.authorName}</a></td>
                        <td>
                            <a data-toggle="collapse" href="#show-${campaigns.id}" aria-expanded="false">description>>></a>

                            <div class="collapse" id="show-${campaigns.id}" >
                                ${campaigns.description}
                            </div>
                        </td>
                        <td>${campaigns.stringDateOfCreation}</td>
                    </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <p><b>No campaigns yet...</b></p>
    </#if>
</form>


</@m.main>