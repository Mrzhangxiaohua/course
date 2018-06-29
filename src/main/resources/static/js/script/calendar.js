require(['jquery'], function ($) {

    $(document).ready(function(){

        $.get("/data/Student/select?stuId=2018000001",function(data){

            var data = JSON.parse(data);
            // console.log(data);
            var elem = $("#tb");
            for(var i = 0;i<data.length;i++){

                var strs = "<tr >"
                if(i==0){
                    strs += "<td rowspan='2' style='vertical-align:middle ' >上午</td>"
                }
                else if(i==2){
                    strs += "<td rowspan=\"2\"  style='vertical-align:middle '>下午</td>"
                }
                else if(i==4){
                    strs += "<td rowspan=\"1\" >晚上</td>"
                }

                strs += "<td>"+((i+1)*2-1)+ "-"+ (i+1)*2 +"</td>";

                for(var j = 0;j<data[i].length;j++){
                    if(data[i][j]!=null){
                        var v = data[i][j].split(",");
                        var s ="<pre style='background-color: #92f4ee; '>" + "课程:"+ v[0] + "</pre>" +"<pre style='background-color: #ffcef9'>" +"教室:"+ v[1] +"</pre>" +"<pre style='background-color: #e0f977'>"+"老师:"+v[2] +"</pre>" ;
                        console.log(s)
                        strs += "<td>" + s +"</td>";
                    }else{
                        strs += "<td></td>";
                    }
                }
                strs +="</tr>";
                elem.append(strs);
            }

        })
    })
})


