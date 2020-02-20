<#import "parts/main.ftlh" as m>

<@m.main "View campaign">

<#if campaign??>
    <h1 class="m-0">${campaign.campaignName}</h1>

    <div class="row">
        <div class="col-md-8">
            <img class="" src="/icons/${campaign.logo}" width="100%">
        </div>

        <div class="col-md-4">
        <div class="card rounded-0 border-0">
            <div class="card-body p-2">
                <h1>150$</h1>

                <div class="form-group row mb-0">
                    <p class="col-sm-6 col-form-label font-weight-bold">out of ${campaign.amountTotal} $</p>

                    <p class="col-sm-6 col-form-label font-weight-bold text-primary text-right">collected 15%</p>
                </div>

                <div class="progress">
                    <div class="progress-bar" role="progressbar" style="width: 15%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
                </div>

                <div class="form-group row mt-0">
                    <p class="col-sm-4 col-form-label font-weight-bold text-center">supported</p>
                    <p class="col-sm-4 col-form-label font-weight-bold text-center">remain</p>
                    <p class="col-sm-4 col-form-label font-weight-bold text-center">created</p>
                </div>

                <button class="btn btn-primary" type="submit">Support</button>

                <p>${campaign.topic}</p>
            </div>
        </div>
    </div>
    </div>


    <div class="row m-0 mt-3">
        <div class="list-group list-group-horizontal">
            <a class="list-group-item list-group-item-action active border-0" data-toggle="list" href="#description">Description</a>

            <a class="list-group-item list-group-item-action border-0" data-toggle="list" href="#comments">Comments</a>

            <a class="list-group-item list-group-item-action border-0" data-toggle="list" href="#sponsors">Sponsors</a>
        </div>
    </div>


    <div class="tab-content p-3">
        <div class="tab-pane fade show active" id="description">${campaign.description}</div>

        <div class="tab-pane fade" id="comments">
            <#include "parts/comments.ftlh">
        </div>

        <div class="tab-pane fade" id="sponsors">sponsors</div>
    </div>

    <div class="row">
        <p class="col-sm-6 col-form-label font-weight-bold">${campaign.stringDateOfCreation}</p>

        <p class="col-sm-6 col-form-label font-weight-bold text-right">${campaign.stringDateOfUpdate}</p>
    </div>

<#else>
    <p class="m-1"><b>No campaigns yet...</b></p>
</#if>

</@m.main>