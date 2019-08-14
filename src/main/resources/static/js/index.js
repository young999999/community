$(document).ready(function(){
    $(".pagination").click(function(){

        $.ajaxSetup({
            contentType : 'application/json'

        });
        $.post(
            "http://localhost:8080/index",
            '{"page":"1"}',
            function(data) {
                var d=JSON.parse(data)
                alert(d.user.avatarurl)
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