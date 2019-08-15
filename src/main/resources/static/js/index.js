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
    $(".pagination").click(function(){

        $("")

        $.ajaxSetup({
            contentType : 'application/json'
        });
        $.post(
            "http://localhost:8080/index",
            '{"page":"1"}',
            function(data) {
                var d=JSON.parse(data)
                var ht="<div id='d'>"+"我是添加div1"+"</div>"
                var ht2="<p>"+"我是添加div2"+"</p>"
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
                for (var i=0;i<d.length-1;i++){

                    if($(".div"+i).length==0){
                        $(".qusetionsList").append(ht)
                        $(".qusetionsList #d").eq(i).addClass('div'+[i])


                        if($(".div"+i).length>0){
                            $(".div"+i).html(ht1)

                            $(".div"+i).find(".media-heading").text(d[i].title)
                            $(".div"+i).find(".description").text(d[i].description)
                            $(".div"+i).find(".commentCount").text(d[i].commentcount)
                            $(".div"+i).find(".viewCount").text(d[i].viewcount)
                            $(".div"+i).find(".creattime").text(dateformat(d[i].gmtcreat))
                            $(".div"+i).find(".media-object").attr('src',d[i].user.avatarurl)
                            //$(".div"+i+".media-heading").text(d[i].title)
                            // $(".div"+i+".description").text(d[i].description)
                            // $(".div"+i+".commentCount").text(d[i].commentcount)
                            // $(".div"+i+".viewCount").text(d[i].viewcount)
                            // $(".div"+i+".creattime").text(dateformat(d[i].gmtcreat))
                            // $(".div"+i+".media-object").attr('src',d[i].user.avatarurl)


                            // $(".media-heading").text(d.id+" "+d.title)
                            // $(".description").text(d.description)
                            // $(".commentCount").text(d.commentcount)
                            // $(".viewCount").text(d.viewcount)
                            // $(".creattime").text(dateformat(d.gmtcreat))
                        }
                    }
                }
            }
        );
    });
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