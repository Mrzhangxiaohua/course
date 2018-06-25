require(['jquery'],function ($) {

    var strTable =
    $(document).ready(function () {
        $.get("/select/classes", function (dataPart) {
            for(var i = 0 ;i<dataPart.length;i++){
                $(".tbody").append("<tr>\n" +
                    "                <td>" + dataPart[i]["className"]+ "</td>\n" +
                    "                <td>" + dataPart[i]["classNum"]+ "</td>\n" +
                    "                <td>" + dataPart[i]["teaName"]+ "</td>\n" +
                    "                <td>" + dataPart[i]["classChooseNum"]+ "</td>\n" +
                    "                <td>" + dataPart[i]["classUpperLimit"]+ "</td>\n" +
                    "                <td>" + dataPart[i]["classDateDescription"]+ "</td>\n" +
                    "                <td>" + dataPart[i]["classPlace"]+ "</td>\n" +
                    "                <td>" + dataPart[i]["classLength"]+ "</td>\n" +
                    "                <td>" + dataPart[i]["classModuleNum"]+ "</td>\n" +
                    "            </tr>")
            }

        });
    })

    //使用ajax 加载部门信息
    $.get("/data/getDepart", function (data) {
        var data = JSON.parse(data);
        for (var i = 0; i < data.length; i++) {
            $("#sel_search_orderstatus").append("<option value='" + data[i]["departName"] + "'>" + data[i]["departName"] + "</option>");
        }
    });
    //点击鼠标查找满足条件的课程
    $("#find").click(function () {
        var depart = $("#sel_search_orderstatus").val();
        var classname = $("#classId").val();

        var param = {
            depart: depart,
            classname: classname,
            json:true
        };
        $.get("/select/classes", param ,function (data) {
            console.log(data)
            $(".tbody").empty();
            for(var i = 0 ;i<data.length;i++){
                $(".tbody").append("<tr>\n" +
                    "                <td>" + data[i]["className"]+ "</td>\n" +
                    "                <td>" + data[i]["classNum"]+ "</td>\n" +
                    "                <td>" + data[i]["teaName"]+ "</td>\n" +
                    "                <td>" + data[i]["classChooseNum"]+ "</td>\n" +
                    "                <td>" + data[i]["classUpperLimit"]+ "</td>\n" +
                    "                <td>" + data[i]["classDateDescription"]+ "</td>\n" +
                    "                <td>" + data[i]["classPlace"]+ "</td>\n" +
                    "                <td>" + data[i]["classLength"]+ "</td>\n" +
                    "                <td>" + data[i]["classModuleNum"]+ "</td>\n" +
                    "            </tr>")
            };

        });
    })

})