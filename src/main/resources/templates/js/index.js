// $(document).ready(function(){
//     $("#btn").click(function(){
//
//         $.ajaxSetup({
//             contentType : 'application/json'
//         });
//         $.post(
//             "http://localhost:8080/area/1",
//             '{"id":"1","name":"py"}',
//             function(data) {
//                 alert(data.name);
//                 $("#return").html(data.name);
//             }
//         );
//     });
// });
$(document).ready(function(){
    // 绑定点击事件
    $("#serch").click(function(){
        $.ajax({
            url:"http://localhost:8080/serch1",
            contentType:"application/json;charset=UTF-8",
            data:'{"id":"1","name":"py"}',
            dataType:"json",
            type:"post",
            success:function(data){
                $("#return").html(data.name)
            }
        });
    });
});