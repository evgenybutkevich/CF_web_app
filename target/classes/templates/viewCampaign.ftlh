<#import 'parts/main.ftlh' as m>

<@m.main 'View campaign'>

<#if campaign??>
    <h1>${campaign.campaignName}</h1>
    <h4>
        (topic: <a href="/topics/${campaign.topic}">${campaign.topic}</a>,
        author: <a href="/topics/${campaign.topic}">${campaign.authorName})</a>
    </h4>

    <div class="row">

        <div class="col-md-7">
            <img class="" src="/icons/${campaign.logo}" width="100%">
        </div>

        <div class="col-md-5">
            <div class="card rounded-0 border-0">
                <div class="card-body p-2">
                    <h1>${campaign.amountCollected} USD</h1>

                    <div class="form-group row mb-0">
                        <p class="col-sm-6 col-form-label font-weight-bold">out of ${campaign.amountTotal} USD</p>

                        <p class="col-sm-6 col-form-label font-weight-bold text-primary text-right">
                            collected ${campaign.amountCollected / campaign.amountTotal * 100} %
                        </p>
                    </div>

                    <div class="progress">
                        <div class="progress-bar" role="progressbar"
                            style="width: ${(campaign.amountCollected / campaign.amountTotal * 100)?round}%"
                                aria-valuenow="${campaign.amountCollected / campaign.amountTotal * 100}"
                                    aria-valuemin="0" aria-valuemax="100">
                        </div>
                    </div>

                    <div class="form-group row mt-0">
                        <p class="col-sm-4 col-form-label font-weight-bold text-success text-center">
                            SUPPORTED BY
                        </p>

                        <p class="col-sm-4 col-form-label font-weight-bold text-center">
                            CREATION DATE
                            ${campaign.stringDateOfCreation}
                        </p>

                        <p class="col-sm-4 col-form-label font-weight-bold text-danger text-center">
                            EXPIRY DATE
                            ${campaign.stringDateOfExpiry}
                        </p>
                    </div>

                    <a class="btn btn-primary btn-block" href="/payments/${campaign.id}" role="button">Support</a>
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
        <div class="tab-pane fade show active" id="description"><p class="m-1"><b>${campaign.description}</b></p></div>

        <div class="tab-pane fade" id="comments"><#include "parts/comments.ftlh"></div>

        <div class="tab-pane fade" id="sponsors"><#include "parts/payments.ftlh"></div>
    </div>

    <div class="text-right">
        <p class="col-form-label font-weight-bold text-right">${campaign.stringDateOfUpdate}</p>
    </div>

<#else>
    <h1>Campaign view page!</h1>

    <p class="m-1"><b>No campaigns yet...</b></p>
</#if>

</@m.main>