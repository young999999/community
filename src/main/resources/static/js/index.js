$(document).ready(function(){
    function  dateformat(date){
        var time = new Date(date);
        var y = time.getFullYear();//年
        var m = time.getMonth() + 1;//月
        var d = time.getDate();//日
        var h = time.getHours();//时
        var mm = time.getMinutes();//分
        var s = time.getSeconds();//秒
        var newTime=y+"-"+m+"-"+d+" "+h+":"+mm+":"+s;
        return newTime;
    }
    document.body.onclick=function(){
        var obj=document.elementFromPoint(event.clientX,event.clientY).textContent-1;
        var page={"page":obj}
        page=JSON.stringify(page)

        $.ajaxSetup({
            contentType : 'application/json'
        });
        $.post(
            "http://localhost:8080/index",
            //'{"page":1}',
            page,
            function(data) {
                var d=JSON.parse(data)
                var ht="<div id='d'>"+"fasffds"+"</div>"
                var ht1="<div>" +
                    "<ul>" +
                    "<div class='media-left'>" +
                    "<img class='media-object'>" +
                    "</div>" +
                    "<div class='media-body'>" +
                    "<h4 class='media-heading'></h4>" +
                    "<span class='description'></span>" +
                    "<br>" +
                    "<span class='text-desc'>" +
                    "<span class='commentCount'></span> 个回复 •" +
                    "<span class='viewCount'></span> 次浏览 •" +
                    "<span class='creattime'></span>" +
                    "</span>"+
                    "</div>"+
                    "</ul>"+
                    "</div>"

                $(".qusetionsList").empty()
                for (var i=0;i<d.length;i++){
                    if($(".div"+obj+i).length==0){

                        $(".qusetionsList").append(ht)
                        $(".qusetionsList #d").eq(i).removeClass()
                        $(".qusetionsList #d").eq(i).addClass('div'+obj+i)

                        if($(".div"+obj+i).length>0) {
                            $(".div" + obj + i).html(ht1)
                        }
                        if($(".div"+obj+i).find(".media-heading").length>0){

                            $(".div"+obj+i).find(".media-heading").text(d[i].title)
                            $(".div"+obj+i).find(".description").text(d[i].description)
                            $(".div"+obj+i).find(".commentCount").text(d[i].commentcount)
                            $(".div"+obj+i).find(".viewCount").text(d[i].viewcount)
                            $(".div"+obj+i).find(".creattime").text(dateformat(d[i].gmtcreat))
                            $(".div"+obj+i).find(".media-object").attr('src',d[i].user.avatarurl)
                        }
                    }
                }
            }
        );
    }
});
// $(document).ready(function(){
//     // 绑定点击事件
//     $(".pagination").click(function(){
//         $.ajax({
//             url:"http://localhost:8080/index",
//             contentType:"application/json;charset=UTF-8",
//             data:'{"page":"2"}',
//             dataType:"json",
//             type:"post",
//             success:function(data){
//                 alert(JSON.stringify(data));
//             }
//         });
//     });
// });