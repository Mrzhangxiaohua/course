function template(dataPart) {       //此处dataPart的数据从哪里得到
    console.log("自动执行");
    var html;
    for (var i = 0; i < dataPart.length; i++) {
        var id = "id" +i;
        var temp = "<tr>\n" +
            "                <td>" + dataPart[i]["className"] + "</td>\n" +
            "                <td>" + dataPart[i]["classNum"] + "</td>\n" +
            "                <td>" + dataPart[i]["teaName"] + "</td>\n" +
            "                <td>" + dataPart[i]["classChooseNum"] + "</td>\n" +
            "                <td>" + dataPart[i]["classUpperLimit"] + "</td>\n" +
            "                <td>" + dataPart[i]["classDateDescription"] + "</td>\n" +
            "                <td>" + dataPart[i]["classPlace"] + "</td>\n" +
            "                <td>" + dataPart[i]["classLength"] + "</td>\n" +
            "                <td>" + dataPart[i]["modelsName"] + "</td>\n" +
            "                <td>" + "<button class='add  btn btn-primary btn-xs glyphicon glyphicon-plus' id = "+ id+"></button>" + "</td>\n" +
            "            </tr>";
        html += temp;
    }
    return html;
}



require(['jquery'], function ($) {
    require(['paginationjs'], function (pagination) {
        $(document).ready(function () {
                        //     console.log(dataPart)
            $('#page').pagination({ ////////////////////////////////
                dataSource: function (done) {
                    $.ajax({
                        type: 'GET',
                        url: '/select/classes',
                        success: function (response) {
                            done(response);
                        }
                    });
                },
                pageSize: 10,
                className: 'paginationjs-theme-blue',
                showNavigator: true,
                callback: function (data, pagination) {
                    // template method of yourself
                    var html = template(data);
                    $(".tbody").empty();

                    $(".tbody").append(html);
                }
            })

            //使用ajax 加载部门信息
            $.get("/data/getDepart", function (data) {
                var data = JSON.parse(data);
                console.log(data)
                for (var i = 0; i < data.length; i++) {
                    $("#sel_search_orderstatus").append("<option value='" + data[i]["departName"] + "'>" + data[i]["departName"] + "</option>");
                }
            });
        });


        //点击鼠标查找满足条件的课程
        $("#find").click(function () {
            var depart = $("#sel_search_orderstatus").val();
            var classname = $("#classId").val();
            console.log(classname);
            $('#page').pagination({
                dataSource: function (done) {
                    $.ajax({
                        type: 'GET',
                        url: '/select/classes',
                        data: "depart=" + depart + "&classname=" + classname,
                        success: function (response) {
                            done(response);
                        }
                    });
                },
                pageSize: 10,
                className: 'paginationjs-theme-blue',
                callback: function (data, pagination) {
                    // template method of yourself
                    var html = template(data);
                    $(".tbody").empty();
                    $(".tbody").append(html);
                }
            })
        })

        $("body").on("click", ".add", function(s) {
            var elem= $(this).parent().parent().children().get(0);
            var text = elem.innerHTML;
            console.log(text)
            var elem =  $("#havenAdd")
            var strs = "<li type=\"button\" class=\"btn btn-primary have \" style='margin-right: 10px;display: inline-block;'>"+text+"</li>"
            elem.append(strs)
        });

        $("body").on("click",".have",function(){
            $(this).remove();

        })
    })
})