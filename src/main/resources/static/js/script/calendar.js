require(['jquery'], function ($) {

    $(document).ready(function(){

        $.get("/data/Student/select?stuId=2018000001",function(data){

            var data = JSON.parse(data);
            console.log(data);
            var elem = $("#tb");
            for(var i = 0;i<data.length;i++){

                var strs = "<tr> <td>"+((i+1)*2-1)+ "-"+ (i+1)*2 +"</td>";

                for(var j = 0;j<data[i].length;j++){
                    if(data[i][j]!=null){
                        strs += "<td>" + data[i][j]+"</td>";
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


