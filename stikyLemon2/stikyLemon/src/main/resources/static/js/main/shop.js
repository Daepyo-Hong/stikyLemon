

$(function (){
    $("#filter>ul>li>input").click(collectionListClickd);
    $("#aside-collection").click(collectionShowHide);
});
function collectionListClickd(){
    $("#filter>ul>li>input").removeClass("target");
    $(this).addClass("target");
}
function collectionShowHide(){
    if($("#aside-collection span").last().text()=="+"){
        $("#aside-collection span").last().text("-");
        $("#coll-list").show();
    }else{
        $("#aside-collection span").last().text("+");
        $("#coll-list").hide();
    }
}