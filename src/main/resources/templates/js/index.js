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
    alert("ready")
    // 绑定点击事件
    $(".pagination")(function(){
        $.ajax({
            url:"http://localhost:8080/",
            contentType:"application/json;charset=UTF-8",
            data:'{"page":"2"}',
            dataType:"json",
            type:"post",
            // success:function(data){
            //     alert("success")
            // }
        });
        alert("success")
    });
});